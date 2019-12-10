package com.briup.app.estore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.app.estore.bean.Customer;
import com.briup.app.estore.service.ICustomerService;
import com.briup.app.estore.service.ICustomerServiceImp;
import com.briup.app.estore.shoppingcart.ShoppingCart;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Customer customer = (Customer) req.getSession().getAttribute("customer");
		customer = null;
		req.getSession().setAttribute("customer",customer);
		
		String page = "/login.jsp";
		req.getRequestDispatcher(page).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String page = "/login.jsp";
		req.getRequestDispatcher(page).forward(req, resp);
		
	}
	
}
