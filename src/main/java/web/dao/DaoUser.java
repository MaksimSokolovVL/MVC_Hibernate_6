package web.dao;

import web.model.User;

import java.util.List;

public interface DaoUser {
    List<User> getAllUsers();

    void addNewUser(User user);

    User getUserForId(long id);

    void updateUser(User user);

    void deleteUser(long id);
}
