package Model.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyList<T> implements MyIList<T> {
    private List<T> list;

    public MyList(){ list = new ArrayList<T>(); }

    public void add(T element){ list.add(element); }
    public void clear(){ list.clear(); }
    public boolean isEmpty(){ return list.isEmpty(); }
    public Iterator<T> iterator(){ return list.iterator(); }
    public T get(int index){ return list.get(index); }
    public String toString(){ return list.toString(); }
    public int size(){ return list.size(); }
}
