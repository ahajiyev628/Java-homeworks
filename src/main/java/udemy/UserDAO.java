package udemy;

import java.util.List;

public interface UserDAO {
    List<User> getAll();
    User getById(int id);
    boolean updateUser(User u);
    boolean deleteUser(int id);
}
