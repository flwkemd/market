package jsp.store2.action;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import jsp.common.action.Action;
import jsp.common.action.ActionForward;
import jsp.store2.model.Store2Bean;
import jsp.store2.model.Store2DAO;

public class Store2WriteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
				
		// 업로드 파일 사이즈
		int fileSize= 10*1024*1024;
		// 업로드될 폴더 절대경로
		String uploadPath = request.getServletContext().getRealPath("/UploadFolder/Store2");

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
			
			Store2DAO dao = new Store2DAO();
			Store2Bean border = new Store2Bean();
			
			border.setStore2Id(dao.getSeq()); // 시퀀스값 가져와 세팅
			border.setStore2Form(multi.getParameter("store2Form"));
			border.setStore2Title(multi.getParameter("store2Title"));
			border.setStore2Num(multi.getParameter("store2Num"));
			border.setStore2Time1(multi.getParameter("store2Time1"));
			border.setStore2Time2(multi.getParameter("store2Time2"));
			border.setStore2Holiday(multi.getParameter("store2Holiday"));
			border.setStore2Service1(multi.getParameter("store2Service1"));
			border.setStore2Service2(multi.getParameter("store2Service2"));
			border.setStore2Service3(multi.getParameter("store2Service3"));
			border.setStore2File1(fileName);
			border.setStore2File2(fileName2);
		
			boolean result = dao.storeInsert(border);
			
			if(result){
				forward.setRedirect(true);
				forward.setNextPath("../store2.do");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("글 작성 오류 : " + e.getMessage());
		}
		return forward;
	}
}
