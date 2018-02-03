package com.johnmiller;

public interface IObserver<T> {
    void handleUpdate(T u);
}
