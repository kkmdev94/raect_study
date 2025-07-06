// function add(a:number, b:number) : number {
//     return a + b;
// }
// const add = (a:number, b:number) => a+b

// 함수의 call signature Type을 만든다. / 타입을 내가 만들고, 함수가 어떻게 작동하는 지 서술해 둘 수 있다. 즉, 함수의 타입을 설명. 즉 위처럼 agrs에 타입을 하나하나 지정할 필요 없이
// 타입을 미리 만들어 놓고 바로바로 사용할 수 있다는 것이다.
// type Add = (a:number, b:number) => number;
// const add:Add = (a,b) => a + b;

//overloading / function overloading, method overloading
// java의 아규먼츠가 여러개인것과 동일하다. 오버로딩.. TypeScript 에서는 보내주는 타입이 여러가지가 될 수 있고, 아규먼츠가 여러개 될 수 도 있음. if로 체크하는경우가 보편적.
// type Add = {
//     (a:number, b:number) : number
//     (a:number, b:string) : number
// }
// const add:Add = (a,b) => {
//     if (typeof b === "string") return a
//     return a + b
// };
type Config = {
    path: string,
    state: object
}

type Push = {
    (path:string):void
    (config: Config):void;
}

const push:Push = (config) => {
    if(typeof config === "string") {console.log(config)}
    else{
        console.log(config.path);
    }
}

type Add = {
    (a: number, b:number) : number
    (a: number, b:number, c:number) : number
}

// return 타입에서 반환값이 파라미터 갯수와 다르면 해당 파라미터는 지정된 값 or undifined여서 ?와 함께 값을 정해주거나, if문을 사용하면 된다.
const add:Add = (a,b,c?:number) => {
    if(c) return  a + b + c
    return a + b
}

add(1, 2);
add(1, 2, 3);