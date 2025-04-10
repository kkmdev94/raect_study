import logging
import time
from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import sys
from webdriver_manager.chrome import ChromeDriverManager
import random
import string
import undetected_chromedriver as uc
from selenium.webdriver import ActionChains
from fake_useragent import UserAgent

# UTF-8 출력 설정
sys.stdout.reconfigure(encoding='utf-8')

# 로깅 설정
logging.basicConfig(
    level=logging.INFO,
    format='%(asctime)s - %(levelname)s - %(message)s',
    handlers=[
        logging.FileHandler('ticket_bot.log', encoding='utf-8'),
        logging.StreamHandler()
    ]
)

# 티켓팅 정보
TARGET_URL = "https://www.ticketlink.co.kr/product/55751"

def create_browser_instance(use_stealth_mode=True):
    try:
        if use_stealth_mode:
            logging.info("스텔스 모드로 브라우저 인스턴스 생성 중...")
            return create_stealth_browser()
        else:
            logging.info("일반 모드로 브라우저 인스턴스 생성 중...")
            return create_normal_browser()
    except Exception as e:
        logging.error(f"브라우저 인스턴스 생성 실패: {str(e)}")
        raise

def create_stealth_browser():
    """자동화 감지를 우회하는 스텔스 모드 브라우저 생성"""
    try:
        # 랜덤 사용자 에이전트 생성
        try:
            ua = UserAgent()
            user_agent = ua.random
            logging.info(f"랜덤 UserAgent 생성: {user_agent}")
        except:
            # 예비 UserAgent 목록
            user_agents = [
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36",
                "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.0.0 Safari/537.36 Edg/119.0.0.0",
                "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/17.0 Safari/605.1.15"
            ]
            user_agent = random.choice(user_agents)
            logging.info(f"예비 UserAgent 사용: {user_agent}")
        
        # 랜덤 창 크기
        window_width = random.randint(1200, 1920)
        window_height = random.randint(800, 1080)
        
        # undetected_chromedriver 설정
        options = uc.ChromeOptions()
        options.add_argument(f"--window-size={window_width},{window_height}")
        options.add_argument(f"user-agent={user_agent}")
        options.add_argument("--disable-blink-features=AutomationControlled")
        options.add_argument("--disable-dev-shm-usage")
        options.add_argument("--no-sandbox")
        options.add_argument("--disable-infobars")
        options.add_argument("--disable-extensions")
        options.add_argument("--disable-popup-blocking")
        options.add_argument("--disable-gpu")
        
        # 랜덤한 프로필 이름 생성
        profile_name = ''.join(random.choice(string.ascii_lowercase) for i in range(8))
        options.add_argument(f"--user-data-dir=./chrome_profiles/{profile_name}")
        
        # 디버깅 포트를 랜덤하게 설정
        debug_port = random.randint(9000, 9999)
        options.add_argument(f"--remote-debugging-port={debug_port}")
        
        # 브라우저 언어 설정
        options.add_argument("--lang=ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7")
        
        # 자동화 설정 비활성화
        options.add_argument("--disable-blink-features")
        
        # undetected_chromedriver 생성
        driver = uc.Chrome(options=options)
        
        # 창 크기 및 위치 추가 랜덤화
        driver.set_window_size(window_width, window_height)
        driver.set_window_position(random.randint(0, 100), random.randint(0, 100))
        
        # 자동화 플래그 수정
        driver.execute_script("Object.defineProperty(navigator, 'webdriver', {get: () => undefined})")
        driver.execute_script("Object.defineProperty(navigator, 'plugins', {get: function() { return [1, 2, 3, 4, 5]; }})")
        driver.execute_script("Object.defineProperty(navigator, 'languages', {get: function() { return ['ko-KR', 'ko', 'en-US', 'en']; }})")
        
        # 인간 같은 행동을 위한 암시적 대기 설정
        driver.implicitly_wait(random.uniform(3, 7))
        
        logging.info("스텔스 모드 브라우저 인스턴스 생성 성공")
        return driver
    except Exception as e:
        logging.error(f"스텔스 모드 브라우저 생성 실패: {str(e)}")
        logging.info("일반 모드로 대체 시도합니다...")
        return create_normal_browser()

