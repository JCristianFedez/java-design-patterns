package com.cristian.design.patterns;

import java.time.LocalDateTime;

import com.cristian.design.patterns.data.MessageData;
import com.cristian.design.patterns.data.StartingData;
import com.cristian.design.patterns.data.StoppingData;
import com.cristian.design.patterns.members.MessageCollectorMember;
import com.cristian.design.patterns.members.StatusMember;

public class Demo {

  public static void main(String[] args) {
    final DataBus bus = DataBus.getInstance();
    bus.suscribe(new StatusMember(1));
    bus.suscribe(new StatusMember(2));
    final MessageCollectorMember foo = new MessageCollectorMember("Foo");
    final MessageCollectorMember bar = new MessageCollectorMember("Bar");
    bus.suscribe(foo);
    bus.publish(StartingData.of(LocalDateTime.now()));
    bus.publish(MessageData.of("Only Foo should see this"));
    bus.suscribe(bar);
    bus.publish(MessageData.of("Foo and Bar should see this"));
    bus.unsubscribe(foo);
    bus.publish(MessageData.of("Only Bar should see this"));
    bus.publish(StoppingData.of(LocalDateTime.now()));
  }
}
