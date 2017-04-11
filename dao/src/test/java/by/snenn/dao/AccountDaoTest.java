package by.snenn.dao;

import by.snenn.pojos.Account;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@ContextConfiguration("/beans-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback(true)
public class AccountDaoTest {

    @Autowired
    IAccountDao accountDao;

    @Test
    public void getAll() throws Exception {
        List accounts= accountDao.getAll();
        Assert.assertNotNull(accounts);
    }

    @Test
    public void readByFKUser() throws Exception {

    }

    @Test
    public void getLastPost() throws Exception {

    }

    @Test
    public void saveOrUpdate() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void get() throws Exception {
        Account account= (Account) accountDao.getLastPost();
        Account account1= (Account) accountDao.get(account.getId());
        Assert.assertEquals(account, account1);
    }

}