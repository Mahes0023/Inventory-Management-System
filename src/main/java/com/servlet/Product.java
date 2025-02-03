package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.ProductDao;
import com.Products;

/**
 * Servlet implementation class Product
 */
@WebServlet("/details")
public class Product extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Product() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String product_name = request.getParameter("productName");
		String product_price = request.getParameter("price");
		String category = request.getParameter("category");
		String description = request.getParameter("description");
		
		Products pd = new Products();
		pd.setProduct_name(product_name);
		pd.setProduct_price(product_price);
		pd.setCategory(category);
		pd.setDescription(description);
		
		ProductDao dao = new ProductDao();
		dao.product_save(pd);
		
		response.sendRedirect("Transfer");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
