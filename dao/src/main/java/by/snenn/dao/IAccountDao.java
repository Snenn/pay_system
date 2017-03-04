package by.snenn.dao;

import by.snenn.pojos.Account;

import java.util.List;

public interface IAccountDao<T> extends IDao<T> {

    List<Account> getAll();

    Account readByFKUser(int id);

    Account getLastPost() ;
}
