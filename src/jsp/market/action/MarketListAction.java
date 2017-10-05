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
 		
 		// ���� ������ ��ȣ �����
 		int pageNumber = 1;
 		
 		MarketDAO dao = new MarketDAO();
 		
 		// �۸���� �����´�.
 		ArrayList<MarketBean> list =  dao.getBoardList();
 	
 		// ���� �� ���� �۸�� ����
 		//request.setAttribute("listCount", listCount);
 		request.setAttribute("list", list);
 		
 		// �ܼ� ��ȸ�̹Ƿ� forward()��� (= DB�� ���º�ȭ �����Ƿ�) 
 		forward.setRedirect(false);
 		forward.setNextPath("../market.jsp");
 		
 		return forward;
	}

}