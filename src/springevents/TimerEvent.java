package springevents;

import org.springframework.context.ApplicationEvent;

/**
 * @author laufer
 */
public class TimerEvent extends ApplicationEvent {

  public TimerEvent(Object source) {
    super(source);
  }
}
