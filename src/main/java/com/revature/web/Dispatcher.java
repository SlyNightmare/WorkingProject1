package com.revature.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.service.LoginService;
import com.revature.service.LoginServiceImpl;
import com.revature.service.ReimburseService;
import com.revature.service.ReimburseServiceImpl;

public class Dispatcher {

	private static final LoginService loginService = new LoginServiceImpl();
	private static final ReimburseService todoService = new ReimburseServiceImpl();
	private static final ObjectMapper mapper = new ObjectMapper();
	
	private Dispatcher() {
	}

	public static Object process(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException, IOException {
		System.out.println(request.getMethod() + " request going to " + request.getRequestURI());
		if (request.getMethod().equalsIgnoreCase("POST")) {
			// Handling to Front Controller logic if a POST request is sent to /login
			if (request.getRequestURI().replace("/Devops_Example/api", "").equals("/login")) {
				loginService.attemptAuthentication(request, response);
			}
			
			// Handling the Front Controller logic if a POST request is sent to /todos (CREATE)
			if (request.getRequestURI().replace("/Devops_Example/api", "").equals("/todos")) {
				todoService.createTodo(request, response);
			}
		}
		if (request.getMethod().equalsIgnoreCase("GET")) {
			// Handle the Front Controller logic if a GET request is sent to /todos (READ ALL)
			if (request.getRequestURI().replace("/Devops_Example/api", "").equals("/todos")) {
				response.setContentType("application/json");
				response.getOutputStream().write(mapper.writeValueAsBytes(todoService.getAllTodosByUsername(request, response)));
			}
		}
		return "Not yet implemented";
	}
}
