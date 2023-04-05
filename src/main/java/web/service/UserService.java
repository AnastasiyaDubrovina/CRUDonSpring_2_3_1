package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    void removeUserById(long id);

    void updateUserById(long id, User user);

    User showById(long id);

    List<User> getAllUsers();
}
