package pl.jnowacki.dao;

import pl.jnowacki.model.Post;
import pl.jnowacki.util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostDaoDBImpl implements PostDao {

    private static PostDaoDBImpl instance;

    private PostDaoDBImpl() {
    }

    public static PostDaoDBImpl getInstance() {
        if (instance == null) {
            instance = new PostDaoDBImpl();
        }

        return instance;
    }

    @Override
    public List<Post> getAllPosts() {

        String selectSQL = "SELECT * FROM posts";
        List<Post> posts = new ArrayList<>();

        try (Connection dbConnection = DbConnection.getDBConnection();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSQL)) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                Long id = rs.getLong("id");
                Long authorId = rs.getLong("author_id");
                String authorName = rs.getString("author");
                String title = rs.getString("title");
                String body = rs.getString("body");

                posts.add(new Post(id, authorId, authorName, title, body));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return posts;
    }

    @Override
    public Post getPost(Long postId) {

        String selectSQL = "SELECT * FROM posts WHERE id = ?";

        try (Connection dbConnection = DbConnection.getDBConnection();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSQL)) {

            preparedStatement.setLong(1, postId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {

                Long id = rs.getLong("id");
                Long authorId = rs.getLong("author_id");
                String authorName = rs.getString("author");
                String title = rs.getString("title");
                String body = rs.getString("body");

                return new Post(id, authorId, authorName, title, body);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}
