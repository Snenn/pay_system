package by.snenn.Command;

import by.snenn.pojos.User;
import by.snenn.services.CreditCardService;
import by.snenn.services.ServiceForPaginator;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;


public class CommandMainAdmin extends Action {

    @Autowired
    CreditCardService creditCardService;
    @Autowired
    ServiceForPaginator serviceForPaginator;

    @Override
    public Action execute(HttpServletRequest req) throws ParseException {

        User user = (User) req.getSession().getAttribute("user");
        if (user == null) return Actions.LOGIN.action;

        req.setAttribute(Messages.msgMessage, "Welcome " + user.getName());


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
        req.setAttribute("adCount", serviceForPaginator.creditCardsCountForPaginator());
        req.setAttribute("startIndex", startNumber);
        req.setAttribute("creditCards", serviceForPaginator.creditCardsForPaginator(startNumber, 6));
        req.setAttribute("creditCardStatuses", serviceForPaginator.creditCardsStatusForPaginator());
        return null ;
    }

}
