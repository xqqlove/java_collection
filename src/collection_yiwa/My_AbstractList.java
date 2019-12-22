package collection_yiwa;

import java.util.Iterator;
import java.util.ListIterator;

public class My_AbstractList<E> extends My_AbstractCollection<E> implements My_List<E> {
    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public boolean retainAll(My_Collection<?> c) {
        return false;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public My_List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
