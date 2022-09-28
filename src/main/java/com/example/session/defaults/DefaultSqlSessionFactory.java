package com.example.session.defaults;

import com.example.session.Configuration;
import com.example.session.SqlSession;
import com.example.session.SqlSessionFactory;

/**
 * @author ZhangPengFei
 * @description
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
