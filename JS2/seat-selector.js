const fs = require('fs');

module.exports = async function selectSeat(page) {
  try {
    console.log('🔍 iframe 로딩 대기 중...');
    await page.waitForSelector('iframe#ifrmSeat', { timeout: 20000 });

    let iframeHandle = await page.$('iframe#ifrmSeat');
    if (!iframeHandle) throw new Error('iframe 핸들을 찾을 수 없습니다.');

    let frame = await iframeHandle.contentFrame();

    // detached 상태인지 확인
    if (!frame || frame._detached) {
      throw new Error('iframe이 이미 분리되었습니다.');
    }

    console.log('✅ iframe 접근 성공! 구조 분석 시작');

    const html = await frame.evaluate(() => document.body.innerHTML);
    fs.writeFileSync('iframe-content.html', html);
    console.log(html.slice(0, 1000)); // 일부만 출력

    await frame.screenshot({ path: 'seat-frame.png', fullPage: true });
    console.log('📸 스크린샷 저장 완료');
    
  } catch (err) {
    console.error('❌ 에러 발생:', err.message);
  }
};
