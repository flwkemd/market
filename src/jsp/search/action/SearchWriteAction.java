package jsp.search.action;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import jsp.common.action.Action;
import jsp.common.action.ActionForward;
import jsp.search.model.SearchBean;
import jsp.search.model.SearchDAO;

public class SearchWriteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
				
		// 업로드 파일 사이즈
		int fileSize= 5*1024*1024;
		// 업로드될 폴더 절대경로
		String uploadPath = request.getServletContext().getRealPath("/UploadFolder/Search");

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
			
			SearchDAO dao = new SearchDAO();
			SearchBean border = new SearchBean();
			
			border.setsId(dao.getSeq()); // 시퀀스값 가져와 세팅
			border.setsTitle(multi.getParameter("sTitle"));
			border.setsContent(multi.getParameter("sContent"));
			border.setsAddress(multi.getParameter("sAddress"));
			border.setsTime1(multi.getParameter("sTime1"));
			border.setsTime2(multi.getParameter("sTime2"));
			border.setsTime3(multi.getParameter("sTime3"));
			border.setsTime4(multi.getParameter("sTime4"));
			border.setsFile(fileName);
		
			boolean result = dao.searchInsert(border);
			
			if(result){
				forward.setRedirect(true);
				forward.setNextPath("../search.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("글 작성 오류 : " + e.getMessage());
		}
		return forward;
	}
}
