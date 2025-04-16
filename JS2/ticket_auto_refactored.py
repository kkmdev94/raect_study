import pyautogui
import time
import os # os 모듈 추가

# 검색할 영역을 정의하는 이미지 파일 경로
region_image_path = 'target_image2.png'
# 영역 내에서 클릭할 대상 이미지 파일 경로
target_image_path = 'target_image.png'
# 클릭하려는 다음 버튼 이미지 파일 경로 (필요하다면 사용)
# next_button_path = 'next_button.png'

region_confidence = 0.9 # 영역(target2) 검색 confidence
target_confidence = 0.95 # 대상(target1) 검색 confidence (0.95로 높임)
debug_region_screenshot_path = 'debug_found_region.png'
debug_target1_context_screenshot_path = 'debug_found_target1_context.png' # Target1 찾았을 때 Context 스크린샷

try:
    # 이전 디버그 스크린샷 파일 삭제
    for f in [debug_region_screenshot_path, debug_target1_context_screenshot_path]:
        if os.path.exists(f):
            os.remove(f)

    # 1. 검색 영역 이미지(target_image2.png)를 찾을 때까지 반복
    print(f"검색 영역 이미지 '{region_image_path}'를 찾는 중 (Confidence: {region_confidence})...")
    search_region = None
    while search_region is None:
        # region은 Box 객체 (left, top, width, height)를 반환
        search_region = pyautogui.locateOnScreen(region_image_path, confidence=region_confidence)
        if search_region:
            print(f"검색 영역 이미지 '{region_image_path}'를 찾았습니다. 영역: {search_region}")
            # 스크린샷 저장 시 튜플로 변환하여 전달
            try:
                screenshot_region_tuple = (search_region.left, search_region.top, search_region.width, search_region.height)
                pyautogui.screenshot(debug_region_screenshot_path, region=screenshot_region_tuple)
                print(f"'{debug_region_screenshot_path}'로 찾은 영역 스크린샷 저장 완료.")
            except Exception as e_screenshot:
                print(f"디버그 스크린샷 저장 중 오류 발생: {e_screenshot}")
            break
        else:
            print(f"'{region_image_path}' 이미지를 아직 찾지 못했습니다. 1초 후 다시 시도합니다.")
            time.sleep(1)

    # 2. 찾은 영역(search_region) 내에서 대상 이미지(target_image.png) 검색 및 클릭
    print(f"\n영역 {search_region} 내에서 '{target_image_path}' 이미지를 찾는 중 (Confidence: {target_confidence})...")
    target_location = None
    time.sleep(0.5) # 영역이 안정화될 시간

    # 검색 영역을 튜플로 미리 준비
    search_region_tuple = (search_region.left, search_region.top, search_region.width, search_region.height)

    target_location = pyautogui.locateCenterOnScreen(
        target_image_path,
        confidence=target_confidence, # 높아진 confidence 적용
        region=search_region_tuple # 튜플 형태로 전달 (안정성을 위해)
    )

    if target_location:
        # 추가 검증: 찾은 위치가 실제로 search_region 내부에 있는지 확인
        if (search_region.left <= target_location.x < search_region.left + search_region.width and
            search_region.top <= target_location.y < search_region.top + search_region.height):

            print(f"영역 내에서 '{target_image_path}' 이미지를 찾았습니다. 위치: {target_location}")
            # Context 스크린샷 저장 시 튜플로 변환하여 전달
            try:
                pyautogui.screenshot(debug_target1_context_screenshot_path, region=search_region_tuple)
                print(f"'{debug_target1_context_screenshot_path}'로 Target1 찾은 시점의 Context 스크린샷 저장 완료.")
            except Exception as e_screenshot:
                print(f"Target1 Context 디버그 스크린샷 저장 중 오류 발생: {e_screenshot}")

            pyautogui.click(target_location)
            print("대상 이미지를 클릭했습니다.")

            # 3. (선택 사항) 다음 버튼 찾기 및 클릭 로직 추가
            # print(f"\n'{next_button_path}' 이미지를 찾는 중...")
            # time.sleep(1) # 대상 클릭 후 다음 버튼이 나타날 시간을 잠시 줍니다.
            # next_button_location = pyautogui.locateCenterOnScreen(next_button_path, confidence=0.8)
            # if next_button_location:
            #     print(f"'{next_button_path}' 이미지를 찾았습니다. 위치: {next_button_location}")
            #     pyautogui.click(next_button_location)
            #     print("다음 버튼을 클릭했습니다.")
            # else:
            #     print(f"'{next_button_path}' 이미지를 화면에서 찾을 수 없습니다.")

        else:
            # 찾았다고 나왔지만 영역 밖에 있는 경우 (오인식 가능성 높음)
            print(f"  -> 경고: 찾은 위치 {target_location}가 검색 영역 {search_region} 밖에 있습니다. 오인식으로 판단하여 무시합니다.")
            target_location = None # 클릭하지 않도록 위치 무효화

    # 최종적으로 target_location이 유효한 경우에만 다음 단계 진행 (위에서 None 처리되었을 수 있음)
    if not target_location:
         print(f"영역 {search_region} 내에서 유효한 '{target_image_path}' 이미지를 최종적으로 찾지 못했습니다.")

except pyautogui.ImageNotFoundException:
    # locateOnScreen/locateCenterOnScreen 이 None을 반환하므로 이 예외는 잘 발생하지 않으나,
    # 파일 자체를 못찾는 경우 등을 대비해 남겨둡니다.
    print("오류: 이미지 파일을 찾을 수 없습니다. 파일 경로를 확인하세요.")
except Exception as e:
    print(f"알 수 없는 오류 발생: {e}")
