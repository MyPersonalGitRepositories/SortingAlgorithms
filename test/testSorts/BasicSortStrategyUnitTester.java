package testSorts;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import sorts.BasicSortStrategy;
import sorts.Item;

import static org.junit.Assert.*;

public class BasicSortStrategyUnitTester extends SortStrategyUnitTester {
	
	@BeforeClass
	public static void setSortStrategy(){
		mySorter.setCurrentSortStrategy(new BasicSortStrategy());
	}
	
	@Override
	@Test
	public void testSortAscNoComparator() {
		mySorter.sortAsc(testDataCopy);
		assertTrue(isSortedAsc(testDataCopy));
	}

	@Override
	@Test
	public void testSortDescNoComparator() {
		mySorter.sortDesc(testDataCopy);
		assertTrue(isSortedDesc(testDataCopy));		
	}

	@Override
	@Test
	public void testSortAscWithComparator() {
		mySorter.sortAsc(testData1Copy, Item.BY_WEIGHT);
		assertTrue(isSortedAsc(testData1Copy,Item.BY_WEIGHT));
	}

	@Override
	@Test
	public void testSortDescWithComparator() {
		mySorter.sortDesc(testData1Copy,Item.BY_COLOR);
		assertTrue(isSortedDesc(testData1Copy,Item.BY_COLOR));
	}
	
}
