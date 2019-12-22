package collection_yiwa;

import com.sun.istack.internal.NotNull;

import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;

public interface My_List<E> extends My_Collection<E> {
    int size();
    boolean isEmpty();
    boolean contains(Object o);
    Iterator<E> iterator();
    Object[] toArray();
    <T> T[] toArray(@NotNull T[] a);
    boolean add(E e);
    boolean remove(Object o);
    boolean containsAll(My_Collection<?> c);
    boolean addAll(My_Collection<? extends E> c);
    boolean removeAll(My_Collection<?> c);
    boolean retainAll(My_Collection<?> c);
    default void sort(Comparator<? super E> c){

    }
    void clear();
    boolean equals(Object o);
    int hashCode();
    E get(int index);
    E set(int index ,E element);
    void add(int index ,E element);
    E remove(int index);
    int indexOf(Object o);
    int lastIndexOf(Object o);
    ListIterator<E> listIterator();
    ListIterator<E> listIterator(int index);
    My_List<E> subList(int fromIndex,int toIndex);

}
