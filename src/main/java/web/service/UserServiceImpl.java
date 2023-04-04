package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service


public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Transactional
    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }
    @Transactional
    @Override
    public void removeUserById(long id) {
        userDao.removeUserById(id);
    }

    @Transactional
    @Override
    public User showById(long id) {
        return userDao.showById(id);

    }

    @Transactional
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
