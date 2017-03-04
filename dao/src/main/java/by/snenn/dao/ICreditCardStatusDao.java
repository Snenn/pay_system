package by.snenn.dao;

import java.util.List;


public interface ICreditCardStatusDao<T> extends IDao<T> {
    List getAll();
}
