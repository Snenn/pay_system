package by.snenn.controller;

import by.snenn.dao.Dao;
import by.snenn.dao.IDao;
import by.snenn.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/reg")
public class SecondController {

//@Autowired()
//IUserService service;

    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public String showSignUpPage(ModelMap model) {
        return "reg";
    }

}
