// 호이스팅 -> JS에서 변수와 함수의 선언문이 해당 범위의 가장 위쪽으로 끌어올려지는 현상 / 변수 호이스팅과 함수 호이스팅이 있다.

connectString('study', 'hoisting'); // 함수 선언전 함수를 미리 호출 -> 함수 호이스팅

function connectString(str1, str2) {
    console.log(str1 + str2);
}

// 변수 호이스팅

// console.log(num1); 호이스팅이 발생하지 않은게 아닌 TDG에 들어가게 되는데, var 키워드는 선언 후 메모리에 바로 올라가지만 let과 const는 메모리에 바로 올라가는게 아닌
                    // 초기화기 이루어 질때까지 해당 키워드로 생성된 변수는 사용할 수 없는 공간인 TDG에 들어가게 된다.
                    // 그 이유는 호이스팅은 JS의 기본 성질이지만 가독성이 떨어지고 여러가지 오류를 일으킬 수 있기에 let과 const를 주로 사용하면서 선언 이후 사용하는게 바람직하다.
// let num1 = 123;

console.log(num2); // -> undefined출력 -> 그 이유는 호이스팅으로 우선 let num2; 이렇게 해석 후 console.log를 찍기 떄문에 undefined가 나온다.
var num2 = 123;