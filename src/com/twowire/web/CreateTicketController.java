package com.twowire.web;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.twowire.model.Ticket;

@SuppressWarnings("serial")
public class CreateTicketController extends HttpServlet {
	
	private String target = "/Success.jsp";
	private String failedTarget = "/CreateTicket.jsp";
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Ticket ticket = null;
		String subject = request.getParameter("subject");
		String question = request.getParameter("question");
		String category = request.getParameter("category");
		String submit = request.getParameter("submit_question");
		
		if (submit != null && allFieldsFull(subject, question, category)) {			
			ticket = new Ticket(subject, question, category);
			response.sendRedirect(target);
			request.getSession().setAttribute("ticket", ticket);
		}
		else {
			response.sendRedirect(failedTarget);
		}	
	}

	private boolean allFieldsFull(String subject, String question,
			String category) {
		return subject!=null && question!=null && category!=null;
	}

}
