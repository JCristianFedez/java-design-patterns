package com.cristian.design.patterns.application.buses.commands;

import java.util.concurrent.CompletableFuture;

import com.cristian.design.patterns.application.handler.command.CommandHandler;
import com.cristian.design.patterns.domain.Command;

public interface CommandBus {

  CompletableFuture<Void> dispatch(Command command);

  void register(Class<? extends Command> command, CommandHandler<? extends Command> handler);
}
