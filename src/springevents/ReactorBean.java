package springevents;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author laufer
 */
public class ReactorBean 
  implements ApplicationContextAware, ApplicationListener, DisposableBean {

  private ApplicationContext context;
  
  public void onApplicationEvent(ApplicationEvent event) {
    if (event.getSource() == this) {
      System.out.println("ignoring my own event " + event);
    } else {
      System.out.println("reacting to " + event);
      // publishEvent does not *schedule* the event, it fires it right away!
      context.publishEvent(new ReactorEvent(this));
      System.out.println("done reacting to " + event);
    }
  }

  public void setApplicationContext(ApplicationContext context) {
    this.context = context;
  }
  
  public void destroy() { }
}
