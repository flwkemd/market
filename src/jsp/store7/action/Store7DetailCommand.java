package jsp.store7.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.store.command.Command;
import jsp.store7.model.Store7Bean;
import jsp.store7.model.Store7DAO;

public class Store7DetailCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		int store7Id = Integer.parseInt(request.getParameter("store7Id"));
		Store7DAO dao = new Store7DAO();
		Store7Bean board = dao.getDetail(store7Id);
		
		request.setAttribute("store7Id", store7Id);
			
	}
}
