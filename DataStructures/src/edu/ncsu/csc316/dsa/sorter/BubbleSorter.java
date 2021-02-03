package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;

/**
 * Class that uses the bubble sorter algorithm to sort a list of objects.
 * 
 * @author Zachary Snowdon
 *
 * @param <E> the generic type of data to sort
 */
public class BubbleSorter<E extends Comparable<E>> extends AbstractComparisonSorter<E> {

	/**
	 * BubbleSorter constructor that passes a null parameter to the other
	 * constructor.
	 */
	public BubbleSorter() {
		this(null);
	}

	/**
	 * BubbleSorter constructor that passes in the comparator to sort a list of
	 * objects.
	 * 
	 * @param comparator The comparator that is used to help sort a list of objects.
	 */
	public BubbleSorter(Comparator<E> comparator) {
		super(comparator);
	}

	/**
	 * Method that uses the bubble sorter algorithm to sort a list of objects.
	 * 
	 * @param c The list of objects that is to be sorted.
	 */
	public void sort(E[] c) {
		boolean r = true;
		while (r) {
			r = false;
			for (int i = 1; i < c.length; i++) {
				if (compare(c[i], c[i - 1]) < 0) {
					E x = c[i - 1];
					c[i - 1] = c[i];
					c[i] = x;
					r = true;
				}
			}
		}
	}

}