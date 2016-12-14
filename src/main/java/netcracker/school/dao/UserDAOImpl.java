package netcracker.school.dao;

import netcracker.school.models.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

/**
 * Created by user on 01.12.16.
 */

@Repository
public class UserDAOImpl implements UserDAO {

//    @Autowired
//    DataSource dataSource;
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @SuppressWarnings("unchecked")
    public List<User> listUser() {
        return sessionFactory.getCurrentSession().createQuery("from User")
                .list();
    }

    public void removeUser(Integer id) {
//        User user = (User) sessionFactory.getCurrentSession().load(
//                User.class, id);
//        if (null != user) {
//            sessionFactory.getCurrentSession().delete(user);
//        }
    }

    public User getUserByEmail(String email) {
        if(email==null)return null;
        Query q = sessionFactory.getCurrentSession().getNamedQuery( User.NamedQuery.USER_FIND_BY_EMAIL );
        q.setString("email", email);
        if(q.list().size()==0)return null;
        User user = (User) q.list().get(0);
        if (null != user) {
            return user;
        }
        return null;
    }
}
