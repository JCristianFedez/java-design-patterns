package com.cristian.design.patterns;

import com.cristian.design.patterns.editor.Editor;
import com.cristian.design.patterns.listeners.EmailNotificationListener;
import com.cristian.design.patterns.listeners.LogOpenListener;
import com.cristian.design.patterns.logger.constants.EnvParameters;

public class Demo {

  public static void main(String[] args) {
    final Editor editor = new Editor();
    editor.getEventManager().subscribe("open", new LogOpenListener(EnvParameters.GENERATED_FILE_URL.buildValue("observer") + "file.txt"));
    editor.getEventManager().subscribe("save", new EmailNotificationListener("admin@example.com"));

    try {
      editor.openFile("test.txt");
      editor.saveFile();
    } catch (NullPointerException e) {
      e.printStackTrace();
    }
  }
}
