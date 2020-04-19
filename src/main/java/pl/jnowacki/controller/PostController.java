package pl.jnowacki.controller;

import pl.jnowacki.model.Post;
import pl.jnowacki.service.PostService;
import pl.jnowacki.service.PostServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/post", name = "PostServlet")
public class PostController extends HttpServlet {

    private PostService postService = PostServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long postId = Long.parseLong(req.getParameter("id"));

        Post post = postService.getPost(postId);

        if (post == null) {
            resp.sendRedirect(req.getContextPath() + "/");
        } else {
            req.setAttribute("post", post);
            getServletContext().getRequestDispatcher("/post.jsp").forward(req, resp);
        }
    }
}
