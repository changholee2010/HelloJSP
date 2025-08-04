/**
 * basic.js
 */
console.log("basic");

var name = 'Hong'; // 변수선언.

name = 'Hwang'; // 새로운 값을 대입.

var name = 'Park'; // 
console.log(name);

let name1 = 'Kim'; // 변수의 선언 한번만 선언.
const age = 20; // 상수.
// age = 30;

// Object 타입.
const obj = new Object(); //{}
obj.name = 'Hong';
obj.age = 20;
obj.info = function() {
	console.log('이름은 ' + obj.name + ', 나이는 ' + obj.age);
}
obj.hobbies = ['독서','수영','자전거'];
obj.pets = [{name: '야옹이', age: 2}, {name: '멍멍이', age: 3}];

console.log(obj.age);
console.log(obj['name']);
console.log('첫번째 취미: ' + obj.hobbies[0]);
console.log('두번째 취미: ' + obj['hobbies'][1]);
console.log(`세번째 취미: ${obj['hobbies'][2]}`);

obj.pets[0].name = '고양이';
obj.pets[1].name;

// 객체구조.
console.log(this);
console.dir(window.document.children[0].children[1].innerHTML);
//window.alert('윈도우객체의 alert함수');

obj.info();
