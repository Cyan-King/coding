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

    private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
    /**
     * 使用连接池连接对象
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        Connection con = tl.get();
        //当con!=null说明事务已经开启了，我们再次调用的话就是是一个新的事务
        if (con != null) return con;
        return dataSource.getConnection();
    }

    //返回一个连接池对象
    public static DataSource getDataSources(){
        return dataSource;
    }

    /**
     * 开始事务beginTransaction
     * @throws SQLException
     */
    public static void beginTransaction() throws SQLException {
        Connection con = tl.get();
        if (con != null) throw new SQLException("已经开启事务不必再开了");
        //给con赋值表示事务已经开始了
        con = getConnection();
        con.setAutoCommit(false);
        tl.set(con);
    }

    /**
     *
     * 提交事务commitTransaction
     * @throws SQLException
     */
    public static void commitTransaction() throws SQLException {
        Connection con = tl.get();

        if (con == null) throw new SQLException("还没有开启事务不能提交！");

        con.commit();
        con.close();
        tl.remove();
}

    /**
     *
     * 提交事务rollbackTransaction
     * @throws SQLException
     */
    public static void rollbackTransaction() throws SQLException {
        Connection con = tl.get();

        if (con == null) throw new SQLException("还没有开启事务不能提交！");

        con.rollback();
        con.close();
        tl.remove();
    }

    /**
     *
     * @param connection
     * @throws SQLException
     */
    public static void releaseConnection(Connection connection) throws SQLException {
        Connection con = tl.get();
        //如果con=null的话表示我们没有事务，那这个事务就可以关闭了
        if (con == null) connection.close();
        //如果con != connection 如果不是con和connection不是一个连接的话拿也是可以关闭的
        if (con != connection) connection.close();
    }

}
