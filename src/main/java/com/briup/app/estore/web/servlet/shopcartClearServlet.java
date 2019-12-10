package com.briup.app.estore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.app.estore.shoppingcart.ShoppingCart;

@WebServlet("/shopcartClear")
public class shopcartClearServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ShoppingCart shoppingcart = (ShoppingCart)req.getSession().getAttribute("shoppingcart");
		
		shoppingcart.clear();
		
		String page = "/user/shoppingCart.jsp";
		String msg = "购物车清空成功!";
		
		req.setAttribute("msg", msg);
		req.getSession().setAttribute("shoppingcart",shoppingcart);
		req.getRequestDispatcher(page).forward(req, resp);
		
	}
	
}
