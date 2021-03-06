package pl.jnowacki.dao;

import pl.jnowacki.model.Post;

import java.util.List;

public interface PostDao {
    List<Post> getAllPosts();
    Post getPost(Long id);
    boolean addPost(String author, Long authorId, String title, String body);
}
