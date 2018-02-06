package sortStuff.tdd;

import java.util.Collection;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class SortedSet<E> implements sortStuff.SortedSet<E> {
    private int size;
    private E[] data;

    public SortedSet() {
        data = (E[]) new Object[10];
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public E first() throws NoSuchElementException {
        return null;
    }

    @Override
    public E last() throws NoSuchElementException {
        return null;
    }

    @Override
    public Comparator getComparator() {
        return null;
    }

    @Override
    public boolean add(E element) {
        return false;
    }

    @Override
    public boolean addAll(Collection elements) {
        return false;
    }

    @Override
    public boolean remove(Object element) {
        return false;
    }

    @Override
    public boolean removeAll(Collection elements) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean contains(Object element) {
        return false;
    }

    @Override
    public boolean containsAll(Collection elements) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }
}
