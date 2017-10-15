package jsp.store7.action;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import jsp.common.action.Action;
import jsp.common.action.ActionForward;
import jsp.store7.model.Store7Bean;
import jsp.store7.model.Store7DAO;

public class Store7WriteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
				
		// 업로드 파일 사이즈
		int fileSize= 10*1024*1024;
		// 업로드될 폴더 절대경로
		String uploadPath = request.getServletContext().getRealPath("/UploadFolder/Store7");

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
			
			Store7DAO dao = new Store7DAO();
			Store7Bean border = new Store7Bean();
			
			border.setStore7Id(dao.getSeq()); // 시퀀스값 가져와 세팅
			border.setStore7Form(multi.getParameter("store7Form"));
			border.setStore7Title(multi.getParameter("store7Title"));
			border.setStore7Num(multi.getParameter("store7Num"));
			border.setStore7Time1(multi.getParameter("store7Time1"));
			border.setStore7Time2(multi.getParameter("store7Time2"));
			border.setStore7Holiday(multi.getParameter("store7Holiday"));
			border.setStore7Service1(multi.getParameter("store7Service1"));
			border.setStore7Service2(multi.getParameter("store7Service2"));
			border.setStore7Service3(multi.getParameter("store7Service3"));
			border.setStore7File1(fileName);
			border.setStore7File2(fileName2);
		
			boolean result = dao.storeInsert(border);
			
			if(result){
				forward.setRedirect(true);
				forward.setNextPath("../store7.do");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("글 작성 오류 : " + e.getMessage());
		}
		return forward;
	}
}
