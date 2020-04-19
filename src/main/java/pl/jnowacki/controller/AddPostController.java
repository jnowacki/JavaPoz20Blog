package pl.jnowacki.controller;

import pl.jnowacki.service.PostService;
import pl.jnowacki.service.PostServiceImpl;
import pl.jnowacki.service.UserService;
import pl.jnowacki.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/new", name = "AddPostServlet")
public class AddPostController extends HttpServlet {

    private PostService postService = PostServiceImpl.getInstance();
    private UserService userService = UserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/newPost.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String title = req.getParameter("title");
        String body = req.getParameter("body");

        String author = req.getSession().getAttribute("username").toString();
        Long authorId = userService.getUser(author).getId();

        postService.addPost(author, authorId, title, body);

        resp.sendRedirect(req.getContextPath() + "/");
    }
}
