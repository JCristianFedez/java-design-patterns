package com.cristian.design.patterns.builder;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;

//@AutoService(Processor.class)
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes("com.cristian.design.patterns.builder.CustomBuilder")
public class CustomBuilderProcessor2 extends AbstractProcessor {

  @Override
  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
    // iterate over all annotated elements
    //    for (Element annotatedElement : roundEnv.getElementsAnnotatedWith(CustomBuilder.class)) {
    //      // check if the annotated element is a class
    //      if (annotatedElement.getKind() != ElementKind.CLASS) {
    //        continue;
    //      }
    //
    //      // cast the annotated element to a TypeElement
    //      TypeElement typeElement = (TypeElement) annotatedElement;
    //
    //      // generate code for the builder pattern
    //      generateBuilderCode(typeElement);
    //    }
    return true;
  }

  //  private void generateBuilderCode(TypeElement typeElement) {
  //    // get the class name and package
  //    String className = typeElement.getSimpleName().toString();
  //    String packageName = processingEnv.getElementUtils().getPackageOf(typeElement).getQualifiedName().toString();
  //
  //    // create the builder class name
  //    String builderClassName = className + "Builder";
  //
  //    // create the code for the builder class
  //    StringBuilder code = new StringBuilder();
  //    code.append("package ").append(packageName).append(";\n\n");
  //    code.append("public class ").append(builderClassName).append(" {\n");
  //
  //    // create fields for each property of the class
  //    for (Element property : typeElement.getEnclosedElements()) {
  //      if (property.getKind() == ElementKind.FIELD) {
  //        code.append("  private ").append(property.asType().toString()).append(" ").append(property.getSimpleName()).append(";\n");
  //      }
  //    }
  //
  //    // create a method for each property to set its value
  //    for (Element property : typeElement.getEnclosedElements()) {
  //      if (property.getKind() == ElementKind.FIELD) {
  //        String propertyName = property.getSimpleName().toString();
  //        String methodName = "with" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
  //        code.append("  public ").append(builderClassName).append(" ").append(methodName).append("(").append(property.asType().toString()).append(" ").append(propertyName).append(") {\n");
  //        code.append("    this.").append(propertyName).append(" = ").append(propertyName).append(";\n");
  //        code.append("    return this;\n");
  //        code.append("  }");
  //}
}