package com.cristian.design.patterns;

import java.awt.Color;

import com.cristian.design.patterns.editor.ImageEditor;
import com.cristian.design.patterns.shapes.Circle;
import com.cristian.design.patterns.shapes.CompoundShape;
import com.cristian.design.patterns.shapes.Dot;
import com.cristian.design.patterns.shapes.Rectangle;

public class Demo {

  public static void main(String[] args) {
    final ImageEditor editor = new ImageEditor();

    editor.loadShapes(
        new Circle(10, 10, Color.BLUE, 10),

        new CompoundShape(
            new Circle(110, 110, Color.RED, 50),
            new Dot(160, 160, Color.RED)
        ),

        new CompoundShape(
            new Rectangle(250, 250, Color.GREEN, 100, 100),
            new Rectangle(240, 240, Color.GREEN, 120, 120),

            new Dot(240, 240, Color.GREEN),
            new Dot(240, 360, Color.GREEN),
            new Dot(360, 360, Color.GREEN),
            new Dot(360, 240, Color.GREEN)
        )
    );
  }
}
