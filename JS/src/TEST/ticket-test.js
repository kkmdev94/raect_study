const puppeteer = require('puppeteer-extra')
const StealthPlugin = require('puppeteer-extra-plugin-stealth')

puppeteer.use(StealthPlugin())

;(async () => {
  const browser = await puppeteer.launch({ headless: false })
  const page = await browser.newPage()

  // Step 1. 티켓링크 공연 페이지 접속
  await page.goto('https://www.ticketlink.co.kr/product/55751', {
    waitUntil: 'networkidle2',
  })

  console.log('[1단계] 공연 페이지 접속 완료 - 로그인 직접 진행하세요.')

  // Step 2. 로그인 완료될 때까지 기다림 (10분 대기 가능)
  console.log('⏳ 로그인 완료 후 엔터키 누르세요...')
  process.stdin.once('data', async () => {
    console.log('[2단계] 자동화 시작! 날짜 및 예매하기 클릭 중...')

    try {
      // 날짜 선택
      await page.waitForSelector('.date-select li a', { timeout: 5000 })
      const dateLinks = await page.$$('.date-select li a')
      if (dateLinks.length > 0) {
        await dateLinks[0].click()
        console.log('[3단계] 날짜 선택 완료')
      } else {
        console.log('❌ 날짜 요소를 찾지 못했습니다.')
      }

      // 예매하기 버튼 클릭
      await page.waitForSelector('.product-contents .btn.btn_reserve', {
        timeout: 5000,
      })
      await page.click('.product-contents .btn.btn_reserve')
      console.log('[4단계] 예매하기 버튼 클릭 완료')

      // 좌석 선택 페이지 로딩 대기
      await page.waitForNavigation({ waitUntil: 'networkidle2' })
      console.log('✅ 좌석 선택 페이지 진입 시도 완료')

      console.log('🧩 여기서부터는 수동 CAPTCHA 또는 보안 절차가 시작됩니다.')

    } catch (err) {
      console.error('❌ 오류 발생:', err.message)
    }
  })
})()
