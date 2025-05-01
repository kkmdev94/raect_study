// 산술 연산자

let num1 = 10;
let num2 = 5;

console.log(num1 + num2);
console.log(num1 - num2);
console.log(num1 * num2);
console.log(num1 / num2);
console.log(num1 % num2);

// 증감 연산자

console.log(num1++);
console.log(++num1);

// 감소 연산자
console.log(num1--);
console.log(--num1);

// 대입 연산자 / 복합 대입 연산자 +=, -=, *=, /=, %=
let num = 10;
// num = num + 5;
num += 5;
console.log(num)

// 비교 연산자

// 일치 / === or ==

let num3 = 10;
let num4 = '10';

console.log(num3 === num4); // 두 변수의 자료형까지 비교
console.log(num3 == num4); // 오직 값만 비교

// 불일치
console.log(num3 !== num4); // 두 변수의 자료형까지 비교
console.log(num3 != num4); // 오직 값만 비교

// 대소 비교 / <, >, <= , >=

let a = 10;
let b = 20;
let c = 10;

console.log(a < b);
console.log(a > b);
console.log(a >= c);
console.log(a > c);

// 연결 연산자 / 숫자와 숫자를 더할떄 사용하면 더하기 연산자가 되고, 플러스 기호 옆ㅇ ㅔ문자열이 하나라도 존재하면 연결 연산자로 작동

let price = 10000;
console.log("가격 = " + price + "원");

// 논리 연산자 / true 와 false / NOT OR AND가 존재

// NOT = ~이 아니라면 기호는 ! / fasle -> true, true -> false

let isClicked = true;
let isOpened = false;

console.log(!isClicked);
console.log(!isOpened);

// OR = 또는 기호는 || / 해당 기호의 양 옆 값이 하나라도 true이면 true를 반환
console.log('============================');
console.log(true || true);
console.log(true || false);
console.log(false || true);
console.log(false || false);

// AND = 그리고 기호는 && / || 와는 반대로 하나라도 false가 존재하면 false를 반환 둘다 true인 경우에만 true를 반환.

console.log('============================');
console.log(true && true);
console.log(true && false);
console.log(false && true);
console.log(false && false);

// null 병합 연산자
// A ?? B 에서 기호를 기준으로 왼쪽값이 null이거나  undefined일 경우 기호의 오른쪽 값을 반환하고 왼쪽 값이 null 혹은 undefined가 아닐경우 왼쪽값을 반환한다.

let num5;
let num6 = 10;

console.log(num5 ?? 20);
console.log(num6 ?? 20);

// 삼항 연산자 / A ? B : C

let num7 = 100;
let result = num7 % 2 === 0 ? "짝수" : "홀수";

console.log(result);
