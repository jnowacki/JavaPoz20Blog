package pl.jnowacki.controller;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/thymeleaf")
public class ThymeleafExampleServlet extends HttpServlet {

    private TemplateEngine templateEngine;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        if (templateEngine == null) {
            initTemplateEngine();
        }

        WebContext ctx = new WebContext(req, resp, getServletContext());

        templateEngine.process("hello", ctx, resp.getWriter());
    }

     private void initTemplateEngine() {
         ServletContextTemplateResolver templateResolver =
                 new ServletContextTemplateResolver(getServletContext());

         templateResolver.setTemplateMode(TemplateMode.HTML);
         templateResolver.setPrefix("/WEB-INF/templates/");
         templateResolver.setSuffix(".html");
         templateResolver.setCacheTTLMs(Long.valueOf(3600000L));

         this.templateEngine = new TemplateEngine();
         this.templateEngine.setTemplateResolver(templateResolver);
     }

}
