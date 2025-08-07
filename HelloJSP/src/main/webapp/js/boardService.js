/**
 * boardService.js
 */

// 페이징 계산.
class PageVO {
	// 생성자.
	constructor(currPage, totalCnt) {
		this.currPage = currPage; // currPage 필드선언.
		this.totalCnt = totalCnt;
		// start, end 계산.
		this.end = Math.ceil(currPage / 10) * 10; // 10page.
		this.start = this.end - 9; // 1page

		let realEnd = Math.ceil(totalCnt / 5); // 3page
		this.end = this.end > realEnd ? realEnd : this.end;
		// prev, next 계산.
		this.prev = this.start > 1;
		this.next = this.end < realEnd;
	}

}

const svc = {
	count: 20, // 속성(property)
	increaseCount: function() { // 메소드
		this.count++;
	},
	showCount() { // 메소드
		return this.count;
	},
	// 목록ajax 메소드.
	replyList(param = { bno: 1, page: 1 }, successCallback, errorCallback) {
		fetch('replyList.do?bno=' + param.bno + '&page=' + param.page)
			.then(resolve => resolve.json())
			.then(successCallback)
			.catch(errorCallback)
	},
	// 삭제ajax 메소드.
	removeReply(rno, successCallback, errorCallback) {
		fetch('removeReply.do?rno=' + rno)
			.then(resolve => resolve.json())
			.then(successCallback)
			.catch(errorCallback)
	},
	// 등록ajax 메소드.
	registerReply(param = { bno, reply, replyer }, successCallback, errorCallback) {
		fetch('addReply.do?bno=' + param.bno + '&reply=' + param.reply + '&replyer=' + param.replyer)
			.then(resolve => resolve.json())
			.then(successCallback)
			.catch(errorCallback)
	},
	// bno에 대한 전체건수 얻는 ajax 메소드.
	replyTotalCount(bno, successCallback, errorCallback) {
		fetch('totalReply.do?bno=' + bno)
			.then(resolve => resolve.json())
			.then(successCallback)
			.catch(errorCallback)
	}
}
