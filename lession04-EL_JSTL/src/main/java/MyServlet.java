import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/my")
public class MyServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MyServlet 收到get请求");
        req.setAttribute("username","admin");
        req.setAttribute("password","123456");

        Student stu = new Student();
        stu.setId(1);
        stu.setNum(10001);
        stu.setName("zhangsan");
        req.setAttribute("s",stu);

        req.setAttribute("a","");
        req.setAttribute("b",null);
        req.getRequestDispatcher("my.jsp").forward(req,resp);
    }
}
