package com.servlet;

import java.io.IOException;

import com.User;
import com.userDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registraion
 */
@WebServlet("/register")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final userDao ud=new userDao();
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("starting");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String repassword = request.getParameter("Repassword");
		System.out.println("11111");
		
		if(password.equals(repassword))
		{
			User us = new User();
			us.setName(name);
			us.setEmail(email);
			us.setPassword(password);
			
			//userDao dao = new userDao();
			ud.save(us);
			}
		response.sendRedirect("Home.html");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
