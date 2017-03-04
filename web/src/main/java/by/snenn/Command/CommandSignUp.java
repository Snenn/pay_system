package by.snenn.Command;


import by.snenn.services.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

class CommandSignUp extends Action {

    @Autowired
    UserService userService;
    @Override
    public Action execute(HttpServletRequest req) {
        Logger logger= Logger.getLogger(CommandSignUp.class.getName());

        if (Form.isPost(req)) {
            String messages;
            String surname;
            String name;
            String login;
            String password;

            try {
                 surname=Form.getString("surname", Patterns.NAME);
                 name=Form.getString("name", Patterns.NAME);
                 login=Form.getString("login", Patterns.LOGIN);
                 password=Form.getString("password", Patterns.PASSWORD);
           } catch (Exception e) {
                logger.error("Error1");
                req.setAttribute(Messages.msgError, "wrong data");
                return null;
            }

            messages= userService.signUpUser(surname, name, login, password);
            req.setAttribute(Messages.msgMessage, messages);
                return Actions.LOGIN.action;
            } else req.setAttribute(Messages.msgError, "wrong data");
        logger.error("Error1");
        return null;
        }
    }

