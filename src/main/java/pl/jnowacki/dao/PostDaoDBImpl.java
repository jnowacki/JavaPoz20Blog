package pl.jnowacki.dao;

import pl.jnowacki.model.Post;

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
        return null;
    }
}
