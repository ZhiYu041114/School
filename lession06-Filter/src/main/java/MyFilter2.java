import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter("/a")
public class MyFilter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyFilter2 init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter2 doFilter");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("MyFilter2 after doFilter");
    }

    @Override
    public void destroy() {
        System.out.println("MyFilter2 destroy");
    }
}
