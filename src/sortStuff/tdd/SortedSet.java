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

        int index = -(binarySearch(item) + 1);
        if (index < 0) {
            return false;
        }

        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = item;
        size++;
        return true;
    }

    private int binarySearch(E item) {
        int low = 0;
        int high = size - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            E midVal = data[mid];

            int compareResult;
            if (comparator == null) {
                compareResult = ((Comparable<E>) midVal).compareTo((E) item);
            } else {
                compareResult = comparator.compare(midVal, item);
            }

            if (compareResult < 0)
                low = mid + 1;
            else if (compareResult > 0)
                high = mid - 1;
            else
                return mid; // element found
        }
        return -(low + 1);  // element not found.
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
