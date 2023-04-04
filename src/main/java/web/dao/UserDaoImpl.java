package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class UserDaoImpl implements UserDao {
    //в приложении должна быть страница, на которую выводятся все юзеры с возможностью добавлять, удалять и изменять юзера.
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void saveUser(User user) {
//        User user = new User(name, age);
        entityManager.persist(user);
    }

//    @Override
//    public void updateUserById(long id) {
//
//    }

    @Override
    public void removeUserById(long id) { /////////////????????????????????
//        TypedQuery <User> query = entityManager.createQuery("select u from User u where u.id = id", User.class);
//        query.setParameter("id", id);
        // добавить findAny().orElse(null)
        entityManager.remove(entityManager.find(User.class, id));

    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery(
                "select u from User u", User.class).getResultList();
    }
}
