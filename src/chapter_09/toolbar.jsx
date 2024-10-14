import React from "react";

const styles = {
    wrapper: {
        padding: 16,
        display: "flex",
        flexDirection: "row",
        borderButton: "1px solid grey",
    },
    greeting: {
        marginRight: 8,
    },
};

function Toolbar(props) {
    const {isLoggedIn, onClickLogin, onClickLogout} = props; // props에 불변변수 3개를 선언

    return (
        <div style={styles.wrapper}> {/** 위에서 설정한 css 값 중 wrapper를 호출 */}
            {isLoggedIn && <span style={styles.greeting}>환영합니다!</span>} 
            {/** 동일하게 위에서 설정한 css값 중 greeting을 호출 하고 조건부 렌더링을 사용해 is LoggedIn이 트루값이면 환영합니다 메세지 출력*/}

            {isLoggedIn ? ( // 삼항연산자를 사용해서 if-else 사용 true값이면 로그아웃을 호출하고 false면 로그인을 호출
                <button onClick={onClickLogout}>로그아웃</button>
            ) : (
                <button onClick={onClickLogin}>로그인</button>
            )}

            {isLoggedIn ? (
                <button onClick={onClickLogout}>테스트입니다.</button>
            ):(
                <button onClick={onClickLogin}>이거슨 실시간으로 변경이 됩니다</button>
            )} 

        </div>
    );
}

export default Toolbar;