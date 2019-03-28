package testSorts;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import sorts.Item;
import sorts.Sorter;

import java.util.Arrays;
import java.util.Comparator;


public abstract class SortStrategyUnitTester {
	
	static Sorter mySorter;
	static Comparable[] testData;
	static Comparable[] testDataCopy;
	static Item[] testData1Copy;
 	Item items[]  = new Item[10];
         
    
	protected boolean isSortedAsc(Comparable[] arr) {
		boolean result = true;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i].compareTo(arr[i + 1]) > 0) {
				result = false;
				break;
			}
		}
		
		return result;
	}
	
	protected boolean isSortedDesc(Comparable[] arr) {
		boolean result = true;
		
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i].compareTo(arr[i + 1]) < 0) {
				result = false;
				break;
			}
		}
		
		return result;
	}
	
	protected boolean isSortedAsc(Comparable[] arr, Comparator comparator) {
		boolean result = true;
		
		for (int i = 0; i < arr.length - 1; i++) {
			if (comparator.compare(arr[i], arr[i + 1]) > 0) {
				result = false;
				break;
			}
		}
		
		return result;
	}
	
	protected boolean isSortedDesc(Comparable[] arr, Comparator comparator) {
		boolean result = true;
		
		for (int i = 0; i < arr.length - 1; i++) {
			if (comparator.compare(arr[i], arr[i + 1]) < 0) {
				result = false;
				break;
			}
		}
		
		return result;
	}	
	
	@BeforeClass
	public static void initialSetUp() {
		mySorter = new Sorter();	
		 
		testData = new Integer[]{35, 2, 11, -50, 44, 10, 18, 5, 0, 22};		
		  Item items[]  = new Item[10];
			for(int i = 0;i<items.length;i++){
		        items[i] = new Item((int)(100*Math.random()),(int)(20*Math.random()),"RGB" + (int)(Math.random()*1000+6440));
		        Item[] itemsCopy = Arrays.copyOf( items,items.length);
		        
		    }
	}	
	
	@Before
	public void setup() {
		
		for(int i = 0;i<items.length;i++){
	        items[i] = new Item((int)(100*Math.random()),(int)(20*Math.random()),"RGB" + (int)(Math.random()*1000+6440));}
	     
		testDataCopy = Arrays.copyOf(testData, testData.length);
		testData1Copy=Arrays.copyOf(items,items.length);
	}
	
	@Test
	abstract void testSortAscNoComparator();
	
	@Test
	abstract void testSortDescNoComparator();
	
	@Test
	abstract void testSortAscWithComparator();
	
	@Test
	abstract void testSortDescWithComparator();

	
	
}
