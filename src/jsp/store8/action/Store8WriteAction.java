package jsp.store8.action;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import jsp.common.action.Action;
import jsp.common.action.ActionForward;
import jsp.store8.model.Store8Bean;
import jsp.store8.model.Store8DAO;

public class Store8WriteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
				
		// ���ε� ���� ������
		int fileSize= 10*1024*1024;
		// ���ε�� ���� ������
		String uploadPath = request.getServletContext().getRealPath("/UploadFolder/Store8");

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
			
			Store8DAO dao = new Store8DAO();
			Store8Bean border = new Store8Bean();
			
			border.setStore8Id(dao.getSeq()); // �������� ������ ����
			border.setStore8Form(multi.getParameter("store8Form"));
			border.setStore8Title(multi.getParameter("store8Title"));
			border.setStore8Num(multi.getParameter("store8Num"));
			border.setStore8Time1(multi.getParameter("store8Time1"));
			border.setStore8Time2(multi.getParameter("store8Time2"));
			border.setStore8Holiday(multi.getParameter("store8Holiday"));
			border.setStore8Service1(multi.getParameter("store8Service1"));
			border.setStore8Service2(multi.getParameter("store8Service2"));
			border.setStore8Service3(multi.getParameter("store8Service3"));
			border.setStore8File1(fileName);
			border.setStore8File2(fileName2);
		
			boolean result = dao.storeInsert(border);
			
			if(result){
				forward.setRedirect(true);
				forward.setNextPath("../store8.do");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�� �ۼ� ���� : " + e.getMessage());
		}
		return forward;
	}
}
