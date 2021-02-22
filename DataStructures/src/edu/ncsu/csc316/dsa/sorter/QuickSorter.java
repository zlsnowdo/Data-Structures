package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;
import java.util.Random;

/**
 * QuickSorter uses the quick sort algorithm to sort a list of objects.
 * 
 * @author Zachary Snowdon
 *
 * @param <E> The generic type of objects that are going to be held in the list.
 */
public class QuickSorter<E extends Comparable<E>> extends AbstractComparisonSorter<E> {

	/**
	 * Interface used by QuickSorter that helps select a pivot integer which tells
	 * QuickSorter where to split the list.
	 * 
	 * @author Zachary Snowdon
	 *
	 */
	private interface PivotSelector {
		/**
		 * Returns the index of the selected pivot element
		 * 
		 * @param low  - the lowest index to consider
		 * @param high - the highest index to consider
		 * @return the index of the selected pivot element
		 */
		int selectPivot(int low, int high);
	}

	/**
	 * Used by QuickSorter to set the pivot index at the lowest index in the list.
	 * 
	 * @author Zachary Snowdon
	 *
	 */
	public static class FirstElementSelector implements PivotSelector {
		/**
		 * Selects the lowest integer for QuickSorter to use so it tests the list
		 * compared to the first item in the list.
		 * 
		 * @param low  The lowest integer in the list that is to be sorted.
		 * @param high The highest integer in the list that is to be sorted.
		 * @return low The lowest integer in the list that is going to be used to find
		 *         the first object in the list.
		 */
		public int selectPivot(int low, int high) {
			return low;
		}
	}

	/**
	 * Used by QuickSorter to set the pivot index at the highest index in the list.
	 * 
	 * @author Zachary Snowdon
	 *
	 */
	public static class LastElementSelector implements PivotSelector {
		/**
		 * Selects the highest integer for QuickSorter to use so it tests the list
		 * compared to the last item in the list.
		 * 
		 * @param low  The lowest integer in the list that is to be sorted.
		 * @param high The highest integer in the list that is to be sorted.
		 * @return high The highest integer in the list that is going to be used to find
		 *         the last object in the list.
		 */
		public int selectPivot(int low, int high) {
			return high;
		}
	}

	/**
	 * Used by QuickSorter to set the pivot index at the middle index in the list.
	 * 
	 * @author Zachary Snowdon
	 *
	 */
	public static class MiddleElementSelector implements PivotSelector {
		/**
		 * Selects the highest integer for QuickSorter to use so it tests the list
		 * compared to the middle item in the list.
		 * 
		 * @param low  The lowest integer in the list that is to be sorted.
		 * @param high The highest integer in the list that is to be sorted.
		 * @return (high + low) / 2 The middle integer in the list that is going to be
		 *         used to find the middle object in the list.
		 */
		public int selectPivot(int low, int high) {
			return (high + low) / 2;
		}
	}

	/**
	 * Used by QuickSorter to set the pivot index at a random index in the list.
	 * 
	 * @author Zachary Snowdon
	 *
	 */
	public static class RandomElementSelector implements PivotSelector {
		/**
		 * Selects a random integer for QuickSorter to use so it tests the list compared
		 * to a random item in the list.
		 * 
		 * @param low  The lowest integer in the list that is to be sorted.
		 * @param high The highest integer in the list that is to be sorted.
		 * @return high - getNum A random integer in the list that is going to be used
		 *         to find a random object in the list.
		 */
		public int selectPivot(int low, int high) {
			Random random = new Random();
			int getNum = random.nextInt(high - low);
			return high - getNum;
		}
	}

	/**
	 * Initiates the FirstElementSelector which will be used by QuickSort to get the
	 * lowest index in the list.
	 */
	public static final PivotSelector FIRST_ELEMENT_SELECTOR = new FirstElementSelector();

	/**
	 * Initiates the LastElementSelector which will be used by QuickSort to get the
	 * highest index in the list.
	 */
	public static final PivotSelector LAST_ELEMENT_SELECTOR = new LastElementSelector();

	/**
	 * Initiates the MiddleElementSelector which will be used by QuickSort to get the middle index in the list.
	 */
	public static final PivotSelector MIDDLE_ELEMENT_SELECTOR = new MiddleElementSelector();
	
