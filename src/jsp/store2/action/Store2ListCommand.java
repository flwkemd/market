package jsp.store2.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.store.command.Command;
import jsp.store2.model.Store2Bean;
import jsp.store2.model.Store2DAO;

public class Store2ListCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		// 현재 페이지 번호 만들기
				int spage = 1;
				String page = request.getParameter("page");

				if(page != null && !page.equals(""))	
					spage = Integer.parseInt(page);

		 		Store2DAO dao = new Store2DAO();
		 		int listCount = dao.getBoardListCount();
		 		
		 	// 한 화면에 10개의 게시글을 보여지게함
				// 페이지 번호는 총 5개, 이후로는 [다음]으로 표시
				
				// 전체 페이지 수
				int maxPage = (int)(listCount/10.0 + 0.9);

				// 만약 사용자가 주소창에서 페이지 번호를 maxPage 보다 높은 값을 입력시
				// maxPage에 해당하는 목록을 보여준다.
				if(spage > maxPage) spage = maxPage;
				
				int start = spage*10-9;
		 		
		 		// 글목록을 가져온다.
		 		ArrayList<Store2Bean> list =  dao.getBoardList(start);

				//시작 페이지 번호
				int startPage = (int)(spage/5.0 + 0.8) * 5 - 4;
				//마지막 페이지 번호
				int endPage = startPage + 4;
				if(endPage > maxPage)	
					endPage = maxPage;
				
				// 4개 페이지번호 저장
				request.setAttribute("start", start);
				request.setAttribute("spage", spage);
				request.setAttribute("maxPage", maxPage);
				request.setAttribute("startPage", startPage);
				request.setAttribute("endPage", endPage);
				
		 		request.setAttribute("list", list);
		
	}
}
