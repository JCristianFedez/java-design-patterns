package com.cristian.design.patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoadBalancer {

  private static final List<Server> SERVERS = new ArrayList<>();

  private static int lastServedId;

  static {
    int id = 0;
    for (final Integer port : Arrays.asList(8080, 8081, 8082, 8083, 8084)) {
      SERVERS.add(new Server("localhost", port, ++id));
    }
  }

  public final void addServer(final Server server) {
    synchronized (SERVERS) {
      SERVERS.add(server);
    }
  }

  public synchronized void serverRequest(final Request request) {
    if (lastServedId >= SERVERS.size()) {
      lastServedId = 0;
    }
    final Server server = SERVERS.get(lastServedId++);
    server.serve(request);
  }
}
