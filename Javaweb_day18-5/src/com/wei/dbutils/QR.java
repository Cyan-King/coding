package com.wei.dbutils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class QR<T> {
    private DataSource dataSource;
    Connection con = null;
    private PreparedStatement prst = null;
    ResultSet rs = null;

    public QR() {
        super();
    }

    public QR(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public int update(String sql, Object... params){

        try {
            //通过连接池获取到了连接对象
            con = dataSource.getConnection();
            //通过sql得到prst
            prst = con.prepareStatement(sql);

            //设置参数
            initParams(prst, params);

            //执行
            return prst.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if (prst != null) prst.close();
                if (con != null) con.close();
            } catch (SQLException e) {}

        }

    }

    private void initParams(PreparedStatement prst, Object[] params) throws SQLException {

        for (int i = 0; i < params.length; i++){
            prst.setObject(i+1, params[i]);
        }
    }

    public T query(String sql, RsHandler<T> rh, Object... params){

        try {
            con = dataSource.getConnection();
            prst = con.prepareStatement(sql);

            initParams(prst, params);

             rs = prst.executeQuery();

             return rh.handle(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try{
                if (con != null) con.close();
                if (prst != null) prst.close();
                if(rs != null) rs.close();
            } catch (Exception e){}

        }

    }
}

interface RsHandler<T>{

    public T handle(ResultSet rs) throws SQLException;

}
