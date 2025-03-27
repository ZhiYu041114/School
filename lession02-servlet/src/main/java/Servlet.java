import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Servlet", value = "/Servlet")
public class Servlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) {
        System.out.println("初始化");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("test_01");
    }

    @Override
    public void destroy() {
        System.out.println("test_02");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("成功获取");
    }
}