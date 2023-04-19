package com.cristian.design.patterns;

import com.cristian.design.patterns.commands.Command;
import com.cristian.design.patterns.commands.UnknownCommand;

public class FrontController {

  public void handleRequest(final String request) {
    final Command command = getCommand(request);
    command.process();
  }

  private Class<?> getCommandClass(final String request) {
    try {
      return Class.forName(String.format("com.cristian.design.patterns.commands.%sCommand", request));
    } catch (final ClassNotFoundException e) {
      return UnknownCommand.class;
    }
  }

  private Command getCommand(final String request) {
    final Class<?> commandClass = getCommandClass(request);
    try {
      return (Command) commandClass.getDeclaredConstructor().newInstance();
    } catch (final Exception e) {
      throw new ApplicationException(e);
    }
  }
}
