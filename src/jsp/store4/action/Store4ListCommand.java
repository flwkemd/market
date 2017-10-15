package jsp.store4.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.store.command.Command;
import jsp.store4.model.Store4Bean;
import jsp.store4.model.Store4DAO;

public class Store4ListCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		// ���� ������ ��ȣ �����
				int spage = 1;
				String page = request.getParameter("page");

				if(page != null && !page.equals(""))	
					spage = Integer.parseInt(page);

		 		Store4DAO dao = new Store4DAO();
		 		int listCount = dao.getBoardListCount();
		 		
		 	// �� ȭ�鿡 10���� �Խñ��� ����������
				// ������ ��ȣ�� �� 5��, ���ķδ� [����]���� ǥ��
				
				// ��ü ������ ��
				int maxPage = (int)(listCount/10.0 + 0.9);

				// ���� ����ڰ� �ּ�â���� ������ ��ȣ�� maxPage ���� ���� ���� �Է½�
				// maxPage�� �ش��ϴ� ����� �����ش�.
				if(spage > maxPage) spage = maxPage;
				
				int start = spage*10-9;
		 		
		 		// �۸���� �����´�.
		 		ArrayList<Store4Bean> list =  dao.getBoardList(start);

				//���� ������ ��ȣ
				int startPage = (int)(spage/5.0 + 0.8) * 5 - 4;
				//������ ������ ��ȣ
				int endPage = startPage + 4;
				if(endPage > maxPage)	
					endPage = maxPage;
				
				// 4�� ��������ȣ ����
				request.setAttribute("start", start);
				request.setAttribute("spage", spage);
				request.setAttribute("maxPage", maxPage);
				request.setAttribute("startPage", startPage);
				request.setAttribute("endPage", endPage);
				
		 		request.setAttribute("list", list);
		
	}
}