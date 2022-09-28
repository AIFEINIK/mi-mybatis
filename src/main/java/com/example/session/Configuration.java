package com.example.session;

import com.example.binding.MapperRegistry;
import com.example.datasource.druid.DruidDataSourceFactory;
import com.example.mapping.Environment;
import com.example.mapping.MappedStatement;
import com.example.transaction.jdbc.JdbcTransactionFactory;
import com.example.type.TypeAliasRegistry;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author ZhangPengFei
 * @description 配置项
 */
public class Configuration {

    protected Environment environment;

    protected MapperRegistry mapperRegistry = new MapperRegistry(this);

    protected final Map<String, MappedStatement> mappedStatements = Maps.newHashMap();

    protected final TypeAliasRegistry typeAliasRegistry = new TypeAliasRegistry();

    public Configuration() {
        typeAliasRegistry.registryAlias("JDBC", JdbcTransactionFactory.class);
        typeAliasRegistry.registryAlias("DRUID", DruidDataSourceFactory.class);
    }

    public void addMappers(String packageName) {
        mapperRegistry.addMappers(packageName);
    }

    public <T> void addMapper(Class<T> type) {
        mapperRegistry.addMapper(type);
    }

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        return mapperRegistry.getMapper(type, sqlSession);
    }

    public void addMappedStatement(MappedStatement ms) {
        mappedStatements.put(ms.getId(), ms);
    }

    public MappedStatement getMappedStatement(String id) {
        return mappedStatements.get(id);
    }

    public TypeAliasRegistry getTypeAliasRegistry() {
        return typeAliasRegistry;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
