package edu.ncsu.csc316.dsa.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Creates an array-based list which can hold data.
 * 
 * @author Zachary Snowdon
 *
 * @param <E> Imports the AbstractList abstract class to shorten commands.
 */
public class ArrayBasedList<E> extends AbstractList<E> {

	// The integer which holds the capacity of the list when it is initiated.
	private final static int DEFAULT_CAPACITY = 10;

	// An array which holds all of the data in the array-based list
	private E[] data;

	// Integer which holds how many data points are currently in the list.
	private int size;

	/**
	 * Constructor for the array-based list which creates a list with a capacity of
	 * 10.
	 */
	public ArrayBasedList() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * Constructor for the array-based list which creates a list with a capacity of
	 * the parameter.
	 * 
	 * @param capacity The maximum amount of data the list can hold when it is
	 *                 initiated.
	 */
	@SuppressWarnings("unchecked")
	public ArrayBasedList(int capacity) {
		data = (E[]) (new Object[capacity]);
		size = 0;
	}

	/**
	 * Adds data(value) to a certain spot spot(index) in the list.
	 * 
	 * @param index The location where the data should be added in the list.
	 * @param value The data to be added to the list at the certain location.
	 */
	@Override
	public void add(int index, E value) {
		ensureCapacity(index + 1);
		int number = size;
		for (int i = number; i > index; i--) {
			if (data[i - 1] != null) {
				data[i] = data[i - 1];
			}
		}
		data[index] = value;
		size++;
	}

	/**
	 * Makes sure that the current capacity of the list is enough to hold a new data
	 * point.
	 * 
	 * @param minCapacity The amount of data the list will hold after the new object
	 *                    is added.
	 */
	private void ensureCapacity(int minCapacity) {
		int oldCapacity = data.length;
		if (minCapacity > oldCapacity) {
			int newCapacity = (oldCapacity * 2) + 1;
			if (newCapacity < minCapacity) {
				newCapacity = minCapacity - 1;
			}
			data = Arrays.copyOf(data, newCapacity);
		}
	}

	/**
	 * Returns the object at the requested location in the list.
	 * 
	 * @param index The location in the list of the object that is to be returned.
	 * @return data[index] The object that was located at the requested index.
	 */
	@Override
	public E get(int index) {
		return data[index];
	}

	/**
	 * Removes an object from the list at a requested index location.
	 * 
	 * @param index The location of the object to be removed from the list.
	 * @return removedE The object that was removed from the list.
	 */
	@Override
	public E remove(int index) {
		checkIndex(index);
		E removedE = data[index];
		for (int i = index; i < size - 1; i++) {
			data[i] = data[i + 1];
		}
		data[size - 1] = null;
		size--;
		return removedE;
	}

	/**
	 * Sets an object into a list at a requested value. This will in turn remove the
	 * object that was previously at the position.
	 * 
	 * @param index The index location of where the data is to be put in the list.
	 * @param value The data that is to be added to the list at the specific
	 *              location.
	 * @return removedE The object that was previously at the index location before
	 *         the new object was added.
	 */
	@Override
	public E set(int index, E value) {
		E removedE = data[index];
		data[index] = value;
		return removedE;
	}

	/**
	 * Method that returns how many objects are currently in the list.
	 * 
	 * @return size The total number of objects in the list.
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Initiates the element iterator which allows the user to move through the
	 * list.
	 * 
	 * @return ElementIterator() An iterator that allows the user to move through
	 *         the lists objects.
	 */
	@Override
	public Iterator<E> iterator() {
		return new ElementIterator();
	}

	/**
	 * Class that allows the user to iterate or move through a list.
	 * 
	 * @author Zachary Snowdon
	 *
	 */
	private class ElementIterator implements Iterator<E> {

		// The integer which holds where the iterator currently is in the list.
		private int position;

		// Tells the remove method if the next() method was previously called which then
		// allows the remove method to be used.
		private boolean removeOK;

		/**
		 * Initiates the iterator by starting at the first value in the list.
		 */
		public ElementIterator() {
			position = 0;
			removeOK = false;
		}

		/**
		 * Tells the iterator if there are any additional objects in the list.
		 * 
		 * @return returnVal Weather or not the list has any more objects.
		 */
		public boolean hasNext() {
			boolean returnVal = true;
			if (data[position] == null) {
				returnVal = false;
			}
			return returnVal;
		}

		/**
		 * Moves the iterator to the next object in the list and returns that object.
		 * 
		 * @return returnVal The value that is the next object in the list.
		 */
		public E next() {
			if (data[position] == null) {
				throw new NoSuchElementException();
			}
			E nextVal = data[position];
			position++;
			removeOK = true;
			return nextVal;
		}

		/**
		 * Method that removes the previously called next() value in the list.
		 */
		public void remove() {
			if (removeOK) {
				int pos = position - 1;
				if (pos == size() - 1) {
					data[pos] = null;
				} else {
					for (int i = pos; i < size(); i++) {
						data[i] = data[i + 1];
					}
				}
				size--;
				position--;
				removeOK = false;
			} else {
				throw new IllegalStateException();
			}
		}
	}

}