def create_normal_browser():
    """기본적인 자동화 우회 설정이 적용된 일반 브라우저 생성"""
    options = Options()
    
    # 기본 설정
    options.add_argument("--start-maximized")
    options.add_argument("--disable-gpu")
    options.add_argument("--no-sandbox")
    options.add_argument("--disable-dev-shm-usage")
    
    # 자동화 감지 방지
    options.add_argument("--disable-blink-features=AutomationControlled")
    options.add_experimental_option("excludeSwitches", ["enable-automation"])
    options.add_experimental_option('useAutomationExtension', False)
    
    # 성능 최적화 설정
    options.add_argument("--disable-extensions")
    options.add_argument("--disable-notifications")
    options.page_load_strategy = 'eager'  # DOM이 준비되면 바로 진행
    
    # ChromeDriver 자동 설치 및 관리
    driver_path = ChromeDriverManager().install()
    service = Service(driver_path)
    
    # WebDriver 생성
    driver = webdriver.Chrome(service=service, options=options)
    driver.implicitly_wait(5)  # 암시적 대기 시간 설정
    
    # 추가적인 자동화 방지 스크립트 실행
    driver.execute_script("Object.defineProperty(navigator, 'webdriver', {get: () => undefined})")
    
    logging.info("일반 모드 브라우저 인스턴스 생성 성공")
    return driver

def add_human_like_behaviors(driver):
    """인간 같은 행동을 시뮬레이션하는 함수"""
    try:
        # 임의의 마우스 움직임 생성
        actions = ActionChains(driver)
        for _ in range(random.randint(3, 7)):
            x_offset = random.randint(-100, 100)
            y_offset = random.randint(-100, 100)
            actions.move_by_offset(x_offset, y_offset)
            
            # 일정 확률로 클릭 추가
            if random.random() < 0.2:
                actions.move_to_element_with_offset(driver.find_element(By.TAG_NAME, "body"), 
                                                 random.randint(0, 500), 
                                                 random.randint(0, 500))
                
            # 임의의 지연 추가
            time.sleep(random.uniform(0.1, 0.5))
        
        actions.perform()
        
        # 일정 확률로 페이지 스크롤
        if random.random() < 0.7:
            scroll_amount = random.randint(100, 700)
            driver.execute_script(f"window.scrollBy(0, {scroll_amount});")
            time.sleep(random.uniform(0.5, 1.5))
            
            # 다시 위로 스크롤할 확률
            if random.random() < 0.3:
                driver.execute_script(f"window.scrollBy(0, -{scroll_amount});")
                time.sleep(random.uniform(0.3, 0.7))
        
        logging.info("인간 같은 행동 시뮬레이션 완료")
    except Exception as e:
        logging.warning(f"인간 같은 행동 시뮬레이션 중 오류: {str(e)}")

