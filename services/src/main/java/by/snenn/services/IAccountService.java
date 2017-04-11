package by.snenn.services;


import by.snenn.pojos.Account;
import by.snenn.pojos.User;

import java.util.List;

public interface IAccountService {

    String resetAccountUser(User user);

    Account viewAccountForAccount(int id);

    List viewCreditCardsForAccount(int id);

    List viewCreditCardStatusesForAccount();

    String createAccount(User user);

    String putMoney(User user, int sum);

    List getAccountsLimit(int startNumber, int countFields);

    int getCountAccounts();
}
