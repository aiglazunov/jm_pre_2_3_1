package web.dao;


import org.springframework.stereotype.Repository;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void create(User user) {
        entityManager.persist(user);

    }

    @Override
    public void delete(User user) {
        entityManager.remove(user);
    }

    @Override
    public void deleteById(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public User read(long id) {
        return entityManager.find(User.class, id);
    }


    @Override
    public void update(User user) {
        entityManager.merge(user);

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        return entityManager.createQuery("from User").getResultList();
    }
}
