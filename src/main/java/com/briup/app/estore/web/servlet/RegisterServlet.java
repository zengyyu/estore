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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private ICustomerService customerService = new ICustomerServiceImp();
	
	//获取参数
	//把参数封装成对象
	//调用service层方法进行业务处理
	//根据service层方法的处理结果,选择合适的界面
	
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
		customer.setZip(req.getParameter("zip"));
		customer.setAddress(req.getParameter("address"));
		customer.setTelephone(req.getParameter("telephone"));
		customer.setEmail(req.getParameter("email"));
		
		String page = "/login.jsp";
		String msg = "注册成功!";
		
		try {
			customerService.register(customer);
		} catch (Exception e) {
			page = "/register.jsp";
			msg = e.getMessage();
			e.printStackTrace();
		}
		
		req.setAttribute("msg", msg);
		req.getRequestDispatcher(page).forward(req, resp);
		
	}
}
