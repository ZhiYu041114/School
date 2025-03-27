//Servlet的配置
//        ServletContext接口
//        发送状态码相关的方法
//        发送响应头相关的方法
//        发送响应消息体相关的方法
//        实现请求重定向
//        获取请求行信息的相关方法
//        获取请求头的相关方法
//        请求转发
//        获取请求参数
//        通过Request对象传递数据


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "HelloServlet", value = "/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Receive get request!!!");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Receive post request!!!");
    }
}