package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUserById(long id, User user) {
        User userToBeUpdated = showById(id);
        userToBeUpdated.setName(user.getName());
        userToBeUpdated.setAge(user.getAge());
        entityManager.merge(userToBeUpdated);
    }

    @Override
    public User showById(long id) {
        return entityManager.find(User.class, id);

    }

    @Override
    public void removeUserById(long id) {
        entityManager.remove(entityManager.find(User.class, id));

    }


    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        return entityManager.createQuery(
                "select u from User u", User.class).getResultList();
    }
}
