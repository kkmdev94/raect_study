// 함수 선언식 / 함수 표현식 / 화살표 함수

// 화살표함수 -> ES6 이후 도입
/*
const sum = (a, b) => { // 이렇게 function을 사용하지 않고 =>를 통해 함수를 변수에 담는것으로 쉽고 빠르게 표현할 수 있다 하여 함수 표현식의 화살표 함수라고한다.
    return a + b;
}
 */

// 함수 표현식 = 변수에 함수를 마치 하나의 값처럼 할당 (익명 함수도 포함)
/*
const func = function () {} -> 함수의 이름을 정하지 않고 변수에 바로 담는 것 (익명 함수)
const func = () => {} -> 위에서 설명한 화살표 함수
호이스팅 관련해서 함수 표현식은 변수에 함수를 할당하는 방식이라 함수전체를 호이스팅하는 선언식과는 다르게 변수의 선언부분만 호이스팅되어 변수 호이스팅과 동일하게
초기화가 이루어지기 전까지 TDG에 들어가기에 사용을 할 수 없다.
 */

// 함수 선언식 = function 키워드 옆에 함수 이름 작성 (여태쓰던 방식)
/*
function func() {} -> 함수 선언식
호이스팅 관련해서 함수 선언식은 선언문 전체가 호이스팅이 되므로 함수를 선언하기 전에 호출을 하더라도 문제가 없다.
 */

// 화살표 함수 사용

const add = function (a, b) {
    return a + b;
};

console.log(add(1, 2));

const add2 = (a, b) =>  a + b; // 중괄호와 return 생략 가능. 코드가 간결해진다.
console.log(add2(10, 20));

// 콜백 함수 -> 다른 함수의 매개변수로 넘겨준 함수

// const printResult = (a,b) =>{
//     let result = a + b;
//     console.log('결과 = ' + result);
// }
//
// const doubleResult = (a,b) => {
//     let result = a + b;
//     console.log('결과에 2를 곱한 값 : ' + result * 2);
// }
//
// printResult(5, 3);
// doubleResult(5, 3);

// 콜백함수를 통해 result와 매개변수로 받는곳을 합칠 수 있을 것 같다.
const calculate = (a, b, callback) => {
    let result = a + b;
    callback(result);
};

const printResult = (result) =>{
    console.log('결과 = ' + result);
}

const doubleResult = (result) => {
    console.log('결과에 2를 곱한 값 : ' + result * 2);
}

calculate(5, 3, printResult);
calculate(5, 3, doubleResult);

// 간단한 콜백 함수

const testFunc = (callback) => {
    callback();
}

testFunc(() => {
    console.log('test');
});