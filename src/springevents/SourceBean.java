package springevents;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author laufer
 */
public class SourceBean 
  implements ApplicationContextAware, InitializingBean, DisposableBean, Runnable {

  private final TimerEvent EVENT = new TimerEvent(this);
  
  private ApplicationContext context;

  private Thread thread;
  
  public void setApplicationContext(ApplicationContext context) {
    this.context = context;
  }
  
  public void afterPropertiesSet() {
    System.out.println("starting source bean");
    synchronized (this) {
      thread = new Thread(this);
      thread.start();
    }
  }

  public synchronized void destroy() {
    System.out.println("stopping source bean");
    synchronized (this) {
      thread.interrupt();
      thread = null;
    }
  }
  
  public void run() {
    while (! Thread.currentThread().isInterrupted()) {
      context.publishEvent(EVENT);
    }
  }
}
