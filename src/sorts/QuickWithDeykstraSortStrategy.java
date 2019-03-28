package sorts;

import java.util.Comparator;

public class QuickWithDeykstraSortStrategy implements SortStrategy {

    @Override
    public String getName() {
        return "QuickWithDeykstraSortStrategy";
    }

    public void sortAsc(Comparable[] a) {

        sortAsc(a, 0, a.length - 1);
        assert isSorted(a);
    }

    // quicksort the subarray a[lo .. hi] using 3-way partitioning
    private static void sortAsc(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int size = hi - lo + 1;
        if (size < 1000) // insertion sortAsc if small
            insertionSortAsc(a, lo, hi);
        else // quicksort if large
        {
            int lt = lo, gt = hi;
            Comparable v = a[lo];
            int i = lo + 1;
            while (i <= gt) {
                int cmp = a[i].compareTo(v);
                if      (cmp < 0) exch(a, lt++, i++);
                else if (cmp > 0) exch(a, i, gt--);
                else              i++;
            }

            // a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi].
            sortAsc(a, lo, lt-1);
            sortAsc(a, gt+1, hi);
            assert isSorted(a, lo, hi);
        }
    }

    private static void sortAsc(Comparable[] a, Comparator comparator, int lo, int hi) {
        if (hi <= lo) return;
        int size = hi - lo + 1;
        if (size < 1000) // insertion sortAsc if small
            insertionSortAsc(a,comparator, lo, hi);
        else // quicksort if large
        {
            int lt = lo, gt = hi;
            Comparable v = a[lo];
            int i = lo + 1;
            while (i <= gt) {
                int cmp = comparator.compare(a[i],v);
                if(cmp < 0) exch(a, lt++, i++);
                else if (cmp > 0) exch(a, i, gt--);
                else i++;
            }

            // a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi].
            sortAsc(a, comparator, lo, lt-1);
            sortAsc(a,comparator, gt+1, hi);
            assert isSorted(a, lo, hi);
        }
    }


    public static void insertionSortAsc(Comparable[] a, int left, int right) {
        int in, out;
        //  sorted on left of out
        for (out = left + 1; out <= right; out++) {
            Comparable temp = a[out]; // remove marked item
            in = out; // start shifts at out
            // until one is smaller,
            while (in > left && a[in - 1].compareTo( temp) >= 0) {
                a[in] = a[in - 1]; // shift item to right
                --in; // go left one position
            }
            a[in] = temp; // insert marked item
        }
    }

    public static void insertionSortAsc(Comparable[] a, Comparator comparator, int left, int right) {
        int in, out;
        //  sorted on left of out
        for (out = left + 1; out <= right; out++) {
            Comparable temp = a[out]; // remove marked item
            in = out; // start shifts at out
            // until one is smaller,
            while (in > left && comparator.compare(a[in - 1], temp) >= 0) {
                a[in] = a[in - 1]; // shift item to right
                --in; // go left one position
            }
            a[in] = temp; // insert marked item
        }
    }

    private static void sortDesc(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int size = hi - lo + 1;
        if (size < 1000) // insertion sortAsc if small
            insertionSortDesc(a, lo, hi);
        else // quicksort if large
        {
            int lt = lo, gt = hi;
            Comparable v = a[lo];
            int i = lo + 1;
            while (i <= gt) {
                int cmp = a[i].compareTo(v);
                if      (cmp < 0) exch(a, lt++, i++);
                else if (cmp > 0) exch(a, i, gt--);
                else              i++;
            }

            // a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi].
            sortDesc(a, lo, lt-1);
            sortDesc(a, gt+1, hi);
        }
    }

    private static void sortDesc(Comparable[] a, Comparator comparator, int lo, int hi) {
        if (hi <= lo) return;
        int size = hi - lo + 1;
        if (size < 1000) // insertion sortAsc if small
            insertionSortDesc(a,comparator, lo, hi);
        else // quicksort if large
        {
            int lt = lo, gt = hi;
            Comparable v = a[lo];
            int i = lo + 1;
            while (i <= gt) {
                int cmp = comparator.compare(a[i],v);
                if(cmp < 0) exch(a, lt++, i++);
                else if (cmp > 0) exch(a, i, gt--);
                else i++;
            }

            // a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi].
            sortDesc(a, comparator, lo, lt-1);
            sortDesc(a,comparator, gt+1, hi);
        }
    }


    public static void insertionSortDesc(Comparable[] a, int left, int right) {
        int in, out;
        //  sorted on left of out
        for (out = left + 1; out <= right; out++) {
            Comparable temp = a[out]; // remove marked item
            in = out; // start shifts at out
            // until one is smaller,
            while (in > left && a[in - 1].compareTo( temp) <= 0) {
                a[in] = a[in - 1]; // shift item to right
                --in; // go left one position
            }
            a[in] = temp; // insert marked item
        }
    }

    public static void insertionSortDesc(Comparable[] a, Comparator comparator, int left, int right) {
        int in, out;
        //  sorted on left of out
        for (out = left + 1; out <= right; out++) {
            Comparable temp = a[out]; // remove marked item
            in = out; // start shifts at out
            // until one is smaller,
            while (in > left && comparator.compare(a[in - 1], temp) <= 0) {
                a[in] = a[in - 1]; // shift item to right
                --in; // go left one position
            }
            a[in] = temp; // insert marked item
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }
    @Override
    public void sortDesc(Comparable[] a) {
        sortDesc(a, 0, a.length - 1);

    }

    @Override
    public void sortAsc(Comparable[] a, Comparator comparator) {
        if(isSorted(a)){
            return;
        }

        sortAsc(a, comparator,0,a.length-1);
    }

    @Override
    public void sortDesc(Comparable[] a, Comparator comparator) {
        if(isSorted(a)){
            return;
        }

        sortDesc(a, comparator,0,a.length-1);
    }
}
