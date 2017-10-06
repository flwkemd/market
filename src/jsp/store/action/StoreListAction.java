package jsp.store.action;
 
 import java.util.ArrayList;
 
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 
 import jsp.common.action.Action;
 import jsp.common.action.ActionForward;
import jsp.store.model.StoreBean;
import jsp.store.model.StoreDAO;
 
 public class StoreListAction implements Action {
 
 	@Override
 	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
 
 		ActionForward forward = new ActionForward();
 		
 		StoreDAO dao = new StoreDAO();
 		
 		// 글목록을 가져온다.
 		ArrayList<StoreBean> list =  dao.getBoardList();
 	
 		// 글의 총 수와 글목록 저장
 		//request.setAttribute("listCount", listCount);
 		request.setAttribute("list", list);
 		
 		// 단순 조회이므로 forward()사용 (= DB의 상태변화 없으므로) 
 		forward.setRedirect(false);
 		forward.setNextPath("StoreListForm.eo");
 		
 		return forward;
	}

}