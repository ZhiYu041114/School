import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class MyListener implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent se) {
        int online=0;
        ServletContext context=se.getSession().getServletContext();
        if(context.getAttribute("ol")==null){
           online = online+1;
           context.setAttribute("ol",online);
        }else{
            online=(int)context.getAttribute("ol");
            online = online+1;
            context.setAttribute("ol",online);
        }
    }
    public void sessionDestroyed(HttpSessionEvent se) {
       ServletContext context=se.getSession().getServletContext();
       int online=(int)context.getAttribute("ol");
       online = online-1;
       context.setAttribute("ol",online);
    }
}
