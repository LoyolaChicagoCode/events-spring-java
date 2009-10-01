package springevents;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author laufer
 */
public class ListenerBean implements ApplicationListener, DisposableBean {
  
  private int count = 0;
  
  private Set threads = new HashSet();
  
  public int getCount() {
    return count;
  }
  
  public void onApplicationEvent(ApplicationEvent event) {
    threads.add(Thread.currentThread().toString());
    count ++;
  }
  
  public void destroy() {
    System.out.println("got " + count + " events");
    System.out.println("in " + threads.size() + " different threads");
    System.out.println(threads);
  }
}
