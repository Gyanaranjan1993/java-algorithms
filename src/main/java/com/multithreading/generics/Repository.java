package com.multithreading.generics;

public interface Repository<T> {
    T save(T entity);
    boolean delete(T entity);
}
