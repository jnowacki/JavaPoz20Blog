package pl.jnowacki.dao;

import pl.jnowacki.model.User;
import pl.jnowacki.util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoDBImpl implements UserDao {

    private static UserDaoDBImpl instance;

    private UserDaoDBImpl() {
    }

    public static UserDaoDBImpl getInstance() {
        if (instance == null) {
            instance = new UserDaoDBImpl();
        }

        return instance;
    }

    @Override
    public User getUser(String userLogin) {

        String selectSQL = "SELECT * FROM users WHERE username = ?";

        try (Connection dbConnection = DbConnection.getDBConnection();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSQL)) {

            preparedStatement.setString(1, userLogin);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                Long id = rs.getLong("id");
                String userName = rs.getString("username");
                String password = rs.getString("password");
                Boolean active = rs.getBoolean("active");
                String token = rs.getString("token");

                return new User(id, userName, password, active, token);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public boolean createUser(String userLogin, String password, String token) {

        String selectSQL = "INSERT INTO users(username, password, token) VALUES (?, ?, ?)";

        try (Connection dbConnection = DbConnection.getDBConnection();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSQL)) {

            preparedStatement.setString(1, userLogin);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, token);

            return preparedStatement.executeUpdate() == 1;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }
}
