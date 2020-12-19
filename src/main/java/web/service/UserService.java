package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    @Autowired
    @Qualifier("userDaoImp")
    private UserDao userDao;

    @Transactional
    public void add(User user) {
        userDao.create(user);
    }

    @Transactional
    public void update(User user) {
        userDao.update(user);
    }

    @Transactional
    public void deleteById(long id) {
        userDao.deleteById(id);
    }


    public void delete(User user) {
        userDao.deleteById(user.getId());
    }


    @Transactional
    public User show(long id) {
        return userDao.read(id);
    }

    @Transactional
    public List<User> listUsers() {
        return userDao.listUsers();
    }
}
