import React, {useState} from "react";

function useCounter(initialValue){
    const [count, setCount] = useState(initialValue);

    const increaseCount = () => setCount((count) => count + 1); //입장버튼 
    const decreaseCount = () => setCount((count) => Math.max(count -1 , 0)); //퇴장버튼

    return [count, increaseCount, decreaseCount];
}

export default useCounter;