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

@WebServlet("/user/customerUpdate")
public class CustomerUpdateServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private ICustomerService customerService = new ICustomerServiceImp();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Customer customer = (Customer)req.getSession().getAttribute("customer");
	
		customer.setPassword(req.getParameter("password"));
		customer.setAddress(req.getParameter("address"));
		customer.setZip(req.getParameter("zip"));
		customer.setTelephone(req.getParameter("telephone"));
		customer.setEmail(req.getParameter("email"));
		
		String page = "/user/userinfo.jsp";
		String msg = "用户修改成功!";
		
		try {
			customerService.update(customer);
			req.getSession().setAttribute("customer",customer);
		
		} catch (Exception e) {
			e.printStackTrace();
			msg = "用户修改失败!";
		}finally {
			req.setAttribute("msg", msg);
			req.getRequestDispatcher(page).forward(req, resp);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
