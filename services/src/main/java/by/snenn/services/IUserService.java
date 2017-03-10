package by.snenn.services;


import by.snenn.pojos.User;
import by.snenn.pojos.UserRole;

public interface IUserService {

    void saveOrUpdate(User user);

    User loginUser(String login, String password);

    String signUpUser(String surname, String name, String login, String password);

    UserRole getRoleUser () throws Exception;

    User findByLogin(String login);
}
