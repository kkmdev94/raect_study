// BigInt

let bigNum1 = 99999999999999999999999n;
let bigNum2 = BigInt("99999999999999999999999");

console.log(typeof bigNum1);
console.log(typeof bigNum2);

// String

let name = 'hyobin';
console.log(typeof name);

let name2 = 'hyobin';
let intro = `my name is ${name2}`;

console.log(intro); // 템플릿 리터럴이라고 한다.

// boolean

let isClicked = false;

if (isClicked) {
    console.log('clicked');
} else {
    console.log('not clicked');
}

// Null

let nullValue = null;
console.log(typeof nullValue); // object라는 값이 출력 -> JS의 오래된 오류 null형임을 확인하기 위해서는 typeof가 아닌 === 기호와 함께 null을 입력해서 비교해야한다.
console.log(nullValue === null); // 이렇게 확인해야 한다. 그러면 null이면 true가 null이 아니면 false가 출력된다.

// Undefined
// 변수에 값이 할당되지 않은 상태

let num;
console.log(typeof num);

//묵시적 형 변환
let num1 = '15'; // 문자형이 숫자형으로 자동으로 변경되는것을 묵시적 형 변환
let num2 = 5;

console.log(num1 / num2);

// 명시적 형 변환
// 더하기 연산을 하게 될 경우 숫자를 문자형으로 자동 변환.
let num3 = '15';
let num4 = 5;

// console.log(num3 + num4);
console.log(parseInt(num3) + num4); // parseInt를 통해 문자 -> 숫자 형변환