package com.example.datasource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author ZhangPengFei
 * @description 数据源工厂
 */
public interface DataSourceFactory {

    void setProperties(Properties properties);

    DataSource getDataSource();
}
