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

@WebServlet("/delete")
public class DeleteUserServlet extends HttpServlet {
    private Map<Integer, User> users;

	@Override
	public void init() throws ServletException {
		System.out.println("Servlet DeleteUser is init");
		Object user = getServletContext().getAttribute("users");
		if(user == null || !(user instanceof HashMap)) {
			throw new IllegalStateException("repo is not init");
		}else {
			users = (HashMap<Integer, User>)user;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		users.remove(Integer.valueOf(request.getParameter("id")));
		response.sendRedirect(request.getContextPath() + "/");
	}

}
