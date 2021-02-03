package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;

/**
 * Abstract class that is used in other classes to create and set comparator
 * objects.
 * 
 * @author Zachary Snowdon
 *
 * @param <E> the generic type of data to sort
 */
public abstract class AbstractComparisonSorter<E extends Comparable<E>> implements Sorter<E> {

	/** Initiates the comparator object to be used in other classes with abstract */
	private Comparator<E> comparator;

	/**
	 * AbstractComparisonSorter constructor that sets the private comparator object
	 * to the parameter value.
	 * 
	 * @param comparator The comparator that is to be set to the private declaration
	 *                   comparator.
	 */
	public AbstractComparisonSorter(Comparator<E> comparator) {
		setComparator(comparator);
	}

	/**
	 * Method that sets the private comparator object as the Comparator<E> passed in
	 * the parameter.
	 * 
	 * @param comparator The comparator object that is to be set to the private
	 *                   comparator.
	 */
	private void setComparator(Comparator<E> comparator) {
		if (comparator == null) {
			comparator = new NaturalOrder();
		}
		this.comparator = comparator;
	}

	/**
	 * Private inner class that sets the natural order of the comparator
	 * 
	 * @author Zachary Snowdon
	 *
	 */
	private class NaturalOrder implements Comparator<E> {
		public int compare(E first, E second) {
			return ((Comparable<E>) first).compareTo(second);
		}
	}

	/**
	 * Compares two generic objects using the comparators compare functionality.
	 * 
	 * @param data1 The first generic object that is compared to the second.
	 * @param data2 The second generic object that is compared to the first.
	 * @return int The integer value that shows how the two objects should be
	 *         ordered when they are sorted.
	 */
	public int compare(E data1, E data2) {
		return comparator.compare(data1, data2);
	}
}