def fast_select_date_and_reserve(driver):
    try:
        # 빠른 날짜 선택 (날짜 이동과 선택을 한번에 처리)
        logging.info("5월 17일 날짜 빠른 선택 시작...")
        start_time = time.time()
        
        # 인간 같은 행동 추가
        add_human_like_behaviors(driver)
        
        # 정확한 날짜 선택을 위한 여러 선택자 시도
        selectors = [
            # 선택자 1: 정확한 클래스 조합 (가장 정확함)
            "//div[contains(@class, 'react-datepicker__day--017') and contains(@class, 'react-datepicker__day--weekend')]",
            # 선택자 2: aria-label 속성 사용
            "//div[@aria-label='Choose 2025년 5월 17일 토요일']",
            # 선택자 3: 클래스와 텍스트 내용 함께 사용
            "//div[contains(@class, 'react-datepicker__day') and text()='17']",
            # 선택자 4: 간단한 텍스트 검색 (마지막 수단)
            "//*[text()='17']"
        ]
        
        # 선택자 순서를 랜덤하게 섞어 봇처럼 보이지 않게 함
        random.shuffle(selectors)
        
        # 모든 선택자 시도
        date_selected = False
        for selector in selectors:
            try:
                logging.info(f"선택자 시도: {selector}")
                
                # 인간같은 대기 시간 추가
                time.sleep(random.uniform(0.3, 1.0))
                
                date_element = WebDriverWait(driver, random.uniform(1.5, 3.0)).until(
                    EC.element_to_be_clickable((By.XPATH, selector))
                )
                
                # 요소로 스크롤
                driver.execute_script("arguments[0].scrollIntoView({block: 'center'});", date_element)
                time.sleep(random.uniform(0.2, 0.7))
                
                # 인간처럼 요소에 마우스 오버 먼저 수행
                ActionChains(driver).move_to_element(date_element).pause(random.uniform(0.1, 0.4)).perform()
                
                # 요소 클릭
                date_element.click()
                
                date_selected = True
                logging.info(f"선택자 성공: {selector}")
                
                # 클릭 후 인간같은 대기 시간 추가
                time.sleep(random.uniform(0.3, 0.8))
                break
            except Exception as e:
                logging.warning(f"선택자 실패: {selector} - {str(e)}")
                continue
        
        if not date_selected:
            logging.error("모든 선택자가 실패했습니다. JavaScript로 직접 클릭 시도...")
            # JavaScript로 직접 클릭 시도
            try:
                # 인간같은 행동 추가
                add_human_like_behaviors(driver)
                
                script = """
                    var dates = document.getElementsByClassName('react-datepicker__day');
                    for(var i = 0; i < dates.length; i++) {
                        if(dates[i].textContent === '17') {
                            // 먼저 요소를 화면 중앙으로 스크롤
                            dates[i].scrollIntoView({block: 'center'});
                            // 약간의 지연 후 클릭 (인간같은 행동)
                            setTimeout(function() {
                                dates[i].click();
                            }, Math.floor(Math.random() * 300) + 100);
                            return true;
                        }
                    }
                    return false;
                """
                date_selected = driver.execute_script(script)
                # 인간같은 대기 시간 추가
                time.sleep(random.uniform(0.5, 1.0))
                
                if date_selected:
                    logging.info("JavaScript로 날짜 선택 성공")
                else:
                    logging.error("JavaScript로도 날짜 선택 실패")
                    return False
            except Exception as e:
                logging.error(f"JavaScript 실행 오류: {str(e)}")
                return False
        
        # 인간 같은 행동 추가
        add_human_like_behaviors(driver)
        
        logging.info("예매 버튼 클릭 시도 중...")
        # 예매 버튼 클릭 (여러 선택자 시도)
        button_selectors = [
            "a.common_btn.btn_primary.btn_xlarge",
            "button.btn_primary",
            "//a[contains(@class, 'common_btn') and contains(@class, 'btn_primary')]",
            "//button[contains(text(), '예매하기')]"
        ]
        
        # 선택자 순서를 랜덤하게 섞어 봇처럼 보이지 않게 함
        random.shuffle(button_selectors)
        
        button_clicked = False
        for selector in button_selectors:
            try:
                # 인간같은 대기 시간 추가
                time.sleep(random.uniform(0.5, 1.2))
                
                if selector.startswith("//"):
                    # XPath 선택자
                    reserve_button = WebDriverWait(driver, random.uniform(1.5, 3.0)).until(
                        EC.element_to_be_clickable((By.XPATH, selector))
                    )
                else:
                    # CSS 선택자
                    reserve_button = WebDriverWait(driver, random.uniform(1.5, 3.0)).until(
                        EC.element_to_be_clickable((By.CSS_SELECTOR, selector))
                    )
                
                # 요소로 스크롤
                driver.execute_script("arguments[0].scrollIntoView({block: 'center'});", reserve_button)
                time.sleep(random.uniform(0.3, 0.8))
                
                # 인간처럼 요소에 마우스 오버 먼저 수행
                ActionChains(driver).move_to_element(reserve_button).pause(random.uniform(0.2, 0.5)).perform()
                
                # 클릭 전 현재 창 핸들 저장
                current_window = driver.current_window_handle
                logging.info(f"현재 창 핸들: {current_window}")
                
                # 버튼 클릭
                reserve_button.click()
                button_clicked = True
                logging.info(f"예매 버튼 클릭 성공: {selector}")
                
                # 인간같은 대기 시간 추가
                time.sleep(random.uniform(1.0, 2.0))
                
                # 새 창 감지
                new_windows = [window for window in driver.window_handles if window != current_window]
                if new_windows:
                    logging.info(f"새 창 감지됨! 총 {len(new_windows)}개의 새 창이 열렸습니다.")
                    
                    # 새 창으로 전환
                    driver.switch_to.window(new_windows[0])
                    logging.info(f"새 창 URL: {driver.current_url}")
                    
                    # 인간 같은 행동 추가
                    add_human_like_behaviors(driver)
                    
                    # 특정 URL 확인
                    expected_url = "https://www.ticketlink.co.kr/reserve/plan/schedule/1170794641"
                    if expected_url in driver.current_url:
                        logging.info("✓ 예상 URL로 올바르게 이동했습니다!")
                    else:
                        logging.warning(f"! 예상 URL과 다릅니다. 현재: {driver.current_url}")
                    
                    # 새 창 스크린샷 저장
                    try:
                        screenshot_path = f"new_window_screenshot_{int(time.time())}.png"
                        driver.save_screenshot(screenshot_path)
                        logging.info(f"새 창 스크린샷 저장: {screenshot_path}")
                    except Exception as e:
                        logging.error(f"스크린샷 저장 실패: {str(e)}")
                else:
                    logging.warning("새 창이 감지되지 않았습니다!")
                
                break
            except Exception as e:
                logging.warning(f"예매 버튼 클릭 실패: {selector} - {str(e)}")
                continue
        
        if not button_clicked:
            logging.error("모든 예매 버튼 선택자가 실패했습니다. JavaScript로 직접 클릭 시도...")
            # JavaScript로 직접 클릭 시도
            try:
                # 인간같은 행동 추가
                add_human_like_behaviors(driver)
                
                script = """
                    var buttons = document.querySelectorAll('a.common_btn, button.btn_primary, a.btn_primary');
                    for(var i = 0; i < buttons.length; i++) {
                        if(buttons[i].textContent.includes('예매') || buttons[i].textContent.includes('예약')) {
                            // 먼저 요소를 화면 중앙으로 스크롤
                            buttons[i].scrollIntoView({block: 'center'});
                            // 약간의 지연 후 클릭 (인간같은 행동)
                            setTimeout(function() {
                                buttons[i].click();
                            }, Math.floor(Math.random() * 300) + 100);
                            return true;
                        }
                    }
                    return false;
                """
                button_clicked = driver.execute_script(script)
                # 인간같은 대기 시간 추가
                time.sleep(random.uniform(1.0, 2.0))
                
                if button_clicked:
                    logging.info("JavaScript로 예매 버튼 클릭 성공")
                    
                    # 새 창 감지 시도
                    time.sleep(random.uniform(1.0, 2.0))
                    if len(driver.window_handles) > 1:
                        new_window = driver.window_handles[-1]
                        driver.switch_to.window(new_window)
                        logging.info(f"JavaScript 클릭 후 새 창 감지! URL: {driver.current_url}")
                        
                        # 인간 같은 행동 추가
                        add_human_like_behaviors(driver)
                    else:
                        logging.warning("JavaScript 클릭 후 새 창 감지 실패")
                else:
                    logging.error("JavaScript로도 예매 버튼 클릭 실패")
                    return False
            except Exception as e:
                logging.error(f"JavaScript 실행 오류: {str(e)}")
                return False
        
        end_time = time.time()
        execution_time = end_time - start_time
        logging.info(f"날짜 선택 및 예매 버튼 클릭 완료: {execution_time:.3f}초 소요")
        
        return True
        
    except Exception as e:
        logging.error(f"날짜 선택/예매 중 오류 발생: {str(e)}")
        # 스크린샷 저장 시도
        try:
            screenshot_path = f"error_screenshot_{int(time.time())}.png"
            driver.save_screenshot(screenshot_path)
            logging.info(f"에러 발생 시점 스크린샷 저장: {screenshot_path}")
        except:
            logging.error("스크린샷 저장 실패")
        return False

