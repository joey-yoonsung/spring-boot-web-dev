package cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie/read")
public class CookieReadServlete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        util.HtmlBuilder builder = new util.HtmlBuilder(resp.getWriter()).startHtml().writeHead("ReadCookie").startBody();

        if(req.getCookies() != null) {
            for (Cookie cookie : req.getCookies()) {
                builder.writeLine("[" + cookie.getMaxAge()+"] "+ cookie.getName() + " : " + cookie.getValue());
            }
        }
    }
}
