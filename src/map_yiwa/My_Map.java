package map_yiwa;

import java.io.Serializable;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public interface My_Map<K,V> {
    int size();
    boolean isEmpty();
    boolean containsKey(Object key);
    boolean containsValue(Object value);
    V get(Object key);
    V put(K key,V value);
    V remove(Object key);
    void putAll(My_Map<? extends K,? extends V> m);
    void clear();
    Set<K> keySet();
    Collection<V> value();
    Set<My_Map.My_Entry<K,V>> entrySet();
    interface My_Entry<K,V>{
        K getKey();
        V getValue();
        V setValue(V value);
        boolean equals(Object o);
        int hashCode();
        public static<K extends Comparable<? super K>,V>Comparator<My_Map.My_Entry<K,V>> comparingByKey(){
            return (Comparator<My_Entry<K,V>>& Serializable) (c1, c2)->c1.getKey().compareTo(c2.getKey());
        }
        public static <K,V extends Comparable<? super V>>Comparator<My_Map.My_Entry<K,V>> comparingByValue(){
            return (Comparator<My_Entry<K,V>>&Serializable) (c1, c2)->c1.getValue().compareTo(c2.getValue());
        }
        public static <K,V> Comparator<My_Map.My_Entry<K,V>> comparingByKey(Comparator<? super K> cmp){
            Objects.requireNonNull(cmp);
            return (Comparator<My_Map.My_Entry<K,V>>&Serializable) (c1,c2)->cmp.compare(c1.getKey(),c2.getKey());
        }
        public static <K, V> Comparator<My_Map.My_Entry<K, V>> comparingByValue(Comparator<? super V> cmp) {
            Objects.requireNonNull(cmp);
            return (Comparator<My_Map.My_Entry<K, V>> & Serializable)
                    (c1, c2) -> cmp.compare(c1.getValue(), c2.getValue());
        }
    }
    boolean equals(Object o);
    int hashCode();
    default V getOrDefault(Object key, V defaultValue) {
        V v;
        return (((v = get(key)) != null) || containsKey(key))
                ? v
                : defaultValue;
    }
    default void forEach(BiConsumer<? super K,? super V> action){
        Objects.requireNonNull(action);
        V v;
        K k;
        for (My_Map.My_Entry<K,V> entry:entrySet()){
            try {
                k=entry.getKey();
                v=entry.getValue();
            } catch (IllegalStateException e) {
                throw new ConcurrentModificationException(e);
            }
            action.accept(k,v);
        }
    }
    default void replaceAll(BiFunction<? super K,? super V ,? extends V> function){
        Objects.requireNonNull(function);
        for (My_Map.My_Entry<K,V> entry:entrySet()){
            K k;
            V v;
            try {
                k=entry.getKey();
                v=entry.getValue();
            } catch (IllegalStateException e) {
                throw new ConcurrentModificationException(e);
            }
            v=function.apply(k,v);
            try {
                entry.setValue(v);
            } catch(IllegalStateException ise) {
                // this usually means the entry is no longer in the map.
                throw new ConcurrentModificationException(ise);
            }
        }

    }
    default V putIfAbsent(K key,V value){
        V v=get(key);
        if (v==null)
            v=put(key,value);
        return v;
    }
    default boolean remove(Object key ,Object value){
        Object curValue=get(key);
        if (!Objects.equals(curValue,value)||(curValue==null&&!containsKey(key))){
            return false;
        }
        remove(key);
        return true;
    }
    default boolean replace(K key,V oldValue,V newValue){
        Object curValue=get(key);
        if (!Objects.equals(oldValue,newValue)||(curValue==null&&!containsKey(key)))
            return false;
        put(key,newValue);
        return true;
    }
    default V replace(K key, V value) {
        V curValue;
        if (((curValue = get(key)) != null) || containsKey(key)) {
            curValue = put(key, value);
        }
        return curValue;
    }
    default V compute(K key,BiFunction<? super K ,? super V,? extends V > remappingFunction){
        Objects.requireNonNull(remappingFunction);
        V oldValue=get(key);
        V newValue =remappingFunction.apply(key,oldValue);
        if (newValue==null){
            if (oldValue==null||containsKey(key)) {
                remove(key);
                return null;
            }else {
                return null;
            }
        }else {
            put(key ,newValue);
            return newValue;
        }
    }
    default V computeIfAbsent(K key, Function<? super K,? extends V> mappingFuncrion){
        Objects.requireNonNull(mappingFuncrion);
        V v;
        if ((v=get(key))==null) {
            V newValue;
            if ((newValue=mappingFuncrion.apply(key))!=null){
                put(key,newValue);
                return newValue;
            }
        }
        return v;
    }
}
