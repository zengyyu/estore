package com.briup.app.estore.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.app.estore.bean.Book;
import com.briup.app.estore.mapper.BookMapper;
import com.briup.app.estore.util.MyBatisSqlSessionFactory;

public class IBookServiceImp implements IBookService {
	private  SqlSession sqlSession ;
	private  BookMapper bookMapper;

	{
		sqlSession = MyBatisSqlSessionFactory.openSession();
		
		bookMapper = sqlSession.getMapper(BookMapper.class);
	}
	
	@Override
	public List<Book> selectAll(){
		List<Book> list = bookMapper.selectAll();
		return list;
	}
	
}
