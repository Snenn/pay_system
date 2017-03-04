package by.snenn.dao;

import by.snenn.pojos.Order;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDao extends Dao<Order> implements IOrderDao<Order> {

    private static Logger logger = Logger.getLogger(PaymentDao.class);

    @Autowired
    public OrderDao(SessionFactory sessionFactory){
        super(sessionFactory);
    }

    public List getAll() {
        List orders = null;
        try {
            Query query = getSession().createQuery("FROM order ");
            orders = query.list();
            logger.info("all orders:" + orders);
        } catch (HibernateException e) {
            logger.error("Error get orders" + e);
        }
        return orders;
    }

    public Order getLastPost() {
        Order order = new Order();
        try {
            Query query = getSession().createSQLQuery("SELECT * FROM order ORDER BY idorder DESC LIMIT 1;");
            order = (Order) query.uniqueResult();
        } catch (HibernateException e) {
            logger.error("Error get order" + e);
        }
        return order;
    }


}
