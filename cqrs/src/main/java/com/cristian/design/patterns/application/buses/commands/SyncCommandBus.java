package com.cristian.design.patterns.application.buses.commands;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import com.cristian.design.patterns.application.handler.command.CommandHandler;
import com.cristian.design.patterns.domain.Command;

public final class SyncCommandBus implements CommandBus {

  private final Map<Class<? extends Command>, CommandHandler<? extends Command>> commandHandlers = new HashMap<>();

  @Override
  public CompletableFuture<Void> dispatch(final Command command) {
    final CommandHandler<Command> handler = (CommandHandler<Command>) this.commandHandlers.get(command.getClass());

    if (handler == null) {
      throw new RuntimeException("No handler found for command of type " + command.getClass().getSimpleName());
    }

    handler.handle(command);
    return CompletableFuture.completedFuture(null);
  }

  @Override
  public void register(final Class<? extends Command> command, final CommandHandler<? extends Command> handler) {
    this.commandHandlers.put(command, handler);
  }

}
