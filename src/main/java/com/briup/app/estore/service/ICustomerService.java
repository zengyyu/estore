package com.briup.app.estore.service;

import com.briup.app.estore.bean.Customer;

public interface ICustomerService {
	
	void register(Customer customer) throws Exception;

	Customer login(Customer customer) throws Exception;

	int update(Customer customer) throws Exception;
}
