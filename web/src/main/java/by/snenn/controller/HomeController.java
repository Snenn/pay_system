package by.snenn.controller;

import by.snenn.services.IAccountService;
import by.snenn.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.apache.commons.lang3.StringUtils;

@Controller
public class HomeController {

    @Autowired
    private IAccountService service;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String showHomePage(ModelMap model) {
        return "default";
    }
    @RequestMapping(value = {"/home"}, method = RequestMethod.GET)
    public String showLogPage(ModelMap model) {
        return "home";
    }



//    @RequestMapping(value = {"/logIn"}, method = RequestMethod.GET)
//    public String showLogInPage(ModelMap model,@ModelAttribute("userForm") User user, HttpServletRequest req) {
//        if (user!=null) {
//            String login;
//            String password;
//
//            try {
//                login=Form.getString("Login", Patterns.LOGIN);
//                password=user.getPassword();
//            } catch (Exception e) {
//                model.put("jsp_error", "Invalid input");
//                return null;
//            }
//
//            user= userService.loginUser(login,password);
//            if (user != null) {
//                HttpSession session = req.getSession();
//                session.setAttribute("user", user);
//                session.setMaxInactiveInterval(600);
//                if (user.getUserRole().getIdRoleUser() == 2) return "admin";
//                if (user.getUserRole().getIdRoleUser() == 1) return "user";
//            } else
//                model.put("jsp_error", "The user is not registered");
//            return null;
//        }
//
//        return "home";
//    }
}
