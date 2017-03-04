package by.snenn.dao;


import by.snenn.pojos.Payment;

import java.util.List;


public interface IPaymentDao<T> extends IDao<T> {
    List getAll() ;

    Payment getLastPost();
}
