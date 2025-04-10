from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from webdriver_manager.chrome import ChromeDriverManager
import time
import logging
import sys

# 로깅 설정
logging.basicConfig(
    level=logging.INFO,
    format='%(asctime)s - %(levelname)s - %(message)s',
    handlers=[
        logging.FileHandler('devtools.log', encoding='utf-8'),
        logging.StreamHandler()
    ]
)

def create_browser_instance():
    """브라우저 인스턴스 생성"""
    try:
        options = Options()
        options.add_argument("--start-maximized")
        options.add_argument("--auto-open-devtools-for-tabs")  # 개발자 도구 자동 열림
        options.add_argument("--disable-blink-features=AutomationControlled")
        options.add_experimental_option("excludeSwitches", ["enable-automation"])
        options.add_experimental_option('useAutomationExtension', False)
        
        # ChromeDriver 자동 설치 및 관리
        driver_path = ChromeDriverManager().install()
        service = Service(driver_path)
        
        # WebDriver 생성
        driver = webdriver.Chrome(service=service, options=options)
        
        # 자동화 감지 방지 스크립트 실행
        driver.execute_script("Object.defineProperty(navigator, 'webdriver', {get: () => undefined})")
        
        logging.info("브라우저 인스턴스 생성 성공")
        return driver
    except Exception as e:
        logging.error(f"브라우저 인스턴스 생성 실패: {str(e)}")
        raise

def force_open_devtools(driver, url=None):
    """이미 열린 페이지에서 개발자 도구 강제 열기"""
    try:
        if url:
            logging.info(f"URL로 이동: {url}")
            driver.get(url)
        
        logging.info("개발자 도구 강제 열기 시도...")
        
        # 방법 1: JavaScript를 통해 개발자 도구 열기 (Chrome에서 작동)
        driver.execute_script("""
            (() => {
                try {
                    // 개발자 도구를 여는 여러 방법 시도
                    // 1. 키보드 단축키 에뮬레이션 (간접적)
                    const keyEvent = new KeyboardEvent('keydown', {
                        key: 'I',
                        code: 'KeyI',
                        ctrlKey: true,
                        shiftKey: true,
                        bubbles: true
                    });
                    document.dispatchEvent(keyEvent);
                    
                    // 2. debug 호출 (콘솔 열림)
                    setTimeout(() => {
                        console.debug('강제 개발자 도구 열기 시도');
                        debugger;
                    }, 1000);
                    
                    // 3. 중단점 삽입
                    setTimeout(() => {
                        debugger;
                    }, 2000);
                    
                    return "개발자 도구 열기 시도 완료";
                } catch (e) {
                    return "개발자 도구 열기 실패: " + e.toString();
                }
            })();
        """)
        
        # 방법 2: Chrome DevTools Protocol 접근 (CDP)
        driver.execute_cdp_cmd('Emulation.setDeviceMetricsOverride', {
            'mobile': False,
            'width': 1920,
            'height': 1080,
            'deviceScaleFactor': 1
        })
        
        # 잠시 대기
        time.sleep(2)
        
        # 현재 페이지에서 개발자 도구가 열려있는지 확인 (간접적)
        dev_tools_status = driver.execute_script("""
            return window.outerHeight - window.innerHeight > 200 ? "개발자 도구가 열린 것으로 추정됨" : "개발자 도구가 열리지 않은 것으로 추정됨";
        """)
        
        logging.info(f"개발자 도구 상태: {dev_tools_status}")
        
        # 추가 방법: 지속적인 디버깅 모드 활성화
        driver.execute_script("""
            // 5초마다 debugger 트리거
            setInterval(() => {
                try {
                    debugger;
                } catch (e) {
                    console.error(e);
                }
            }, 5000);
        """)
        
        # 특정 사이트의 제한 우회 시도
        bypass_restrictions(driver)
        
        return True
    except Exception as e:
        logging.error(f"개발자 도구 열기 실패: {str(e)}")
        return False

