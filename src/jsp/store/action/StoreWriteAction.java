package jsp.store.action;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import jsp.common.action.Action;
import jsp.common.action.ActionForward;
import jsp.search.model.SearchBean;
import jsp.search.model.SearchDAO;
import jsp.store.model.StoreBean;
import jsp.store.model.StoreDAO;

public class StoreWriteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
				
		// ���ε� ���� ������
		int fileSize= 10*1024*1024;
		// ���ε�� ���� ������
		String uploadPath = request.getServletContext().getRealPath("/UploadFolder/Store1");

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
			
			StoreDAO dao = new StoreDAO();
			StoreBean border = new StoreBean();
			
			border.setStore1Id(dao.getSeq()); // �������� ������ ����
			border.setStore1Form(multi.getParameter("store1Form"));
			border.setStore1Title(multi.getParameter("store1Title"));
			border.setStore1Num(multi.getParameter("store1Num"));
			border.setStore1Time1(multi.getParameter("store1Time1"));
			border.setStore1Time2(multi.getParameter("store1Time2"));
			border.setStore1Holiday(multi.getParameter("store1Holiday"));
			border.setStore1Service1(multi.getParameter("store1Service1"));
			border.setStore1Service2(multi.getParameter("store1Service2"));
			border.setStore1Service3(multi.getParameter("store1Service3"));
			border.setStore1File1(fileName);
			border.setStore1File2(fileName2);
		
			boolean result = dao.storeInsert(border);
			
			if(result){
				forward.setRedirect(true);
				forward.setNextPath("../store1.do");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�� �ۼ� ���� : " + e.getMessage());
		}
		return forward;
	}
}
