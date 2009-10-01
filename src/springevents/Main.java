package springevents;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author laufer
 *
 */
public class Main {

  public static void main(String[] args) {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml"); 
//    ListenerBean bean = (ListenerBean) context.getBean("eventBean");
//    System.out.println(bean.getMessage());
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) { }
    context.close();
  }
}
