package sorts;

import java.util.Comparator;

public class HeapSortStrategy<T> implements SortStrategy {

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
        return "HeapSort";
    }

    private static<T>void exch(Comparable<T>[]a,int i,int j){
        Comparable<T>swap=a[i];
        a[i] = a[j];
        a[j] =swap;
    }

    private static int total;

    private static<T> void heapifyAsc(Comparable<T>[] a, int i) {
        int lft = i * 2;
        int rgt = lft + 1;
        int grt = i;

        if (lft <= total && a[lft].compareTo((T) a[grt]) > 0) grt = lft;
        if (rgt <= total && a[rgt].compareTo((T) a[grt]) > 0) grt = rgt;
        if (grt != i) {
            exch(a, i, grt);
            heapifyAsc(a, grt);
        }
    }

    private static<T> void heapifyComporatorAsc(Comparable<T>[] a, Comparator<T> comparator, int i) {
        int lft = i * 2;
        int rgt = lft + 1;
        int grt = i;

        if (lft <= total && comparator.compare((T) a[lft],(T) a[grt])> 0) grt = lft;
        if (rgt <= total && comparator.compare((T) a[rgt],(T) a[grt])> 0) grt = rgt;
        if (grt != i) {
            exch(a, i, grt);
            heapifyComporatorAsc(a,comparator, grt);
        }
    }

    private static<T> void heapifyComporatorDesc(Comparable<T>[] a, Comparator<T> comparator, int i) {
        int lft = i * 2;
        int rgt = lft + 1;
        int grt = i;

        if (lft <= total && comparator.compare((T) a[lft],(T) a[grt])< 0) grt = lft;
        if (rgt <= total && comparator.compare((T) a[rgt],(T) a[grt])< 0) grt = rgt;
        if (grt != i) {
            exch(a, i, grt);
            heapifyComporatorDesc(a,comparator, grt);
        }
    }

    private static<T> void heapifyDesc(Comparable<T>[] a, int i) {
        int lft = i * 2;
        int rgt = lft + 1;
        int grt = i;

        if (lft <= total && a[lft].compareTo((T)a[grt]) < 0) grt = lft;
        if (rgt <= total && a[rgt].compareTo((T)a[grt]) < 0) grt = rgt;
        if (grt != i) {
            exch(a, i, grt);
            heapifyDesc(a, grt);
        }
    }

    @Override
    public void sortAsc(Comparable[] a) {

        if(isSorted(a)){
            return;
        }

        total = a.length - 1;

        for (int i = total / 2; i >= 0; i--)
            heapifyAsc(a, i);

        for (int i = total; i > 0; i--) {
            exch(a, 0, i);
            total--;
            heapifyAsc(a, 0);
        }
    }

    @Override
    public void sortDesc(Comparable[] a) {

        if(isSorted(a)){
            return;
        }

        total = a.length - 1;

        for (int i = total / 2; i >= 0; i--)
            heapifyDesc(a, i);

        for (int i = total; i > 0; i--) {
            exch(a, 0, i);
            total--;
            heapifyDesc(a, 0);
        }
    }

    @Override
    public void sortAsc(Comparable[] a, Comparator comparator) {

        if(isSorted(a)){
            return;
        }

        total = a.length - 1;

        for (int i = total / 2; i >= 0; i--)
            heapifyComporatorAsc(a,comparator, i);

        for (int i = total; i > 0; i--) {
            exch(a, 0, i);
            total--;
            heapifyComporatorAsc(a,comparator, 0);
        }
    }

    @Override
    public void sortDesc(Comparable[] a, Comparator comparator) {

        if(isSorted(a)){
            return;
        }

        total = a.length - 1;

        for (int i = total / 2; i >= 0; i--)
            heapifyComporatorDesc(a,comparator, i);

        for (int i = total; i > 0; i--) {
            exch(a, 0, i);
            total--;
            heapifyComporatorDesc(a,comparator, 0);
        }
    }
}
