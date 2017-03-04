package by.snenn.dao;

import by.snenn.pojos.User;

import java.util.List;


public interface IUserDao<Type> extends IDao<Type> {
    List<Type> getAll() ;

    public User getUserByLogin(String login, String password) throws Exception ;

    public User getLastPost();


}
