package observer;

import commons.logger.constants.EnvParameters;
import observer.editor.Editor;
import observer.listeners.EmailNotificationListener;
import observer.listeners.LogOpenListener;

public class Demo {

  public static void main(String[] args) {
    final Editor editor = new Editor();
    editor.getEventManager().subscribe("open", new LogOpenListener(EnvParameters.GENERATED_FILE_URL.getValue() + "file.txt"));
    editor.getEventManager().subscribe("save", new EmailNotificationListener("admin@example.com"));

    try {
      editor.openFile("test.txt");
      editor.saveFile();
    } catch (NullPointerException e) {
      e.printStackTrace();
    }
  }
}
