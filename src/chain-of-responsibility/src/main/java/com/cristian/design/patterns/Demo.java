package com.cristian.design.patterns;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.cristian.design.patterns.middleware.Middleware;
import com.cristian.design.patterns.middleware.RoleCheckMiddleware;
import com.cristian.design.patterns.middleware.ThrottlingMiddleware;
import com.cristian.design.patterns.middleware.UserExistsMiddleware;
import com.cristian.design.patterns.server.Server;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Demo {

  private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

  private static Server server;

  public static void main(String[] args) throws IOException {
    init();

    boolean success;
    do {
      log.debug("Introduzca email: ");
      final String email = reader.readLine();
      log.debug("Introduzca la contraseña: ");
      final String password = reader.readLine();
      success = server.logIn(email, password);
    } while (!success);
  }

  private static void init() {
    server = new Server();
    server.register("admin@example.com", "admin_pass");
    server.register("user@example.com", "user_pass");

    // Todos los cheques están vinculados. El cliente puede construir varias cadenas utilizando los mismos componentes.
    final Middleware middleware = new ThrottlingMiddleware(2);
    middleware.linkWith(new UserExistsMiddleware(server)).linkWith(new RoleCheckMiddleware());

    // El servidor obtiene una cadena del código del cliente.
    server.setMiddleware(middleware);
  }
}
