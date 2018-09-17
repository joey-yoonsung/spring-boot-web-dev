package cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie/new")
public class CookieCreateServlet extends HttpServlet {
    private static final long serialVersionUID = -466604201502479470L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        new util.HtmlBuilder(resp.getWriter()).writeBasicHtml("example for cookie");

        Cookie jcookie = new Cookie("jpub", "books "+ System.currentTimeMillis());
        Cookie cookie2 = new Cookie("key2", "value2");
        jcookie.setDomain("localhost");
        jcookie.setMaxAge(3600);
        cookie2.setMaxAge(60);
        resp.addCookie(jcookie);
        resp.addCookie(cookie2);

    }
}
