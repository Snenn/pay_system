package by.snenn.dao;

import java.util.List;


public interface IUserDao<TYPE> extends IDao<TYPE> {
    List<TYPE> getAll() ;

    public TYPE getUserByLogin(String login, String password) throws Exception ;

    public TYPE getLastPost();

    TYPE findByLogin(String login);

}
