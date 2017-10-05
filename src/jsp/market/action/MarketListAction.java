package jsp.market.action;
 
 import java.util.ArrayList;
 
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 
 import jsp.common.action.Action;
 import jsp.common.action.ActionForward;
 import jsp.market.model.MarketBean;
 import jsp.market.model.MarketDAO;
 
 public class MarketListAction implements Action {
 
 	@Override
 	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
 
 		ActionForward forward = new ActionForward();
 		
 		// 현재 페이지 번호 만들기
 		int pageNumber = 1;
 		
 		MarketDAO dao = new MarketDAO();
 		
 		// 글목록을 가져온다.
 		ArrayList<MarketBean> list =  dao.getBoardList();
 	
 		// 글의 총 수와 글목록 저장
 		//request.setAttribute("listCount", listCount);
 		request.setAttribute("list", list);
 		
 		// 단순 조회이므로 forward()사용 (= DB의 상태변화 없으므로) 
 		forward.setRedirect(false);
 		forward.setNextPath("../market.jsp");
 		
 		return forward;
	}

}