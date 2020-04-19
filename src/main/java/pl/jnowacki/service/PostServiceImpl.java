package pl.jnowacki.service;

import pl.jnowacki.dao.PostDao;
import pl.jnowacki.dao.PostDaoDBImpl;
import pl.jnowacki.model.Post;

import java.util.List;

public class PostServiceImpl implements PostService {

    private static PostServiceImpl instance;

    private PostDao postDao = PostDaoDBImpl.getInstance();

    private PostServiceImpl() {
    }

    public static PostServiceImpl getInstance() {
        if(instance == null) {
            instance = new PostServiceImpl();
        }

        return instance;
    }


    @Override
    public List<Post> getAllPosts() {
        return postDao.getAllPosts();
    }

    @Override
    public Post getPost(Long id) {
        return postDao.getPost(id);
    }
}
