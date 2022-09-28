package com.example.session;

/**
 * @author ZhangPengFei
 * @description 用来执行SQL，获取映射器，管理事务
 */
public interface SqlSession {

    /**
     * 根据指定的SqlID获取一条记录的封装对象
     * @param statement
     * @return
     * @param <T>
     */
    <T> T selectOne(String statement);

    /**
     * 根据指定的SqlID获取一条记录的封装对象，可以通过parameter传递参数到sql
     * @param statement
     * @param parameter
     * @return
     * @param <T>
     */
    <T> T selectOne(String statement, Object parameter);

    Configuration getConfiguration();

    /**
     * 获取映射器
     * @param type
     * @return
     * @param <T>
     */
    <T> T getMapper(Class<T> type);
}
