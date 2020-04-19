package pl.jnowacki.service;

public interface UserService {
    boolean isUserValid(String username, String password);
    boolean registerUser(String username, String password, String path);
    boolean activateUser(String token);
}
