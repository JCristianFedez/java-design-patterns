package com.cristian.design.pattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class StudentDataMapperImpl implements StudentDataMapper {

  /* Note: Normally this would be in the form of an actual database */
  private final Map<Integer, Student> cache = new HashMap<>();

  @Override
  public Optional<Student> find(final int studentId) {
    return Optional.ofNullable(this.cache.get(studentId));
  }

  @Override
  public void insert(final Student studentToBeInserted) throws DataMapperException {
    if (find(studentToBeInserted.getStudentId()).isPresent()) {
      throw new DataMapperException(String.format("Student already [{}] exists", studentToBeInserted.getStudentId()));
    }
    this.cache.put(studentToBeInserted.getStudentId(), studentToBeInserted);
  }

  @Override
  public void update(final Student studentToBeUpdated) throws DataMapperException {
    if (!find(studentToBeUpdated.getStudentId()).isPresent()) {
      throw new DataMapperException(String.format("Student [{}] is not found", studentToBeUpdated.getName()));
    }
    this.cache.put(studentToBeUpdated.getStudentId(), studentToBeUpdated);
  }

  @Override
  public void delete(final Student studentToBeDeleted) throws DataMapperException {
    if (this.cache.remove(studentToBeDeleted.getStudentId()) == null) {
      throw new DataMapperException(String.format("Student [{}] is not found", studentToBeDeleted.getName()));
    }
  }

  public List<Student> getStudents() {
    return new ArrayList<>(this.cache.values());
  }
}
