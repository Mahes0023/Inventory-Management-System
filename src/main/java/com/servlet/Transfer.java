package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.ProductDao;
import com.Products;

/**
 * Servlet implementation class Transfer
 */
@WebServlet("/Transfer")
public class Transfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		
  		HttpSession ses = request.getSession(false); // Get session without creating a new one
  		if (ses == null || ses.getAttribute("email") == null) 
  		{
  		    response.sendRedirect("Login.jsp"); // Redirect to login if not logged in
  		}
  		
  		ProductDao sd = new ProductDao();
		List<Products> products=sd.getAllProducts();
		request.setAttribute("mahesh", products);
		request.getRequestDispatcher("Transfer.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
