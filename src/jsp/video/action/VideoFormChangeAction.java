package jsp.video.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.common.action.Action;
import jsp.common.action.ActionForward;

public class VideoFormChangeAction implements Action
{
	private String form = "video.jsp";
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
		forward.setRedirect(false);
		
		// ����ȭ���� ��� MainForm.jsp�� ��η� �����Ѵ�.
		if(form.equals("video.jsp"))
			forward.setNextPath(form);
		else
			forward.setNextPath(form+path);
		
		return forward;
	}
}
