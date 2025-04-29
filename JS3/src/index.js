let name = 'KKI';
name = 'hyobin'; // 변수 명에는 $, _ 기호 제외 사용 X / 맨 앞에 숫자 X / 예약어 사용 X
console.log(name);

const NAME = 'KKIs'; // 상수에서는 let이 아닌 const를 사용하여 상수를 명명. / 자바와 같이 모두 대문자로 선언.
console.log(NAME);

/*
// 원시 타입 -> 아래의 예제처럼 어떤 자료형(String, int ...)이든 한 번에 단 하나의 값만을 가지는 자료형을 원시 타입 자료형이라 한다.
let num = 123; // int만 가지고 있으므로 원시 타입 자료형
num = 'four'; // string만 가지고 있으므로 원시 타입 자료형
// 비 원시 타입
let arr = [1, 'two', 3]; // Array 배열처럼 한번에 여러 타입을 가지고 있는 변수를 비 원시형(BIC) 타입 자료형이라고 부른다
 */

// typeof -> JS에서 기본으로 제공하는 연산자로, 특정 변수의 자료형을 결과값으로 반환하는 연산자.
let num = 10;
console.log(typeof num); // typeof 연산자를 통해 해당 num이라는 변수의 타입을 알 수 있다.

// 숫자형
let num1 =123;
let num2 = 10.00012;

console.log(typeof  num1);
console.log(typeof num2);

let num3 = Infinity;
console.log('a = ' + typeof num3); // number로 출력된다. 이 Infinity를 출력하고 싶다면
let num4 = 100 / 0 ; // 임시로 예를 든것이고, 어떠한 숫자를 0으로 나눈 값을 변수에 할당 후 tyepof를 쓰지않고 출력하면 Infinity를 출력할 수 있다.
console.log('b = ' + num4); // 어느 숫자든 0으로 나누변 반환되는 값이다.

let number = NaN; // 동일하게 number로 표시
console.log(typeof number);

let number2 = 'javascript' / 10; // 부정확한 연산(예시 처럼 글자를 숫자로 나눈다는 등)을 하면 none이라는 값이 출력된다.
console.log(number);
// 이렇게 JS는 부정확한 연산이나 0으로 나누는 연산을 진행해도 에러가 발생하는게 아닌 Infinity나 NaN을 반환한다.