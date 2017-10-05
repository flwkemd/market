package jsp.search.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.common.action.Action;
import jsp.common.action.ActionForward;
import jsp.search.model.SearchBean;
import jsp.search.model.SearchDAO;

public class SearchDetailAction implements Action
{
	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		
		// �Ķ���ͷ� �Ѿ�� �۹�ȣ�� �����´�.
		int sId = Integer.parseInt(request.getParameter("sId"));
		
		SearchDAO dao = new SearchDAO();
		SearchBean board = dao.getDetail(sId);

		request.setAttribute("board", board);
			
			forward.setRedirect(false); // �ܼ��� ��ȸ�̹Ƿ�
			forward.setNextPath("SearchDetailForm.so");
		
		return forward;
	}
}
