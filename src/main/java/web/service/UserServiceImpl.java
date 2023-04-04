package web.service;

import org.springframework.stereotype.Component;
import web.dao.UserDao;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;


@Component
public class UserServiceImpl implements UserService {

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
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
