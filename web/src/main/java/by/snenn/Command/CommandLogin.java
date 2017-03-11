package by.snenn.Command;



import by.snenn.controller.Util.Form;
import by.snenn.controller.Util.Messages;
import by.snenn.controller.Util.Patterns;
import by.snenn.pojos.User;
import by.snenn.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

class CommandLogin extends Action {

    @Autowired
    UserService userService;
    @Override
    public Action execute(HttpServletRequest req) {
        if (Form.isPost(req)) {

            String login;
            String password;

            try {
                login=Form.getString("Login", Patterns.LOGIN);
                password=req.getParameter("Password");
            } catch (Exception e) {
                req.setAttribute(Messages.msgError, "Invalid input");
                return null;
            }

            User user= userService.loginUser(login,password);
            if (user != null) {
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                session.setMaxInactiveInterval(600);
                if (user.getUserRole().getIdRoleUser() == 2) return Actions.MAINADMIN.action;
                if (user.getUserRole().getIdRoleUser() == 1) return Actions.MAINUSER.action;
            } else
            req.setAttribute(Messages.msgMessage, "The user is not registered");
            return null;
        }
            return null;

        }
}
