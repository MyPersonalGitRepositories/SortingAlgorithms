package sorts;

import java.util.Comparator;

public class QuickWithInsertionSortStrategy implements SortStrategy {

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
        return "QuickWithInsertionSort";
    }

    public void recQuickSortAsc(Comparable[] a, int left, int right) {
        int size = right - left + 1;
        if (size < 500) // insertion sortAsc if small
            insertionSortAsc(a, left, right);
        else // quicksort if large
        {
            Comparable median = medianOf3(a, left, right);
            int partition = partitionIt(a, left, right, median);
            recQuickSortAsc(a, left, partition - 1);
            recQuickSortAsc(a, partition + 1, right);
        }
    }

    public void recQuickSortAsc(Comparable[] a, Comparator comparator, int left, int right) {
        int size = right - left + 1;
        if (size < 500) // insertion sortAsc if small
            insertionSortAsc(a, comparator, left, right);
        else // quicksort if large
        {
            Comparable median = medianOf3(a, comparator, left, right);
            int partition = partitionIt(a, comparator, left, right, median);
            recQuickSortAsc(a, comparator, left, partition - 1);
            recQuickSortAsc(a, comparator, partition + 1, right);
        }
    }

    public Comparable medianOf3(Comparable[] a,int left, int right) {
        int center = (left + right) / 2;
        // order left & center
        if (a[left].compareTo( a[center])>0)
            swap(a, left, center);
        // order left & right
        if (a[left].compareTo(a[right])>0)
            swap(a, left, right);
        // order center & right
        if (a[center].compareTo( a[right])>0)
            swap(a, center, right);

        swap(a, center, right - 1);
        return a[right - 1];
    }

    public Comparable medianOf3(Comparable[] a,Comparator comparator, int left, int right) {
        int center = (left + right) / 2;
        // order left & center
        if (comparator.compare(a[left], a[center]) > 0)
            swap(a, left, center);
        // order left & right
        if (comparator.compare(a[left], a[right]) > 0)
            swap(a, left, right);
        // order center & right
        if (comparator.compare(a[center], a[right]) > 0)
            swap(a, center, right);

        swap(a, center, right - 1);
        return a[right - 1];
    }

    public void swap(Comparable[] a, int d1, int d2) {
        Comparable temp = a[d1];
        a[d1] = a[d2];
        a[d2] = temp;
    }

    public int partitionIt(Comparable a[], int left, int right, Comparable pivot) {
        int leftPtr = left; // right of first elem
        int rightPtr = right - 1; // left of pivot
        while (true) {
            //find bigger
            while (a[++leftPtr].compareTo(pivot) < 0);
            //find smaller
            while (a[--rightPtr].compareTo(pivot)>0);
            if (leftPtr >= rightPtr) // if pointers cross, partition done
                break;
            else
                swap(a, leftPtr, rightPtr);
        }
        swap(a, leftPtr, right - 1); // restore pivot
        return leftPtr; // return pivot location
    }

    public int partitionIt(Comparable a[], Comparator comparator, int left, int right, Comparable pivot) {
        int leftPtr = left; // right of first elem
        int rightPtr = right - 1; // left of pivot
        while (true) {
            //find bigger
            while (comparator.compare(a[++leftPtr],pivot) < 0);
            //find smaller
            while (a[--rightPtr].compareTo(pivot)>0);
            if (leftPtr >= rightPtr) // if pointers cross, partition done
                break;
            else
                swap(a, leftPtr, rightPtr);
        }
        swap(a, leftPtr, right - 1); // restore pivot
        return leftPtr; // return pivot location
    }

    public void insertionSortAsc(Comparable[] a, int left, int right) {
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

    public void insertionSortAsc(Comparable[] a, Comparator comparator, int left, int right) {
        int in, out;
        //  sorted on left of out
        for (out = left + 1; out <= right; out++) {
            Comparable temp = a[out]; // remove marked item
            in = out; // start shifts at out
            // until one is smaller,
            while (in > left && comparator.compare(a[in-1], temp)>= 0) {
                a[in] = a[in - 1]; // shift item to right
                --in; // go left one position
            }
            a[in] = temp; // insert marked item
        }
    }

    public void recQuickSortDesc(Comparable[] a, int left, int right) {
        int size = right - left + 1;
        if (size < 500) // insertion sortAsc if small
            insertionSortDesc(a, left, right);
        else // quicksort if large
        {
            Comparable median = medianOf3(a, left, right);
            int partition = partitionIt(a, left, right, median);
            recQuickSortDesc(a, left, partition - 1);
            recQuickSortDesc(a, partition + 1, right);
        }
    }

    public void recQuickSortDesc(Comparable[] a, Comparator comparator, int left, int right) {
        int size = right - left + 1;
        if (size < 500) // insertion sortAsc if small
            insertionSortDesc(a, comparator, left, right);
        else // quicksort if large
        {
            Comparable median = medianOf3(a, comparator, left, right);
            int partition = partitionIt(a, comparator, left, right, median);
            recQuickSortDesc(a, comparator, left, partition - 1);
            recQuickSortDesc(a, comparator, partition + 1, right);
        }
    }

    public void insertionSortDesc(Comparable[] a, int left, int right) {
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

    public void insertionSortDesc(Comparable[] a, Comparator comparator, int left, int right) {
        int in, out;
        //  sorted on left of out
        for (out = left + 1; out <= right; out++) {
            Comparable temp = a[out]; // remove marked item
            in = out; // start shifts at out
            // until one is smaller,
            while (in > left && comparator.compare(a[in-1], temp) <= 0) {
                a[in] = a[in - 1]; // shift item to right
                --in; // go left one position
            }
            a[in] = temp; // insert marked item
        }
    }

    @Override
    public void sortAsc(Comparable[] a) {

        if(isSorted(a)){
            return;
        }

        recQuickSortAsc(a,0,a.length-1);

    }

    @Override
    public void sortDesc(Comparable[] a) {

        if(isSorted(a)){
            return;
        }

        recQuickSortDesc(a,0,a.length-1);
    }

    @Override
    public void sortAsc(Comparable[] a, Comparator comparator) {
        if(isSorted(a)){
            return;
        }

        recQuickSortAsc(a,comparator,0,a.length-1);

    }

    @Override
    public void sortDesc(Comparable[] a, Comparator comparator) {
        if(isSorted(a)){
            return;
        }

        recQuickSortDesc(a,comparator,0,a.length-1);

    }
}
