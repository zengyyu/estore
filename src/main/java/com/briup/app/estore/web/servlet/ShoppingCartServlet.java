package com.briup.app.estore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.app.estore.bean.*;
import com.briup.app.estore.service.IBookServiceImp;
import com.briup.app.estore.shoppingcart.ShoppingCart;

@WebServlet("/shoppingCart")
public class ShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBookServiceImp bookService = new IBookServiceImp();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * String page = "/user/shoppingCart.jsp";
		 * req.getRequestDispatcher(page).forward(req, resp);
		 */
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Customer customer = (Customer) req.getSession().getAttribute("customer");
		ShoppingCart shoppingcart = customer.getShoppingcart();
		String bookName = req.getParameter("bookName");
		
		List<Book> booklist = bookService.selectAll();
		Orderline orderline = new Orderline();

		for (Book b : booklist) {
			if(b.getName().equals(bookName)) {
				orderline.setBook(b);
			}
		}
		
		shoppingcart.add(orderline);
		
		String page = "/user/shoppingCart.jsp";
		String msg = "购买成功!";
		
		req.getSession().setAttribute("shoppingcart",shoppingcart);
		
		req.setAttribute("msg", msg);
		req.getRequestDispatcher(page).forward(req, resp);
		
	}
	
}
