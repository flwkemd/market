package jsp.video.action;
 
 import java.util.ArrayList;
 
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 
 import jsp.common.action.Action;
 import jsp.common.action.ActionForward;
import jsp.video.model.VideoBean;
import jsp.video.model.VideoDAO;
 
 public class VideoListAction implements Action {
 
 	@Override
 	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
 
 		ActionForward forward = new ActionForward();
 		
 		VideoDAO dao = new VideoDAO();
 		
 		// 글목록을 가져온다.
 		ArrayList<VideoBean> list =  dao.getBoardList();
 	
 		// 글의 총 수와 글목록 저장
 		//request.setAttribute("listCount", listCount);
 		request.setAttribute("list", list);
 		
 		// 단순 조회이므로 forward()사용 (= DB의 상태변화 없으므로) 
 		forward.setRedirect(false);
 		forward.setNextPath("VideoListForm.vo");
 		
 		return forward;
	}

}