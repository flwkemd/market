package jsp.store2.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.store.command.Command;
import jsp.store2.model.Store2Bean;
import jsp.store2.model.Store2DAO;

public class Store2DetailCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		int store2Id = Integer.parseInt(request.getParameter("store2Id"));
		Store2DAO dao = new Store2DAO();
		Store2Bean board = dao.getDetail(store2Id);
		
		request.setAttribute("store2Id", store2Id);
			
	}
}
