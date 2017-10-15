package jsp.store5.action;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import jsp.common.action.Action;
import jsp.common.action.ActionForward;
import jsp.store5.model.Store5Bean;
import jsp.store5.model.Store5DAO;

public class Store5WriteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
				
		// ���ε� ���� ������
		int fileSize= 10*1024*1024;
		// ���ε�� ���� ������
		String uploadPath = request.getServletContext().getRealPath("/UploadFolder/Store5");

		try {
			
			// ���Ͼ��ε� 
			MultipartRequest multi = new MultipartRequest
					(request, uploadPath, fileSize, "utf-8", new DefaultFileRenamePolicy());

			// �����̸� ��������
			String fileName = "";
			String fileName2 = "";
			Enumeration<String> names = multi.getFileNames();
			if(names.hasMoreElements())
			{
				String name = names.nextElement();
				fileName2 = multi.getFilesystemName(name);
				String name2 = names.nextElement();
				fileName = multi.getFilesystemName(name2);
			}
			
			Store5DAO dao = new Store5DAO();
			Store5Bean border = new Store5Bean();
			
			border.setStore5Id(dao.getSeq()); // �������� ������ ����
			border.setStore5Form(multi.getParameter("store5Form"));
			border.setStore5Title(multi.getParameter("store5Title"));
			border.setStore5Num(multi.getParameter("store5Num"));
			border.setStore5Time1(multi.getParameter("store5Time1"));
			border.setStore5Time2(multi.getParameter("store5Time2"));
			border.setStore5Holiday(multi.getParameter("store5Holiday"));
			border.setStore5Service1(multi.getParameter("store5Service1"));
			border.setStore5Service2(multi.getParameter("store5Service2"));
			border.setStore5Service3(multi.getParameter("store5Service3"));
			border.setStore5File1(fileName);
			border.setStore5File2(fileName2);
		
			boolean result = dao.storeInsert(border);
			
			if(result){
				forward.setRedirect(true);
				forward.setNextPath("../store5.do");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�� �ۼ� ���� : " + e.getMessage());
		}
		return forward;
	}
}
