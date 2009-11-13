package com.twowire.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.twowire.auth.AuthenticationService;
import com.twowire.auth.FakeAuthenticationService;
import com.twowire.data.DataService;
import com.twowire.data.IDataService;
import com.twowire.model.PendingTickets;

@SuppressWarnings("serial")
public class LoginController extends HttpServlet {

	private String target = "/CreateTicket.jsp";
	private String failedTarget = "/InvalidLogin.jsp";

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// If it is a get request forward to doPost()
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (getAuthenticationService().isValidLogin(username, password)) {

			request.setAttribute("tickets", getTickets());
			
			response.sendRedirect(target);
			request.getSession().setAttribute("username", username);
		}
		else {
			response.sendRedirect(failedTarget);
		}
		
	}

	private List getTickets() {
		PendingTickets tickets = new PendingTickets(getDataService());
		return tickets.getTickets();
	}

	protected IDataService getDataService() {
		try {
			return new DataService();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	protected AuthenticationService getAuthenticationService() {
        return new FakeAuthenticationService();
    }

}
