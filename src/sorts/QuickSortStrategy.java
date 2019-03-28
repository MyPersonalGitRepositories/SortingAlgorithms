package sorts;

import java.util.Comparator;

public class QuickSortStrategy<T> implements SortStrategy {

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
        return "QuickSort";
    }

    private static<T> int partitionAsc(Comparable<T>[] a, int start, int end){
        Comparable<T> pivot = a[end];
        for(int i=start; i<end; i++){
            if(a[i].compareTo((T) pivot) < 0){
                Comparable<T> temp= a[start];
                a[start]=a[i];
                a[i]=temp;
                start++;
            }
        }
        Comparable<T> temp = a[start];
        a[start] = pivot;
        a[end] = temp;

        return start;
    }

    private static<T> int partitionDesc(Comparable<T>[] a, int start, int end){
        Comparable<T> pivot = a[end];
        for(int i=start; i<end; i++){
            if(a[i].compareTo((T) pivot) > 0){
                Comparable<T> temp= a[start];
                a[start]=a[i];
                a[i]=temp;
                start++;
            }
        }
        Comparable<T> temp = a[start];
        a[start] = pivot;
        a[end] = temp;

        return start;
    }

    private static<T> int partitionForComporatorAsc(Comparable<T>[] a,Comparator<T> comparator, int start, int end){
        Comparable<T> pivot = a[end];

        for(int i=start; i<end; i++){
            if(comparator.compare((T)a[i],((T)pivot)) < 0){
                Comparable<T> temp= a[start];
                a[start]=a[i];
                a[i]=temp;
                start++;
            }
        }
        Comparable<T> temp = a[start];
        a[start] = pivot;
        a[end] = temp;

        return start;
    }

    private static<T> int partitionForComporatorDesc(Comparable<T>[] a,Comparator<T> comparator, int start, int end){
        Comparable<T> pivot = a[end];

        for(int i=start; i<end; i++){
            if(comparator.compare((T)a[i],((T)pivot)) > 0){
                Comparable<T> temp= a[start];
                a[start]=a[i];
                a[i]=temp;
                start++;
            }
        }
        Comparable<T> temp = a[start];
        a[start] = pivot;
        a[end] = temp;

        return start;
    }

    public static<T> void quickSortDesc(Comparable<T>[] a, Comparator<T> comparator, int start, int end){

        int partitionForComporatorDesc = partitionForComporatorDesc(a, comparator, start, end);

        if(partitionForComporatorDesc-1>start) {
            quickSortDesc(a,comparator, start, partitionForComporatorDesc - 1);
        }
        if(partitionForComporatorDesc+1<end) {
            quickSortDesc(a, comparator,partitionForComporatorDesc + 1, end);
        }
    }

    public static<T> void quickSortAsc(Comparable<T>[]a, Comparator<T> comparator, int start, int end){

        int partitionForComporatorAsc = partitionForComporatorAsc(a, comparator, start, end);

        if(partitionForComporatorAsc-1>start) {
            quickSortAsc(a,comparator, start, partitionForComporatorAsc - 1);
        }
        if(partitionForComporatorAsc+1<end) {
            quickSortAsc(a, comparator,partitionForComporatorAsc + 1, end);
        }
    }

    public static<T> void quickSortAsc(Comparable<T>[] a, int start, int end){

        int partitionAsc = partitionAsc(a, start, end);

        if(partitionAsc-1>start) {
            quickSortAsc(a, start, partitionAsc - 1);
        }
        if(partitionAsc+1<end) {
            quickSortAsc(a, partitionAsc + 1, end);
        }
    }

    public static<T> void quickSortDesc(Comparable<T>[] a, int start, int end){

        int partitionDesc = partitionDesc(a, start, end);

        if(partitionDesc-1>start) {
            quickSortDesc(a, start, partitionDesc - 1);
        }
        if(partitionDesc+1<end) {
            quickSortDesc(a, partitionDesc + 1, end);
        }
    }

    @Override
    public void sortAsc(Comparable[] a) {

        if(isSorted(a)){
            return;
        }

        quickSortAsc(a,0,a.length-1);
    }

    @Override
    public void sortDesc(Comparable[] a) {

        if(isSorted(a)){
            return;
        }

        quickSortDesc(a,0,a.length-1);
    }

    @Override
    public void sortAsc(Comparable[] a, Comparator comparator) {

        if(isSorted(a)){
            return;
        }

        quickSortAsc(a,comparator,0,a.length-1);
    }

    @Override
    public void sortDesc(Comparable[] a, Comparator comparator) {

        if(isSorted(a)){
            return;
        }

        quickSortDesc(a,comparator,0,a.length-1);
    }
}
