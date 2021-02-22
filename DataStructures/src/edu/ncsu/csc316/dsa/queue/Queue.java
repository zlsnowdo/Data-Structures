package edu.ncsu.csc316.dsa.queue;

/**
 * Interface to be used in the queue package to add and remove items from a
 * queue list.
 * 
 * @author Zachary Snowdon
 *
 * @param <E> The generic object type which will be added to the list.
 */
public interface Queue<E> {

	/**
	 * Adds an object to the very back of the stack list.
	 * 
	 * @param value The object that is to be added to the list.
	 */
	void enqueue(E value);

	/**
	 * Removes and returns the object that is at the very front of the list.
	 * 
	 * @return E The object that was previously located at the front of the list.
	 */
	E dequeue();

	/**
	 * Returns the object that is located at the very front of the list.
	 * 
	 * @return E The object that is at the very front of the list.
	 */
	E front();

	/**
	 * Tells the user how many objects are currently in the list.
	 * 
	 * @return int The number of objects that are held in the queue list.
	 */
	int size();

	/**
	 * Tells the user weather or not the queue has any objects in it.
	 * 
	 * @return Weather or not the list has any objects in it.
	 */
	boolean isEmpty();
}