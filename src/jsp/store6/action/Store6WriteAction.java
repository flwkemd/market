package jsp.store6.action;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import jsp.common.action.Action;
import jsp.common.action.ActionForward;
import jsp.store6.model.Store6Bean;
import jsp.store6.model.Store6DAO;

public class Store6WriteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
				
		// 업로드 파일 사이즈
		int fileSize= 10*1024*1024;
		// 업로드될 폴더 절대경로
		String uploadPath = request.getServletContext().getRealPath("/UploadFolder/Store6");

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
			
			Store6DAO dao = new Store6DAO();
			Store6Bean border = new Store6Bean();
			
			border.setStore6Id(dao.getSeq()); // 시퀀스값 가져와 세팅
			border.setStore6Form(multi.getParameter("store6Form"));
			border.setStore6Title(multi.getParameter("store6Title"));
			border.setStore6Num(multi.getParameter("store6Num"));
			border.setStore6Time1(multi.getParameter("store6Time1"));
			border.setStore6Time2(multi.getParameter("store6Time2"));
			border.setStore6Holiday(multi.getParameter("store6Holiday"));
			border.setStore6Service1(multi.getParameter("store6Service1"));
			border.setStore6Service2(multi.getParameter("store6Service2"));
			border.setStore6Service3(multi.getParameter("store6Service3"));
			border.setStore6File1(fileName);
			border.setStore6File2(fileName2);
		
			boolean result = dao.storeInsert(border);
			
			if(result){
				forward.setRedirect(true);
				forward.setNextPath("../store6.do");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("글 작성 오류 : " + e.getMessage());
		}
		return forward;
	}
}
