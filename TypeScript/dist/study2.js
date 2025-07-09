"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
// type Age = number;
// type Name = String;
// type Player = {
//     readonly name:Name
//     age?:Age
// }
//
// const playerMaker = (name:String) : Player => ({name})
// const nico = playerMaker("nico")
// nico.age = 12
// nico.name = "las"
// readonly = 수정 불가. -> 즉 이뮨 / js에서는 readonly가 없음.
const numbers = [1, 2, 3, 4];
// numbers.push(1); // 오류 발생, push 불가.
// let newVar = [];  //Tuple -> array를 생성할 수 있게 하는데 최소한의 길이와 특정 위치에 특정 타입이 있어야 함.
const player = ["nico", 12, false]; // const player: string[] <- 이런게 아닌 []=[]로 타입을 각 인덱스에 정해놓는다.
// player[0] = 1 -> 오류 발생. 첫 배열은 string이기 떄문에
// let a = [] -> let a : any[] -> any란? Typescript로부터 빠져나오고 싶을 때 쓰는 타입. 아무타입이나 될 수 있다. 말그대로 진짜 any
const a = [1, 2, 3, 4];
const b = true;
console.log(a + b); // 타입 스크립트의 보호를 못받고 JS가 된다. 그래서 말도 안되는게 + 가능
