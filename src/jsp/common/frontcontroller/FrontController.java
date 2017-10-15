package jsp.common.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.store.action.StoreDetailCommand;
import jsp.store.action.StoreListCommand;
import jsp.store.command.Command;
import jsp.store2.action.Store2DetailCommand;
import jsp.store2.action.Store2ListCommand;
import jsp.store3.action.Store3DetailCommand;
import jsp.store3.action.Store3ListCommand;
import jsp.store4.action.Store4DetailCommand;
import jsp.store4.action.Store4ListCommand;
import jsp.store5.action.Store5DetailCommand;
import jsp.store5.action.Store5ListCommand;
import jsp.store6.action.Store6DetailCommand;
import jsp.store6.action.Store6ListCommand;
import jsp.store7.action.Store7DetailCommand;
import jsp.store7.action.Store7ListCommand;
import jsp.store8.action.Store8DetailCommand;
import jsp.store8.action.Store8ListCommand;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String viewPage = null;
		Command command = null;
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		if(com.equals("/store1.do")) {
			command = new StoreListCommand();
			command.execute(request, response);
			viewPage = "/store/store.jsp";
		} else if(com.equals("/store2.do")) {
			command = new Store2ListCommand();
			command.execute(request, response);
			viewPage = "/store2/store2.jsp";
		} else if(com.equals("/store3.do")) {
			command = new Store3ListCommand();
			command.execute(request, response);
			viewPage = "/store3/store3.jsp";
		} else if(com.equals("/store4.do")) {
			command = new Store4ListCommand();
			command.execute(request, response);
			viewPage = "/store4/store4.jsp";
		} else if(com.equals("/store5.do")) {
			command = new Store5ListCommand();
			command.execute(request, response);
			viewPage = "/store5/store5.jsp";
		} else if(com.equals("/store6.do")) {
			command = new Store6ListCommand();
			command.execute(request, response);
			viewPage = "/store6/store6.jsp";
		} else if(com.equals("/store7.do")) {
			command = new Store7ListCommand();
			command.execute(request, response);
			viewPage = "/store7/store7.jsp";
		} else if(com.equals("/store8.do")) {
			command = new Store8ListCommand();
			command.execute(request, response);
			viewPage = "/store8/store8.jsp";
		} else if(com.equals("/storeDetail.do")) {
			command = new StoreDetailCommand();
			command.execute(request, response);
			viewPage = "/store/storeView.jsp";
		} else if(com.equals("/store2Detail.do")) {
			command = new Store2DetailCommand();
			command.execute(request, response);
			viewPage = "/store2/store2View.jsp";
		} else if(com.equals("/store3Detail.do")) {
			command = new Store3DetailCommand();
			command.execute(request, response);
			viewPage = "/store3/store3View.jsp";
		} else if(com.equals("/store4Detail.do")) {
			command = new Store4DetailCommand();
			command.execute(request, response);
			viewPage = "/store4/store4View.jsp";
		} else if(com.equals("/store5Detail.do")) {
			command = new Store5DetailCommand();
			command.execute(request, response);
			viewPage = "/store5/store5View.jsp";
		} else if(com.equals("/store6Detail.do")) {
			command = new Store6DetailCommand();
			command.execute(request, response);
			viewPage = "/store6/store6View.jsp";
		} else if(com.equals("/store7Detail.do")) {
			command = new Store7DetailCommand();
			command.execute(request, response);
			viewPage = "/store7/store7View.jsp";
		} else if(com.equals("/store8Detail.do")) {
			command = new Store8DetailCommand();
			command.execute(request, response);
			viewPage = "/store8/store8View.jsp";
		}
	
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		if(viewPage!="null")
		dispatcher.forward(request, response);
		
	}
		
	}
	
	
