package sorts;

import java.util.Comparator;

public class BasicSortStrategy<T> implements SortStrategy {

    @Override
    public String getName() {
        return "BasicSort";
    }

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

    private static<T>void exch(Comparable<T>[]a,int i,int j){
        Comparable<T>swap=a[i];
        a[i] = a[j];
        a[j] =swap;
    }
    @Override
    public void sortAsc(Comparable[] a) {
        if(isSorted(a)){
            return;
        }
        for(int i = 0;i < a.length;i++)
            for(int j = i;j > 0;j--){
                if(a[j].compareTo((T)a[j - 1]) < 0){
                    exch(a,j,j - 1);
                }
                else break;
            }
    }

    @Override
    public void sortDesc(Comparable[] a) {
        if(isSorted(a)){
            return;
        }
        for(int i = 0;i < a.length;i++)
            for(int j = i;j > 0;j--){
                if(a[j].compareTo((T)a[j-1]) > 0){
                    exch(a,j,j-1);
                }
                else break;
            }
    }

    @Override
    public void sortAsc(Comparable[] a, Comparator comparator) {
        if(isSorted(a)){
            return;
        }
        for(int i = 0;i < a.length;i++)
            for(int j = i;j>0;j--){
                if(comparator.compare((T)a[j],(T)a[j - 1]) < 0){
                    exch(a,j,j - 1);
                }
                else break;
            }
    }

    @Override
    public void sortDesc(Comparable[] a, Comparator comparator) {
        if(isSorted(a)){
            return;
        }
        for(int i = 0;i < a.length;i++)
            for(int j = i;j > 0;j--){
                if(comparator.compare((T)a[j],(T)a[j - 1]) > 0){
                    exch(a,j,j - 1);
                }
                else break;
            }
    }
}
