package session;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.javafx.runtime.eula.Eula;

import util.HtmlBuilder;

@WebServlet("/session/read")
public class SessionRead extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        final HtmlBuilder builder = new HtmlBuilder(resp.getWriter())
                .startHtml()
                .writeHead("Read Session Attributes")
                .startBody();
        final HttpSession session = req.getSession();
        final Enumeration<String> keys = session.getAttributeNames();
        while (keys.hasMoreElements()) {
            final String key = keys.nextElement();
            builder.writeLine(key + " : " + session.getAttribute(key));
        }

//        builder.writeLine("\n--------------in servlet context----------------");
//        ServletContext context = req.getServletContext();
//        final Enumeration<String> attrKeys = context.getAttributeNames();
//        while(attrKeys.hasMoreElements()){
//            final String key = attrKeys.nextElement();
//            builder.writeLine(key + " : " + context.getAttribute(key));
//        }

        builder.endBody()
               .endHtml();
    }
}
