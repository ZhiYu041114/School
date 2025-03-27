/**
 * @description:login
 * @author:halation
 * @date:2025/3/18 15:56
 **/
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if ("root".equals(username) && "123123".equals(password)) {
            // 用户名密码正确
//            resp.sendRedirect("");
            req.getSession().setAttribute("uname", username);
            resp.sendRedirect(req.getContextPath()+"/books");


        } else {
            //用户名或者密码错误
            req.setAttribute("msg", "用户名或者密码错误");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}

