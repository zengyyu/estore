package com.briup.app.estore.service;

import org.apache.ibatis.session.SqlSession;

import com.briup.app.estore.bean.Customer;
import com.briup.app.estore.mapper.CustomerMapper;
import com.briup.app.estore.util.MyBatisSqlSessionFactory;

public class ICustomerServiceImp implements ICustomerService {

	private  SqlSession sqlSession ;
	private  CustomerMapper customerMapper;

	{
		sqlSession = MyBatisSqlSessionFactory.openSession();
		
		customerMapper = sqlSession.getMapper(CustomerMapper.class);
	}
	
	@Override
	public void register(Customer customer) throws Exception {
		//SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		//CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
		Customer customer2 = customerMapper.selectByName(customer.getName());
		if(customer2 == null) {
			customerMapper.insert(customer);
		}else {
			throw new Exception("用户名"+customer2.getName() +"已存在!");
		}
		sqlSession.commit();
	}

	@Override
	public Customer login(Customer customer) throws Exception {
		Customer customer2 = customerMapper.selectByName(customer.getName());
		
		if(customer2 == null) {
			throw new Exception("用户名"+customer.getName() +"不存在!");
		}else {
			if(!customer2.getPassword().equals(customer.getPassword())) {
				throw new Exception("密码错误");
			}
		}
		return customer2;
	}
	
	@Override
	public int update(Customer customer) throws Exception {
		
		int i = customerMapper.updateByPrimaryKey(customer);
		sqlSession.commit();
		return i;
		
	}
	
	
}
