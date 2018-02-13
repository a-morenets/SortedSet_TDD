package sortStuff.tdd;

import java.util.Collection;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class SortedSet<E> implements sortStuff.SortedSet<E> {

    private Comparator<E> comparator;
    private int size;
    private E[] data;

    SortedSet() {
        data = (E[]) new Object[2];
    }

    SortedSet(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Comparator getComparator() {
        return comparator;
    }

    @Override
    public E first() throws NoSuchElementException {
        if (size == 0)
            throw new NoSuchElementException();
        return data[0];
    }

    @Override
    public E last() throws NoSuchElementException {
        if (size == 0)
            throw new NoSuchElementException();
        return data[size - 1];
    }

    @Override
    public boolean add(E item) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(item)) {
                return false;
            }
        }

        data[size] = item;
        size++;
        return true;
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
