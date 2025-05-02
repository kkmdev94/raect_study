// 전역 scope / 지역 scope

//전역
let globalNum = 100; // 전역 변수 -> 어디서든 사용 가능.

function testFunc() {
    console.log(globalNum);
}

testFunc();
console.log(globalNum);

//지역

function testFunc2() {
    let innerNum = 50; // 지역 변수 -> 선언한 그 공간(지역)에서만 사용 가능.
    console.log(globalNum);
    console.log(innerNum);
}

testFunc2();
console.log(globalNum);
// console.log(innerNum);

function print2() {
    for (let i = 0; i < 10; i++) { // 블록스코프
        console.log(i);
    }
    // console.log(i); // i는 블록 스코프라 접근이 불가능하다.
}

print2();

function print3() {
    for (var i = 0; i < 10; i++) { // var는 함수 스코프
        console.log(i);
    }
    console.log(i); // var 키워드로 선언된 변수는 함수 스코프로 가진다.
}

print3();

// let과 var의 차이점 -> let 키워드로 선언된 변수는 블록스코프를 var키워드로 선언된 변수는 함수 스코프를 갖는다.

// let num = 10;
// let num = 100; // 같은 변수명 동시 선언 불가

var num = 11;
var num = 101; // var 키워드는 동일 변수명 선언 가능하며, 기존에 선언된 변수는 무시됨.
// var는 오래된 변수 선언 방식으로 이제는 잘 사용하지 않으며 신뢰성이 낮아 ES6버전에 도입된 let과 CONST를 주로 사용한다.

console.log(num);

