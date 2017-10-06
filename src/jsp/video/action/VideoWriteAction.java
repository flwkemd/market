package jsp.video.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.common.action.Action;
import jsp.common.action.ActionForward;

import jsp.video.model.VideoBean;
import jsp.video.model.VideoDAO;

public class VideoWriteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8"); // 인코딩

		ActionForward forward = new ActionForward();
		
			String vTitle = request.getParameter("vTitle");
			String vContent = request.getParameter("vContent");
			String vFile = request.getParameter("vFile");
			
				
			VideoDAO dao = new VideoDAO();
			VideoBean border = new VideoBean();
			
			border.setvId(dao.getSeq()); // 시퀀스값 가져와 세팅
			border.setvTitle(vTitle);
			border.setvContent(vContent);
			border.setvFile(vFile);
		
			boolean result = dao.videoInsert(border);
			
			if(result){
				forward.setRedirect(true);
				forward.setNextPath("video.jsp");
			}

			return forward;
	}
}
