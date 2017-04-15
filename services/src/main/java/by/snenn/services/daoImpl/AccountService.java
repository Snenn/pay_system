package by.snenn.services.daoImpl;


import by.snenn.dao.*;
import by.snenn.pojos.Account;
import by.snenn.pojos.User;
import by.snenn.services.IAccountService;
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
    private ICreditCardDao creditCardDao;
    @Autowired
    private ICreditCardStatusDao creditCardStatusDao;
    @Autowired
    private IAccountDao accountDao;

    @Override
    public String resetAccountUser(User user) {
        try {
            Account account= (Account) accountDao.getByIdUser(user.getId());
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
        return (Account) accountDao.getByIdUser(id);
    }
    @Override
    public List viewCreditCardsForAccount(int id) {
        return creditCardDao.getAllByIdAccount(id);
    }
    @Override
    public List viewCreditCardStatusesForAccount() {
        return creditCardStatusDao.getAll();
    }

    @Override
    public String createAccount(User user) {

        try {
            if (accountDao.getCountByUser(user.getId())<5){
            Account account=new Account(0, user, null);
            accountDao.saveOrUpdate(account);}
            else messages="you have 5 account";
        }
        catch (Exception e) {
            messages="Error";
            logger.error("Error2");
        }
        return messages;
    }

    @Override
    public String putMoney(User user, int sum) {

        try {
            Account account= (Account) accountDao.getByIdUser(user.getId());
            account.setBalance(sum+account.getBalance());
            accountDao.saveOrUpdate(account);
        } catch (Exception e) {
            logger.error("Error3");
            messages="error";
        }
        messages="successful";

        return messages;
    }

    @Override
    public List getAccountsLimit(int startNumber, int countFields) {
        return (List<Account>) accountDao.getAllLimit(startNumber, countFields);
    }

    @Override
    public List getAccountsLimitByUser(int startNumber, int countFields, int idUser) {
        return (List<Account>) accountDao.getAllLimitByUser(startNumber, countFields, idUser);
    }

    @Override
    public int getCountAccounts() {
        return accountDao.getCountAll();
    }

    @Override
    public int getCountByUser(int id) {
        return accountDao.getCountByUser(id);
    }

    @Override
    public int getSumAllBalance() {
        return accountDao.sumAllBalance();
    }

    @Override
    public int getSumAllBalanceByUser(int id) {
        return accountDao.sumAllBalanceByUser(id);
    }
}


/*TODO: ERROR get ID for delete*/