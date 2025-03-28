import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/b")
public class ServletB extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie:cookies){
            String cookieName = cookie.getName();
            String cookieValue = cookie.getValue();
            System.out.println(cookieName+"\t"+cookieValue);
        }
    }
}
