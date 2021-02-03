package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;

/**
 * SelectionSorter uses the selection sort algorithm to sort data
 * 
 * @author Dr. King
 * @author Zachary Snowdon
 *
 * @param <E> the generic type of data to sort
 */
public class SelectionSorter<E extends Comparable<E>> extends AbstractComparisonSorter<E> {

	/**
	 * SelectionSorter constructor that passes a null parameter to the other
	 * constructor.
	 */
	public SelectionSorter() {
		this(null);
	}

	/**
	 * SelectionSorter constructor that passes in the comparator to sort a list of
	 * objects.
	 * 
	 * @param comparator The comparator that is used to help sort a list of objects.
	 */
	public SelectionSorter(Comparator<E> comparator) {
		super(comparator);
	}

	/**
	 * Method that uses the selection sort algorithm to sort a list of objects.
	 * 
	 * @param data The list of objects that is to be sorted.
	 */
	public void sort(E[] data) {
		for (int i = 0; i < data.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < data.length; j++) {
				if (compare(data[j], data[min]) < 0) {
					min = j;
				}
			}
			if (i != min) {
				E x = data[i];
				data[i] = data[min];
				data[min] = x;
			}
		}
	}

}