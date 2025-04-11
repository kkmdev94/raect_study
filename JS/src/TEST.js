const puppeteer = require('puppeteer');
const selectSeat = require('./seat-selector');

(async () => {
    const browser = await puppeteer.launch({
        headless: false, // 브라우저 띄우기 (중요)
        defaultViewport: null,
        args: ['--start-maximized']
    });

    const page = await browser.newPage();
    await page.goto('https://www.ticketlink.co.kr/product/55751');

    console.log('🧑 수동으로 로그인하고, 날짜 클릭해서 좌석 선택 페이지까지 진입하세요!');
    console.log('⏳ 진입 후 ENTER 키를 눌러주세요.');

    process.stdin.once('data', async () => {
        console.log('📥 좌석 페이지 처리 시작!');
        await selectSeat(page); // 좌석 iframe 접근 및 구조 분석
    });
})();
