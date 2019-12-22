package collection_yiwa;

import com.sun.istack.internal.NotNull;

import java.util.Iterator;

public interface My_Collection<E> extends Iterable<E> {
    int size();
    boolean isEmpty();
    boolean contains(Object o);
    Iterator<E> iterator();
    Object[] toArray();
    <T> T[] toArray(@NotNull T[] a);
    boolean add(E e);
    boolean remove(Object o);
    boolean containsAll(My_Collection<?> c);
    boolean addAll(My_Collection<? extends E>c);
    boolean removeAll(My_Collection<?> c);
    void clear();
    boolean equals(Object o);
    int hashCode();
}
