package sorts;

import java.util.Comparator;

public class ShellSortStrategy<T> implements SortStrategy {

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
        return "ShellSort";
    }

    @Override
    public void sortAsc(Comparable[] a) {
        for( int gap = a.length / 2; gap > 0;
             gap = gap == 2 ? 1 : (int) ( gap / 2.2 ) )
            for( int i = gap; i < a.length; i++ )
            {
                Comparable tmp = a[ i ];
                int j = i;

                for( ; j >= gap && tmp.compareTo( a[ j - gap ] ) < 0; j -= gap )
                    a[ j ] = a[ j - gap ];
                a[ j ] = tmp;
            }
    }

    @Override
    public void sortDesc(Comparable[] a) {
        for( int gap = a.length / 2; gap > 0;
             gap = gap == 2 ? 1 : (int) ( gap / 2.2 ) )
            for( int i = gap; i < a.length; i++ )
            {
                Comparable tmp = a[ i ];
                int j = i;

                for( ; j >= gap && tmp.compareTo( a[ j - gap ] ) > 0; j -= gap )
                    a[ j ] = a[ j - gap ];
                a[ j ] = tmp;
            }
    }

    @Override
    public void sortAsc(Comparable[] a, Comparator comparator) {
        for( int gap = a.length / 2; gap > 0;
             gap = gap == 2 ? 1 : (int) ( gap / 2.2 ) )
            for( int i = gap; i < a.length; i++ )
            {
                Comparable tmp = a[ i ];
                int j = i;
                for( ; j >= gap && comparator.compare((T)tmp,(T)a[j - gap]) < 0; j -= gap )
                    a[ j ] = a[ j - gap ];
                a[ j ] = tmp;
            }
    }

    @Override
    public void sortDesc(Comparable[] a, Comparator comparator) {
        for( int gap = a.length / 2; gap > 0;
             gap = gap == 2 ? 1 : (int) ( gap / 2.2 ) )
            for( int i = gap; i < a.length; i++ )
            {
                Comparable tmp = a[ i ];
                int j = i;
                for( ; j >= gap && comparator.compare((T)tmp,(T)a[j - gap]) > 0; j -= gap )
                    a[ j ] = a[ j - gap ];
                a[ j ] = tmp;
            }
    }
}
