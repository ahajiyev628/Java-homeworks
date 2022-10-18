package udemy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl extends AbstractDAO implements UserDAO {

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try (Connection c = connect()) {
            Statement stm = c.createStatement();
            stm.execute("select * from ahajiyev");
            ResultSet result = stm.getResultSet();
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                users.add(new User(id, name));
            }
            return users;
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public User getById(int id) {
        User u = null;
        try (Connection c = connect()) {
            Statement stm = c.createStatement();
            stm.execute("select * from ahajiyev where id = " + id);
            ResultSet result = stm.getResultSet();
            while (result.next()) {
                int userId = result.getInt("id");
                String name = result.getString("name");
                u = new User(userId, name);
            }
            return u;
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public boolean updateUser(User u) {
        try (Connection c = connect()) {
            PreparedStatement stm = c.prepareStatement("update ahajiyev set name = ? where id = ?");
            stm.setString(1, u.getName());
            stm.setInt(2, u.getId());
//            c.setAutoCommit(false);
//            c.commit();
            return stm.execute();
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public boolean deleteUser(int id) {
        try (Connection c = connect()) {
            Statement stm = c.createStatement();
            return stm.execute("delete from ahajiyev where id = " + id);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}