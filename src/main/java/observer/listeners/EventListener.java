package observer.listeners;

import java.io.File;

public interface EventListener {
  void update(final String eventType, final File file);
}
