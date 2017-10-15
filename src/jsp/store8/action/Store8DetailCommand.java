package jsp.store8.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.store.command.Command;
import jsp.store8.model.Store8Bean;
import jsp.store8.model.Store8DAO;

public class Store8DetailCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		int store8Id = Integer.parseInt(request.getParameter("store8Id"));
		Store8DAO dao = new Store8DAO();
		Store8Bean board = dao.getDetail(store8Id);
		
		request.setAttribute("store8Id", store8Id);
			
	}
}
