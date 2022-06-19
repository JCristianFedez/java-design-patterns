package observer.editor;

import java.io.File;

import observer.publisher.EventManager;

public class Editor {

  private final EventManager events;

  private File file;

  public Editor() {
    this.events = new EventManager("open", "save");
  }

  public void openFile(final String filePath) {
    this.file = new File(filePath);
    this.events.notify("open", file);
  }

  public void saveFile() throws NullPointerException {
    if (this.file != null) {
      events.notify("save", file);
    } else {
      throw new NullPointerException("Por favor abra un fichero primero");
    }
  }

  public EventManager getEventManager() {
    return this.events;
  }
}
