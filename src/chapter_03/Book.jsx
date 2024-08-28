import React from "react";

function Book(props) {
    return (
        // ${}를 사용해서 변수 값을 쓸떄는 "이나 ' 이 아닌 `이거를 사용해야 한다.
        <div>
            <h1>{`이 책의 이름은 ${props.name}입니다.`}</h1>
            <h2>{`이 책은 총 ${props.numOfPage}페이지로 이뤄져 있습니다.`}</h2>
        </div>
    );
}
export default Book;