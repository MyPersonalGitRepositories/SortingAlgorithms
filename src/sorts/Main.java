package sorts;

import ua.princeton.lib.In;
import ua.princeton.lib.Out;
import ua.princeton.lib.Stopwatch;

import java.io.File;

public class Main {

    public static void main(String[]args){

        Sorter<Integer> itemSorter = new Sorter<>();
        SortStrategy<Integer> sortStrategiesSet[] = new SortStrategy[8];
        sortStrategiesSet[0] = new BasicSortStrategy<Integer>();
        sortStrategiesSet[1] = new BubbleSortStrategy<Integer>();
        sortStrategiesSet[2] = new InsertionSortStrategy<Integer>();
        sortStrategiesSet[3] = new CombSortStrategy<Integer>();
        sortStrategiesSet[4] = new ShellSortStrategy<Integer>();
        sortStrategiesSet[5] = new QuickSortStrategy<Integer>();
        sortStrategiesSet[6] = new HeapSortStrategy<Integer>();
        sortStrategiesSet[7] = new MergeSortStrategy<Integer>();

        File inputFiles[] = new File[9];
        inputFiles[0] = new File("1k_random.txt");
        inputFiles[1] = new File("2k_random.txt");
        inputFiles[2] = new File("4k_random.txt");
        inputFiles[3] = new File("8k_random.txt");
        inputFiles[4] = new File("16k_random.txt");
        inputFiles[5] = new File("32k_random.txt");
        inputFiles[6] = new File("input_sorted.txt");
        inputFiles[7] = new File("32k_reversed.txt");
        inputFiles[8] = new File("1k_same.txt");

        Out out = new Out("output.txt");

        for (int i = 0; i < sortStrategiesSet.length; i++) {
            itemSorter.setCurrentSortStrategy(sortStrategiesSet[i]);

            out.println("Algorithm: " + sortStrategiesSet[i].getName().toUpperCase());
            out.println("=============");

            for (int j = 0; j < inputFiles.length; j++) {

                int input[] = new In(inputFiles[j].getName()).readAllInts();
                Integer items[] = new Integer[input.length];

                for (int k = 0; k < items.length; k++) {
                    items[k] = input[k];
                }

                Stopwatch stopwatch = new Stopwatch();
                itemSorter.sortAsc(items);
                out.println("File: " + inputFiles[j].getName() +
                        "; Sorting completed in: " + stopwatch.elapsedTime());
            }

            out.println("=============");
            out.println("=============");
            out.println("=============");
            out.println();
        }
        out.close();
    }
}