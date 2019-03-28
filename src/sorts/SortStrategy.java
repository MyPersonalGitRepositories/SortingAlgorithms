package sorts;

import java.util.Comparator;

public interface SortStrategy<T> {

    String getName();

    void sortAsc(Comparable<T>[] a);
    void sortDesc(Comparable<T>[] a);

    void sortAsc(Comparable<T>[] a, Comparator<T> comparator);
    void sortDesc(Comparable<T>[] a, Comparator<T> comparator);
}
