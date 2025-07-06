//Polymorphism(다형성)
// 여러가지 다른 구조
// type SuperPrint = {
//     (arr: number[]):void
//     (arr: boolean[]):void
//     (arr: string[]):void
// }
//
// const superPrint: SuperPrint = (arr) =>{
//     arr.forEach(i => console.log(i));
// }
//
// superPrint([1,2,3,4])
// superPrint([true, false, true]);
// superPrint(["a","b","c"])
//
// //concrete type : number,string,boolean, void unknown
// //다형성 활용법
// type SuperPrint2 = {
//     // (arr: number[]):void
//     // (arr: boolean[]):void
//     // (arr: string[]):void
//     (arr: (number|boolean|string)[]):void // 다형성을 활용하여 여러가지 타입을 받아오는 방법 / 타입이 섞여도 가능.
// }
//
// const superPrint2: SuperPrint2 = (arr) =>{
//     arr.forEach(i => console.log(i));
// }

// 이걸 더 편하게 하기 위해 제네릭을 사용
// type SuperPrint3 = {
//     // <TypePlaceholder>(arr: TypePlaceholder[]): TypePlaceholder
//     // <T>(arr: T[]): T[] // 전체를 반환할때.
//     <T>(arr: T[]): T // 예제의 학습처럼 하나씩 반환할때
// }
//
// // superPrint의 첫번째 요소를 리턴하게 만드는것. / 일상적으로는 자바의 제네릭 처럼 T를 많이 사용한다고 한다고 하니 형태를 잘 기억해 놓자
// // const superPrint3: SuperPrint3 = (arr) => arr // 전체를 반환할때 처럼 타입을 맞추면 된다. 아래의 [0]은 첫번째부터 리턴하게 하는것이라 타입이 안맞아 오류가 나왓던것.
// const superPrint3: SuperPrint3 = (arr) => arr[0]
//
// const a = superPrint3([1,2,3,4])
// const b = superPrint3([true, false, true]);
// const c = superPrint3(["a","b","c"])
// const d = superPrint3([1,2,true,false,"hello"]);

// // Generics Recap
// // 매개변수를 늘리는것과 같이 제네릭에 추가를 해주고 부여를 해주면 된다.
// type SuperPrint = {
//     <T,M>(arr: T[], b:M): T
// }
//
// const superPrint: SuperPrint = (arr) => arr[0]
//
// const a = superPrint([1,2,3,4], "x")
// const b = superPrint([true, false, true], 1);
// const c = superPrint(["a","b","c"], true)
// const d = superPrint([1,2,true,false,"hello"], []);

//Conclusions
// 타입스크립트는 스스로가 타입을 찾게하는것이 항상 좋기에 제네릭 사용이 매우 유용함.
function superPrint<V>(a: V[]) {
    return a[0]
}

const a = superPrint([1,2,3,4])
const b = superPrint([true, false, true]);
const c = superPrint(["a","b","c"])
const d = superPrint([1,2,true,false,"hello"]);

type Player<E> = {
    name:string;
    extraInfo:E
}
type NicoPlayer = Player<{favFood:string}>

const nico: NicoPlayer = {
    name:"nico",
    extraInfo:{
        favFood:"kimchi"
    }
}

const lynn : Player<null> = {
    name: "lynn",
    extraInfo:null
}

type A = Array<number>
let a:A= [1,2,3,4]

function printAllNumber(arr: Array<number>){

}