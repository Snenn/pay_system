package by.snenn.dao;




import by.snenn.pojos.CreditCard;

import java.util.List;

public interface ICreditCardDao<T> extends IDao<T> {

    List<CreditCard> getAll() ;

    List getAllByIdAccount(int id) ;

    List<CreditCard> getAllLimit(int startNumber, int endNumber) ;

    int getCount();

    CreditCard getLastPost() ;

}
