package edu.ncsu.csc316.dsa.queue;

/**
 * Class that will function as an abstract class for the list using the stack
 * interface.
 * 
 * @author Zachary Snowdon
 *
 * @param <E> The generic type of data that will be held in the list.
 */
public abstract class AbstractQueue<E> implements Queue<E> {
	/**
	 * Tells the user weather or not the list is empty.
	 * 
	 * @return size() Weather or not the list is empty.
	 */
	@Override
	public boolean isEmpty() {
		return size() == 0;
	}
}