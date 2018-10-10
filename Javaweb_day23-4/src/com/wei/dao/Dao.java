package com.wei.dao;

import cn.itcast.jdbc.TxQueryRunner;
import com.wei.domain.City;
import com.wei.domain.Provnice;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class Dao {

    QueryRunner qr = new TxQueryRunner();

    /**
     * 通过数据库查询所有的省名称
     * @return
     */
    public List<Provnice> findByProvnice() {


        try {
            String sql = "SELECT * FROM t_province";

            return qr.query(sql, new BeanListHandler<Provnice>(Provnice.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    /**
     *
     * 通过省pid得到所有的省名称下面的所有市名称
     * @param pid
     * @return
     */
    public List<City> findByCity(int pid) {

        try {
            String sql = "SELECT * FROM t_city where pid = ?";

            return qr.query(sql, new BeanListHandler<City>(City.class), pid);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

}