	/**
	 * Initiates the RandomtElementSelector which will be used by QuickSort to get a random index in the list.
	 */
	public static final PivotSelector RANDOM_ELEMENT_SELECTOR = new RandomElementSelector();

	/**
	 * Initiates the PivotSelector which will hold one of the four selectors above.
	 */
	private PivotSelector selector;

	/**
	 * Initiates the QuickSorter that sets a Comparator and PivotSelector
	 * 
	 * @param comparator Comparator that is used to compare objects so that they can
	 *                   be ordered in the list.
	 * @param p          Tells QuickSorter which element to test against in the
	 *                   list.
	 */
	public QuickSorter(Comparator<E> comparator, PivotSelector p) {
		super(comparator);
		setSelector(p);
	}

	/**
	 * Initiates the QuickSorter that sets a Comparator and PivotSelector
	 * 
	 * @param p Tells QuickSorter which element to test against in the list.
	 */
	public QuickSorter(PivotSelector p) {
		this(null, p);
	}

	/**
	 * Initiates the QuickSorter that sets a Comparator and PivotSelector
	 * 
	 * @param comparator Comparator that is used to compare objects so that they can
	 *                   be ordered in the list.
	 */
	public QuickSorter(Comparator<E> comparator) {
		this(comparator, null);
	}

	/**
	 * Initiates the QuickSorter that sets a Comparator and PivotSelector
	 */
	public QuickSorter() {
		this(null, null);
	}

	/**
	 * Sets the selector to tell the Quicksorter which index to test against.
	 * 
	 * @param p Tells QuickSorter which element to test against in the list.
	 */
	private void setSelector(PivotSelector p) {
		if (p == null) {
			selector = new RandomElementSelector();
		} else {
			this.selector = p;
		}
	}

	/**
	 * Initiates the QuickSorter which will sort a list of objects.
	 * 
	 * @param data The list that is to be sorted using the quick sort algorithm.
	 */
	public void sort(E[] data) {
		quickSort(data, 0, data.length - 1);
	}

	/**
	 * Sorts a list of objects from one index to another using the quick sort
	 * algorithm.
	 * 
	 * @param data The list that is to be sorted using the quick sort algorithm.
	 * @param low  The lowest integer in the list to be sorted.
	 * @param high The highest integer in the list to be sorted.
	 */
	private void quickSort(E[] data, int low, int high) {
		if (low < high) {
			int pivotIndex = partition(data, low, high);
			quickSort(data, low, pivotIndex - 1);
			quickSort(data, pivotIndex + 1, high);
		}
	}

	/**
	 * Splits up a smaller section of the list then passes it to partitionHelper
	 * 
	 * @param data The data that is to be split and passed to partitionHelper.
	 * @param low  The lowest integer in the list to be sorted.
	 * @param high The highest integer in the list to be sorted.
	 * @return partitionHelper(data, low, high) The integer that was returned from
	 *         partitionHelper.
	 */
	private int partition(E[] data, int low, int high) {
		int pivotIndex = selector.selectPivot(low, high);
		swap(data, pivotIndex, high);
		return partitionHelper(data, low, high);
	}

	/**
	 * This part of the class tests the objects in the list to see which objects are
	 * greater than other objects. The objects are swapped if in the wrong position.
	 * 
	 * @param data The list that is to be sorted using the quick sort algorithm.
	 * @param low  The first index in the list to be tested.
	 * @param high The last index in the list to be tested.
	 * @return index The final index which is where the partition ended.
	 */
	private int partitionHelper(E[] data, int low, int high) {
		E pivot = data[high];
		int index = low;
		for (int i = low; i <= high - 1; i++) {
			if (compare(data[i], pivot) <= 0) {
				swap(data, index, i);
				index = index + 1;
			}
		}
		swap(data, index, high);
		return index;
	}

	/**
	 * Swaps two elements in the list which is used when two objects are in the
	 * wrong positions.
	 * 
	 * @param data The list that holds the two objects that are to be switched.
	 * @param low  One of two elements that are to be swapped in the list.
	 * @param high The other object in the list that is to be swapped with the
	 *             first.
	 */
	private void swap(E[] data, int low, int high) {
		E value = data[high];
		data[high] = data[low];
		data[low] = value;
	}

}