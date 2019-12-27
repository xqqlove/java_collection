package map_yiwa;
//https://www.cnblogs.com/xiaoxi/p/7233201.html 
import java.io.Serializable;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class My_HashMap<K ,V> extends AbstractMap<K,V> implements Map<K,V>,Cloneable, Serializable {

    static final int DEFAULT_INITIAL_CAPACITY=1<<4;//HashMap的默认容量
    static final int MAXIMUM_CAPACITY = 1 << 30;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;//默认加载因子0.75调节这个值可以改变链表和数组的长度比例
    static final int TREEIFY_THRESHOLD = 8;//链表长度大于该值转换为红黑树
    static final int UNTREEIFY_THRESHOLD = 6; // 当桶(bucket)上的结点数小于这个值时树转链表
    static final int MIN_TREEIFY_CAPACITY = 64;//桶中的Node被树化时最小的hash表容量
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

    transient Node<K,V>[] table;// 存储元素的数组，总是2的幂次倍
    transient Set<Map.Entry<K,V>> entrySet;    // 存放具体元素的集
    transient int size;   // 存放元素的个数，注意这个不等于数组的长度。
    transient int modCount;
    int threshold;   // 临界值 当实际大小(容量*填充因子)超过临界值时，会进行扩容
    final float loadFactor;  // 填充因子
    //===============================构造函数===================================
    public My_HashMap(){
        this.loadFactor=DEFAULT_LOAD_FACTOR;
    }
    public My_HashMap(int initialCapacity){
        this(initialCapacity,DEFAULT_LOAD_FACTOR);
    }
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
    //===============================构造函数===================================
    public V put(K key,V value){
        return putVal(hash(key),key,value,false,true);
    }
    final V putVal(int hash ,K key,V value,boolean onlyIfAbsent,boolean evict){
        Node<K,V>[] tab;Node<K,V> p;int n,i;
        if ((tab=table)==null||(n=tab.length)==0)
            n=(tab=resize()).length;
        return  null;
    };

    final Node<K,V> [] resize(){
        Node<K,V> [] oldTable=table;
        int oldCap=(oldTable==null)?0:oldTable.length;
        int oldThr=threshold;
        int newCap,newThr=0;
        if(oldCap>0){
            if (oldCap>=MAXIMUM_CAPACITY){
                threshold=Integer.MAX_VALUE;
                return oldTable;
            }
            else if ((newCap=oldCap<<1)<MAXIMUM_CAPACITY&&oldCap>=DEFAULT_INITIAL_CAPACITY)
                newThr=oldThr<<1;
        }
        else if (oldThr>0)
            newCap=oldThr;
        else {
            newCap=DEFAULT_INITIAL_CAPACITY;
            newThr= (int) (DEFAULT_LOAD_FACTOR*DEFAULT_INITIAL_CAPACITY);
        }
        if (newThr == 0) {
            float ft = (float)newCap * loadFactor;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                    (int)ft : Integer.MAX_VALUE);
        }
        threshold = newThr;
        Node<K,V> [] newTable=(Node<K,V>[])new Node[newCap];
        table=newTable;
//        if (oldTable!=null){
//            for (int j=0;j<oldCap;++j){
//                Node<K,V>e;
//                if ((e=oldTable[j])!=null){
//                    oldTable[j] = null;
//                    if (e.next == null)
//                        newTable[e.hash&(newCap-1)]=e;
//                    else if (e instanceof TreeNode){
//
//                    }else {
//                        Node<K,V> loHead = null, loTail = null;
//                        Node<K,V> hiHead = null, hiTail = null;
//                        Node<K,V> next;
//                        do{
//
//                        }while ((e.next)!=null);
//                    }
//
//                }
//            }
//        }
        return  null;
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
