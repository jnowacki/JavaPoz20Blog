package pl.jnowacki.controller;

import pl.jnowacki.service.PostService;
import pl.jnowacki.service.PostServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "", name = "BlogServlet")
public class BlogController extends HttpServlet {

    private PostService postService = PostServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("posts", postService.getAllPosts());

        getServletContext().getRequestDispatcher("/blog.jsp").forward(req, resp);
    }
}
