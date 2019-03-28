package testSorts;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({

		BubbleSortStrategyUnitTester.class,
		CombSortStrategyUnitTester.class,
		HeapSortStrategyUnitTester.class,
		InsertionSortStrategyUnitTester.class,
		ShellSortStrategyUnitTester.class,
		MergeSortStrategyUnitTester.class,
		MergeWithModificationsSortStrategyUnitTester.class,
		MergeWithComparisonSortStrategyUnitTester.class,
		MergeWithInsertionSortStrategyUnitTester.class,
		QuickSortStrategyUnitTester.class,
		QuickWithDeykstraSortStrategyUnitTester.class,
		QuickWithInsertionSortStrategyUnitTester.class,
		QuickWithTwoModificationsSortStrategyUnitTester.class

})
public class AllUnitTests {

}
