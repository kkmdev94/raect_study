/*
// truthy -> 오브젝트 밑 배열 등 데이터가 존재하는 경우를 truthy라고 한다.
true
{} (empty object)
[] (empty array)
 42 (number, not zero) -> 0이 아닌 숫자
 "0", "false" (strin, not empty) -> 비어있지 않은 문자열 

 // falsy -> 0이거나 데이터가 없는 형태, 공백 등을 falsy라고 한다.
 fasle 
 0, -0 (zero, minus zero)
 0n (BigInt zero) -> 새로생긴 javascript의 연산자 유형으로 number와 동일하지 안다. (BigInt에 대해서는 추후 공부)
 '', "", `` (empty string) -> 비어있는 문자열
 null
 undefined
 NaN (not a number)

 ===========================

 &&연산자를 사용할때 조건문에서 
    <div>
        <h1 boolean && expression> 일떄 expression이 false expression 즉 뒤의 조건값이 거짓조건양식이면 결과물이 그대로 리턴 된다.
    </div>

예시를 들자면 

function Counter(props) {
    const count = 0;

    return (
        <div>
            {count && <h1>현재 카운트: {count}</h1>} -> 이것처럼 뒤의 값이 false expreesion이 되어버리면 0이라는 카운트 값이 그대로 리턴되서 출력이 된다. 
        </div>
    );
}

Component 렌더링을 막기위해서는 null을 return 하면 된다.
 */