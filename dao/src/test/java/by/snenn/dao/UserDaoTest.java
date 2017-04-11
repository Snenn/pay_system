package by.snenn.dao;

import by.snenn.pojos.User;
import by.snenn.pojos.UserRole;
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
public class UserDaoTest {

    @Autowired
    IUserDao userDao;
    @Autowired
    IUserRoleDao userRoleDao;

    @Test
    public void getAll() throws Exception {
        UserRole userRole= (UserRole) userRoleDao.get(1);
        User user=new User("testUser","testUser","testUser","testUser",null,userRole);
        List users= userDao.getAll();
        Assert.assertNotNull(users);

    }

    @Test
    public void getAllLimit() throws Exception {
        List users= userDao.getAllLimit(2, 5);
        System.out.println(users);

    }



    @Test
    public void getLastPost() throws Exception {
        UserRole userRole= (UserRole) userRoleDao.get(1);
        User user=new User("testUser","testUser","testUser","testUser",null,userRole);
        userDao.saveOrUpdate(user);
        User user1= (User) userDao.getLastPost();
        Assert.assertEquals(user, user1);
    }

    @Test
    public void findByLogin() throws Exception {
        UserRole userRole= (UserRole) userRoleDao.get(1);
        User user=new User("findByLogin","findByLogin","findByLogin","findByLogin",null,userRole);
        userDao.saveOrUpdate(user);
        User user1= (User) userDao.findByLogin("findByLogin");
        Assert.assertEquals(user, user1);
    }

    @Test
    public void saveOrUpdate() throws Exception {
        UserRole userRole= (UserRole) userRoleDao.get(1);
        User user=new User("testUser","testUser","testUser","testUser",null,userRole);
        userDao.saveOrUpdate(user);
        User user1= (User) userDao.getLastPost();
        Assert.assertEquals(user, user1);

    }

    @Test
    public void delete() throws Exception {
        List users= userDao.getAll();
        int one=users.size();
        User user1= (User) userDao.getLastPost();
        userDao.delete(user1);
        users= userDao.getAll();
        int two=users.size();
        Assert.assertEquals(one, two+1);

    }

    @Test
    public void get() throws Exception {
        UserRole userRole= (UserRole) userRoleDao.get(1);
        User user=new User("testUser","testUser","testUser","testUser",null,userRole);
        userDao.saveOrUpdate(user);
        User user1= (User) userDao.getLastPost();
        User user2= (User) userDao.get(user1.getId());
        Assert.assertEquals(user, user2);

    }

}