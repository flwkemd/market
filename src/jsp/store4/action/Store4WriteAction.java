package jsp.store4.action;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import jsp.common.action.Action;
import jsp.common.action.ActionForward;
import jsp.store4.model.Store4Bean;
import jsp.store4.model.Store4DAO;

public class Store4WriteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
				
		// 업로드 파일 사이즈
		int fileSize= 10*1024*1024;
		// 업로드될 폴더 절대경로
		String uploadPath = request.getServletContext().getRealPath("/UploadFolder/Store4");

		try {
			
			// 파일업로드 
			MultipartRequest multi = new MultipartRequest
					(request, uploadPath, fileSize, "utf-8", new DefaultFileRenamePolicy());

			// 파일이름 가져오기
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
			
			Store4DAO dao = new Store4DAO();
			Store4Bean border = new Store4Bean();
			
			border.setStore4Id(dao.getSeq()); // 시퀀스값 가져와 세팅
			border.setStore4Form(multi.getParameter("store4Form"));
			border.setStore4Title(multi.getParameter("store4Title"));
			border.setStore4Num(multi.getParameter("store4Num"));
			border.setStore4Time1(multi.getParameter("store4Time1"));
			border.setStore4Time2(multi.getParameter("store4Time2"));
			border.setStore4Holiday(multi.getParameter("store4Holiday"));
			border.setStore4Service1(multi.getParameter("store4Service1"));
			border.setStore4Service2(multi.getParameter("store4Service2"));
			border.setStore4Service3(multi.getParameter("store4Service3"));
			border.setStore4File1(fileName);
			border.setStore4File2(fileName2);
		
			boolean result = dao.storeInsert(border);
			
			if(result){
				forward.setRedirect(true);
				forward.setNextPath("../store4.do");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("글 작성 오류 : " + e.getMessage());
		}
		return forward;
	}
}
