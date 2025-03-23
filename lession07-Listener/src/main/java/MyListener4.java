import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class MyListener4 implements ServletRequestListener {
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("新的请求对象创建了" );
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("新的请求对象销毁了" );
    }
}
