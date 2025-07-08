export {}

// unknown
let a : unknown;

if (typeof a === 'number') { //if 와 typeof를 통해 type을 체크하고 a를 number라고 지정함. 그래서 해당 if문에서는 a === number가 됨.
    let b = a + 1
}
// let c = a + 1 -> typeof를 통한 체크가 없으면 unknown으로 타입을 확인할 수 없어 오류 발생.

if (typeof a === "string") {
    let b = a.toUpperCase();
}

// void
// 아무것도 return하지 않는 함수.
function hello() { // return을 사용하지 않으면 타입이 void가 됨 / 따로 지정 한해도 댐.
    console.log('x')
}

// const a = hello();
// a.toUpperCase() // void 타입엔 toUpperCase가 없어서 오류 발생??

//never
//never은 함수가 절대 return하지 않을 때 발생 // 함수에서 exception이 발생시킬 때 사용. 즉 throw를 사용하여 강제로 에러를 발생시킬때 사용
function hello2() : never {
    // return "X";
    throw new Error("XXX")
}

// type이 2가지일 경우에도 never를 사용하여 체크 할 수 있다.
function hello3(name:string|number) : never {  // 파라미터의 타입을 string과 number로 받고 hello3의 타입을 never를 주입
    if(typeof name === "string") { // typeof를 통해 string이면 name 출력
        name
    }else if (typeof name === "number") { // string이 아니면 위에서 아래로 내려와서 number인지 확인 / 맞으면 출력
        name
    }else { // 그 외의 타입은 전부 never가 되고 return이 없다. / 절대 실행되지 않음.
        name
    }
}