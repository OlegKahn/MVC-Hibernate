package web.dao;


import web.model.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager manager;


    @Override
    public void add(User user) {
        manager.merge(user);
        manager.flush();

    }


    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        Query query = manager.createQuery("from User", User.class);
        return query.getResultList();
    }


    @Override
    public void delete(Long id) {
        Query query = manager.createQuery("delete from User where id = :userId");
        query.setParameter("userId", id);
        query.executeUpdate();
    }


    @Override
    public User getUser(Long i) {
        return manager.find(User.class, i);
    }
}