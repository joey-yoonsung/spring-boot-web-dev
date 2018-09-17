package session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.HtmlBuilder;

@WebServlet("/session/create")
public class SessionAttrCreate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        String key = req.getParameter("key");
        String value = req.getParameter("value");

        HtmlBuilder builder = new HtmlBuilder(resp.getWriter()).startHtml().writeHead(
                "Session Create What you pass to parameter key and value.").startBody();

        if(key != null && value != null) {
            session.setAttribute(key, value);
            builder.writeLine("<a href='/session/read'>read session</a>").endBody().endHtml();
        }else{
            builder.writeLine("Wrong attributes!");
        }
    }
}
