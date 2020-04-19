package pl.jnowacki.service;

import pl.jnowacki.model.Post;

import java.util.List;

public interface PostService {
    List<Post> getAllPosts();
    Post getPost(Long id);
    boolean addPost(String author, Long authorId, String title, String body);
}
