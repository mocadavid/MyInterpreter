package Model.collections;

import Model.values.Value;

import java.util.*;

public class HeapDictionary<K,V> implements MyIHeap<K,V> {

    private Map<K,V> dictionary;
    private int freeAddress=1;

    public HeapDictionary(){ dictionary = new Hashtable<>(); }
    public int getFreeAddress(){ return freeAddress; }
    public void setFreeAddress(int newFreeAddress){ freeAddress=newFreeAddress; }

    public boolean isDefined(K key){
        V value = dictionary.get(key);
        return value != null;
    }

    public V getValue(K key){ return dictionary.get(key); }
    public void update(K key, V value){ dictionary.put(key,value); }
    //public Enumeration<K> keys(){ return dictionary.keys(); }
    //public Enumeration<V> elements(){ return dictionary.elements(); }
    public String toString(){ return dictionary.toString(); }
    public int size(){ return dictionary.size();}
    public V remove(K key){ return dictionary.remove(key); }
    public Set<Map.Entry<K,V>> entrySet(){ return dictionary.entrySet(); }
    public Map<K,V> getContent(){ return dictionary; }
    public void setContent(Map<K, V> content){ dictionary=content; }
}
