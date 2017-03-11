package by.snenn.controller;

import by.snenn.controller.Util.Form;
import by.snenn.controller.Util.Messages;
import by.snenn.controller.Util.Patterns;
import by.snenn.controller.Util.Util;
import by.snenn.pojos.Account;
import by.snenn.pojos.CreditCard;
import by.snenn.pojos.User;
import by.snenn.services.CreditCardService;
import by.snenn.services.IAccountService;
import by.snenn.services.IUserService;
import by.snenn.services.ServiceForPaginator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IAccountService accountService;
    @Autowired
    CreditCardService creditCardService;
    @Autowired
    ServiceForPaginator serviceForPaginator;
    @Autowired
    IUserService userService;


    @RequestMapping(value = {""}, method = {RequestMethod.POST, RequestMethod.GET })
    public String showUserPage(ModelMap model, HttpServletRequest req) {
        Logger logger = Logger.getLogger(HomeController.class.getName());
        User user=userService.findByLogin(Util.getPrincipal());
        model.addAttribute("user", user);

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

        Account account = accountService.viewAccountForAccount(user.getId());
        model.addAttribute("account", account);
        List<CreditCard> creditCards = null;
        if (account != null) {
            logger.info("test");
            creditCards = accountService.viewCreditCardsForAccount(account.getId());
        }
        model.addAttribute("creditCards", creditCards);
        model.addAttribute("creditCardStatuses", accountService.viewCreditCardStatusesForAccount());



        return "user";
    }
}
