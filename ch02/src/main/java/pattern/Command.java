package pattern;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Command {

    private HttpServletRequest req;
    private HttpServletResponse resp;
    private ServletContext servletContext;

    abstract public void excute();

    public void forward(String url){
        try{
            RequestDispatcher rd = req.getRequestDispatcher(url);
            rd.forward(req, resp);
        } catch (ServletException e) {
            servletContext.log("foward error", e);
            e.printStackTrace();
        } catch (IOException e) {
            servletContext.log("servlet error", e);
            e.printStackTrace();
        }
    }

    public void setReq(HttpServletRequest req) {
        this.req = req;
    }

    public void setResp(HttpServletResponse resp) {
        this.resp = resp;
    }

    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}
