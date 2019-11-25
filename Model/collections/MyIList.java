package Model.collections;

import java.util.Iterator;

public interface MyIList<T> {
    void add(T element);
    void clear();
    boolean isEmpty();
    Iterator<T> iterator();
    T get(int index);
    String toString();
    int size();
}
