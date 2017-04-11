package by.snenn.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration("/beans-services.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback(true)
public class CreditCardServiceTest {
    @Test
    public void blockCardUser() throws Exception {

    }

    @Test
    public void blockCard() throws Exception {

    }

    @Test
    public void unlockCard() throws Exception {

    }

    @Test
    public void existCard() throws Exception {

    }

    @Test
    public void payOrderUser() throws Exception {

    }

    @Test
    public void transferMoneyUser() throws Exception {

    }

    @Test
    public void verifyCardByUser() throws Exception {

    }

    @Test
    public void createCreditCard() throws Exception {

    }

}