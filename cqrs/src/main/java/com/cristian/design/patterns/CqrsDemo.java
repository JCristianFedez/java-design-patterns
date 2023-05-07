package com.cristian.design.patterns;

import com.cristian.design.patterns.application.buses.commands.CommandBus;
import com.cristian.design.patterns.application.buses.commands.SyncCommandBus;
import com.cristian.design.patterns.application.buses.queries.QueryBus;
import com.cristian.design.patterns.application.buses.queries.SyncQueryBus;
import com.cristian.design.patterns.application.commands.WizardCastSpellCommand;
import com.cristian.design.patterns.application.handler.command.WizardCastSpellCommandHandler;
import com.cristian.design.patterns.application.handler.query.FindWizardQueryHandler;
import com.cristian.design.patterns.application.queries.FindWizardQuery;
import com.cristian.design.patterns.application.repositoris.KaerMorhenRepository;
import com.cristian.design.patterns.application.requests.FindWizardRequest;
import com.cristian.design.patterns.application.requests.WizardCastSpellRequest;
import com.cristian.design.patterns.infrastructure.adapters.primary.DemoCommandController;
import com.cristian.design.patterns.infrastructure.adapters.primary.DemoQuerryController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CqrsDemo {

  public static void main(String[] args) {
    final CommandBus syncCommandBus = new SyncCommandBus();
    syncCommandBus.registrarse(WizardCastSpellCommand.class, new WizardCastSpellCommandHandler(new KaerMorhenRepository()));
    new DemoCommandController(syncCommandBus).castSpell(new WizardCastSpellRequest(1, "Expelliarmus"));

    final QueryBus syncQueryBus = new SyncQueryBus();
    syncQueryBus.registrarse(FindWizardQuery.class, new FindWizardQueryHandler(new KaerMorhenRepository()));
    LOGGER.debug(new DemoQuerryController(syncQueryBus).findWizard(new FindWizardRequest(3)));
  }
}
