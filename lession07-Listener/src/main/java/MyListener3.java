import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class MyListener3 implements ServletContextAttributeListener
{
    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        System.out.println("存数据了" );
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("删除数据了" );
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("修改数据了" );
    }
}
