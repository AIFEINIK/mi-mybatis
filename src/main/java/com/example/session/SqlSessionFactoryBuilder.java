package com.example.session;

import com.example.builder.xml.XMLConfigBuilder;
import com.example.session.defaults.DefaultSqlSessionFactory;

import java.io.Reader;

/**
 * @author ZhangPengFei
 * @description 构建SqlSessionFactory的工厂
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(Reader reader) {
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(reader);
        return build(xmlConfigBuilder.parse());
    }

    public SqlSessionFactory build(Configuration configuration) {
        return new DefaultSqlSessionFactory(configuration);
    }
}
