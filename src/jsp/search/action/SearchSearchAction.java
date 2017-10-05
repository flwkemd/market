package jsp.search.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.common.action.Action;
import jsp.common.action.ActionForward;
import jsp.search.model.SearchBean;
import jsp.search.model.SearchDAO;

public class SearchSearchAction implements Action {

	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		
		String word = request.getParameter("word");
		
		
		SearchDAO dao = new SearchDAO();
		ArrayList<SearchBean> list = dao.searchBoard(word);
		
		request.setAttribute("list", list);
		
		forward.setRedirect(false);
		forward.setNextPath("SearchListForm.so");
		
		return forward;
	}

}
