package by.snenn.dao;

import by.snenn.pojos.Account;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDao extends Dao<Account> implements IAccountDao<Account> {

    private static Logger logger = Logger.getLogger(AccountDao.class);

    @Autowired
    public AccountDao(SessionFactory sessionFactory){
        super(sessionFactory);
    }


    public List<Account> getAll() {
        List accounts = null;
        try {
            Query query = getSession().createSQLQuery("FROM Account ");
            accounts = query.list();
            logger.info("all users:" + accounts);
        } catch (HibernateException e) {
            logger.error("Error get users" + e);
        }
        return accounts;
    }

    public Account readByFKUser(int id) {
        Account account = null;
        try {
                Query query = getSession().createQuery("from Account where user.id=:id");
                query.setParameter("id",id);
                account = (Account) query.uniqueResult();
            } catch (HibernateException e) {
                logger.error("Error get CreditCards" + e);
            }
            return account;
        }


    public Account getLastPost() {

        Account account = new Account();
            try {
                Query query = getSession().createSQLQuery("SELECT * FROM account ORDER BY id DESC LIMIT 1;");
                account = (Account) query.uniqueResult();
            } catch (HibernateException e) {
                logger.error("Error get account" + e);

        }
        return account;
    }


}
