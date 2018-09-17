package basic;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "/init", urlPatterns = {"/init"},
        initParams = {@WebInitParam (name = "siteName", value = "yoonsung")}
        )
public class InitServlet extends HttpServlet {

    private static final long serialVersionUID = -6794678692056665985L;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException{
        System.out.println("init call");
        System.out.println("this site is " + servletConfig.getInitParameter("siteName"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        resp.getWriter().println("hello");
    }
}
