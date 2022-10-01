package udemy;

import java.sql.*;
import java.util.List;

public class JDBCtrail {
    public static void main(String[] args) {
        UserDAOImpl udi = new UserDAOImpl();

        List<User> u = udi.getAll();
        System.out.println(u);

        User us = udi.getById(2);
        us.setName("ahajiyev");
        udi.updateUser(us);

        List<User> u2 = udi.getAll();
        System.out.println(u2);
    }
}
