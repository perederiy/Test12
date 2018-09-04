package org.itstep.servlet;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebListener;

import org.itstep.model.User;

@WebListener
public class ContextListener implements ServletContextListener {
	
	private Map<Integer, User> users;
	
	public void contextInitialized(ServletContextEvent contextEvent) {
		
		ServletContext context = contextEvent.getServletContext();
		
		users = new HashMap<Integer, User>();
		
		User user = new User(1, "Alex", 23);
		users.put(user.getId(), user);
		
		context.setAttribute("users", users);
		
		
		
	}

	public void contextDestroyed(ServletContextEvent context) {
		
		users = null;
	}

	

}
