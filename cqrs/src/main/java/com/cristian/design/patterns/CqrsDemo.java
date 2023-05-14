package com.cristian.design.patterns;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.cristian.design.patterns.application.buses.commands.CommandBus;
import com.cristian.design.patterns.application.buses.commands.CommandBusImpl;
import com.cristian.design.patterns.application.buses.queries.QueryBus;
import com.cristian.design.patterns.application.buses.queries.QueryBusImpl;
import com.cristian.design.patterns.application.commands.WizardCastSpellCommand;
import com.cristian.design.patterns.application.handler.command.WizardCastSpellCommandHandler;
import com.cristian.design.patterns.application.handler.query.FindWizardQueryHandler;
import com.cristian.design.patterns.application.queries.FindWizardQuery;
import com.cristian.design.patterns.application.repositoris.KaerMorhenRepository;
import com.cristian.design.patterns.application.requests.FindWizardRequest;
import com.cristian.design.patterns.application.requests.WizardCastSpellRequest;
import com.cristian.design.patterns.application.response.FindWizardResponse;
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

    final QueryBus syncQueryBus = new QueryBusImpl();
    syncQueryBus.registrarse(FindWizardQuery.class, new FindWizardQueryHandler(new KaerMorhenRepository()));
    LOGGER.debug(new DemoQueryController(syncQueryBus).findWizardSync(new FindWizardRequest(3)).toString());

    TerminalStyle.logMethodEnd("SYNC QUERY");
  }

  private static void asyncQuery() {
    TerminalStyle.logMethodStart("ASYNC QUERY");

    final ExecutorService executorService = Executors.newFixedThreadPool(2);
    final QueryBus bus = new QueryBusImpl();
    bus.registrarse(FindWizardQuery.class, new FindWizardQueryHandler(new KaerMorhenRepository()));
    final CompletableFuture<FindWizardResponse> firstWizard =
        new DemoQueryController(bus).findWizardAsync(executorService, new FindWizardRequest(1));
    final CompletableFuture<FindWizardResponse> secondWizard =
        new DemoQueryController(bus).findWizardAsync(executorService, new FindWizardRequest(2));
    final CompletableFuture<FindWizardResponse> thirdWizard =
        new DemoQueryController(bus).findWizardAsync(executorService, new FindWizardRequest(3));
    firstWizard.thenAccept(request -> LOGGER.debug("Completed first query: {}", request));
    secondWizard.thenAccept(request -> LOGGER.debug("Completed second query: {}", request));
    thirdWizard.thenAccept(request -> LOGGER.debug("Completed third query: {}", request));
    LOGGER.debug("Time pase while wizards are found");

    // Wait until wizards are found
    firstWizard.join();
    secondWizard.join();
    thirdWizard.join();

    TerminalStyle.logMethodEnd("ASYNC QUERY");
  }

  private static void syncCommand() {
    TerminalStyle.logMethodStart("SYNC COMMAND");

    final CommandBus syncCommandBus = new CommandBusImpl();
    syncCommandBus.register(WizardCastSpellCommand.class, new WizardCastSpellCommandHandler(new KaerMorhenRepository()));
    new DemoCommandController(syncCommandBus).castSpellSync(new WizardCastSpellRequest(1, "Expelliarmus"));

    TerminalStyle.logMethodEnd("SYNC COMMAND");
  }

  private static void asyncCommand() {
    TerminalStyle.logMethodStart("ASYNC COMMAND");

    final ExecutorService executorService = Executors.newFixedThreadPool(2);
    final CommandBus asyncCommandBus = new CommandBusImpl();
    asyncCommandBus.register(WizardCastSpellCommand.class, new WizardCastSpellCommandHandler(new KaerMorhenRepository()));
    final CompletableFuture<Void> firstSpell =
        new DemoCommandController(asyncCommandBus).castSpellAsync(executorService, new WizardCastSpellRequest(2, "Crutzio"));
    final CompletableFuture<Void> secondSpell =
        new DemoCommandController(asyncCommandBus).castSpellAsync(executorService, new WizardCastSpellRequest(3, "Alohomora"));
    final CompletableFuture<Void> thirdSpell =
        new DemoCommandController(asyncCommandBus).castSpellAsync(executorService, new WizardCastSpellRequest(4, "Flipendo"));
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
