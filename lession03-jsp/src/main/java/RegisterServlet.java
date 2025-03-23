import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private final String username = "admin";
    private final String password = "admin";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 当访问/register时，生成并返回验证码图片
        resp.setContentType("image/jpeg");  // 设置响应类型为图片
        generateCode(req, resp);  // 调用验证码生成方法
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String vcode = req.getParameter("vcode");

        // 输入验证
        if (username == null || password == null || vcode == null) {
            req.setAttribute("msg", "所有字段均为必填");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
            return;
        }

        // 验证验证码
        String sessionCode = (String) req.getSession().getAttribute("code");
        if (!vcode.equalsIgnoreCase(sessionCode)) {
            req.setAttribute("msg", "验证码错误");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
            return;
        }

        // 注册逻辑（这里仍使用硬编码作为示例）
        if (username.equals(this.username) && password.equals(this.password)) {
            req.getSession().setAttribute("user", username);
            resp.sendRedirect(req.getContextPath() + "/Home.jsp");
        } else {
            req.setAttribute("msg", "用户名或者密码错误");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        }
    }

    private void generateCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Random random = new Random(System.currentTimeMillis());
        StringBuilder sb = new StringBuilder();

        // 生成4位随机验证码
        for (int i = 0; i < 4; i++) {  // 修改为4位验证码
            int str = random.nextInt(62);
            char sc;
            if (str < 10) {
                sb.append(str);
            } else if (str < 36) {
                sc = (char) ((str - 10) + 'A');  // 修改为大写字母，更易读
                sb.append(sc);
            } else {
                sc = (char) ((str - 36) + 'a');
                sb.append(sc);
            }
        }

        // 创建验证码图片
        BufferedImage image = new BufferedImage(60, 20, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();

        // 设置背景色
        graphics.setColor(Color.GRAY);
        graphics.fillRect(0, 0, image.getWidth(), image.getHeight());

        // 设置文字颜色和字体
        graphics.setColor(Color.BLUE);
        graphics.setFont(new Font("Times New Roman", Font.BOLD, 18));

        // 绘制验证码
        graphics.drawString(sb.toString(), 3, 17);

        // 添加一些干扰线（可选，增加安全性）
        graphics.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i < 5; i++) {
            int x1 = random.nextInt(60);
            int y1 = random.nextInt(20);
            int x2 = random.nextInt(60);
            int y2 = random.nextInt(20);
            graphics.drawLine(x1, y1, x2, y2);
        }

        graphics.dispose();

        // 输出图片到响应流
        ImageIO.write(image, "JPEG", response.getOutputStream());

        // 打印日志（生产环境应使用日志框架）
        System.out.println("生成的验证码：" + sb);

        // 保存验证码到session
        request.getSession().setAttribute("code", sb.toString());
    }
}