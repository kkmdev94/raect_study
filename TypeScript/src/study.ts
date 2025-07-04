// let a : number = 1;
// let b : string = "il"
// let c : boolean = true
//
// const player : {
//     name : string,
//     age? : number // ?를 붙히는순간 해당 변수는 undefined가 되어 필수값이 아니게 된다.
// } = {
//     name : "nico"
// }
//
// if(player.age && player.age < 10) { // player가 undefined가 되면 player를 확인하기 위한 작업이 필요하다.
//
// }

// -------------------------------------------------------------------------------------------------------
// 반복되는 type 설정을 편리하게 alias(별칭)을 생성하게 해주는 코드
// type Player = {
//     name: string,
//     age?: number
// }
//
// const nico : Player = {
//     name: 'Nico',
// }
// const lynn : Player = {
//     name: 'Lynn',
//     age:12
// }

// ----------------------------------------------------------------------------------------------------
// 아래처럼 변수로 만들어서 선언도 가능은 하지만 너무 과하면 오히려 좋지 않다.
// type Age = number;
// type Name = String;
// type Player = {
//     name: Name,
//     age?: Age
// }
//
// const nico : Player = {
//     name: 'Nico',
// }
// const lynn : Player = {
//     name: 'Lynn',
//     age:12
// }

// ----------------------------------------------------------------------------------------------------
// 함수화
type Age = number;
type Name = String;
type Player = {
    name: Name,
    age?: Age
}
function playerMaker(name:string) : Player {
    return {
        name:name,
    }
}

const nico = playerMaker("nico");
nico.age = 12


