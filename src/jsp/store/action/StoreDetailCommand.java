package jsp.store.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.store.command.Command;
import jsp.store.model.StoreBean;
import jsp.store.model.StoreDAO;

public class StoreDetailCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		int store1Id = Integer.parseInt(request.getParameter("store1Id"));
		StoreDAO dao = new StoreDAO();
		StoreBean board = dao.getDetail(store1Id);
		
		request.setAttribute("store1Id", store1Id);
			
	}
}
