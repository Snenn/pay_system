package by.snenn.controller;

import by.snenn.controller.Util.Form;
import by.snenn.controller.Util.Messages;
import by.snenn.controller.Util.Patterns;
import by.snenn.controller.Util.Util;
import by.snenn.pojos.Account;
import by.snenn.pojos.User;
import by.snenn.services.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IAccountService accountService;
    @Autowired
    ICreditCardService creditCardService;
    @Autowired
    IUserService userService;
    @Autowired
    IPaymentService paymentService;
    @Autowired
    ITransferService transferService;


    @RequestMapping(value = {""}, method = {RequestMethod.POST, RequestMethod.GET })
    public String showUserPage(ModelMap model, HttpServletRequest req, HttpSession httpSession) {
        Logger logger = Logger.getLogger(HomeController.class.getName());
        User user=userService.findByLogin(Util.getPrincipal());
        httpSession.setAttribute("user", user);
        Account account = accountService.viewAccountForAccount(user.getId());

        if (req.getParameter("resetAccount") != null) {
            String messages = accountService.resetAccountUser(user);
            model.addAttribute(Messages.msgMessage, messages);
        }

        if (req.getParameter("putMoney") != null) {
            String messages = null;
            try {
                messages = accountService.putMoney(user,
                        Integer.parseInt(Form.getString(req.getParameter("sumPutMoney"), Patterns.NUMBER)));
            } catch (ParseException e) {
                model.addAttribute(Messages.msgError, "Invalid input!!!");
                logger.error("Error1, Invalid input");
            }
            model.addAttribute(Messages.msgMessage, messages);
        }

        if (req.getParameter("createCreditCard") != null) {
            String messages = creditCardService.createCreditCard(account);
            model.addAttribute(Messages.msgMessage, messages);
        }

        if (req.getParameter("cardBlock") != null) {
            String messages = creditCardService.blockCardUser(user, Integer.parseInt(req.getParameter("idCardBlock")));
            model.addAttribute(Messages.msgMessage, messages);
        }

        if (req.getParameter("transfer") != null) {
            String messages = null;
            try {
                int idCardSender = Integer.parseInt(Form.getString(req.getParameter("idCardSenderTransfer"), Patterns.NUMBER));
                int idCardRecipient= Integer.parseInt(Form.getString(req.getParameter("idCardRecipientTransfer"), Patterns.NUMBER));
                int sum = Integer.parseInt(Form.getString(req.getParameter("sumTransfer"), Patterns.NUMBER));
                messages = creditCardService.transferMoneyUser(user,idCardSender,idCardRecipient,sum);
            } catch (ParseException e) {
                model.addAttribute(Messages.msgError, "Invalid input!!!");
                logger.error("Error1, Invalid input");
            }
            model.addAttribute(Messages.msgMessage, messages);
        }

        if (req.getParameter("pay") != null) {
            String messages = null;
            try {
                int idCard = Integer.parseInt(Form.getString(req.getParameter("idCardSenderPay"), Patterns.NUMBER));
                int sum = Integer.parseInt(Form.getString(req.getParameter("sumPay"), Patterns.NUMBER));
                messages = creditCardService.payOrderUser(user, idCard, sum);
            } catch (ParseException e) {
                model.addAttribute(Messages.msgError, "Invalid input!!!");
                logger.error("Error1, Invalid input");            }
            model.addAttribute(Messages.msgMessage, messages);
        }
//        account = accountService.viewAccountForAccount(user.getId());
//        List<CreditCard> creditCards = null;
//        if (account != null) {
//            logger.info("test");
//            creditCards = accountService.viewCreditCardsForAccount(account.getId());
//        }
        httpSession.setAttribute ("countAccounts", accountService.getCountByUser(user.getId()));
        httpSession.setAttribute ("countCards", creditCardService.getCountCreditCardsByUser(user.getId()));
        httpSession.setAttribute ("sumBalance", accountService.getSumAllBalanceByUser(user.getId()));
        model.addAttribute("accounts", accountService.getAccountsLimitByUser(0,6,user.getId()) );
        model.addAttribute("creditCardStatuses", accountService.viewCreditCardStatusesForAccount());



        return "user";
    }

    @RequestMapping(value = {"/cards"}, method = {RequestMethod.POST, RequestMethod.GET })
    public String showUserCardsPage(ModelMap model, HttpServletRequest req, HttpSession httpSession) {
        User user= (User) httpSession.getAttribute("user");
        Logger logger = Logger.getLogger(HomeController.class.getName());
        model.addAttribute("cards", creditCardService.getCreditCardsLimitByUser(0,6,user.getId()) );
        model.addAttribute("creditCardStatuses", accountService.viewCreditCardStatusesForAccount());
        return "userCards";
    }

    @RequestMapping(value = {"/payments"}, method = {RequestMethod.POST, RequestMethod.GET })
    public String showUserPaymentsPage(ModelMap model, HttpServletRequest req, HttpSession httpSession) {
        User user= (User) httpSession.getAttribute("user");
        Logger logger = Logger.getLogger(HomeController.class.getName());
        model.addAttribute("payments", paymentService.getPaymentsLimitByUser(0,6,user.getId()) );
        return "userPayments";
    }

    @RequestMapping(value = {"/transfers"}, method = {RequestMethod.POST, RequestMethod.GET })
    public String showUserTransfersPage(ModelMap model, HttpServletRequest req, HttpSession httpSession) {
        User user= (User) httpSession.getAttribute("user");
        Logger logger = Logger.getLogger(HomeController.class.getName());
        model.addAttribute("transfers", transferService.getTransfersLimitByUser(0,6,user.getId()) );
        return "userTransfers";
    }

    @RequestMapping(value = {"/createAccount"}, method = {RequestMethod.POST, RequestMethod.GET })
    public String showUserСreateAccountPage(ModelMap model, HttpServletRequest req, HttpSession httpSession) {
        User user= (User) httpSession.getAttribute("user");
        Logger logger = Logger.getLogger(HomeController.class.getName());
        if (req.getParameter("createAccount") != null) {
            String messages = accountService.createAccount(user);
            model.addAttribute(Messages.msgMessage, messages);
        }
        httpSession.setAttribute ("countAccounts", accountService.getCountByUser(user.getId()));
        return "userCreateAccount";
    }

    @RequestMapping(value = {"/replenishAccount"}, method = {RequestMethod.POST, RequestMethod.GET })
    public String showUserReplenishAccountPage(ModelMap model, HttpServletRequest req, HttpSession httpSession) {
        Logger logger = Logger.getLogger(HomeController.class.getName());
        return "userReplenishAccount";
    }

    @RequestMapping(value = {"/deleteAccount"}, method = {RequestMethod.POST, RequestMethod.GET })
    public String showUserDeleteAccountPage(ModelMap model, HttpServletRequest req, HttpSession httpSession) {
        User user= (User) httpSession.getAttribute("user");
        Logger logger = Logger.getLogger(HomeController.class.getName());
        return "userDeleteAccount";
    }

    @RequestMapping(value = {"/createCard"}, method = {RequestMethod.POST, RequestMethod.GET })
    public String showUserСreateCardPage(ModelMap model, HttpServletRequest req, HttpSession httpSession) {
        User user= (User) httpSession.getAttribute("user");
        Logger logger = Logger.getLogger(HomeController.class.getName());
        return "userСreateCard";
    }

    @RequestMapping(value = {"/deleteCard"}, method = {RequestMethod.POST, RequestMethod.GET })
    public String showUserDeleteCardPage(ModelMap model, HttpServletRequest req, HttpSession httpSession) {
        User user= (User) httpSession.getAttribute("user");
        Logger logger = Logger.getLogger(HomeController.class.getName());
        return "userDeleteCard";
    }

    @RequestMapping(value = {"/createPayment"}, method = {RequestMethod.POST, RequestMethod.GET })
    public String showUserCreatePaymentPage(ModelMap model, HttpServletRequest req, HttpSession httpSession) {
        User user= (User) httpSession.getAttribute("user");
        Logger logger = Logger.getLogger(HomeController.class.getName());
        return "userCreatePayment";
    }

    @RequestMapping(value = {"/createTransfer"}, method = {RequestMethod.POST, RequestMethod.GET })
    public String showUserCreateTransferPage(ModelMap model, HttpServletRequest req, HttpSession httpSession) {
        User user= (User) httpSession.getAttribute("user");
        Logger logger = Logger.getLogger(HomeController.class.getName());
        return "userCreateTransfer";
    }




}
