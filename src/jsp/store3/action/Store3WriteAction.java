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
				
		// 업로드 파일 사이즈
		int fileSize= 10*1024*1024;
		// 업로드될 폴더 절대경로
		String uploadPath = request.getServletContext().getRealPath("/UploadFolder/Store3");

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
			
			Store3DAO dao = new Store3DAO();
			Store3Bean border = new Store3Bean();
			
			border.setStore3Id(dao.getSeq()); // 시퀀스값 가져와 세팅
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
			System.out.println("글 작성 오류 : " + e.getMessage());
		}
		return forward;
	}
}
