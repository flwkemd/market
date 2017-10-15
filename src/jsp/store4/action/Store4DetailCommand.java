package jsp.store4.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.store.command.Command;
import jsp.store4.model.Store4Bean;
import jsp.store4.model.Store4DAO;

public class Store4DetailCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		int store4Id = Integer.parseInt(request.getParameter("store4Id"));
		Store4DAO dao = new Store4DAO();
		Store4Bean board = dao.getDetail(store4Id);
		
		request.setAttribute("store4Id", store4Id);
			
	}
}
