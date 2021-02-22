package edu.ncsu.csc316.dsa.stack;

/**
 * Interface to be used in the stack package to add and remove items from a
 * stack list.
 * 
 * @author Zachary Snowdon
 *
 * @param <E> The generic object type which will be added to the list.
 */
public interface Stack<E> {

	/**
	 * Adds an object to the very front/top of the stack list.
	 * 
	 * @param value The object that is to be added to the list.
	 */
	void push(E value);

	/**
	 * Removes and returns the object that is at the very front/top of the list.
	 * 
	 * @return E The object that was previously located at the front/top of the
	 *         list.
	 */
	E pop();

	/**
	 * Returns the item that is at the very front/top of the list without removing
	 * it.
	 * 
	 * @return E The item that is located at the very top/front of the list.
	 */
	E top();

	/**
	 * Method which returns how many items are currently held in the stack list.
	 * 
	 * @return int The number of objects in the list.
	 */
	int size();

	/**
	 * Tells the user weather or not the stack has any objects in it.
	 * 
	 * @return Weather or not the list has any objects in it.
	 */
	boolean isEmpty();
}