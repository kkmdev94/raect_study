import React from "react";
import Comment from "./comment";

const comments = [
    {
        name: "ppp",
        comment: "hello",
    },
    {
        name: "sss",
        comment: "hallo",
    },
    {
        name: "text",
        comment: "byyy",
    }
];

function CommentList(props){
    return(
        <div>
            {comments.map((comment) => {
                return(
                    <Comment name={comment.name} comment={comment.comment} />
                );
            })}
        </div>
    );
}

export default CommentList;