package web.dao;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
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
        //sessionFactory.getCurrentSession().delete(user);
        entityManager.remove(user);
    }

    @Override
    public void deleteById(long id) {
        //Session session = sessionFactory.getCurrentSession();
        ///User user = session.get(User.class, id);
        //session.delete(user);
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public User read(long id) {
        //return sessionFactory.getCurrentSession().get(User.class, id);
        return  entityManager.find(User.class, id);
    }


    @Override
    public void update(long id, User updatedUser) {
//        Session session = sessionFactory.getCurrentSession();
//        User user = session.get(User.class, id);
//
//        user.setName(updatedUser.getName());
//        user.setLastName(updatedUser.getLastName());
//        user.setAge(updatedUser.getAge());
//        user.setUsername(updatedUser.getUsername());
//
//        session.update(user);
        User user = entityManager.find(User.class, id);
        user.setName(updatedUser.getName());
        user.setLastName(updatedUser.getLastName());
        user.setAge(updatedUser.getAge());
        user.setUsername(updatedUser.getUsername());

        entityManager.merge(user);

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        //TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        //return query.getResultList();
        return entityManager.createQuery("from User").getResultList();
    }
}
