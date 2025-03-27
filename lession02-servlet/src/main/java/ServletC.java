/**
 * @description:c
 * @author:halation
 * @date:2025/3/15 15:12
 **/
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/c")
public class ServletC extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletC收到get请求");

        req.setAttribute("a","111");
        resp.sendRedirect(req.getContextPath()+"/d");//重定向
    }
}