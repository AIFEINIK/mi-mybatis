package com.example.binding;

import cn.hutool.core.lang.ClassScanner;
import com.example.session.Configuration;
import com.example.session.SqlSession;
import com.google.common.collect.Maps;

import java.util.Map;
import java.util.Set;

/**
 * @author ZhangPengFei
 * @description 映射器注册机
 */
public class MapperRegistry {

    /**
     * 将已添加的映射器代理加入到 HashMap
     */
    private final Map<Class<?>, MapperProxyFactory<?>> knownMappers = Maps.newHashMap();

    private Configuration configuration;

    public MapperRegistry(Configuration configuration) {
        this.configuration = configuration;
    }

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        MapperProxyFactory<T> mapperProxyFactory = (MapperProxyFactory<T>) knownMappers.get(type);
        if (mapperProxyFactory == null) {
            throw new RuntimeException("Type " + type + " is not known to the MapperRegistry.");
        }

        return mapperProxyFactory.newInstance(sqlSession);
    }

    public <T> void addMapper(Class<T> type) {
        if (type.isInterface()) {
            if (knownMappers.containsKey(type)) {
                throw new RuntimeException("Type " + type + " is already known to the MapperRegistry");
            }

            knownMappers.put(type, new MapperProxyFactory<>(type));
        }
    }

    public void addMappers(String packageName) {
        Set<Class<?>> classes = ClassScanner.scanPackage(packageName);
        for (Class<?> mapperClass : classes) {
            addMapper(mapperClass);
        }
    }
}
