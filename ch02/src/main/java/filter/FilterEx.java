package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("*.jsp")
public class FilterEx implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        util.HtmlBuilder
                builder = new util.HtmlBuilder(response.getWriter()).startHtml().writeHead("before print\n");
        chain.doFilter(request, response);
        builder.writeBody("\nafter print").endHtml();

    }

    @Override
    public void destroy() {

    }
}
