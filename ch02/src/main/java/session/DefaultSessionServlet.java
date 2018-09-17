package session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.DateConverter;
import util.HtmlBuilder;

@WebServlet("/session")
public class DefaultSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HtmlBuilder builder = new HtmlBuilder(resp.getWriter()).startHtml().writeHead("<Session>").startBody();
        HttpSession session = req.getSession();
        builder.writeLine("sessionId : " + session.getId());
        builder.writeLine("session created : " + DateConverter.fromTimestamp(session.getCreationTime()));
        builder.writeLine("session lastAccessTime : " + DateConverter.fromTimestamp(session.getLastAccessedTime()));
        builder.endBody().endHtml();

    }
}
