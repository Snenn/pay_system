package by.snenn.services;

import by.snenn.pojos.Account;
import by.snenn.pojos.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@ContextConfiguration("/beans-services.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback(true)
public class AccountServiceTest {

    @Autowired
    IAccountService accountService;
    @Autowired
    IUserService userService;

    @Test
    public void resetAccountUser() throws Exception {
        User user=new User("resetAccountUser","resetAccountUser","resetAccountUser","resetAccountUser" ,null,null);
        userService.saveOrUpdate(user);
        accountService.createAccount(user);
        user=userService.findByLogin("resetAccountUser");
        accountService.resetAccountUser(user);
        Account account=accountService.viewAccountForAccount(user.getId());
        Assert.assertNull(account);
    }

    @Test
    public void viewAccountForAccount() throws Exception {
        Account account= accountService.viewAccountForAccount(2);
        Assert.assertNotNull(account);

    }

    @Test
    public void viewCreditCardsForAccount() throws Exception {
        List creditCards=accountService.viewCreditCardsForAccount(2);
        Assert.assertNotNull(creditCards);
    }

    @Test
    public void viewCreditCardStatusesForAccount() throws Exception {
        List statuses=accountService.viewCreditCardStatusesForAccount();
        Assert.assertNotNull(statuses);
    }

    @Test
    public void createAccount() throws Exception {
        User user=new User("createAccount","createAccount","createAccount","createAccount" ,null,null);
        userService.saveOrUpdate(user);
        accountService.createAccount(user);
        user=userService.findByLogin("createAccount");
        Account account=accountService.viewAccountForAccount(user.getId());
        Assert.assertNotNull(account);
    }

    @Test
    public void putMoney() throws Exception {
        User user=new User("putMoney","putMoney","putMoney","putMoney" ,null,null);
        userService.saveOrUpdate(user);
        accountService.createAccount(user);
        accountService.putMoney(user,500);
        user=userService.findByLogin("putMoney");
        Account account=accountService.viewAccountForAccount(user.getId());
        Assert.assertEquals(account.getBalance(), 500);
    }

}