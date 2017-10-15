package jsp.store3.action;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import jsp.common.action.Action;
import jsp.common.action.ActionForward;
import jsp.store3.model.Store3Bean;
import jsp.store3.model.Store3DAO;

public class Store3WriteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
				
		// ���ε� ���� ������
		int fileSize= 10*1024*1024;
		// ���ε�� ���� ������
		String uploadPath = request.getServletContext().getRealPath("/UploadFolder/Store3");

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
			
			Store3DAO dao = new Store3DAO();
			Store3Bean border = new Store3Bean();
			
			border.setStore3Id(dao.getSeq()); // �������� ������ ����
			border.setStore3Form(multi.getParameter("store3Form"));
			border.setStore3Title(multi.getParameter("store3Title"));
			border.setStore3Num(multi.getParameter("store3Num"));
			border.setStore3Time1(multi.getParameter("store3Time1"));
			border.setStore3Time2(multi.getParameter("store3Time2"));
			border.setStore3Holiday(multi.getParameter("store3Holiday"));
			border.setStore3Service1(multi.getParameter("store3Service1"));
			border.setStore3Service2(multi.getParameter("store3Service2"));
			border.setStore3Service3(multi.getParameter("store3Service3"));
			border.setStore3File1(fileName);
			border.setStore3File2(fileName2);
		
			boolean result = dao.storeInsert(border);
			
			if(result){
				forward.setRedirect(true);
				forward.setNextPath("../store3.do");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�� �ۼ� ���� : " + e.getMessage());
		}
		return forward;
	}
}
