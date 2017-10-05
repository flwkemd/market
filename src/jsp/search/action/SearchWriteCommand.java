package jsp.search.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.common.action.Action;
import jsp.common.action.ActionForward;
import jsp.search.model.SearchBean;
import jsp.search.model.SearchDAO;

public class SearchWriteCommand implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		SearchBean board = new SearchBean();
		
		board.setsTitle(request.getParameter("sTitle"));
		board.setsContent(request.getParameter("sContent"));
		board.setsAddress(request.getParameter("sAddress"));
		board.setsTime1(request.getParameter("sTime1"));
		board.setsTime2(request.getParameter("sTime2"));
		board.setsTime3(request.getParameter("sTime3"));
		board.setsTime4(request.getParameter("sTime4"));
		board.setsFile(request.getParameter("sFile"));
		
		SearchDAO dao = new SearchDAO();
				
		dao.searchInsert(board);
		
		return null;
	}

}
