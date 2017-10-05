package jsp.market.action;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import jsp.common.action.Action;
import jsp.common.action.ActionForward;
import jsp.market.model.MarketBean;
import jsp.market.model.MarketDAO;

public class MarketWriteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
				
		// ���ε� ���� ������
		int fileSize= 5*1024*1024;
		// ���ε�� ���� ������
		String uploadPath = request.getServletContext().getRealPath("/UploadFolder/Market");

		try {
			
			// ���Ͼ��ε� 
			MultipartRequest multi = new MultipartRequest
					(request, uploadPath, fileSize, "utf-8", new DefaultFileRenamePolicy());

			// �����̸� ��������
			String fileName = "";
			Enumeration<String> names = multi.getFileNames();
			if(names.hasMoreElements())
			{
				String name = names.nextElement();
				fileName = multi.getFilesystemName(name);
			}
			
			MarketDAO dao = new MarketDAO();
			MarketBean border = new MarketBean();
			
			border.setmId(dao.getSeq()); // �������� ������ ����

			border.setmTitle(multi.getParameter("mTitle"));
			border.setmContent(multi.getParameter("mContent"));
			border.setmFile(fileName);
		
			boolean result = dao.marketInsert(border);
			
			if(result){
				forward.setRedirect(true);
				forward.setNextPath("MarketListAction.bo");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�� �ۼ� ���� : " + e.getMessage());
		}
		return forward;
	}
}
