package web.dao;

import web.model.User;

import java.util.List;


public interface UserDao {

    void saveUser(User user);

    User showById(long id);

//    void updateUserById(long id);

    void removeUserById(long id);

    List<User> getAllUsers();

}
