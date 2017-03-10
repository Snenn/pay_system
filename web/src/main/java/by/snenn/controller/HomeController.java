package by.snenn.controller;

import by.snenn.pojos.User;
import by.snenn.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String showHomePage(ModelMap model) {
        return "default";
    }
    @RequestMapping(value = {"/home"}, method = RequestMethod.GET)
    public String showLogPage(ModelMap model) {
        return "home";
    }
    @RequestMapping(value = {"/home1"}, method = RequestMethod.GET)
    public String showTest(ModelMap model) {
        return "home1";
    }

    @RequestMapping(value = {"/logIn"}, method = RequestMethod.POST)
    public String logIn(ModelMap model, @ModelAttribute("userForm") User user, HttpServletRequest req) throws Exception {
        System.out.println(user);
        User user1=userService.loginUser(user.getLogin(),user.getPassword());
        if (user1 != null) {
            HttpSession session = req.getSession();
            session.setAttribute("user", user1);
            session.setMaxInactiveInterval(600);
            if (user1.getUserRole().getIdRoleUser() == 2) {return "admin";}
            if (user1.getUserRole().getIdRoleUser() == 1) {return "home1";}
        } else
            model.put("jsp_error", "The user is not registered");
        return "home";
    }


}
