package com.wei.demo;

import com.wei.dao.AccountDao;
import com.wei.jdbc.JdbcUtils;
import org.junit.Test;

import java.sql.SQLException;

public class Demo {

    private static AccountDao accountDao = new AccountDao();

    @Test
    public void service() throws SQLException {
        try {
            JdbcUtils.beginTransaction();
            accountDao.update("ls", -100);
            accountDao.update("zs", 100);
            JdbcUtils.commitTransaction();
        } catch (SQLException e) {
            try {
                JdbcUtils.rollbackTransaction();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            throw e;
        }
    }
}