def test_new_window_detection(driver, url):
    """새 창 감지 기능만 테스트하는 함수"""
    try:
        logging.info(f"새 창 감지 테스트 시작: {url}")
        
        # 인간 같은 행동 추가
        add_human_like_behaviors(driver)
        
        # 현재 창 핸들 저장
        current_window = driver.current_window_handle
        logging.info(f"현재 창 핸들: {current_window}")
        
        # JavaScript로 새 창 열기
        driver.execute_script(f"window.open('{url}', '_blank');")
        logging.info("JavaScript로 새 창 열기 명령 실행")
        
        # 인간같은 대기 시간 추가
        time.sleep(random.uniform(1.0, 2.0))
        
        # 새 창 감지
        new_windows = [window for window in driver.window_handles if window != current_window]
        if new_windows:
            logging.info(f"새 창 감지됨! 총 {len(new_windows)}개의 새 창이 열렸습니다.")
            
            # 새 창으로 전환
            driver.switch_to.window(new_windows[0])
            logging.info(f"새 창 URL: {driver.current_url}")
            
            # 인간 같은 행동 추가
            add_human_like_behaviors(driver)
            
            # 예상 URL 확인
            if url in driver.current_url:
                logging.info("✓ 예상 URL로 올바르게 이동했습니다!")
            else:
                logging.warning(f"! 예상 URL과 다릅니다. 현재: {driver.current_url}")
            
            # 새 창 스크린샷 저장
            try:
                screenshot_path = f"test_window_screenshot_{int(time.time())}.png"
                driver.save_screenshot(screenshot_path)
                logging.info(f"새 창 스크린샷 저장: {screenshot_path}")
            except Exception as e:
                logging.error(f"스크린샷 저장 실패: {str(e)}")
                
            # 인간같은 대기 시간 추가
            time.sleep(random.uniform(0.5, 1.5))
            
            # 원래 창으로 돌아가기
            driver.switch_to.window(current_window)
            logging.info("원래 창으로 복귀")
            
            return True
        else:
            logging.warning("새 창이 감지되지 않았습니다!")
            return False
            
    except Exception as e:
        logging.error(f"새 창 감지 테스트 중 오류 발생: {str(e)}")
        return False

