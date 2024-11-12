import React from "react";

class ConfirmButton extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            isConfirmed: false,
        };

        //this.handleConfirm = this.handleConfirm.bind(this); //class fields syntax로 전환시 바인드 비활성화
    }

    // handleConfirm() { 
    //     this.setState((prevState) =>({
    //         isConfirmed: !prevState.isConfirmed,
    //     }));
    // }

    handleConfirm = () => { //class fields syntax로 전환시 Arrow function으로 변경
        this.setState((prevState) =>({
            isConfirmed: !prevState.isConfirmed,
        }));
    }

    render() {
        return (
            <button
                onClick={this.handleConfirm}
                disabled={this.state.isConfirmed}
            >
                {this.state.isConfirmed ? "OK" : "Failed"}
            </button>
        );
    }
}

export default ConfirmButton;