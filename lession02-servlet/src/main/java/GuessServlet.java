import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/guess")
public class GuessServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        // 可以移除这里的随机数生成
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        // 获取或生成随机数
        Integer randomNumber = (Integer)session.getAttribute("randomNumber");
        if (randomNumber == null) {
            randomNumber = (int)(Math.random() * 100) + 1;
            session.setAttribute("randomNumber", randomNumber);
            System.out.println("New number generated: " + randomNumber);
        }

        try {
            int guess = Integer.parseInt(request.getParameter("guess"));
            String message;

            if (guess == randomNumber) {
                message = "恭喜你！你猜对了！正确答案是：" + randomNumber;
                // 猜对后清除随机数，以便开始新游戏
                session.removeAttribute("randomNumber");
            } else if (guess > randomNumber) {
                message = "太高了!";
            } else {
                message = "太低了!";
            }

            request.setAttribute("message", message);
            request.getRequestDispatcher("/result.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            request.setAttribute("message", "请输入有效的数字！");
            request.getRequestDispatcher("/result.jsp").forward(request, response);
        }
    }
}