# ticket_test.py
import asyncio
from playwright.async_api import async_playwright

async def main():
    async with async_playwright() as p:
        browser = await p.chromium.launch(headless=False)
        page = await browser.new_page()

        # 1. 공연 페이지 접속
        await page.goto("https://www.ticketlink.co.kr/product/55751")

        print("[1단계] 공연 페이지 접속 완료")

        # 2. 날짜 선택
        await page.wait_for_selector(".date-select li a")
        date_links = await page.query_selector_all(".date-select li a")
        if date_links:
            await date_links[0].click()
            print("[2단계] 날짜 선택 완료")

        # 3. 예매하기 버튼 클릭
        await page.wait_for_selector(".product-contents .btn.btn_reserve")
        await page.click(".product-contents .btn.btn_reserve")

        print("[3단계] 예매하기 버튼 클릭 완료")

        # 4. 다음 페이지 로딩 대기
        await page.wait_for_load_state("networkidle")
        print("[4단계] 좌석 선택 페이지 진입 시도")

        print("👀 여기서부터 수동 CAPTCHA 처리 필요")

asyncio.run(main())
