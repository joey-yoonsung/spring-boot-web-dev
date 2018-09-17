package cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie/delete")
public class CookieDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        util.HtmlBuilder
                builder = new util.HtmlBuilder(resp.getWriter()).startHtml().writeHead("Remove Cookie").startBody();

        if(req.getCookies() != null) {
            for (Cookie cookie : req.getCookies()) {
                builder.writeLine("try to remove " + cookie.getName() + " : " + cookie.getValue());
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
            }
        }
        builder.writeLine("try connect to /cookie/read again!").endBody().endHtml();
    }
}
