package by.snenn.dao;




import by.snenn.pojos.Order;

import java.util.List;

public interface IOrderDao<T> extends IDao<T> {
    List getAll() ;

    Order getLastPost();
}
