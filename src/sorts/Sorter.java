package sorts;

import java.util.Comparator;

public class Sorter<T> {

    private SortStrategy<T> currentSortStrategy;

    public Sorter(){

    }

    public Sorter(SortStrategy<T> currentSortStrategy){
        this.currentSortStrategy = currentSortStrategy;
    }

    public void setCurrentSortStrategy(SortStrategy<T> currentSortStrategy) {
        this.currentSortStrategy = currentSortStrategy;
    }

    public void sortAsc(Comparable<T>[] a){
        currentSortStrategy.sortAsc(a);
    }

    public void sortDesc(Comparable<T>[]a){
        currentSortStrategy.sortDesc(a);
    }

    public void sortAsc(Comparable<T>[]a, Comparator<T> comparator){
        currentSortStrategy.sortAsc(a,comparator);
    }

    public void sortDesc(Comparable<T>[]a,Comparator<T> comparator){
        currentSortStrategy.sortDesc(a,comparator);
    }
}
