package by.snenn.services;

import java.util.List;

public interface IPaymentService {

    List getAllPayment ();

    String createPayment (int idCard, int sum);

    List getPaymentsLimit(int startNumber, int countFields);

    List getPaymentsLimitByUser(int startNumber, int countFields, int idUser);

    int getCountPayments();

}
