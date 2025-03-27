// heading 변수 선언 -> h1 태그를 저장
var heading = document.querySelector("#heading");
// h1태그를 클릭하면 글자 색깔을 변하게 하는 함수를 만들었다.
heading.onclick = function () {
  heading.style.color = "red";
}