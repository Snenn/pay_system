package by.snenn.dao.daoImpl;

import by.snenn.dao.IAccountDao;
import by.snenn.pojos.Account;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
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
    public AccountDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }


    public List<Account> getAll() {
        List accounts = null;
        try {
            Query query = getSession().createQuery("FROM Account ");
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
            query.setParameter("id", id);
            account = (Account) query.uniqueResult();
        } catch (HibernateException e) {
            logger.error("Error get CreditCards" + e);
        }
        return account;
    }


    public Account getLastPost() {

        Account account = new Account();
        try {
            Query query = getSession().createQuery("FROM Account a ORDER BY a.id DESC");
            query.setMaxResults(1);
            account = (Account) query.uniqueResult();
        } catch (HibernateException e) {
            logger.error("Error get account" + e);

        }
        return account;
    }

    @Override
    public List<Account> getAllLimit(int startNumber, int countFields) {
        List<Account> accounts = null;
        try {
            Criteria cr = getSession().createCriteria(Account.class);
            cr.setFirstResult(startNumber);
            cr.setMaxResults(countFields);
            accounts = cr.list();
        } catch (HibernateException e) {
            logger.error("Error get Accounts" + e);
        }
        return  accounts;
    }

    @Override
    public int getCount() {
        int result=0;
        try {
            Query query = getSession().createQuery("select count (*) FROM Account");
            result = Integer.parseInt(String.valueOf(query.uniqueResult()));

        } catch (HibernateException e) {
            logger.error("Error get count Account" + e);
        }

        return result;
    }


}
