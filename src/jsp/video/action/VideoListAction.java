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
 		
 		// �۸���� �����´�.
 		ArrayList<VideoBean> list =  dao.getBoardList();
 	
 		// ���� �� ���� �۸�� ����
 		//request.setAttribute("listCount", listCount);
 		request.setAttribute("list", list);
 		
 		// �ܼ� ��ȸ�̹Ƿ� forward()��� (= DB�� ���º�ȭ �����Ƿ�) 
 		forward.setRedirect(false);
 		forward.setNextPath("VideoListForm.vo");
 		
 		return forward;
	}

}