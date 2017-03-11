package by.snenn.dao;


import by.snenn.pojos.User;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao extends Dao<User> implements IUserDao<User>{

    private static Logger logger = Logger.getLogger(UserDao.class);

    @Autowired
    public UserDao(SessionFactory sessionFactory){
        super(sessionFactory);
    }

    public List getAll() {
        List users = null;
        try {
            Query query = getSession().createSQLQuery("FROM User ");
            users = query.list();
            logger.info("all users:" + users);
        } catch (HibernateException e) {
            logger.error("Error get users" + e);
                    }
        return users;
    }

    public User getUserByLogin(String login, String password) throws Exception {
        User user = new User();
        try {
            Query query = getSession().createQuery("from User u where u.login = :login and u.password = :password");
            query.setParameter("login",login).setParameter("password",password);
            user = (User) query.uniqueResult();
            logger.info("get user" + user);
        } catch (HibernateException e) {
            logger.error("Error get user" + e);
        }
        return user;
    }

    public User getLastPost() {
        User user = new User();
        try {
            Query query = getSession().createSQLQuery("SELECT * FROM user ORDER BY iduser DESC LIMIT 1;");
            user = (User) query.uniqueResult();
        } catch (HibernateException e) {
            logger.error("Error get user" + e);
        }
        return user;
    }

    public User findByLogin(String login) {
        User user = new User();
        try {
            Query query = getSession().createQuery("from User u where u.login = :login");
            query.setParameter("login",login);
            user = (User) query.uniqueResult();
            logger.info("get user" + user);
        } catch (HibernateException e) {
            logger.error("Error get user" + e);
        }
        return user;
    }
}
