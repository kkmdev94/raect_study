import React, {useState, useEffect} from "react";
import useCounter from "./useCounter";

const MAX_CAPACITY = 10; //counter max 값

function Accommodate(props) { 
    const [isFull, setIsFull] = useState(false); //의존성 배열이 없는 Effect 훅에서 사용되는 변수
    const [count, increaseCount, decreaseCount] = useCounter(0); //의존성 배열이 있는 Effect 훅에서 사용되는 변수

    useEffect(() => { //의존성 배열이 없음
        console.log("=====================");
        console.log("useEffect() is called.");
        console.log(`isFull: ${isFull}`);
    });

    useEffect(() => { //의존성 배열이 있음
        setIsFull(count >= MAX_CAPACITY); //인원이 가득찼는지를 확인하기 위해 IsFull이라는 스테이트에 저장
        console.log(`Current count value: ${count}`);
    },[count]);

    return (
        <div style={{ padding: 16}}>
            <p>{`총 ${count}명 수용했습니다.`}</p>

            <button onClick={increaseCount} disabled={isFull}> {/* onClick(카멜표기법) C가 대문자, 버튼을 누르다가 isFull에 담긴 값이 MAX가 되면 비활성화 */}
                입장
            </button>
            <button onClick={decreaseCount}>퇴장</button>

            {isFull && <p style={{color : "red"}}>정원이 가득찼습니다.</p>}
        </div>
    );
}

export default Accommodate;