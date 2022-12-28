package com.cristian.design.pattern;

import java.util.Optional;

public class Demo {

  private static final String STUDENT_STRING = "Demo.main(), student : ";

  public static void main(String[] args) {
    /* Create new data mapper for type 'first' */
    final StudentDataMapperImpl mapper = new StudentDataMapperImpl();

    /* Create new student */
    Student student = new Student(1, "Adam", 'A');

    /* Add student in respectibe store */
    mapper.insert(student);

    System.out.println(STUDENT_STRING + student + ", is inserted");

    /* Find this student */
    final Optional<Student> studentToBeFound = mapper.find(student.getStudentId());

    System.out.println(STUDENT_STRING + studentToBeFound + ", is searched");

    /* Update existing student object */
    student = new Student(student.getStudentId(), "AdamUpdated", 'A');

    /* Update student in respectibe db */
    mapper.update(student);

    System.out.println(STUDENT_STRING + student + ", is updated");
    System.out.println(STUDENT_STRING + student + ", is going to be deleted");

    /* Delete student in db */
    mapper.delete(student);
  }
}
