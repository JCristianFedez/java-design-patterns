package com.cristian.design.patterns.application.handler.command;

import com.cristian.design.patterns.domain.Command;

public interface CommandHandler<C extends Command> {

  void handle(C command);
}
