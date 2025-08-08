/**
 * openapi.js
 */

let url =
	`https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=qCwQYxNXeK%2FaB1Ngf9oNZDttjmjQ6ku1OdR6%2Fd0Jj5EIdqOxMXolplih%2BYjTqB4uxCuK636co3tf9T5%2Fr9OLvw%3D%3D`;
//url = 'eventList.do';

// 이벤트 등록.
document.querySelector('#search').addEventListener('change', function(e) {
	let sido = e.target.value; // select 태그의 value를 활용해서 함수호출.
	searchCenterList(sido);
});

// 검색목록 생성.
fetch(url)
	.then(resolve => resolve.json())
	.then(result => {
		const search = document.getElementById('search');
		result.data // 센터목록을 담고 있는 배열.
			.reduce((acc, elem) => {
				if (acc.indexOf(elem.sido) == -1) {
					acc.push(elem.sido); // ['서울특별시','제주자치도']
				}
				return acc; // 다음순번의 acc값으로 활용.
			}, [])
			.forEach(elem => {
				// <option value="서울특별시">서울특별시</option>
				let opt = document.createElement('option');
				opt.value = elem;
				opt.innerHTML = elem;
				search.appendChild(opt);
			})

	})
	.catch(err => console.error(err));

// 함수호출.
searchCenterList('서울특별시');

function searchCenterList(sido) {
	const COLUMS = ['id', 'centerName', 'phoneNumber'];

	fetch(url)
		.then(resolve => resolve.json())
		.then(result => {
			// 기존목록 지우기.
			document.querySelector('#list').innerHTML = '';
			// 결과값을 활용해서 반복문(forEach)활용해서 목록생성.
			const cols = result.data // 전체목록배열.
				.filter(elem => elem.sido == sido)
				.map(elem => {
					return `<tr onclick='window.open("daumapi.jsp?lat=${elem.lat}&lng=${elem.lng}")'>${COLUMS.map(col => `<td>${elem[col]}</td>`).join('')}</tr>`;
				}).join('');
			document.querySelector('#list').innerHTML = cols;
		})
		.catch(err => console.error(err));

} // end of searchCenterList();
