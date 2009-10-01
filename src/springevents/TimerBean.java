package springevents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author laufer
 */
public class TimerBean 
  implements ApplicationContextAware, InitializingBean, DisposableBean {

  private static final int DEFAULT_INTERVAL = 1000;
  
  private ApplicationContext context;
  
  private Timer timer = new Timer(DEFAULT_INTERVAL, null);
  
  public TimerBean() {
    timer.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        context.publishEvent(new TimerEvent(this));
      }
    });
  }

  public void setApplicationContext(ApplicationContext context) {
    this.context = context;
  }
  
  public void afterPropertiesSet() {
    System.out.println("starting timer");
    timer.start();
  }

  public void destroy() {
    System.out.println("stopping timer");
    timer.stop();
  }
  
  public void setInterval(int msec) {
    timer.setDelay(msec);
  }

  public int getInterval() {
    return timer.getDelay();
  }

}
