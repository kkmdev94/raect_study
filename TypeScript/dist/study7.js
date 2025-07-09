"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
class Player {
    constructor(firstName, lastName, health) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.health = health;
    }
    fullName() {
        return `${this.firstName} ${this.lastName}`;
    }
    sayHi(name) {
        return `Hello ${name}. My name is ${this.fullName()}`;
    }
}
function makeUser(user) {
    return "hi";
}
makeUser({
    firstName: "nico",
    lastName: "las",
    fullName: () => "Xx",
    sayHi: (name) => "string"
});
