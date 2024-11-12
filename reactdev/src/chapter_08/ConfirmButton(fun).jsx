import React, {useState} from "react";

function ConfirmButtonF(props) {
    const [isConfirmed, setIsConfirmeed] = useState(false);

    const handleConfirm = () => {
        setIsConfirmeed((prevIsConfirmed) => !prevIsConfirmed);
    };

    return (
        <button onClick={handleConfirm} disabled={isConfirmed}>
            {isConfirmed ? "OK":"Falied"}
        </button>
    );
}

export default ConfirmButtonF;