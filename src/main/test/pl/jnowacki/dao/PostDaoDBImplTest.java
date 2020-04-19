package pl.jnowacki.dao;

import org.junit.Test;

public class PostDaoDBImplTest {

    @Test
    public void getAllPosts() {
        System.out.println(PostDaoDBImpl.getInstance().getAllPosts());
    }
}