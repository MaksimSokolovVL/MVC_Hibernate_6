package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.DaoUser;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private DaoUser daoUser;

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return daoUser.getAllUsers();
    }

    @Override
    @Transactional
    public void addNewUser(User user) {
        daoUser.addNewUser(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserForId(long id) {
        return daoUser.getUserForId(id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        daoUser.updateUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(long id) {
        daoUser.deleteUser(id);
    }
}
