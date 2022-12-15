package callback;

import java.util.Optional;

abstract class Task {

  final void executeWith(final Callback callback) {
    execute();
    Optional.ofNullable(callback).ifPresent(Callback::call);
  }

  public abstract void execute();
}
