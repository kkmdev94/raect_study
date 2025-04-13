import puppeteer from 'puppeteer-extra';
import StealthPlugin from 'puppeteer-extra-plugin-stealth';
import readline from 'readline';
import fs from 'fs';

puppeteer.use(StealthPlugin());

(async () => {
  const browser = await puppeteer.launch({
    executablePath: 'C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe',
    headless: false,
    defaultViewport: null,
    args: [
      '--start-maximized',
      '--no-sandbox',
      '--disable-setuid-sandbox',
      '--disable-blink-features=AutomationControlled'
    ]
  });

  const page = await browser.newPage();

  // 사용자처럼 보이게 설정
  await page.setUserAgent('Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36');
  await page.evaluateOnNewDocument(() => {
    Object.defineProperty(navigator, 'webdriver', { get: () => false });
    window.navigator.chrome = { runtime: {} };
    Object.defineProperty(navigator, 'languages', { get: () => ['ko-KR', 'ko'] });
    Object.defineProperty(navigator, 'plugins', { get: () => [1, 2, 3, 4, 5] });
  });

  await page.goto('https://www.ticketlink.co.kr/product/55751', { waitUntil: 'networkidle2' });

  console.log('🎯 수동으로 로그인 → 날짜 선택 → 예매하기 버튼 클릭까지 진행하세요.');

  // 새 창 감지 + 안정화 처리
  const ticketPage = await waitForNewPage(browser);

  console.log('🆕 새 창 감지 완료:', ticketPage.url());
  console.log('🔐 새 창에서 캡차 수동 입력 후 Enter를 누르세요...');
  await waitForEnterKey();

  try {
    await ticketPage.waitForSelector('iframe[name="ifrmSeat"]', { timeout: 15000 });
    const frame = ticketPage.frames().find(f => f.name() === 'ifrmSeat');
    if (!frame || frame._detached) throw new Error('❌ iframe이 분리되었거나 존재하지 않음');

    console.log('✅ 좌석 iframe 탐색 성공');

    const html = await frame.evaluate(() => document.documentElement.innerHTML);
    fs.writeFileSync('iframe-content.html', html);
    await frame.screenshot({ path: 'seat-frame.png', fullPage: true });

    console.log('📸 스크린샷 및 HTML 저장 완료');
  } catch (err) {
    console.error('❌ iframe 처리 중 에러:', err.message);
  }
})();

// 새 창 감지 함수 (안정적)
async function waitForNewPage(browser) {
  return new Promise(resolve => {
    const checkTarget = async () => {
      const targets = await browser.targets();
      for (const target of targets) {
        const page = await target.page();
        if (page && page.url().includes('/reserve/')) {
          resolve(page);
          return;
        }
      }
      setTimeout(checkTarget, 500); // 계속 확인
    };
    checkTarget();
  });
}

// 사용자 입력 대기
function waitForEnterKey() {
  const rl = readline.createInterface({ input: process.stdin, output: process.stdout });
  return new Promise(resolve => rl.question('계속하려면 Enter를 누르세요...\n', () => {
    rl.close();
    resolve();
  }));
}
