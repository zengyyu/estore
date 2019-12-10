package com.briup.app.estore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.app.estore.shoppingcart.ShoppingCart;

@WebServlet("/updateProduct")
public class updateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ShoppingCart shoppingcart = (ShoppingCart)req.getSession().getAttribute("shoppingcart");
		
		int productid = Integer.parseInt(req.getParameter("productid"));
		int number = Integer.parseInt(req.getParameter("number"));
		
		shoppingcart.update(productid, number);
		
		String page = "/user/shoppingCart.jsp";
		String msg = "修改成功!";
		req.getSession().setAttribute("shoppingcart",shoppingcart);
		req.setAttribute("msg", msg);
		req.getRequestDispatcher(page).forward(req, resp);
		
	}
	
}
