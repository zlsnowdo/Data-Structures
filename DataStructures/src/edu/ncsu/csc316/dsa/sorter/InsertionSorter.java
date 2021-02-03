package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;

/**
 * InsertionSorter uses the insertion sort algorithm to sort data.
 * 
 * @author Dr. King
 * @author Zachary Snowdon
 * 
 * @param <E> the generic type of data to sort
 */
public class InsertionSorter<E extends Comparable<E>> extends AbstractComparisonSorter<E> {

	/**
	 * InsertionSorter constructor that passes a null parameter to the other
	 * constructor.
	 */
	public InsertionSorter() {
		this(null);
	}

	/**
	 * InsertionSorter constructor that passes in the comparator to sort a list of
	 * objects.
	 * 
	 * @param comparator The comparator that is used to help sort a list of objects.
	 */
	public InsertionSorter(Comparator<E> comparator) {
		super(comparator);
	}

	/**
	 * Method that uses the insertion sorter algorithm to sort a list of objects.
	 * 
	 * @param c The list of objects that is to be sorted.
	 */
	public void sort(E[] c) {
		for (int i = 1; i <= c.length - 1; i++) {
			E x = c[i];
			int j = i - 1;
			while (j >= 0 && compare(c[j], x) > 0) {
				c[j + 1] = c[j];
				j = j - 1;
			}
			c[j + 1] = x;
		}
	}

}