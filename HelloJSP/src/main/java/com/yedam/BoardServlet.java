package com.yedam;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

// 서블릿의 실행순서.
// 페이지: 75
// live server:
// client -> 웹서버(정적페이지) -> 서블릿컨테이너(톰캣) -> init() -> service()
@WebServlet("/board")
public class BoardServlet extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() 메소드 호출.");
	}

	// req, resp
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (req.getMethod().equals("GET")) { // 조회.
			resp.setContentType("text/html;charset=utf-8");

			System.out.println("service() 메소드 호출.");
			// http://localhost:8080/HelloJSP/board?board_no=3&writer=user01
			String board_no = req.getParameter("board_no"); // "3"
			int bno = Integer.parseInt(board_no); // "23" -> 23

			BoardService svc = new BoardServiceImpl();
			BoardVO board = svc.searchBoard(bno);

			// 글번호: 3 제목: ????
			// 내용: ㅇ라ㅣㅇㅁ라ㅣㅇㄴ;ㅁ리
			// 작성자: 홍길동
			// 작성일시: 2025.07.25 13:22:18
			String html = "<table border='2'>";
			html += "<tr><th>글번호</th><td>" + board.getBoardNo()//
					+ "</td><th>제목</th><td>" + board.getTitle() + "</td></tr>";
			html += "<tr><th>내용</th><td colspan='3'>" + board.getContent() + "</td></tr>";
			html += "<tr><th>작성자</th><td colspan='3'>" + board.getWriter() + "</td></tr>";
			html += "<tr><th>작성일시</th><td colspan='3'>" + board.getCreationDate() + "</td></tr>";
			html += "</table>";

			html += "<div><a href='DeleteBoard?board_no=" + board.getBoardNo() + "'>글삭제</a></div>";
			html += "<div><a href='BoardListServlet'>글목록이동</a></div>";

			resp.getWriter().print(html);

		} else if (req.getMethod().equals("POST")) { // 등록.

			// 요청정보의 인코딩 지정.
			req.setCharacterEncoding("utf-8"); // 한글처리.

			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String writer = req.getParameter("writer");
			// BoardVO 파리미터.
			BoardVO param = new BoardVO();
			param.setTitle(title);
			param.setContent(content);
			param.setWriter(writer);

			BoardService svc = new BoardServiceImpl();
			if (svc.registerBoard(param)) {
				// 목록.
				resp.sendRedirect("BoardListServlet");
			} else {
				System.out.println("에러발생."); // 에러페이지(jsp)
			}

		}

	} // end of service.
} // end of class.
