package edu.ncsu.csc316.dsa.list;

/**
 * Interface that is used by a number of different lists to get, set, and remove
 * objects in the list.
 * 
 * @author Zachary Snowdon
 *
 * @param <E> The iterable class that lets a user move through a list by
 *            iteration.
 */
public interface List<E> extends Iterable<E> {

	/**
	 * Adds an object(value) to a specific position(index) in a list.
	 * 
	 * @param index The index location where the object should be added to the list.
	 * @param value The object that is to be added to the list at the specific
	 *              index.
	 */
	void add(int index, E value);

	/**
	 * Adds an object(value) to the very front of a list and shifts everything else
	 * in the list over.
	 * 
	 * @param value The object that is to be added to the front of the list.
	 */
	void addFirst(E value);

	/**
	 * Adds an object(value) to the very end of a list.
	 * 
	 * @param value The object that is to be added to the end of the list.
	 */
	void addLast(E value);

	/**
	 * Returns the first object in the list.
	 * 
	 * @return E The first object in the list.
	 */
	E first();

	/**
	 * Returns the object in the list at the requested index location.
	 * 
	 * @param index The location of the object in the list to be returned.
	 * @return E The object that is currently located at the requested index
	 *         location.
	 */
	E get(int index);

	/**
	 * Tests to see if the list has any objects in it, or if it is empty.
	 * 
	 * @return boolean Weather or not the list has any objects in it or not.
	 */
	boolean isEmpty();

	/**
	 * Returns the very last object in the list.
	 * 
	 * @return E The very last object/element in the list.
	 */
	E last();

	/**
	 * Finds the object at a specific index location in a list, returns its value,
	 * then removes it from the list.
	 * 
	 * @param index The location of the object to be removed from the list.
	 * @return E The object that was at the given index before it was removed.
	 */
	E remove(int index);

	/**
	 * Removes the very first object in the list and returns its value.
	 * 
	 * @return E The value of the first object in the list that is then removed.
	 */
	E removeFirst();

	/**
	 * Removes the very last object in the list and returns its value.
	 * 
	 * @return E The value of the last object in the list that is then removed.
	 */
	E removeLast();

	/**
	 * Sets the value at a requested index location to a requested value.
	 * 
	 * @param index The index location where the object is to be set at.
	 * @param value The object that is to be set at the requested location
	 * @return E The object that was previously at the index location before the new
	 *         object was set.
	 */
	E set(int index, E value);

	/**
	 * Method that returns how many objects are currently in the list.
	 * 
	 * @return int The number of objects currently in the list.
	 */
	int size();

}