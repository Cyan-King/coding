package com.wei.dao;

import com.wei.jdbc.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

public class AccountDao extends QueryRunner {

    public static void update(String name, double money) throws SQLException {
        QueryRunner qr = new TxQueryRunner();
        String sql = "update account set balance=balance+? where name=?";
        Object[] params = {money, name};

        qr.update(sql, params);
    }
}
