package by.snenn.Command;

import by.snenn.controller.Util.Form;
import by.snenn.controller.Util.Messages;
import by.snenn.controller.Util.Patterns;
import by.snenn.pojos.Account;
import by.snenn.pojos.CreditCard;
import by.snenn.pojos.User;
import by.snenn.services.AccountService;
import by.snenn.services.CreditCardService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

class CommandMainUser extends Action {

    @Autowired
    AccountService accountService;
    @Autowired
    CreditCardService creditCardService;

    @Override
    public Action execute(HttpServletRequest req) {

        Logger logger=Logger.getLogger(CommandMainUser.class.getName());
        User user = (User) req.getSession().getAttribute("user");
        req.setAttribute("user", user);
        req.setAttribute(Messages.msgMessage, "Welcome " + user.getName());
        Account account= accountService.viewAccountForAccount(user.getId());
        req.setAttribute("account", account);
        List<CreditCard> creditCards = null;
        if (account!=null) {
            logger.info("test");
            creditCards=accountService.viewCreditCardsForAccount(account.getId());
        }
        req.setAttribute("creditCards", creditCards);
        req.setAttribute("creditCardStatuses", accountService.viewCreditCardStatusesForAccount());

        if (req.getParameter("resetAccount") != null) {
            String messages= accountService.resetAccountUser(user);
            req.setAttribute(Messages.msgMessage, messages);
            }

        if (req.getParameter("cardBlock") != null) {
            String messages= creditCardService.blockCardUser(user, Integer.parseInt(req.getParameter("idCardBlock")));
            req.setAttribute(Messages.msgMessage, messages);
            }

        if (req.getParameter("transfer") != null) {
            String messages= null;
            try {
                messages = creditCardService.transferMoneyUser(user,
                        Integer.parseInt(Form.getString("idCardSenderTransfer", Patterns.NUMBER)),
                        Integer.parseInt(Form.getString( "idCardRecipientTransfer", Patterns.NUMBER)),
                        Integer.parseInt(Form.getString("sumTransfer", Patterns.NUMBER)));
                } catch (ParseException e) {
                req.setAttribute(Messages.msgError, "Invalid input");
                logger.error("Error1, Invalid input");
                     }
            req.setAttribute(Messages.msgMessage, messages);
            }

        if (req.getParameter("pay") != null) {
            String messages= null;
            try {
                messages = creditCardService.payOrderUser(user,
                        Integer.parseInt(Form.getString("idCardSenderPay", Patterns.NUMBER)),
                        Integer.parseInt(Form.getString("sumPay", Patterns.NUMBER)));
                } catch (ParseException e) {
                req.setAttribute(Messages.msgError, "Invalid input");
                logger.error("Error1, Invalid input");
                   }
            req.setAttribute(Messages.msgMessage, messages);
            }
        return null;
    }
}

/*TODO: new button - new account, new button - new creditCard*/