export{}

// abstract class User{
//     constructor(
//         private firstName:string,
//         private lastName:string,
//         public nickname:string
//     ){}
//     getFullName(){
//         return `${this.firstName} ${this.lastName}`
//     }
// }
//
// class Player extends User{
//
// }
//
// const nico = new Player("nico","las", "니꼬")
//
// // nico.firstName = private이라 인식 안됨
// nico.nickname
// nico.getFullName()
//
// //
// type Words = {
//     [key:string] :string
// }
//
// class Dict {
//     private words: Words
//     constructor() {
//         this.words = {}
//     }
//     add(word:Word){
//         if (this.words[word.term] === undefined) {
//             this.words[word.term] = word.def;
//         }
//     }
//
//     def(term: string) {
//         return this.words[term]
//     }
// }
//
// class Word {
//     constructor(
//         public readonly term:string,
//         public readonly def :string
//     ) {}
// }
//
// const kimchi = new Word("kimchi", "한국의 음식");
// const dict = new Dict();
// dict.add(kimchi);
// dict.def("kimchi");
//
// //
// type Team = "red" | "blue" | "yellow"
// type Health = 1 | 5 | 10
//
//
// interface Player2  {
//     nickname:string,
//     team:Team,
//     health: Health
// }
//
// const nico2 : Player2 = {
//     nickname: "nico",
//     team: "yellow",
//     health:10
// }
//
// type Food = string;
//
// const kimchi2:Food = "delicious"
//
// //-------------------------------------------------------------------------------------
// interface User {
//     name: string
// }
//
// interface Player3 extends User {
// }
//
// const nico3 : Player3 = {
//     name:"nico"
// }
//
// //-------------------------------------------------------------------------------------
// type User2 = {
//     name:string,
// }
// type Player4 = User &{
// }
// const nico4 : Player4 = {
//     name:"nico"
// }

//------------------------------------------------------------------------------------- 인터페이스 활용
interface User {
    name:string
}
interface User { // type User interface와 같은 이름을 가진 type은 생성 불가.
    lastName:string
}
interface User {
    health: number
}

const nico: User = {
    name:"nico",
    lastName:"n",
    health:10
}

console.log(nico);