/**
 * function.js
 */
// 함수선언식.
//function sum(num1, num2) {
//	let result = num1 + num2;
//	return result;
//}

// 화살표 함수.
let sum = (num1, num2) => num1 + num2;

sum(10, 12);

// 함수표현식.
let showInfo = (result) => console.log(result);

showInfo('Hello, World');
