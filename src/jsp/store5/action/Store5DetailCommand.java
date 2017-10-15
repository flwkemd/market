package jsp.store5.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.store.command.Command;
import jsp.store5.model.Store5Bean;
import jsp.store5.model.Store5DAO;

public class Store5DetailCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		int store5Id = Integer.parseInt(request.getParameter("store5Id"));
		Store5DAO dao = new Store5DAO();
		Store5Bean board = dao.getDetail(store5Id);
		
		request.setAttribute("store5Id", store5Id);
			
	}
}
