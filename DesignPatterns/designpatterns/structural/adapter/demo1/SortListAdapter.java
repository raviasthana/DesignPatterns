package structural.adapter.demo1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Trivial example - just to illustrate the pattern
 * 
 * A simple object adapter which adapts a list sorter
 * to a client that uses int array sort 
 */
public class SortListAdapter implements Sorter{
	@Override   
	public int[] sort(int[] numbers) {
		//convert the array to a List

		List<Integer> numberList = Arrays.stream(numbers)
									.boxed()
									.collect(Collectors.toList());
		/*
		List<Integer> numberList = IntStream.of(numbers)
									.boxed()
									.collect(Collectors.toList());
		*/
		//call the adapter
		NumberSorter sorter = new NumberSorter();
		numberList = sorter.sort(numberList);
		//convert the list back to an array and return
		return numberList.stream().mapToInt(i->i).toArray();
	}
}