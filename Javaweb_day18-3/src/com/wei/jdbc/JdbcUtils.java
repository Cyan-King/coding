package com.wei.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * new JdbcUtils
 */
public class JdbcUtils {

    /**
     * 使用一个规定的c3p0-config.xml和规定的位置
     */
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

    /**
     * 使用连接池连接对象
     * @param dataSource
     * @return
     * @throws SQLException
     */
    public static Connection getConnection(ComboPooledDataSource dataSource) throws SQLException {
        return dataSource.getConnection();
    }

    //返回一个连接池对象
    public static DataSource getDataSources(){
        return dataSource;
    }
}
