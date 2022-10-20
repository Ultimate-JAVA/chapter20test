package com.sz.guigu.test04;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Properties;

public class JDBCUtils {
    static DataSource dataSource;

    static {
        try {
            Properties properties = new Properties();
            properties.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {

        Connection connection = getConnection();
        System.out.println(connection);
    }

    public static Connection getConnection() throws Exception {

        return dataSource.getConnection();
    }

}
