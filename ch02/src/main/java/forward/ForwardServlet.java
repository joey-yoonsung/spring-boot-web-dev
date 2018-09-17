package forward;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.DateConverter;
import util.HtmlBuilder;

@WebServlet("forward/session")
public class ForwardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String method = req.getParameter("method");

        if (method == null || method.isEmpty()) {
            HtmlBuilder builder = new HtmlBuilder(resp.getWriter()).writeBasicHtml(
                    "Please pass parameter value fo key \"method\" using query string.");
        } else {
            method = method.toLowerCase();

            HttpSession session = req.getSession();
            session.setAttribute("Forwarded Attributes",
                                 DateConverter.fromTimestamp(System.currentTimeMillis()));


            final String destination = "/session/read";
            if (method.equals("sendredirect")) {
                resp.sendRedirect(destination);
            } else if (method.equals("requestdispatcher")) {
                RequestDispatcher rd = req.getRequestDispatcher(destination);
                rd.forward(req, resp);
            }
        }
    }
}
