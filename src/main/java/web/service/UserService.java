package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    void removeUserById(long id);

    User showById(long id);

    List<User> getAllUsers();
}
