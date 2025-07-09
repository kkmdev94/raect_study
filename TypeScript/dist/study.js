"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
// function playerMaker(name:string) : Player {
//     return {
//         name:name,
//     }
// }
const playerMaker = (name) => ({ name });
const nico = playerMaker("nico");
nico.age = 12;
