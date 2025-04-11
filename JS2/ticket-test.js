import puppeteer from 'puppeteer-core';
import readline from 'readline';

// 👉 유저가 직접 입력해서 크롬 경로 설정 (필요 시 수정)
const browser = await puppeteer.launch({
  executablePath: 'C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe', // 크롬 설치 경로
  headless: false,
  defaultViewport: null,
  args: ['--start-maximized']
});

const page = await browser.newPage();
await page.goto('https://www.ticketlink.co.kr/product/55751', { waitUntil: 'networkidle2' });

// 👉 날짜 영역 로딩 대기 및 날짜 클릭
await page.waitForSelector('.select_date .date_list a[data-date]', { timeout: 60000 });
await page.click('a[data-date="2025.05.17"]'); // 원하는 날짜 설정

// 👉 예매하기 버튼 대기 및 클릭
await page.waitForSelector('.prdBtnR a.btn.btn_green.ticket');
await page.click('.prdBtnR a.btn.btn_green.ticket');

// 👉 새 창으로 전환 대기
const newPagePromise = new Promise(resolve => browser.once('targetcreated', async target => {
  const newPage = await target.page();
  await newPage.bringToFront();
  resolve(newPage);
}));
const ticketPage = await newPagePromise;

// 👉 캡차 수동 입력 대기
console.log('🔐 캡차를 수동으로 입력하고 Enter를 눌러주세요...');
await waitForEnterKey();

// 👉 좌석 선택 iframe 로딩 대기
await ticketPage.waitForSelector('iframe[name="ifrmSeat"]');
const frame = await ticketPage.frames().find(f => f.name() === 'ifrmSeat');

console.log('✅ 좌석 선택 iframe 로딩 완료!');

// 👉 다음 로직은 여기서 iframe 안의 요소 클릭 등 추가 가능

// === 보조 함수 ===
function waitForEnterKey() {
  const rl = readline.createInterface({ input: process.stdin, output: process.stdout });
  return new Promise(resolve => rl.question('계속하려면 Enter를 누르세요...\n', () => {
    rl.close();
    resolve();
  }));
}
