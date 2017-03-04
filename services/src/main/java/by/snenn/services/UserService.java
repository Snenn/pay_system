package by.snenn.services;


import by.snenn.dao.IUserDao;
import by.snenn.dao.UserDao;
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



    @Override
    public User loginUser(String login, String password) {
        try {
//            user=userDao.getUserByLogin(login, password);
            logger.info("surname user: "+user.getSurname());

        } catch (Exception ignored) {
            logger.error("Error1");
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
}