def bypass_restrictions(driver):
    """사이트의 개발자 도구 제한 우회 시도"""
    try:
        logging.info("제한 우회 시도...")
        
        # 1. 디버깅 방지 기능 무력화 시도
        disable_protection_script = """
        (() => {
            // 디버거 감지 함수 무력화
            const originalKeys = Object.keys(window);
            
            // debugger 문 차단 우회
            const originalEval = window.eval;
            window.eval = function(s) {
                if (s.includes('debugger')) {
                    console.log("Debugger statement blocked");
                    return;
                }
                return originalEval.apply(this, arguments);
            };
            
            // F12 키 이벤트 차단 방지
            window.addEventListener('keydown', function(e) {
                if (e.key === 'F12' || 
                    (e.ctrlKey && e.shiftKey && e.key === 'I') || 
                    (e.ctrlKey && e.shiftKey && e.key === 'J') ||
                    (e.ctrlKey && e.shiftKey && e.key === 'C')) {
                    e.stopImmediatePropagation();
                }
            }, true);
            
            // 개발자 도구 감지 속성 제거
            Object.defineProperty(window, 'devtools', {
                get: function() { return undefined; }
            });
            
            // 콘솔 차단 우회
            for (const method of ['log', 'debug', 'info', 'warn', 'error']) {
                if (console[method]._originalMethod) continue;
                console[method]._originalMethod = console[method];
            }
            
            return "보호 기능 우회 시도 완료";
        })();
        """
        result = driver.execute_script(disable_protection_script)
        logging.info(f"보호 기능 우회 결과: {result}")
        
        # 2. document.designMode 활성화 (일부 사이트의 JavaScript 제한을 우회할 수 있음)
        driver.execute_script("document.designMode = 'on';")
        
        # 3. 콘솔에서 사용할 수 있는 유틸리티 함수 주입
        driver.execute_script("""
        window.forceDevTools = {
            openConsole: function() {
                console.log("콘솔 열기 시도");
                setTimeout(() => { debugger; }, 100);
            },
            disableProtection: function() {
                // 모든 이벤트 리스너 우회
                const oldAddEventListener = EventTarget.prototype.addEventListener;
                EventTarget.prototype.addEventListener = function(type, listener, options) {
                    if (type === 'keydown' || type === 'contextmenu') {
                        console.log("키 또는 컨텍스트 메뉴 이벤트 리스너 차단됨");
                        return;
                    }
                    return oldAddEventListener.apply(this, arguments);
                };
                return "이벤트 보호 비활성화 됨";
            }
        };
        console.log("forceDevTools 도구가 전역 객체에 추가되었습니다. forceDevTools.openConsole() 호출로 콘솔을 열 수 있습니다.");
        """)
        
        # 4. 이 사이트에 맞는 특정 우회 기법
        if "ticketlink.co.kr" in driver.current_url:
            logging.info("티켓링크 사이트 감지됨, 맞춤형 우회 적용...")
            driver.execute_script("""
            // 티켓링크 사이트에 맞는 특정 우회 로직
            (() => {
                // 개발자 도구 차단 메서드 찾기 및 비활성화
                try {
                    // 전역 이벤트 리스너 제거 (F12 키 등을 막는 리스너)
                    const oldAddEventListener = EventTarget.prototype.addEventListener;
                    EventTarget.prototype.addEventListener = function(type, listener, options) {
                        if (type === 'keydown' || type === 'contextmenu') {
                            // 이벤트 리스너 자체를 무시
                            return;
                        }
                        return oldAddEventListener.apply(this, arguments);
                    };
                    
                    // 모든 전역 변수 스캔해서 디버거 감지 함수 무력화
                    Object.keys(window).forEach(key => {
                        try {
                            if (typeof window[key] === 'function' && 
                                window[key].toString().includes('debugger')) {
                                console.log('디버거 감지 함수 발견:', key);
                                window[key] = function() { return false; };
                            }
                        } catch (e) {}
                    });
                    
                    // 티켓링크 특화 우회
                    if (window.TL && window.TL.COMM) {
                        // 가능한 TL 객체 내부의 보안 함수 무력화
                        console.log('티켓링크 TL 객체 발견');
                    }
                    
                    return "티켓링크 맞춤 보호 우회 시도 완료";
                } catch (e) {
                    return "티켓링크 맞춤 보호 우회 실패: " + e.toString();
                }
            })();
            """)
        
        return True
    except Exception as e:
        logging.error(f"제한 우회 실패: {str(e)}")
        return False

def main():
    url = "https://www.ticketlink.co.kr/reserve/plan/schedule/1170794641?menuIndex=reserve"
    target_url = input(f"개발자 도구를 열 URL을 입력하세요 (기본값: {url}): ").strip()
    
    if not target_url:
        target_url = url
    
    try:
        # 1. 브라우저 인스턴스 생성 (이미 개발자 도구 열기 옵션이 포함됨)
        driver = create_browser_instance()
        
        # 2. 페이지로 이동
        driver.get(target_url)
        logging.info(f"페이지 로드됨: {target_url}")
        
        # 3. 추가적으로 강제 개발자 도구 열기 시도
        force_open_devtools(driver)
        
        # 4. 수동 방법 안내
        print("\n=== 수동으로 개발자 도구 열기 ===")
        print("1. 브라우저 창에서 새로고침 후 즉시 F12 또는 Ctrl+Shift+I를 누르세요.")
        print("2. 콘솔에서 다음 코드를 실행해 보세요: debugger;")
        print("3. 대상 사이트의 파일 소스를 확인하려면 콘솔에 다음을 입력하세요:")
        print("   - document.documentElement.innerHTML")
        print("4. 콘솔에서 forceDevTools.openConsole()을 실행해보세요.")
        print("5. 콘솔에서 forceDevTools.disableProtection()을 실행해보세요.")
        
        input("브라우저를 종료하려면 Enter 키를 누르세요...")
        
    except Exception as e:
        logging.error(f"오류 발생: {str(e)}")
    finally:
        logging.info("프로그램 종료")

if __name__ == "__main__":
    main() 