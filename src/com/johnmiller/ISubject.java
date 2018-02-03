package com.johnmiller;


public interface ISubject<T> {
    void register(IObserver<T> observer);
    void remove(IObserver<T> observer);
    void update(T update);
}
