package basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/helloget")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("do Get in " + req.getContextPath());
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        new util.HtmlBuilder(resp.getWriter()).writeBasicHtml("do Get");

    }
}
