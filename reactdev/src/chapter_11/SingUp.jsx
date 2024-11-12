import React, { useState } from "react";

function SingUp(props) {
    const [name, setName] = useState("");
    const [gender, setGender] = useState("man");

    const handleChangeName = (event) => {
        setName(event.target.value);
    };

    const handleChangeGender = (event) => {
        setGender(event.target.value);
    };

    const handleSubmit = (event) => {
        alert(`이름: ${name}, 성별: ${gender}`);
        event.preventDefault();
    };

    return (
        <form onSubmit={handleSubmit}>
            <label>
                name :
                <input type="text" value={name} onChange={handleChangeName} />
            </label>
            <br />
            <label>
                Gender:
                <select value={gender} onChange={handleChangeGender}>
                    <option value="man">man</option>
                    <option value="female">female</option>
                </select>
            </label>
            <button type="submit">제출</button>
        </form>
    );
}

export default SingUp;