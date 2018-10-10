package com.wei.dbutils;

import com.wei.jdbc.JdbcUtils;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo1 {

    @Test
    public void fun1(){
//        Stu stu = new Stu(5, "周瑜", 18, "男");
//        add(stu);
        Stu stu = load(5);
        System.out.println(stu);
    }

    public void add(Stu stu){
        QR qr = new QR(JdbcUtils.getDataSources());
        String sql = "insert into stu values(?,?,?,?)";
        Object[] params = {stu.getId(), stu.getNAME(), stu.getAge(), stu.getSex()};
        qr.update(sql, params);
    }

    @Test
    public Stu load(int id) {
        QR qr = new QR(JdbcUtils.getDataSources());//创建对象时给出连接池
        String sql = "select * from t_stu where sid=?";//给出sql模板
        Object[] params = {id};

        System.out.println("-----   ");
        RsHandler<Stu> rh = new RsHandler<Stu>() {
            public Stu handle(ResultSet rs) throws SQLException {
                if(!rs.next()) return null;
                Stu stu = new Stu();
                stu.setId(rs.getInt("id"));
                stu.setNAME(rs.getString("NAME"));
                stu.setAge(rs.getInt("age"));
                stu.setSex(rs.getString("sex"));
                return stu;
            }
        };
        return (Stu) qr.query(sql, rh, params);
    }
}
