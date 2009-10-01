package springevents;

import org.springframework.context.ApplicationEvent;

/**
 * @author laufer
 */
public class ReactorEvent extends ApplicationEvent {

  public ReactorEvent(Object source) {
    super(source);
  }
}
