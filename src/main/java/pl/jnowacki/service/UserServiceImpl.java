package pl.jnowacki.service;

import org.apache.commons.lang3.RandomStringUtils;
import pl.jnowacki.dao.UserDao;
import pl.jnowacki.dao.UserDaoDBImpl;
import pl.jnowacki.model.User;
import pl.jnowacki.util.PasswordUtil;

public class UserServiceImpl implements UserService {

    private UserDao userDao = UserDaoDBImpl.getInstance();

    private static UserServiceImpl instance;

    private UserServiceImpl() {
    }

    public static UserServiceImpl getInstance() {
        if(instance == null) {
            instance = new UserServiceImpl();
        }

        return instance;
    }
    
    @Override
    public boolean isUserValid(String username, String password) {
        User user = userDao.getUser(username);

        return user != null && PasswordUtil.checkPassword(password, user.getPassword());
    }

    @Override
    public void registerUser(String username, String password) {

        int tokenLength = 50;
        String token = RandomStringUtils.randomAlphanumeric(tokenLength);

        userDao.createUser(username, PasswordUtil.hashPassword(password), token);
    }
}