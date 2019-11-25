package Model.collections;

import java.util.Iterator;

public interface MyIStack<T> {
    void push(T element);
    T pop();
    Iterator<T> iterator();
    boolean isEmpty();
    String toString();
    int size();
}
