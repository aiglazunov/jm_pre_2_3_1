package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    void delete(User user);
    User update(User user);
    List<User> listUsers();
}