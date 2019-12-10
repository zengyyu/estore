package com.briup.app.estore.service;

import org.apache.ibatis.session.SqlSession;

import com.briup.app.estore.bean.Order;
import com.briup.app.estore.mapper.OrderMapper;
import com.briup.app.estore.util.MyBatisSqlSessionFactory;

public class IOrderServiceImp implements IOrderService {

	private  SqlSession sqlSession ;
	private  OrderMapper orderMapper;

	{
		sqlSession = MyBatisSqlSessionFactory.openSession();
		
		orderMapper = sqlSession.getMapper(OrderMapper.class);
	}
	

	@Override
	public void saveOrder(Order order) {
		orderMapper.insert(order);
		sqlSession.commit();
	}
	
	
}
