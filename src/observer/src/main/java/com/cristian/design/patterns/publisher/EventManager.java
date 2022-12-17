package com.cristian.design.patterns.publisher;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cristian.design.patterns.listeners.EventListener;

public class EventManager {

  private final Map<String, List<EventListener>> listeners = new HashMap<>();

  public EventManager(final String... operations) {
    Arrays.asList(operations).forEach(operation -> this.listeners.put(operation, new ArrayList<>()));
  }

  public void subscribe(final String eventType, final EventListener listener) {
    final List<EventListener> users = this.listeners.get(eventType);
    users.add(listener);
  }

  public void unsubscribe(final String eventType, final EventListener listener) {
    final List<EventListener> users = this.listeners.get(eventType);
    users.remove(listener);
  }

  public void notify(final String eventType, final File file) {
    final List<EventListener> users = this.listeners.get(eventType);
    users.forEach(user -> user.update(eventType, file));
  }
}
