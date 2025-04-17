import pyautogui
import time

# 검색할 영역을 정의하는 이미지 파일 경로
region_image_path = 'target_image2.png'
# 영역 내에서 클릭할 대상 이미지 파일 경로
target_image_path = 'target_image.png'

region_confidence = 0.9 # 영역(target2) 검색 confidence
target_confidence = 0.95 # 대상(target1) 검색 confidence

print("자동 클릭 스크립트 시작...")

while True: # 전체 과정을 무한 반복
    try:
        # 1. 검색 영역 이미지(target_image2.png)를 찾을 때까지 반복
        print(f"'{region_image_path}' 이미지를 찾는 중...")
        search_region = None
        while search_region is None:
            search_region = pyautogui.locateOnScreen(region_image_path, confidence=region_confidence)
            if search_region:
                print(f"'{region_image_path}' 찾음. 영역: {search_region}")
                break # 영역 찾으면 내부 루프 탈출
            else:
                # 찾지 못하면 1초 대기 후 다시 시도
                time.sleep(1)

        # 2. 찾은 영역(search_region) 내에서 대상 이미지(target_image.png) 검색 (한 번 시도)
        print(f"영역 {search_region} 내에서 '{target_image_path}' 검색 중...")
        time.sleep(0.5) # 영역 나타난 후 잠시 대기

        target_location = pyautogui.locateCenterOnScreen(
            target_image_path,
            confidence=target_confidence,
            region=search_region
        )

        # 3. 결과에 따라 처리
        if target_location:
            print(f"'{target_image_path}' 찾음. 위치: {target_location}. 클릭 실행.")
            pyautogui.click(target_location)
            # 클릭 후 다음 검색까지 잠시 대기 (필요 시 시간 조절)
            print("클릭 완료. 2초 후 다음 영역 검색 시작...")
            time.sleep(2)
        else:
            print(f"영역 내에서 '{target_image_path}' 찾지 못함.")
            # 찾지 못했을 때도 잠시 대기 후 다음 영역 검색 시작
            print("1초 후 다음 영역 검색 시작...")
            time.sleep(1)

    except pyautogui.ImageNotFoundException:
        # locateOnScreen 에서 파일을 못 찾는 경우 거의 없지만 안전을 위해 유지
        print(f"오류: '{region_image_path}' 또는 '{target_image_path}' 이미지 파일 자체를 찾을 수 없습니다. 경로를 확인하세요.")
        print("5초 후 재시도...")
        time.sleep(5)
    except Exception as e:
        print(f"알 수 없는 오류 발생: {e}")
        print("5초 후 재시도...")
        time.sleep(5)
