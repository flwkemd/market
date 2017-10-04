package jsp.market.action;

import java.util.ArrayList;
import java.util.HashMap;

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
		int spage = 1;
		String page = request.getParameter("page");

		if(page != null && !page.equals(""))	spage = Integer.parseInt(page);
		
		MarketDAO dao = new MarketDAO();
		int listCount = dao.getBoardListCount();
		
		// �� ȭ�鿡 10���� �Խñ��� ����������
		// ������ ��ȣ�� �� 5��, ���ķδ� [����]���� ǥ��
		
		// ��ü ������ ��
		int maxPage = (int)(listCount/10.0 + 0.9);

		// �۸���� �����´�.
		ArrayList<MarketBean> list =  dao.getBoardList();
	
		//���� ������ ��ȣ
		int startPage = (int)(spage/5.0 + 0.8) * 5 - 4;
		//������ ������ ��ȣ
		int endPage = startPage + 4;
		if(endPage > maxPage)	endPage = maxPage;
		
		// 4�� ��������ȣ ����
		request.setAttribute("spage", spage);
		request.setAttribute("maxPage", maxPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);

		// ���� �� ���� �۸�� ����
		//request.setAttribute("listCount", listCount);
		request.setAttribute("list", list);
		
		// �ܼ� ��ȸ�̹Ƿ� forward()��� (= DB�� ���º�ȭ �����Ƿ�) 
		forward.setRedirect(false);
		forward.setNextPath("../market.jsp");
		
		return forward;
	}

}
