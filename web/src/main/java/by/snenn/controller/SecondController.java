package by.snenn.controller;

import by.snenn.pojos.User;
import by.snenn.pojos.UserRole;
import by.snenn.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/reg")
public class SecondController {

@Autowired
IUserService userService;


    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public String showSignUpPage(ModelMap model) {
        return "reg";
    }

    @RequestMapping(value = {"/signUp"}, method = RequestMethod.POST)
    public String addUser(ModelMap model, @ModelAttribute("userForm") User user,
                          HttpServletRequest request) throws Exception {
        if (userService.findByLogin(user.getLogin())==null){
        user.setAccounts(null);
        UserRole userRole=userService.getRoleUser();
        user.setUserRole(userRole);
        userService.saveOrUpdate(user);
        request.getSession().setAttribute("jsp_message", "successful");
        return "login";}
        else {
            request.getSession().setAttribute("jsp_message", "error");
            return "reg";}
        }


    }


