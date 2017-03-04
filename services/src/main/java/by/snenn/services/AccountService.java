package by.snenn.services;


import by.snenn.dao.*;
import by.snenn.pojos.Account;
import by.snenn.pojos.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountService implements IAccountService {

    private Logger logger= Logger.getLogger(AccountService.class.getName());
    private String messages = null;

    @Autowired
    private IAccountDao accountDao;
    @Autowired
    private ICreditCardDao creditCardDao;
    @Autowired
    private ICreditCardStatusDao creditCardStatusDao;


    @Override
    public String resetAccountUser(User user) {
        try {
            Account account= (Account) accountDao.get(user.getId());
            if (account.getBalance()==0) {
                accountDao.delete(account);
                messages="successful";
            }
            else messages="the account has money";
        }
        catch (Exception e) {
            logger.error("Error1");
        }
        return messages;
    }


    @Override
    public Account viewAccountForAccount(int id) {
        return (Account) accountDao.readByFKUser(id);
    }
    @Override
    public List viewCreditCardsForAccount(int id) {
        return creditCardDao.getAllByIdAccount(id);
    }
    @Override
    public List viewCreditCardStatusesForAccount() {
        return creditCardStatusDao.getAll();
    }
}


/*TODO: ERROR get ID for delete*/