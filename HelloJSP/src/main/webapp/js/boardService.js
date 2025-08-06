/**
 * boardService.js
 */
class PageVO {
	// start, end, prev, next
	constructor(currentPage, totalCount) {
		let realEnd = Math.ceil(totalCount / 5);
		this.currentPage = currentPage;
		this.totalCount = totalCount;

		this.end = Math.ceil(currentPage / 10) * 10;
		this.start = this.end - 9;

		this.end = this.end > realEnd ? realEnd : this.end;

		this.prev = this.start > 1;
		this.next = this.end < realEnd;

	}
}

//console.log(new PageVO(23, 136));

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
	// 추가메소드.
	replyTotalCount(bno, successCallback, errorCallback) {
		fetch('totalReply.do?bno=' + bno)
			.then(resolve => resolve.json())
			.then(successCallback)
			.catch(errorCallback)
	}
}
