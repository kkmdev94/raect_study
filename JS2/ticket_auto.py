import pyautogui
import time

# 좌석 이미지 파일명
SEAT_IMAGE = "vip_c_seat.png"
RESERVE_IMAGE = "reserve_button.png"  # 예매하기 버튼 이미지도 따로 저장해놔야 함

def refresh():
    pyautogui.press('f5')
    print("🔄 새로고침!")
    time.sleep(1.5)  # 로딩 시간 고려

def find_and_click(image_path, description, confidence=0.85):
    location = pyautogui.locateOnScreen(image_path, confidence=confidence)
    if location:
        center = pyautogui.center(location)
        pyautogui.click(center)
        print(f"✅ {description} 클릭 완료!")
        return True
    return False

def main_loop():
    print("🎯 자동 좌석 탐색 시작 (Ctrl+C로 중단)")
    while True:
        refresh()

        if find_and_click(SEAT_IMAGE, "타겟 좌석"):
            time.sleep(0.5)  # 예매 버튼 로딩 고려
            if find_and_click(RESERVE_IMAGE, "예매하기 버튼"):
                print("🎉 예매 시도 완료!")
                break
            else:
                print("⚠️ 예매하기 버튼을 찾을 수 없음. 계속 시도 중...")

        time.sleep(0.3)  # 너무 빠르면 서버가 감지할 수도 있어

if __name__ == "__main__":
    main_loop()
