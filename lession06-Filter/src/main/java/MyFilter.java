import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter("/a")
public class MyFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("myFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("myFilter doFilter");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("myFilter after doFilter");
    }

    @Override
    public void destroy() {
        System.out.println("myFilter destroy");
    }
}
