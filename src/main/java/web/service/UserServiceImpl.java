package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;


    @Autowired
    ApplicationContext applicationContext;


    @Override
    @Transactional
    public void add(User user) {
        userDao.add(user);
    }


    @Override
    @Transactional
    public List<User> listUsers() {
        return userDao.listUsers();
    }


    @Override
    @Transactional
    public void delete(Long id) {
        userDao.delete(id);
    }


    @Override
    @Transactional
    public User getUser(Long id) {
        return userDao.getUser(id);
    }
}
