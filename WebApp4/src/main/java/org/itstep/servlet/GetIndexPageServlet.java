package org.itstep.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.itstep.model.User;

@WebServlet("/")
public class GetIndexPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<Integer, User> users;

	@Override
	public void init() throws ServletException {

		System.out.println("Servlet GetIndexPage is init");
		
		Object user = getServletContext().getAttribute("users");
		if(user == null || !(user instanceof HashMap)) {
			throw new IllegalStateException("Your repository not  initialize");
		}else {
			users = (HashMap<Integer, User>)user; 
		}
		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("users", users.values());
		request.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(request, response);
	}

}
