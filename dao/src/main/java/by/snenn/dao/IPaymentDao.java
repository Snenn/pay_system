package by.snenn.dao;


import by.snenn.pojos.Payment;

import java.util.List;

public interface IPaymentDao extends IDao {
    List<Payment> getAll();

    List<Payment> getAllLimit(int startNumber, int countFields);

    List<Payment> getAllLimitByUser(int startNumber, int countFields, int idUser);

    int getCount();

}
