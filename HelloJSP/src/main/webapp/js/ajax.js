/**
 * ajax.js
 * Asynchronous Javascript And Xml
 */

// 동기방식 vs. 비동기방식
setTimeout(function() {
	console.log('1');
}, 1000);

setTimeout(function() {
	console.log('2');
}, 2000);

setTimeout(function() {
	console.log('3');
}, 500);

const xhtp = new XMLHttpRequest();


