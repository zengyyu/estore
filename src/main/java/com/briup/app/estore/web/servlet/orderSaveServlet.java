package com.briup.app.estore.web.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.app.estore.bean.Customer;
import com.briup.app.estore.bean.Order;
import com.briup.app.estore.bean.Orderline;
import com.briup.app.estore.service.ILineService;
import com.briup.app.estore.service.ILineServiceImp;
import com.briup.app.estore.service.IOrderService;
import com.briup.app.estore.service.IOrderServiceImp;
import com.briup.app.estore.shoppingcart.ShoppingCart;

@WebServlet("/user/orderSave")
public class orderSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IOrderService orderService = new IOrderServiceImp();
	private ILineService lineService = new ILineServiceImp();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ShoppingCart shoppingcart = (ShoppingCart)req.getSession().getAttribute("shoppingcart");
		Customer customer = (Customer)req.getSession().getAttribute("customer");
		
		Map<Integer, Orderline> lines = shoppingcart.getLines();
		
		if(!shoppingcart.getLines().isEmpty()) {
			Order order = new Order();
			order.setCost(shoppingcart.getCost());
			order.setOrderdate(new Timestamp(new Date().getTime()));
			order.setCustomer(customer);
			orderService.saveOrder(order);
			lines.forEach(
					(k, v) -> {
						System.out.println("key = "+ k+ "value = "+ v);
						v.setOrder(order);
						lineService.saveLine(v);
					}
					);
			shoppingcart.clear();
			String page = "/user/orderSave.jsp";
			String msg = "订单成功!";
			req.setAttribute("msg", msg);
			req.getSession().setAttribute("shoppingcart",shoppingcart);
			req.getRequestDispatcher(page).forward(req, resp);
		}else {
			String page = "/index.jsp";
			req.getRequestDispatcher(page).forward(req, resp);
		}
		
	}
	
}
