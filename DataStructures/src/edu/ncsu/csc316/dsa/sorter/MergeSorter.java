package edu.ncsu.csc316.dsa.sorter;

import java.util.Arrays;
import java.util.Comparator;

/**
 * MergeSorter uses the merge sort algorithm to sort a list of data objects.
 * 
 * @author Zachary Snowdon
 *
 * @param <E> The generic type of data that is held in the lists.
 */
public class MergeSorter<E extends Comparable<E>> extends AbstractComparisonSorter<E> {

	/**
	 * Initiates the merge sorter with a specified comparator to help sort the list
	 * of objects by comparison.
	 * 
	 * @param comparator Comparator that will be used to compare objects to held
	 *                   sort.
	 */
	public MergeSorter(Comparator<E> comparator) {
		super(comparator);
	}

	/**
	 * Initiates the MergeSorter with a null comparator to sort the objects.
	 */
	public MergeSorter() {
		this(null);
	}

	/**
	 * Sorts the list of elements by splitting them in halves and sorting the halves
	 * by using the comparator.
	 * 
	 * @param data The list that is to be split up, sorted, then merged back.
	 */
	public void sort(E[] data) {
		int n = data.length;
		if (n >= 2) {
			int mid = n / 2;
			E[] left = Arrays.copyOfRange(data, 0, mid);
			E[] right = Arrays.copyOfRange(data, mid, data.length);

			sort(left);
			sort(right);

			merge(left, right, data);
		}

	}

	/**
	 * Combines the lists that were previously split up by using the comparator and
	 * merging the lists together.
	 * 
	 * @param left  One of the lists that is to be combined with the right list.
	 * @param right The other list that is to be combined with the left list.
	 * @param T     The list that is going to hold the combined, sorted left and
	 *              right lists.
	 */
	private void merge(E[] left, E[] right, E[] t) {
		int leftIndex = 0;
		int rightIndex = 0;
		int n = t.length;
		while (leftIndex + rightIndex < n) {
			if (rightIndex == right.length
					|| (leftIndex < left.length && compare(left[leftIndex], right[rightIndex]) < 0)) {
				t[leftIndex + rightIndex] = left[leftIndex];
				leftIndex = leftIndex + 1;
			} else {
				t[leftIndex + rightIndex] = right[rightIndex];
				rightIndex = rightIndex + 1;
			}
		}
	}

}