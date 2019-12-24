package map_yiwa;

import java.io.Serializable;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class My_HashMap<K ,V> extends AbstractMap<K,V> implements Map<K,V>,Cloneable, Serializable {

    static final int DEFAULT_INITIAL_CAPACITY=1<<4;
    static final int MAXIMUM_CAPACITY = 1 << 30;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    static final int TREEIFY_THRESHOLD = 8;
    static final int UNTREEIFY_THRESHOLD = 6;
    static final int MIN_TREEIFY_CAPACITY = 64;
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
    static class Node<K,V> implements Map.Entry<K,V>{
        final int hash;
        final K key;
        V value;
        Node<K,V> next;
        Node(int hash,K key,V value,Node<K,V> next){
            this.hash=hash;
            this.key=key;
            this.value=value;
            this.next=next;
        }
        public K getKey() {
            return key;
        }
        public V getValue() {
            return value;
        }
        public V setValue(V newValue) {
            V oldValue=value;
            value=newValue;
            return oldValue;
        }
        public final int hashCode(){
            return Objects.hashCode(key)^Objects.hashCode(value);
        }
        public final boolean equals(Object o){
            if (o==this)
                return true;
            if (o instanceof Map.Entry){
                Map.Entry<?,?> e= (Entry<?, ?>) o;
                if (Objects.equals(key,e.getKey())&&Objects.equals(value,e.getValue())){
                    return true;
                }
            }
            return false;
        }

    }
    static final int hash(Object key){
        int h;
        return (key==null)?0:(h=key.hashCode())^(h>>>16);
    }

    transient Node<K,V>[] table;
    transient Set<Map.Entry<K,V>> entrySet;
    transient int size;
    transient int modCount;
    int threshold;
    final float loadFactor;
    public My_HashMap(int initialCapacity,float loadFactor){
        if (initialCapacity<0)
            throw new IllegalArgumentException("Illegal inittal capacity: "+ initialCapacity);
        if (initialCapacity>MAXIMUM_CAPACITY)
            initialCapacity=MAXIMUM_CAPACITY;
        if (loadFactor <= 0 || Float.isNaN(loadFactor))
            throw new IllegalArgumentException("Illegal load factor: " +
                    loadFactor);
        this.loadFactor = loadFactor;
        this.threshold = tableSizeFor(initialCapacity);

    }
    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    @Override
    public V getOrDefault(Object key, V defaultValue) {
        return null;
    }

    @Override
    public void forEach(BiConsumer<? super K, ? super V> action) {

    }

    @Override
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {

    }

    @Override
    public V putIfAbsent(K key, V value) {
        return null;
    }

    @Override
    public boolean remove(Object key, Object value) {
        return false;
    }

    @Override
    public boolean replace(K key, V oldValue, V newValue) {
        return false;
    }

    @Override
    public V replace(K key, V value) {
        return null;
    }

    @Override
    public V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
        return null;
    }

    @Override
    public V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return null;
    }

    @Override
    public V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return null;
    }

    @Override
    public V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
        return null;
    }
}
