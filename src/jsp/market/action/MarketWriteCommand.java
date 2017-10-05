package jsp.market.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.common.action.Action;
import jsp.common.action.ActionForward;
import jsp.market.model.MarketBean;
import jsp.market.model.MarketDAO;

public class MarketWriteCommand implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		MarketBean board = new MarketBean();
		
		
		board.setmTitle(request.getParameter("mTitle"));
		board.setmContent(request.getParameter("mContent"));
		board.setmFile(request.getParameter("mFile"));
		
		MarketDAO dao = new MarketDAO();
				
		dao.marketInsert(board);
		
		return null;
	}

}
