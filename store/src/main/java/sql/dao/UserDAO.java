package sql.dao;


import sql.model.User;

import java.util.List;

public interface UserDAO {
    void create(User user);
    void update(User user);
    void delete(User user);

    User getById(int id);
    List<User> getAll();
}
