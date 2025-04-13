
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.alert import Alert
from selenium.common.exceptions import UnexpectedAlertPresentException, NoSuchElementException
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from selenium_stealth import stealth
import time
import random

# === Chrome Driver 설정 ===
options = Options()
options.add_argument("--start-maximized")
options.add_argument("--disable-blink-features=AutomationControlled")
options.add_experimental_option("excludeSwitches", ["enable-automation"])
options.add_experimental_option("useAutomationExtension", False)

driver = webdriver.Chrome(service=Service(), options=options)

# === Stealth 적용 ===
stealth(driver,
    languages=["ko-KR", "ko"],
    vendor="Google Inc.",
    platform="Win32",
    webgl_vendor="Intel Inc.",
    renderer="Intel Iris OpenGL Engine",
    fix_hairline=True,
)

# === 예매 사이트 접속 안내 ===
print("✅ 브라우저 실행 완료")
driver.get("https://www.ticketlink.co.kr/product/55751")
print("🎯 수동으로 로그인, 날짜 선택, 예매하기 버튼 클릭까지 진행하세요.")

# === 새 창 감지 및 전환 ===
original_window = driver.current_window_handle
new_window = None

print("📌 예매하기 클릭 후 새 창이 뜨면 자동으로 감지합니다.")
while not new_window:
    time.sleep(1)
    handles = driver.window_handles
    if len(handles) > 1:
        for handle in handles:
            if handle != original_window:
                new_window = handle
                break

driver.switch_to.window(new_window)
print("🆕 새 창 전환 완료")

# === 캡차 수동 입력 대기 ===
input("🔐 캡차 입력 완료 후 Enter 키를 눌러주세요...")

# === 자연스러운 대기 후 iframe 접근 ===
delay = random.uniform(8, 14)
print(f"🕒 자연스러운 대기 중... ({delay:.1f}초)")
time.sleep(delay)

try:
    iframe = driver.find_element(By.NAME, "ifrmSeat")
    driver.switch_to.frame(iframe)
    print("✅ iframe 접근 성공! 좌석 선택 로직 추가 가능")
except UnexpectedAlertPresentException:
    alert = Alert(driver)
    print("🚨 시스템 경고 발생:", alert.text)
    alert.accept()
    print("⚠️ 경고창을 닫았습니다. 자동화 차단 가능성 높음")
except NoSuchElementException:
    print("❌ iframe을 찾을 수 없습니다. 사이트 구조가 변경됐을 수 있습니다.")
