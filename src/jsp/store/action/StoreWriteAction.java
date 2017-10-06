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
				
		// 업로드 파일 사이즈
		int fileSize= 5*1024*1024;
		// 업로드될 폴더 절대경로
		String uploadPath = request.getServletContext().getRealPath("/UploadFolder/Store");

		try {
			
			// 파일업로드 
			MultipartRequest multi = new MultipartRequest
					(request, uploadPath, fileSize, "utf-8", new DefaultFileRenamePolicy());

			// 파일이름 가져오기
			String fileName = "";
			Enumeration<String> names = multi.getFileNames();
			if(names.hasMoreElements())
			{
				String name = names.nextElement();
				fileName = multi.getFilesystemName(name);
			}
			
			StoreDAO dao = new StoreDAO();
			StoreBean border = new StoreBean();
			
			border.seteId(dao.getSeq()); // 시퀀스값 가져와 세팅
			border.seteTitle(multi.getParameter("eTitle"));
			border.seteContent(multi.getParameter("eContent"));
			border.seteAddress(multi.getParameter("eAddress"));
			border.seteTime1(multi.getParameter("eTime1"));
			border.seteTime2(multi.getParameter("eTime2"));
			border.seteTime3(multi.getParameter("eTime3"));
			border.seteTime4(multi.getParameter("eTime4"));
			border.seteFile(fileName);
		
			boolean result = dao.storeInsert(border);
			
			if(result){
				forward.setRedirect(true);
				forward.setNextPath("store.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("글 작성 오류 : " + e.getMessage());
		}
		return forward;
	}
}
