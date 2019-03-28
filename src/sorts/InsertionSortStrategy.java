package sorts;

import java.util.Comparator;

public class InsertionSortStrategy<T> implements SortStrategy {

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
        return "InsertionSort";
    }

    @Override
    public void sortAsc(Comparable[] a) {

        if(isSorted(a)){
            return;
        }

        for (int i = 1; i < a.length; ++i)
        {
            Object key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j].compareTo((T)key) > 0 )
            {
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = (Comparable<T>) key;
        }
    }

    @Override
    public void sortDesc(Comparable[] a) {

        if(isSorted(a)){
            return;
        }

        for (int i = 1; i < a.length; ++i)
        {
            Object key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j].compareTo((T)key) < 0 )
            {
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = (Comparable<T>) key;
        }
    }

    @Override
    public void sortAsc(Comparable[] a, Comparator comparator) {

        if(isSorted(a)){
            return;
        }

        for (int i = 1; i < a.length; ++i) {
            Object key = a[i];
            int j = i - 1;
            while (j >= 0 && comparator.compare((T)a[j],((T)key)) > 0 )
            {
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = (Comparable<T>) key;
        }
    }

    @Override
    public void sortDesc(Comparable[] a, Comparator comparator) {

        if(isSorted(a)){
            return;
        }

        for (int i = 1; i < a.length; ++i) {
            Object key = a[i];
            int j = i - 1;
            while (j >= 0 && comparator.compare((T)a[j],((T)key)) < 0 )
            {
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = (Comparable<T>) key;
        }
    }
}