def main():
    logging.info("⏳ 티켓팅 봇 시작")
    driver = None
    
    try:
        # 스텔스 모드 선택
        stealth_mode = input("스텔스 모드를 사용하시겠습니까? (y/n, 기본값: y): ").strip().lower() != 'n'
        
        # 브라우저 인스턴스 생성
        driver = create_browser_instance(use_stealth_mode=stealth_mode)
        
        # 테스트 모드 선택
        test_type = input("테스트 모드를 선택하세요 (1: 새 창 감지 테스트, 2: 전체 티켓팅 프로세스): ")
        
        if test_type == "1":
            # 새 창 감지 테스트
            test_url = "https://www.ticketlink.co.kr/reserve/plan/schedule/1170794641?menuIndex=reserve"
            logging.info(f"새 창 감지 테스트를 시작합니다. URL: {test_url}")
            driver.get(TARGET_URL)  # 먼저 기본 페이지로 이동
            
            # 인간같은 대기 시간 추가
            time.sleep(random.uniform(2.0, 4.0))
            
            # 인간 같은 행동 추가
            add_human_like_behaviors(driver)
            
            result = test_new_window_detection(driver, test_url)
            if result:
                logging.info("새 창 감지 테스트 성공!")
            else:
                logging.error("새 창 감지 테스트 실패!")
        else:
            # 티켓팅 페이지로 이동
            logging.info("티켓팅 페이지로 이동 중...")
            driver.get(TARGET_URL)
            
            # 인간 같은 행동 추가
            add_human_like_behaviors(driver)
            
            # 로그인을 위한 시간 제공
            logging.info("수동 로그인을 위한 시간입니다. 로그인을 완료해주세요...")
            input("로그인 완료 후 Enter 키를 눌러주세요...")
            
            # 인간 같은 행동 추가
            add_human_like_behaviors(driver)
            
            # 빠른 날짜 선택 및 예매 버튼 클릭
            logging.info("티켓팅 시작...")
            fast_select_date_and_reserve(driver)
        
        logging.info("티켓팅 프로세스 완료. 종료하려면 Ctrl+C를 누르세요.")
        input("프로그램을 종료하려면 Enter 키를 누르세요...")
        
    except KeyboardInterrupt:
        logging.info("사용자에 의해 프로그램이 종료되었습니다.")
    except Exception as e:
        logging.error(f"오류 발생: {str(e)}")
    finally:
        logging.info("프로그램 종료")

if __name__ == "__main__":
    main() 