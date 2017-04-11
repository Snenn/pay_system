package by.snenn.dao;

import by.snenn.pojos.Account;

import java.util.List;

public interface IAccountDao<TYPE> extends IDao<TYPE> {

    List<TYPE> getAll();

    TYPE readByFKUser(int id);

    TYPE getLastPost() ;

    List<Account> getAllLimit(int startNumber, int countFields);

    int getCount();
}
