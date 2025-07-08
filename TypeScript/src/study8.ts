export {}
// TS 커뮤니티에서는 클래스나 오브젝트의 모양을 정의하고 싶으면 인터페이스를 사용하고 나머지에서 타입을 쓰라고 한다.
//type을 쓰고 싶다면, type 키워드를 사용하면 된다.
type PlayerA = {
    name:string
}
//
// const playerA: PlayerA = {
//     name:"nico"
// }

/////////////////////////
// interface와 다르게 타입을 상속시키려면 또다른 타입 하나를 만들어서 다른 타입인 PlayerAA타입이 PlayerA 타입과 lastName을 가지는 오브젝트를 합친거라고 말해야 한다.
type PlayerAA = PlayerA & {
    lastName:string
}
const playerA: PlayerAA = {
    name:"nico",
    lastName:"las"
}

//// interface
// interface PlayerB {
//     name:string
// }
// const playerB: PlayerB = {
//     name:"nico"
// }

///////////
// interface의 상속은 implements를 사용.
interface PlayerB {
    name:string
}
interface PlayerBB extends PlayerB {
    lastName:string
}
const playerB: PlayerBB = {
    name:"nico",
    lastName:"las"
}

///
type PlayerC = {
    firstName:string
}
interface PlayerD {
    firstName:string
}

class User implements PlayerC {
    constructor(
        public firstName:string,
    ) {}
}