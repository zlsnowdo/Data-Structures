package edu.ncsu.csc316.dsa.stack;

/**
 * Class that will function as a list using the stack interface.
 * 
 * @author Zachary Snowdon
 *
 * @param <E> The generic type of data that will be held in the list.
 */
public abstract class AbstractStack<E> implements Stack<E> {
	/**
	 * Tells the user weather or not the list is empty.
	 * @return size() Weather or not the list is empty.
	 */
	@Override
	public boolean isEmpty() {
		return size() == 0;
	}
}