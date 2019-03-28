package sorts;

import java.util.Arrays;
import java.util.Comparator;

public class MergeWithInsertionSortStrategy implements SortStrategy {

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

    public static final int K = 500;

    @Override
    public String getName() {
        return "MergeWithInsertionSort";
    }

    public static void insertionSortAsc(Comparable A[], int p, int q) {
        for (int i = p; i < q; i++) {
            Comparable tempVal = A[i + 1];
            int j = i + 1;
            while (j > p && A[j - 1].compareTo(tempVal) > 0) {
                A[j] = A[j - 1];
                j--;
            }
            A[j] = tempVal;
        }

        // Comparable[] temp = Arrays.copyOfRange(A, p, q +1);

    }

    public static void insertionSortAsc(Comparable A[], Comparator comparator, int p, int q) {
        for (int i = p; i < q; i++) {
            Comparable tempVal = A[i + 1];
            int j = i + 1;
            while (j > p && comparator.compare(A[j-1], tempVal) > 0) {
                A[j] = A[j - 1];
                j--;
            }
            A[j] = tempVal;
        }

        // Comparable[] temp = Arrays.copyOfRange(A, p, q +1);

    }

    public static void mergeAsc(Comparable[] a, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        Comparable[] LA = Arrays.copyOfRange(a, p, q +1);
        Comparable[] RA = Arrays.copyOfRange(a, q+1, r +1);
        int RIDX = 0;
        int LIDX = 0;
        for (int i = p; i < r - p + 1; i++) {
            if (RIDX == n2) {
                a[i] = LA[LIDX];
                LIDX++;
            } else if (LIDX == n1) {
                a[i] = RA[RIDX];
                RIDX++;
            } else if (RA[RIDX].compareTo(LA[LIDX]) > 0) {
                a[i] = LA[LIDX];
                LIDX++;
            } else {
                a[i] = RA[RIDX];
                RIDX++;
            }
        }
    }

    public static void mergeAsc(Comparable[] a, Comparator comparator, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        Comparable[] LA = Arrays.copyOfRange(a, p, q +1);
        Comparable[] RA = Arrays.copyOfRange(a, q+1, r +1);
        int RIDX = 0;
        int LIDX = 0;
        for (int i = p; i < r - p + 1; i++) {
            if (RIDX == n2) {
                a[i] = LA[LIDX];
                LIDX++;
            } else if (LIDX == n1) {
                a[i] = RA[RIDX];
                RIDX++;
            } else if (comparator.compare(RA[RIDX],LA[LIDX])>0) {
                a[i] = LA[LIDX];
                LIDX++;
            } else {
                a[i] = RA[RIDX];
                RIDX++;
            }
        }
    }

    public static void sortAsc(Comparable[] A, Comparator comparator, int p, int r) {
        if (r - p > K) {
            int q = (p + r) / 2;
            sortAsc(A, comparator, p, q);
            sortAsc(A, comparator, q + 1, r);
            mergeAsc(A, comparator, p, q, r);
        } else {
            insertionSortAsc(A,comparator, p, r);
        }
    }

    public static void sortAsc(Comparable[] A, int p, int r) {
        if (r - p > K) {
            int q = (p + r) / 2;
            sortAsc(A, p, q);
            sortAsc(A, q + 1, r);
            mergeAsc(A, p, q, r);
        } else {
            insertionSortAsc(A, p, r);
        }
    }

    public static void insertionSortDesc(Comparable A[], int p, int q) {
        for (int i = p; i < q; i++) {
            Comparable tempVal = A[i + 1];
            int j = i + 1;
            while (j > p && A[j - 1].compareTo(tempVal) < 0) {
                A[j] = A[j - 1];
                j--;
            }
            A[j] = tempVal;
        }

        // Comparable[] temp = Arrays.copyOfRange(A, p, q +1);

    }

    public static void insertionSortDesc(Comparable A[], Comparator comparator, int p, int q) {
        for (int i = p; i < q; i++) {
            Comparable tempVal = A[i + 1];
            int j = i + 1;
            while (j > p && comparator.compare(A[j-1], tempVal) < 0) {
                A[j] = A[j - 1];
                j--;
            }
            A[j] = tempVal;
        }

        // Comparable[] temp = Arrays.copyOfRange(A, p, q +1);

    }

    public static void mergeDesc(Comparable[] a, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        Comparable[] LA = Arrays.copyOfRange(a, p, q +1);
        Comparable[] RA = Arrays.copyOfRange(a, q+1, r +1);
        int RIDX = 0;
        int LIDX = 0;
        for (int i = p; i < r - p + 1; i++) {
            if (RIDX == n2) {
                a[i] = LA[LIDX];
                LIDX++;
            } else if (LIDX == n1) {
                a[i] = RA[RIDX];
                RIDX++;
            } else if (RA[RIDX].compareTo(LA[LIDX]) < 0) {
                a[i] = LA[LIDX];
                LIDX++;
            } else {
                a[i] = RA[RIDX];
                RIDX++;
            }
        }
    }

    public static void mergeDesc(Comparable[] a, Comparator comparator, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        Comparable[] LA = Arrays.copyOfRange(a, p, q +1);
        Comparable[] RA = Arrays.copyOfRange(a, q+1, r +1);
        int RIDX = 0;
        int LIDX = 0;
        for (int i = p; i < r - p + 1; i++) {
            if (RIDX == n2) {
                a[i] = LA[LIDX];
                LIDX++;
            } else if (LIDX == n1) {
                a[i] = RA[RIDX];
                RIDX++;
            } else if (comparator.compare(RA[RIDX],LA[LIDX]) < 0) {
                a[i] = LA[LIDX];
                LIDX++;
            } else {
                a[i] = RA[RIDX];
                RIDX++;
            }
        }
    }

    public static void sortDesc(Comparable[] A, Comparator comparator, int p, int r) {
        if (r - p > K) {
            int q = (p + r) / 2;
            sortDesc(A, comparator, p, q);
            sortDesc(A, comparator, q + 1, r);
            mergeDesc(A, comparator, p, q, r);
        } else {
            insertionSortDesc(A,comparator, p, r);
        }
    }

    public static void sortDesc(Comparable[] A, int p, int r) {
        if (r - p > K) {
            int q = (p + r) / 2;
            sortDesc(A, p, q);
            sortDesc(A, q + 1, r);
            mergeDesc(A, p, q, r);
        } else {
            insertionSortDesc(A, p, r);
        }
    }


    @Override
    public void sortAsc(Comparable[] a) {

        if(isSorted(a)){
            return;
        }

        sortAsc(a,0,a.length-1);

    }


    @Override
    public void sortDesc(Comparable[] a) {
        if(isSorted(a)){
            return;
        }

        sortDesc(a,0,a.length-1);

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
