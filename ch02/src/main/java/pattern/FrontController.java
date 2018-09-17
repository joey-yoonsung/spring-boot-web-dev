package pattern;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/controller",
initParams = {@WebInitParam (name="mapping", value="/WEB-INF/command.properties")}
)
public class FrontController extends HttpServlet {

    private Properties cmdMapping;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String cmd = req.getParameter("cmd");
        String cmdClass = (String) cmdMapping.get(cmd);
        Command command = null;

        try{
            command = (Command)Class.forName(cmdClass).newInstance();
        } catch (IllegalAccessException | InstantiationException| ClassNotFoundException e) {
            getServletContext().log("class not found", e);
        }

        command.setReq(req);
        command.setResp(resp);
        command.setServletContext(getServletContext());
        command.excute();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        InputStream is = null;
        try{
            String location = config.getInitParameter("mapping");
            is = getServletContext().getResourceAsStream(location);
            cmdMapping = new Properties();
            cmdMapping.load(is);
        } catch (IOException e) {
            getServletContext().log("I/O Error", e);
        }finally {
            try{
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
