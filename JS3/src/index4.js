// if문

let num = 5;

if (num < 10) {
    console.log('num is less than 10');
} else {
    console.log('num is greater than 10');
}

let num2 = 10;
if (num2 < 10) {
    console.log('num2 is less than 10');
}else {
    if (num2 > 10) {
        console.log('num2 is greater than 10');
    } else {
        console.log('num2 is equal to 10');
    }
}

// elseif
let num3 = 50;
if (num3 < 10) {
    console.log('num3 is less than 10');
} else if (num3 > 10) {
    console.log('num3 is greater than 10');
} else {
    console.log('num3 is equal to 10');
}

// switch case

let fruit= 'apple';

switch (fruit) {
    case 'banana':
        console.log('banana');
        break;
    case 'orange':
        console.log('orange');
        break;
    case 'apple':
        console.log('apple');
        break;
    case 'grape':
        console.log('grape');
        break;
    default:
        console.log('default');
}