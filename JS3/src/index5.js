// 함수
let num1 = 10;
let num2 = 15;
let sum = num1 + num2;

console.log(sum);

function add(num3, num4) {
    return num3 + num4; // return문 아래에서 실행되는 로직은 호출 X
    console.log('함수 호출');
}

let result = add(11, 17); // 함수가 호출될때 넘기는 값을 인수라고 한다.

console.log(`두 숫자를 더한 결과는 ${result} 입니다.`);

// Early return pattern / 빨리 리턴한다. = 특정 조건에 부합하지 않으면 바로 리턴할 수 있도록 하는 패턴

// function compare(num) {
//     if (num === 0) {
//         console.log("num의 값이 0 입니다.");
//     }else if (num < 0) {
//         console.log("num의 값이 0보다 작습니다.");
//     } else {
//         if (num >= 0) {
//             console.log('num의 값이 10보다 크거나 같습니다');
//         } else {
//             console.log("num의 값이 0보다 크고 10보다 작습니다.");
//         }
//     }
// }
// compare(15);
// 패턴 적용 / if문과 return을 이용해서 적용
function compare(num) {
    if (num === 0) {
        return ("num의 값이 0 입니다.");
    }if (num < 0) {
        return ("num의 값이 0보다 작습니다.");
    }
    if (num >= 0) {
        return ('num의 값이 10보다 크거나 같습니다');
    }
    return ("num의 값이 0보다 크고 10보다 작습니다.");
}

console.log(compare(15));

// 중간에서 함수 호출

function print() {
    console.log(1);
    console.log(2);
}

console.log(3);
print();
console.log(4);