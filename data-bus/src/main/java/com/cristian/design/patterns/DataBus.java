package com.cristian.design.patterns;

import java.util.HashSet;
import java.util.Set;

import com.cristian.design.patterns.data.DataType;
import com.cristian.design.patterns.members.Member;

public class DataBus {

  private static final DataBus INSTANCE = new DataBus();

  private final Set<Member> listeners = new HashSet<>();

  public static DataBus getInstance() {
    return INSTANCE;
  }

  public void suscribe(final Member member) {
    this.listeners.add(member);
  }

  public void unsubscribe(final Member member) {
    this.listeners.remove(member);
  }

  public void publish(final DataType event) {
    this.listeners.forEach(listener -> listener.accept(event));
  }
}
