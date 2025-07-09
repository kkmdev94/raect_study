"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const push = (config) => {
    if (typeof config === "string") {
        console.log(config);
    }
    else {
        console.log(config.path);
    }
};
// return 타입에서 반환값이 파라미터 갯수와 다르면 해당 파라미터는 지정된 값 or undifined여서 ?와 함께 값을 정해주거나, if문을 사용하면 된다.
const add = (a, b, c) => {
    if (c)
        return a + b + c;
    return a + b;
};
add(1, 2);
add(1, 2, 3);
