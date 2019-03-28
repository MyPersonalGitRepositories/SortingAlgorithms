package sorts;

import java.util.Comparator;

public class BubbleSortStrategy<T> implements SortStrategy {

    private static <T> boolean less(Comparable<T> v,Comparable<T> w){
        return v.compareTo((T)w)<0;
    }

    private static <T> void change(Comparable<T>[] a,int i,int j){
        Comparable<T> swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static <T> boolean isSorted(Comparable<T>[] a){
        for(int i =1;i<a.length;i++){
            if(less(a[i],a[i-1])){
                return false;
            }
        }
        return true;
    }

    @Override
    public void sortAsc(Comparable[] a) {
        int n = a.length;
        if(isSorted(a)){
            return;
        }
        for(int i =0;i<n;i++)
            for(int j = i;j>0;j--){
                if(a[j].compareTo((T) a[j-1])<0){
                    change(a,j,j-1);
                }
                else break;
            }
    }

    @Override
    public void sortDesc(Comparable[] a) {
        int n = a.length;
        if(isSorted(a)){
            return;
        }
        for(int i =0;i<n;i++)
            for(int j = i;j>0;j--){
                if(a[j].compareTo((T) a[j-1])>0){
                    change(a,j,j-1);
                }
                else break;
            }

    }

    @Override
    public void sortAsc(Comparable[] a, Comparator comparator) {
        int n = a.length;
        if(isSorted(a)){
            return;
        }
        for(int i = 0;i<n;i++)
            for (int j = i ; j >0;j--){
                if(comparator.compare((T) a[j],(T) a[j-1] )<0){
                    change(a,j,j-1);
                }
                else break;
            }
    }

    @Override
    public String getName() {
        return "BubbleSort";
    }

    @Override
    public void sortDesc(Comparable[] a, Comparator comparator) {
        int n = a.length;
        if(isSorted(a)){
            return;
        }
        for(int i = 0;i<n;i++)
            for (int j = i ; j >0;j--){
                if(comparator.compare((T) a[j],(T) a[j-1] )>0){
                    change(a,j,j-1);
                }
                else break;
            }
    }
}
