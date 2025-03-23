import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/stu")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("StudentServlet 收到get请求");
        List<Student> studentList = new ArrayList<Student>();

        Student student1 = new Student();
        student1.setId(1);
        student1.setNum(10001);
        student1.setName("zhangyi");

        Student student2 = new Student();
        student1.setId(2);
        student1.setNum(10002);
        student1.setName("zhanger");

        Student student3 = new Student();
        student1.setId(3);
        student1.setNum(10003);
        student1.setName("zhangsan");

        Student student4 = new Student();
        student1.setId(4);
        student1.setNum(10004);
        student1.setName("zhangsi");

        Student student5 = new Student();
        student1.setId(5);
        student1.setNum(10005);
        student1.setName("zhangwu");

    }
}