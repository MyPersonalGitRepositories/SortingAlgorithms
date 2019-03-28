package sorts;

import java.util.Comparator;

public class MergeSortStrategy<T> implements SortStrategy {

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
        return "MergeSort";
    }

    private static<T> void mergeSortAsc(Comparable<T> [] a, Comparable<T> [] tmp, int left, int right) {
        if( left < right )
        {
            int center = (left + right) / 2;
            mergeSortAsc(a, tmp, left, center);
            mergeSortAsc(a, tmp, center + 1, right);
            mergeAsc(a, tmp, left, center + 1, right);
        }
    }

    private static<T> void mergeAsc(Comparable<T>[] a, Comparable<T>[] tmp, int left, int right, int rightEnd ) {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while(left <= leftEnd && right <= rightEnd)
            if(a[left].compareTo((T) a[right]) <= 0)
                tmp[k++] = a[left++];
            else
                tmp[k++] = a[right++];

        while(left <= leftEnd)    // Copy rest of first half
            tmp[k++] = a[left++];

        while(right <= rightEnd)  // Copy rest of right half
            tmp[k++] = a[right++];

        // Copy tmp back
        for(int i = 0; i < num; i++, rightEnd--)
            a[rightEnd] = tmp[rightEnd];
    }

    private static<T> void mergeSortDesc(Comparable<T> [] a, Comparable<T> [ ] tmp, int left, int right) {
        if( left < right )
        {
            int center = (left + right) / 2;
            mergeSortDesc(a, tmp, left, center);
            mergeSortDesc(a, tmp, center + 1, right);
            mergeDesc(a, tmp, left, center + 1, right);
        }
    }

    private static<T> void mergeDesc(Comparable<T>[] a, Comparable<T>[] tmp, int left, int right, int rightEnd ) {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while(left <= leftEnd && right <= rightEnd)
            if(a[left].compareTo((T) a[right]) >= 0)
                tmp[k++] = a[left++];
            else
                tmp[k++] = a[right++];

        while(left <= leftEnd)    // Copy rest of first half
            tmp[k++] = a[left++];

        while(right <= rightEnd)  // Copy rest of right half
            tmp[k++] = a[right++];

        // Copy tmp back
        for(int i = 0; i < num; i++, rightEnd--)
            a[rightEnd] = tmp[rightEnd];
    }

    private static<T> void mergeSortAsc(Comparable<T> [] a, Comparable<T> [ ] tmp, Comparator<T> comparator, int left, int right) {
        if( left < right )
        {
            int center = (left + right) / 2;
            mergeSortAsc(a, tmp,comparator, left, center);
            mergeSortAsc(a, tmp, comparator, center + 1, right);
            mergeAsc(a, tmp,comparator, left, center + 1, right);
        }
    }

    private static<T> void mergeAsc(Comparable<T>[] a, Comparable<T>[] tmp, Comparator<T> comparator, int left, int right, int rightEnd ) {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while(left <= leftEnd && right <= rightEnd)
            if(comparator.compare((T)a[left],(T)a[right]) <= 0)
                tmp[k++] = a[left++];
            else
                tmp[k++] = a[right++];

        while(left <= leftEnd)    // Copy rest of first half
            tmp[k++] = a[left++];

        while(right <= rightEnd)  // Copy rest of right half
            tmp[k++] = a[right++];

        // Copy tmp back
        for(int i = 0; i < num; i++, rightEnd--)
            a[rightEnd] = tmp[rightEnd];
    }

    private static<T> void mergeSortDesc(Comparable<T> [] a, Comparable<T> [ ] tmp, Comparator<T> comparator, int left, int right) {
        if( left < right )
        {
            int center = (left + right) / 2;
            mergeSortDesc(a, tmp,comparator, left, center);
            mergeSortDesc(a, tmp, comparator, center + 1, right);
            mergeDesc(a, tmp,comparator, left, center + 1, right);
        }
    }

    private static<T> void mergeDesc(Comparable<T>[] a, Comparable<T>[] tmp, Comparator<T> comparator, int left, int right, int rightEnd ) {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while (left <= leftEnd && right <= rightEnd)
            if (comparator.compare((T) a[left], (T) a[right]) >= 0)
                tmp[k++] = a[left++];
            else
                tmp[k++] = a[right++];

        while (left <= leftEnd)    // Copy rest of first half
            tmp[k++] = a[left++];

        while (right <= rightEnd)  // Copy rest of right half
            tmp[k++] = a[right++];

        // Copy tmp back
        for (int i = 0; i < num; i++, rightEnd--)
            a[rightEnd] = tmp[rightEnd];
    }

    @Override
    public void sortAsc(Comparable[] a) {

        if(isSorted(a)){
            return;
        }

        Comparable[] tmp = new Comparable[a.length];
        mergeSortAsc(a, tmp,  0,  a.length - 1);
    }

    @Override
    public void sortDesc(Comparable[] a) {

        if(isSorted(a)){
            return;
        }

        Comparable[] tmp = new Comparable[a.length];
        mergeSortDesc(a, tmp,  0,  a.length - 1);
    }

    @Override
    public void sortAsc(Comparable[] a, Comparator comparator) {

        if(isSorted(a)){
            return;
        }

        Comparable[] tmp = new Comparable[a.length];
        mergeSortAsc(a, tmp, comparator, 0,  a.length - 1);
    }

    @Override
    public void sortDesc(Comparable[] a, Comparator comparator) {

        if(isSorted(a)){
            return;
        }

        Comparable[] tmp = new Comparable[a.length];
        mergeSortDesc(a, tmp, comparator, 0,  a.length - 1);
    }
}
