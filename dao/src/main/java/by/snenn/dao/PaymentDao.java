package by.snenn.dao;

import by.snenn.pojos.Payment;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class PaymentDao extends Dao<Payment> implements IPaymentDao<Payment>{

    private static Logger logger = Logger.getLogger(PaymentDao.class);

    @Autowired
    public PaymentDao(SessionFactory sessionFactory){
        super(sessionFactory);
    }

    public List getAll() {
        List payments = null;
        try {
            Query query = getSession().createQuery("FROM Payment");
            payments = query.list();
            logger.info("all payments:" + payments);
        } catch (HibernateException e) {
            logger.error("Error get payments" + e);
        }
        return payments;
    }

    public Payment getLastPost() {
        Payment payment = new Payment();
        try {
            Query query = getSession().createSQLQuery("SELECT * FROM payment ORDER BY idpayment DESC LIMIT 1;");
            payment = (Payment) query.uniqueResult();
        } catch (HibernateException e) {
            logger.error("Error get payment" + e);
        }
        return payment;
    }

}
