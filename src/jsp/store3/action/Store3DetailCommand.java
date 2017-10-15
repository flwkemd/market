package jsp.store3.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.store.command.Command;
import jsp.store3.model.Store3Bean;
import jsp.store3.model.Store3DAO;

public class Store3DetailCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		int store3Id = Integer.parseInt(request.getParameter("store3Id"));
		Store3DAO dao = new Store3DAO();
		Store3Bean board = dao.getDetail(store3Id);
		
		request.setAttribute("store3Id", store3Id);
			
	}
}
