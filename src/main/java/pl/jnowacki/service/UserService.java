package pl.jnowacki.service;

import pl.jnowacki.model.User;

public interface UserService {
    boolean isUserValid(String username, String password);
    boolean registerUser(String username, String password, String path);
    boolean activateUser(String token);
    User getUser(String name);
}
