package com.revature.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.ReimburseDao;
import com.revature.dao.ReimburseDaoImpl;
import com.revature.model.Reimburse;

public class ReimburseServiceImpl implements ReimburseService {

	private final ReimburseDao dao = new ReimburseDaoImpl();
	
	@Override
	public List<Reimburse> getAllTodosByUsername(HttpServletRequest request, HttpServletResponse response) {
		final String username = (String) request.getSession().getAttribute("currentUser");
		System.out.println(username + " attempting access all todos");
		return dao.getAllTodosByUsername(username);
	}

	@Override
	public void createTodo(HttpServletRequest request, HttpServletResponse response) {
		final String username = (String) request.getSession().getAttribute("currentUser");
		final String title = (String) request.getParameter("title");
		final String description = (String) request.getParameter("description");
		Reimburse todo = dao.createTodo(new Reimburse(0, title, description), username);
			try {
				if (todo == null) {
					request.getRequestDispatcher("/home.jsp?error").forward(request, response);
				} else {
					request.getRequestDispatcher("/home.jsp").forward(request, response);
				}
				
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			} 
	}

}
