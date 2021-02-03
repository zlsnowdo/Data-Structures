package edu.ncsu.csc316.dsa.sorter;

/**
 * Interface that defines the sorting behavior
 * 
 * @author Dr. King
 * @author Zachary Snowdon
 * 
 * @param <E> the generic type of data to sort
 */
public interface Sorter<E> {

	/**
	 * Method that is used to call the sort methods in other classes.
	 * 
	 * @param lists The list of objects that is to be sorted.
	 */
	void sort(E[] lists);

}
