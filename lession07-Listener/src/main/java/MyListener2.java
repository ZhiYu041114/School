import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class MyListener2 implements ServletContextListener {
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("" );
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("" );
    }
}
