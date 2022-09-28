package com.example;

import com.example.dao.IUserDao;
import com.example.io.Resources;
import com.example.po.User;
import com.example.session.SqlSession;
import com.example.session.SqlSessionFactory;
import com.example.session.SqlSessionFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.Reader;

@SpringBootTest
@Slf4j
class SpringBootDemoApplicationTests {

	@Test
	public void mapperProxyFactoryTest() throws IOException {
		Reader reader = Resources.getResourceAsReader("mybatis-config-datasource.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

		SqlSession sqlSession = sqlSessionFactory.openSession();
		IUserDao userDao = sqlSession.getMapper(IUserDao.class);
		User res = userDao.queryUserInfoById("100");
		System.out.println("结果：" + res);
	}

}
