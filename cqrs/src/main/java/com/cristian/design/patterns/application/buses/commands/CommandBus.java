package com.cristian.design.patterns.application.buses.commands;

import com.cristian.design.patterns.application.handler.command.CommandHandler;
import com.cristian.design.patterns.domain.Command;

public interface CommandBus {

  void dispatch(Command command);

  void register(Class<? extends Command> command, CommandHandler<? extends Command> handler);
}
