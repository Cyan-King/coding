package test;

import com.wei.user.dao.UserDaoImpl;
import com.wei.user.domain.User;
import org.junit.Test;

public class TestUserDao {

    @Test
    public void TestfindByUsername(){
        UserDaoImpl userDao = new UserDaoImpl();

        User user = userDao.findByUsername("张三");
        System.out.println(user);
    }

    @Test
    public void TestAdd(){
        UserDaoImpl userDao = new UserDaoImpl();

        User user = new User();
        user.setUsername("张三");
        user.setPassword("123");
        userDao.add(user);
    }
}
