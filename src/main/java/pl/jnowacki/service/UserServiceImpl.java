package pl.jnowacki.service;

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
}
