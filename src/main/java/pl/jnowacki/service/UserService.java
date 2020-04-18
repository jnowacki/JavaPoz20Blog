package pl.jnowacki.service;

public interface UserService {
    boolean isUserValid(String username, String password);

    void registerUser(String username, String password);
}
