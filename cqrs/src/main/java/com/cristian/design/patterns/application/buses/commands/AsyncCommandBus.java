package com.cristian.design.patterns.application.buses.commands;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

import com.cristian.design.patterns.application.handler.command.CommandHandler;
import com.cristian.design.patterns.domain.Command;

public class AsyncCommandBus implements CommandBus {

  private final ExecutorService executorService;

  private final Map<Class<? extends Command>, CommandHandler<? extends Command>> commandHandlers = new ConcurrentHashMap<>();

  public AsyncCommandBus(final ExecutorService executorService) {
    this.executorService = executorService;
  }

  @Override
  public CompletableFuture<Void> dispatch(final Command command) {
    final CommandHandler<Command> handler = (CommandHandler<Command>) this.commandHandlers.get(command.getClass());

    if (handler == null) {
      final CompletableFuture<Void> future = new CompletableFuture<>();
      future.completeExceptionally(new RuntimeException("No handler found for command of type " + command.getClass().getSimpleName()));
      return future;
    }

    final CompletableFuture<Void> future = new CompletableFuture<>();
    this.executorService.execute(() -> {
      handler.handle(command);
      future.complete(null);
    });

    return future;
  }

  @Override
  public void register(final Class<? extends Command> command, final CommandHandler<? extends Command> handler) {
    this.commandHandlers.put(command, handler);
  }
}
