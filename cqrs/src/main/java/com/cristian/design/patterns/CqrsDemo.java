package com.cristian.design.patterns;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.cristian.design.patterns.application.buses.commands.AsyncCommandBus;
import com.cristian.design.patterns.application.buses.commands.CommandBus;
import com.cristian.design.patterns.application.buses.commands.SyncCommandBus;
import com.cristian.design.patterns.application.buses.queries.AsyncQueryBus;
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
import com.cristian.design.patterns.infrastructure.adapters.primary.DemoQueryController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CqrsDemo {

  public static void main(String[] args) {
    syncCommand();
    asyncCommand();
    syncQuery();
    asyncQuery();

    System.exit(0);
  }

  private static void syncQuery() {
    TerminalStyle.logMethodStart("SYNC QUERY");

    final QueryBus<String> syncQueryBus = new SyncQueryBus();
    syncQueryBus.registrarse(FindWizardQuery.class, new FindWizardQueryHandler(new KaerMorhenRepository()));
    LOGGER.debug(new DemoQueryController<>(syncQueryBus).findWizard(new FindWizardRequest(3)));

    TerminalStyle.logMethodEnd("SYNC QUERY");
  }

  private static void asyncQuery() {
    TerminalStyle.logMethodStart("ASYNC QUERY");

    final ExecutorService executorService = Executors.newFixedThreadPool(2);
    final QueryBus<CompletableFuture<String>> asyncQueryBus = new AsyncQueryBus(executorService);
    asyncQueryBus.registrarse(FindWizardQuery.class, new FindWizardQueryHandler(new KaerMorhenRepository()));
    final CompletableFuture<String> firstWizard = new DemoQueryController<>(asyncQueryBus).findWizard(new FindWizardRequest(1));
    final CompletableFuture<String> secondWizard = new DemoQueryController<>(asyncQueryBus).findWizard(new FindWizardRequest(2));
    final CompletableFuture<String> thirdWizard = new DemoQueryController<>(asyncQueryBus).findWizard(new FindWizardRequest(3));
    firstWizard.thenAccept(LOGGER::debug);
    secondWizard.thenAccept(LOGGER::debug);
    thirdWizard.thenAccept(LOGGER::debug);
    LOGGER.debug("Time pase while wizards are found");

    // Wait until wizards are found
    firstWizard.join();
    secondWizard.join();
    thirdWizard.join();

    TerminalStyle.logMethodEnd("ASYNC QUERY");
  }

  private static void syncCommand() {
    TerminalStyle.logMethodStart("SYNC COMMAND");

    final CommandBus syncCommandBus = new SyncCommandBus();
    syncCommandBus.register(WizardCastSpellCommand.class, new WizardCastSpellCommandHandler(new KaerMorhenRepository()));
    new DemoCommandController(syncCommandBus).castSpell(new WizardCastSpellRequest(1, "Expelliarmus"));

    TerminalStyle.logMethodEnd("SYNC COMMAND");
  }

  private static void asyncCommand() {
    TerminalStyle.logMethodStart("ASYNC COMMAND");

    final ExecutorService executorService = Executors.newFixedThreadPool(2);
    final CommandBus asyncCommandBus = new AsyncCommandBus(executorService);
    asyncCommandBus.register(WizardCastSpellCommand.class, new WizardCastSpellCommandHandler(new KaerMorhenRepository()));
    final CompletableFuture<Void> firstSpell =
        new DemoCommandController(asyncCommandBus).castSpell(new WizardCastSpellRequest(2, "Crutzio"));
    final CompletableFuture<Void> secondSpell =
        new DemoCommandController(asyncCommandBus).castSpell(new WizardCastSpellRequest(3, "Alohomora"));
    final CompletableFuture<Void> thirdSpell =
        new DemoCommandController(asyncCommandBus).castSpell(new WizardCastSpellRequest(4, "Flipendo"));
    firstSpell.thenAccept(ignore -> LOGGER.debug("First spell has been cast"));
    secondSpell.thenAccept(ignore -> LOGGER.debug("Second spell has been cast"));
    thirdSpell.thenAccept(ignore -> LOGGER.debug("Third spell has been cast"));
    LOGGER.debug("Goblins run while spells are executed");

    // Wait until spell is executed
    firstSpell.join();
    secondSpell.join();
    thirdSpell.join();

    TerminalStyle.logMethodEnd("ASYNC COMMAND");
  }

  private static final class TerminalStyle {

    private static void logMethodStart(final String methodName) {
      LOGGER.debug("### START " + methodName + " ###");
    }

    private static void logMethodEnd(final String methodName) {
      LOGGER.debug("### END " + methodName + " ###");
    }
  }
}
