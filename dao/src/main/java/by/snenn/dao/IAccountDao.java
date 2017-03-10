package by.snenn.dao;

import java.util.List;

public interface IAccountDao<TYPE> extends IDao<TYPE> {

    List<TYPE> getAll();

    TYPE readByFKUser(int id);

    TYPE getLastPost() ;
}
