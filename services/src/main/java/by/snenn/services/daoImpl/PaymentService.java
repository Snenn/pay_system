package by.snenn.services.daoImpl;


import by.snenn.dao.IPaymentDao;
import by.snenn.pojos.Payment;
import by.snenn.services.IPaymentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;

@Service
@Transactional
public class PaymentService implements IPaymentService {

    @Autowired
    private IPaymentDao paymentDao ;

    private Logger logger= Logger.getLogger(CreditCardService.class.getName());
    private String messages = null;

    @Override
    public List getAllPayment() {
        List<Payment> payments=paymentDao.getAll();
        return payments;
    }

    @Override
    public String createPayment(int idCard, int sum) {
        try {
            Payment payment=new Payment();
            payment.setSum(sum);
            payment.setIdCreditCard(idCard);
            payment.setData(Calendar.getInstance().getTime());
            paymentDao.saveOrUpdate(payment);
            messages="payment save";
        } catch (Exception e) {
            messages="Payment error, please try again";
        }
        return messages;
    }

    @Override
    public List getPaymentsLimit(int startNumber, int countFields) {
        return (List<Payment>) paymentDao.getAllLimit(startNumber, countFields);
    }

    @Override
    public int getCountPayments() {
        return paymentDao.getCount();
    }
}
