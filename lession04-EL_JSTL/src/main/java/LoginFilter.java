import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter({"/stu","/student.jsp"})
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();

        String username = (String) session.getAttribute("username");

        if(username != null){
            chain.doFilter(req, response);
        }else{
            req.setAttribute("msg","请先登录!");
            req.getRequestDispatcher("login.jsp").forward(req, response);
        }
    }
}
