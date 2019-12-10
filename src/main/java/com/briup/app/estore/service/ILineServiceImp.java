package com.briup.app.estore.service;

import org.apache.ibatis.session.SqlSession;

import com.briup.app.estore.bean.Orderline;
import com.briup.app.estore.mapper.OrderlineMapper;
import com.briup.app.estore.util.MyBatisSqlSessionFactory;

public class ILineServiceImp implements ILineService {

	private  SqlSession sqlSession ;
	private  OrderlineMapper orderlineMapper;

	{
		sqlSession = MyBatisSqlSessionFactory.openSession();
		
		orderlineMapper = sqlSession.getMapper(OrderlineMapper.class);
	}
	
	@Override
	public void saveLine(Orderline v) {
		orderlineMapper.insert(v);
		sqlSession.commit();
	}

}
