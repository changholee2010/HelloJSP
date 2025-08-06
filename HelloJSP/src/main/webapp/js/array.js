/**
 * array.js (forEach, map, filter, reduce)
 * document.querySelectorAll() 결과에 사용.
 */

let sum = 0;

var evenSum = (elem, idx, ary) => {
	if (elem % 2 == 0) {
		sum += elem;
	}
	if (idx == ary.length - 1) {
		console.log(`짝수의 합계는 ${sum}`);
	}
}
var oddSum = (elem, idx, ary) => {
	if (idx % 2 == 0) {
		sum += elem;
	}
	if (idx == ary.length - 1) {
		console.log(`홀수번째 합계는 ${sum}`);
	}
}
var totalSum = (elem, idx, ary) => {
	sum += elem;
	if (idx == ary.length - 1) {
		console.log(`전체 합계는 ${sum}`);
	}
}

[12, 34, 83, 22, 59, 77].forEach(totalSum);
