package edu.ncsu.csc316.dsa.list;

/**
 * Common functionalities for linked lists and array-based lists.
 * 
 * @author Zachary Snowdon
 *
 * @param <E> Common list functionalities imported from java
 */
public abstract class AbstractList<E> implements List<E> {

	/**
	 * Adds an object to the first spot in a list.
	 * 
	 * @param value The data to be added to the first spot in the list.
	 */
	@Override
	public void addFirst(E value) {
		add(0, value);
	}

	/**
	 * Adds an object to the last spot in a list.
	 * 
	 * @param value The data to be added to the last spot in the list.
	 */
	@Override
	public void addLast(E value) {
		add(size(), value);
	}

	/**
	 * Checks to see if a certain spot in a list exists, or if it will return an
	 * error.
	 * 
	 * @param index The spot in the list to be checked if it exists.
	 * @throws IndexOutOfBoundsException if the index is not a valid index.
	 */
	protected void checkIndex(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("Index is invalid: " + index + " (size=" + size() + ")");
		}
	}

	/**
	 * Checks to see if data or a node is able to be added at a certain position.
	 * 
	 * @param index The spot to be checked if data or a node can be added at.
	 * @throws IndexOutOfBoundsException if data or a node cannot be added at the
	 *                                   given index.
	 */
	protected void checkIndexForAdd(int index) {
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException("Index is invalid: " + index + " (size=" + size() + ")");
		}
	}

	/**
	 * Returns the first value in a list.
	 * 
	 * @return get(0) The data or node that is first in a list.
	 */
	@Override
	public E first() {
		return get(0);
	}

	/**
	 * Checks to see if a list contains any data or nodes.
	 * 
	 * @return size() == 0 Weather or not the list is empty or not.
	 */
	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * Returns the last value in a list.
	 * 
	 * @return get(size() - 1) The data or node that is the last in a list.
	 */
	@Override
	public E last() {
		return get(size() - 1);
	}

	/**
	 * Removes the first data point or node in a given list.
	 * 
	 * @return remove(0) The data that was previously in the first place that was
	 *         removed.
	 */
	@Override
	public E removeFirst() {
		return remove(0);
	}

	/**
	 * Removes the last data point or node in a given list.
	 * 
	 * @return remove(size() - 1) The data that was previously in the last place
	 *         that was removed.
	 */
	@Override
	public E removeLast() {
		return remove(size() - 1);
	}
}