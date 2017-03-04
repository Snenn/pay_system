package by.snenn.services;


import by.snenn.pojos.User;

public interface IUserService {

    User loginUser(String login, String password);

    String signUpUser(String surname, String name, String login, String password);
}
