import React from "react";
import styled from "styled-components";
//함수는 매개변수로 표현식 하나를 받고, 표현식의 결과가 최종 값이 됩니다
const Wrapper = styled.div`
    width: calc(100% - 32px); 
    padding: 16px;
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    justify-content: center;
    border: 1px solid grey;
    border-radius: 8px;
    cursor: pointer;
    background: white;
    :hover {
        background: lightgrey;
    }
`;

const TitleText = styled.p`
    font-size : 20px;
    font-weight: 500;
`;

function PostlistItem(props) {
    const { post, onClick } = props;

    return (
        <Wrapper onClick={onClick}>
            <TitleText>{post.title}</TitleText>
        </Wrapper>
    );
}

export default PostlistItem;