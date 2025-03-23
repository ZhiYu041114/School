
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final String username = "admin";
    private final String password = "admin";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("收到用户名: " + username);
        System.out.println("收到密码：" + password);

        if (username.equals(this.username) && password.equals(this.password)){
            resp.sendRedirect(req.getContextPath() + "/Home.jsp");

        }else{
            req.setAttribute("msg","用户名或者密码错误");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath() + "/Login.jsp");
    }
}
