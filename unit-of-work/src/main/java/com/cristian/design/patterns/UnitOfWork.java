package com.cristian.design.patterns;

public interface UnitOfWork<T> {

  void registerNow(T entity);

  void registerModified(T entity);

  void registerDeleted(T entity);

  void commit();
}
