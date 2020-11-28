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
    //@Override
    public void add(User user) {
        userDao.create(user);
    }

    @Transactional
    public void update(long id, User user) {
        userDao.update(id, user);
    }

    @Transactional
    public void deleteById(long id) {
        userDao.deleteById(id);
    }

    //@Override
    public void delete(User user) {
        userDao.deleteById(user.getId());
    }

    //@Override
    @Transactional
    public User show(long id) {
        return userDao.read(id);
    }

    @Transactional
    //@Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }
}
