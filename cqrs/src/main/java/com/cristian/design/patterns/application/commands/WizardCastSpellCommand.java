package com.cristian.design.patterns.application.commands;

import com.cristian.design.patterns.domain.Command;

public record WizardCastSpellCommand(long wizardId, String spell) implements Command {

}
