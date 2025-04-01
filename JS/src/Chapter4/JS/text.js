function hello() {
  let rnd1 = Math.floor(Math.random() * 20);
  let rnd2 = Math.floor(Math.random() * 40);
  let rnd3 = Math.floor(Math.random() * 3) + 100;

  $(".hello").css({ // 글자 흔들기
    "bottom" : rnd1,
    "left" : rnd2
  })
  // 배경 확대
  $(".hello .text").css({"background-size" : rnd3 + "%"});
}
setInterval(hello, 10); // 0.01초마다 hello 흔들기