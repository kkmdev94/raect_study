# NextButton이 나오면 클릭 (selenium을 이용해서 xpahx나 class 값으로 클릭하게 만듬)
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.options import Options

def ClickButton() :
    #env로 가상환경만들지 아니면 docker file에 python을 추가할지 고민
    a
# 강의가 종료될때까지 대기..(이부분 대기를 어떻게 진행할지 고민)
# 다시 강의가 종료되고 나오면은 다음버튼 클릭(xpath나 class로 1번에서 해결한거를 함수로 만들어서 다시 호출하기)
# 특정한 키를 누르면 종료(특정키 조합을 누르면 종료되는것 or 다음수업 버튼이 비활성화되면 강제로 종료되게 하기)