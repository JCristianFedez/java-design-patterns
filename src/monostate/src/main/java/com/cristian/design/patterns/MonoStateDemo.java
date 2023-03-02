package com.cristian.design.patterns;

public class MonoStateDemo {

  public static void main(String[] args) {
    new MonoStateDemo().run();
  }

  private void run() {
    final LoadBalancer loadBalancer1 = new LoadBalancer();
    final LoadBalancer loadBalancer2 = new LoadBalancer();
    loadBalancer1.serverRequest(new Request("Hello"));
    loadBalancer2.serverRequest(new Request("Hello World"));
  }
}
