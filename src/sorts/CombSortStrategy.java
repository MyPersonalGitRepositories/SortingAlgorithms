package sorts;

import java.util.Comparator;

public class CombSortStrategy<T> implements SortStrategy {

    private static<T>boolean less(Comparable<T> v,Comparable<T>w){
        return v.compareTo ((T)w)<0;
    }

    private static<T>boolean isSorted(Comparable<T>[]a){
        for(int i=1;i<a.length;i++){
            if(less(a[i],a[i-1])){
                return false;
            }
        }
        return true;
    }

    @Override
    public String getName() {
        return "CombSort";
    }

    @Override
    public void sortAsc(Comparable[] a) {

        if(isSorted(a)){
            return;
        }

        int gap = a.length;
        boolean swapped = true;
        while (gap > 1 || swapped) {
            if (gap > 1)
                gap = (int) (gap / 1.247330950103979);

            int i = 0;
            swapped = false;
            while (i + gap < a.length) {
                if (a[i].compareTo((T) a[i + gap]) > 0) {
                    T t = (T) a[i];
                    a[i] = a[i + gap];
                    a[i + gap] = (Comparable<T>) t;
                    swapped = true;
                }
                i++;
            }
        }
    }

    @Override
    public void sortDesc(Comparable[] a) {

        if(isSorted(a)){
            return;
        }

        int gap = a.length;
        boolean swapped = true;
        while (gap > 1 || swapped) {
            if (gap > 1)
                gap = (int) (gap / 1.247330950103979);

            int i = 0;
            swapped = false;
            while (i + gap < a.length) {
                if (a[i].compareTo((T) a[i + gap]) < 0) {
                    T t = (T) a[i];
                    a[i] = a[i + gap];
                    a[i + gap] = (Comparable<T>) t;
                    swapped = true;
                }
                i++;
            }
        }
    }

    @Override
    public void sortAsc(Comparable[] a, Comparator comparator) {

        if(isSorted(a)){
            return;
        }

        int gap = a.length;
        boolean swapped = true;
        while (gap > 1 || swapped) {
            if (gap > 1)
                gap = (int) (gap / 1.247330950103979);

            int i = 0;
            swapped = false;
            while (i + gap < a.length) {
                if (comparator.compare((T)a[i],(T)a[i + gap]) > 0) {
                    T t = (T) a[i];
                    a[i] = a[i + gap];
                    a[i + gap] = (Comparable<T>) t;
                    swapped = true;
                }
                i++;
            }
        }
    }

    @Override
    public void sortDesc(Comparable[] a, Comparator comparator) {

        if(isSorted(a)){
            return;
        }

        int gap = a.length;
        boolean swapped = true;
        while (gap > 1 || swapped) {
            if (gap > 1)
                gap = (int) (gap / 1.247330950103979);

            int i = 0;
            swapped = false;
            while (i + gap < a.length) {
                if (comparator.compare((T)a[i],(T)a[i + gap]) < 0) {
                    T t = (T) a[i];
                    a[i] = a[i + gap];
                    a[i + gap] = (Comparable<T>) t;
                    swapped = true;
                }
                i++;
            }
        }
    }
}
