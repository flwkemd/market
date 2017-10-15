package jsp.store6.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.store.command.Command;
import jsp.store6.model.Store6Bean;
import jsp.store6.model.Store6DAO;

public class Store6DetailCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		int store6Id = Integer.parseInt(request.getParameter("store6Id"));
		Store6DAO dao = new Store6DAO();
		Store6Bean board = dao.getDetail(store6Id);
		
		request.setAttribute("store6Id", store6Id);
			
	}
}
