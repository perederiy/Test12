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

@WebServlet("/update")
public class UpdateUserServlet extends HttpServlet {
    private Map<Integer, User> users;   

	@Override
	public void init() throws ServletException {
		System.out.println("Servlet UpdateUser is init");
		Object user = getServletContext().getAttribute("users");
		if(user == null || !(user instanceof HashMap)) {
			throw new IllegalStateException("repo is not init");
		}else {
			users = (HashMap<Integer, User>)user;
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		User user = users.get(Integer.parseInt(id));
		request.setAttribute("user", user);
		request.getRequestDispatcher("/WEB-INF/pages/update.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		
		User user = users.get(Integer.parseInt(id));
		user.setName(name);
		
		response.sendRedirect(request.getContextPath() + "/");
		
	}

}
