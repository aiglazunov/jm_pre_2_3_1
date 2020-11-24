package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService{

    @Autowired
    @Qualifier("userDaoImp")
    private UserDao userDao;

    @Transactional
    //@Override
    public void add(User user) {
        userDao.add(user);
    }

    //@Override
    public void delete(User user) {
        userDao.delete(user);
    }

    //@Override
    public User update(User user) {
        return null;
    }

    @Transactional
    //@Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }
}
