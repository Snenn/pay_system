package by.snenn.controller;

import by.snenn.controller.Util.Form;
import by.snenn.controller.Util.Messages;
import by.snenn.controller.Util.Patterns;
import by.snenn.services.ICreditCardService;
import by.snenn.services.IServiceForPaginator;
import by.snenn.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    ICreditCardService creditCardService;
    @Autowired
    IServiceForPaginator serviceForPaginator;
    @Autowired
    IUserService userService;

    @RequestMapping(value = {""}, method = {RequestMethod.POST, RequestMethod.GET })
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
        try {startNumber =Form.getInt(req, "startIndex");}
            catch (ParseException e) {
                try {startNumber = Form.getInt(req, "startNumber");}
                    catch (ParseException e1){startNumber = 0;}
            }
        model.addAttribute("adCount", serviceForPaginator.creditCardsCountForPaginator());
        model.addAttribute("startIndex", startNumber);
        model.addAttribute("creditCards", serviceForPaginator.creditCardsForPaginator(startNumber, 6));
        model.addAttribute("creditCardStatuses", serviceForPaginator.creditCardsStatusForPaginator());


        return "admin";
    }




}
