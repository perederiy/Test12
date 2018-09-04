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
import org.itstep.util.Utils;

@WebServlet("/add_user")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private Map<Integer, User> users;
	private int id;
	
	@Override
	public void init() throws ServletException {
		Object user = getServletContext().getAttribute("users");
		if(user == null || !(user instanceof HashMap)) {
			throw new IllegalStateException("Your repo is not init");
		}else {
			users = (HashMap<Integer, User>)user;
		}
		
		id = 2;
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		User user = new User();
		id = Utils.getIncrementId(id);
		user.setId(id);
		user.setName(name);
		user.setAge(Integer.valueOf(age));
		
		users.put(id, user);
		
		response.sendRedirect(request.getContextPath() + "/");
	}


}
