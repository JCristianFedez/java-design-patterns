package com.cristian.design.patterns.builder;

import java.io.PrintWriter;
import java.lang.annotation.ElementType;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.auto.service.AutoService;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

@AutoService(Processor.class)
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes("com.cristian.design.patterns.builder.CustomBuilder")
public class CustomBuilderProcessor extends AbstractProcessor {

  @Override
  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
    annotations.forEach(annotation ->
        roundEnv.getElementsAnnotatedWith(annotation)
            .forEach(this::generateBuilderFile)
    );
    return true;
  }

  private void generateBuilderFile(Element element) {
    String className = element.getSimpleName().toString();
    String packageName = element.getEnclosingElement().toString();
    String builderName = className + "com.cristian.design.patterns.builder.CustomBuilder";
    String builderFullName = packageName + "." + builderName;
    List<? extends Element> fields = element.getEnclosedElements()
        .stream().filter(e -> ElementType.FIELD.equals(e.getKind())).collect(Collectors.toList());

    try (PrintWriter writer = new PrintWriter(this.processingEnv.getFiler().createSourceFile(builderFullName).openWriter())) {
      writer.println(String.format("package %s", packageName));
      writer.println(String.format("public class %s {", builderFullName));
      fields.forEach(field -> writer.print(String.format("private %s %s;", field.asType().toString(), field.getSimpleName())));

      writer.println();
      fields.forEach(field -> {
            writer.println(String.format("public %s %s(%s value) {", builderName, field.getSimpleName(), field.asType().toString()));
            writer.println(String.format("    %s = value;", field.getSimpleName()));
            writer.println("    return this;");
            writer.println("}");
          }
      );

      writer.println(String.format("public %s build() {", className));
      writer.println(String.format("   return new %s(%s);", className,
          fields.stream().map(Element::getSimpleName).collect(Collectors.joining(", "))));
      writer.println("}");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}