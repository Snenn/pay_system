package by.snenn.controller;

import by.snenn.Command.Form;
import by.snenn.Command.Messages;
import by.snenn.Command.Patterns;
import by.snenn.pojos.Account;
import by.snenn.pojos.CreditCard;
import by.snenn.pojos.User;
import by.snenn.services.CreditCardService;
import by.snenn.services.IAccountService;
import by.snenn.services.IUserService;
import by.snenn.services.ServiceForPaginator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private IAccountService accountService;
    @Autowired
    CreditCardService creditCardService;
    @Autowired
    ServiceForPaginator serviceForPaginator;
    @Autowired
    IUserService userService;


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

    @RequestMapping(value = {"/login", ""}, method = RequestMethod.GET)
    public void loginPage(ModelMap model) {
    }

    @RequestMapping(value = {"/user"}, method = RequestMethod.GET)
    public String showUserPage(ModelMap model, HttpServletRequest req) {
        Logger logger = Logger.getLogger(HomeController.class.getName());
        User user=userService.findByLogin(getPrincipal());
        model.addAttribute("user", user);
        model.addAttribute(Messages.msgMessage, "Welcome " + user.getName());
        Account account = accountService.viewAccountForAccount(user.getId());
        model.addAttribute("account", account);
        List<CreditCard> creditCards = null;
        if (account != null) {
            logger.info("test");
            creditCards = accountService.viewCreditCardsForAccount(account.getId());
        }
        model.addAttribute("creditCards", creditCards);
        model.addAttribute("creditCardStatuses", accountService.viewCreditCardStatusesForAccount());

        if (req.getParameter("resetAccount") != null) {
            String messages = accountService.resetAccountUser(user);
            model.addAttribute(Messages.msgMessage, messages);
        }

        if (req.getParameter("cardBlock") != null) {
            String messages = creditCardService.blockCardUser(user, Integer.parseInt(req.getParameter("idCardBlock")));
            model.addAttribute(Messages.msgMessage, messages);
        }

        if (req.getParameter("transfer") != null) {
            String messages = null;
            try {
                messages = creditCardService.transferMoneyUser(user,
                        Integer.parseInt(Form.getString("idCardSenderTransfer", Patterns.NUMBER)),
                        Integer.parseInt(Form.getString("idCardRecipientTransfer", Patterns.NUMBER)),
                        Integer.parseInt(Form.getString("sumTransfer", Patterns.NUMBER)));
            } catch (ParseException e) {
                model.addAttribute(Messages.msgError, "Invalid input");
                logger.error("Error1, Invalid input");
            }
            model.addAttribute(Messages.msgMessage, messages);
        }

        if (req.getParameter("pay") != null) {
            String messages = null;
            try {
                messages = creditCardService.payOrderUser(user,
                        Integer.parseInt(Form.getString("idCardSenderPay", Patterns.NUMBER)),
                        Integer.parseInt(Form.getString("sumPay", Patterns.NUMBER)));
            } catch (ParseException e) {
                model.addAttribute(Messages.msgError, "Invalid input");
                logger.error("Error1, Invalid input");
            }
            model.addAttribute(Messages.msgMessage, messages);
        }

        return "user";
    }

    @RequestMapping(value = {"/admin"}, method = RequestMethod.GET)
    public String showAdminPage(ModelMap model, HttpServletRequest req) {

            int startNumber;
            if (req.getParameter("block") != null) {
                if (req.getParameter("idCard").matches(Patterns.ID_CARD)) {
                    int idCard= Integer.parseInt(req.getParameter("idCard"));
                    req.setAttribute(Messages.msgMessage, creditCardService.blockCard(idCard));
                } else {
                    req.setAttribute(Messages.msgError, "Input Error");
                }
            }

            if (req.getParameter("unlock") != null) {
                if (req.getParameter("idCard").matches(Patterns.ID_CARD)) {
                    int idCard= Integer.parseInt(req.getParameter("idCard"));
                    req.setAttribute(Messages.msgMessage, creditCardService.unlockCard(idCard));
                } else {
                    req.setAttribute(Messages.msgError, "Input Error");
                }
            }
            try {
                System.out.println("startIndex" + Form.getInt(req, "startIndex"));
                startNumber =Form.getInt(req, "startIndex");

            } catch (ParseException e) {
                try {
                    startNumber = Form.getInt(req, "startNumber");
                } catch (ParseException e1){
                    startNumber = 0;}
            }
            model.addAttribute("adCount", serviceForPaginator.creditCardsCountForPaginator());
            model.addAttribute("startIndex", startNumber);
            model.addAttribute("creditCards", serviceForPaginator.creditCardsForPaginator(startNumber, 6));
            model.addAttribute("creditCardStatuses", serviceForPaginator.creditCardsStatusForPaginator());


        return "admin";
    }

    @RequestMapping(value = "/access_denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("jsp_message", "access denied");
        return "default";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login";
    }

    private String getPrincipal(){
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }


}
