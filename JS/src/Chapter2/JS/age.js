
  function calc() {
  var currentYear = 2025;
  var birthYear = prompt("태어난 년도를 입력하세요.", "YYYY");
  var age = currentYear - birthYear + 1;
  document.querySelector("#result").innerHTML = "당신의 나이는" + age + "세 입니다.";
}