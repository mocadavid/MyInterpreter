package Model.collections;

import Model.values.Value;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

public interface MyIDictionary<K,V> {
    boolean isDefined(K key);
    V getValue(K key);
    void update(K key, V value);
    //Enumeration<K> keys();
    //Enumeration<V> elements();
    int size();
    String toString();
    V remove(K key);
    Set<Map.Entry<K,V>> entrySet();
    Map<K,V> getContent();
    void setContent(Map<K, V> content);
}
