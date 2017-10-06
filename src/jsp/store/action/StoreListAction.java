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
 		
 		// �۸���� �����´�.
 		ArrayList<StoreBean> list =  dao.getBoardList();
 	
 		// ���� �� ���� �۸�� ����
 		//request.setAttribute("listCount", listCount);
 		request.setAttribute("list", list);
 		
 		// �ܼ� ��ȸ�̹Ƿ� forward()��� (= DB�� ���º�ȭ �����Ƿ�) 
 		forward.setRedirect(false);
 		forward.setNextPath("StoreListForm.eo");
 		
 		return forward;
	}

}