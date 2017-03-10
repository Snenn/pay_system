package by.snenn.services;


import by.snenn.dao.IUserDao;
import by.snenn.dao.IUserRoleDao;
import by.snenn.pojos.User;
import by.snenn.pojos.UserRole;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Service
public class UserService implements IUserService{

    private Logger logger= Logger.getLogger(UserService.class.getName());
    private String messages;
    private User user;

    @Autowired
    IUserDao userDao;
    @Autowired
    IUserRoleDao userRoleDao;

    @Override
    public void saveOrUpdate(User user) {
        try {
            userDao.saveOrUpdate(user);
        } catch (Exception e) {
            logger.error("Error saveOrUpdate in UserService: " + e);
        }
    }

    @Override
    public User loginUser(String login, String password) {
        try {
            user = (User) userDao.getUserByLogin(login, password);
            logger.info("get user: "+user.getSurname());
        } catch (Exception ignored) {
            logger.error("Error1"+user);
        }
        return user;
    }

    @Override
    public String signUpUser(String surname, String name, String login, String password) {
        UserRole userRole = null;
        userRole.setIdRoleUser(1);
        User user=new User(surname, name, login, password, null, userRole);
        try {
//            userDao.saveOrUpdate(user);
            messages ="User created";
        } catch (Exception e) {
            return messages ="User not created";
        }
        return messages;
    }

    @Override
    public UserRole getRoleUser() throws Exception {
        return (UserRole) userRoleDao.get(1);
    }

    @Override
    public User findByLogin(String login) {
        return (User) userDao.findByLogin(login);
    }

}
