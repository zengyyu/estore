package com.briup.app.estore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.app.estore.bean.Customer;
import com.briup.app.estore.service.IBookServiceImp;
import com.briup.app.estore.service.ICustomerService;
import com.briup.app.estore.service.ICustomerServiceImp;
import com.briup.app.estore.shoppingcart.ShoppingCart;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICustomerService customerService = new ICustomerServiceImp();
	private IBookServiceImp bookService = new IBookServiceImp();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String page = "/login.jsp";
		req.getRequestDispatcher(page).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Customer customer = new Customer();
		customer.setName(req.getParameter("name"));
		customer.setPassword(req.getParameter("password"));
		
		String page = "/index.jsp";
		String msg = "登陆成功!";
		
		try {
			customer = customerService.login(customer);
			customer.setShoppingcart(new ShoppingCart());
			req.getSession().setAttribute("customer",customer);
			
			req.getSession().setAttribute("booklist", bookService.selectAll());
		} catch (Exception e) {
			page = "/login.jsp";
			msg = e.getMessage();
			e.printStackTrace();
		}
		req.setAttribute("msg", msg);
		req.getRequestDispatcher(page).forward(req, resp);
		
	}
	
}
