import React from "react";
import styled from "styled-components";
import PostlistItem from "./PostlistItem";

const Wrapper = styled.div`
    display: flex;
    flex-direction: colum;
    align-items: flex-start;
    justify-content: center;

    & > * {
        :not(:last-child) {
            margin-bottom: 16px;
        }
    }
`;

function PostList(props) {
    const {posts, onClickItem} = props;

    return (
      <Wrapper>
        {props.map((post, index) => {
            return (
                <PostlistItem
                    key={post.id}
                    post={post}
                    onClick={()=>{
                        onClickItem(post);
                    }}
                />
            );
        })}
      </Wrapper>
    );
};

export default PostList;