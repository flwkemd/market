package jsp.search.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.common.action.Action;
import jsp.common.action.ActionForward;

public class SearchFormChangeAction implements Action
{
	private String form = "search.jsp";
	private String path;
	
	/**
	 * ��ɾ�κ��� ���� �̵��� ������ ��θ� �����Ѵ�.
	 * @param command ��ɾ�
	 */
	public void setCommand(String command){
		int idx = command.indexOf(".");
		path = command.substring(0, idx)+".jsp";
	}

	
	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		System.out.println("path"+path);
		forward.setRedirect(false);
		
		// ����ȭ���� ��� MainForm.jsp�� ��η� �����Ѵ�.
		if(form.equals("search.jsp"))
			forward.setNextPath(form);
		else
			forward.setNextPath(form+path);
		
		return forward;
	}
}
