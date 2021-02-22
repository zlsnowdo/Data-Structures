package edu.ncsu.csc316.dsa.queue;

import java.util.NoSuchElementException;

/**
 * Class which creates a queue list using an array to hold the objects.
 * 
 * @author Zachary Snowdon
 *
 * @param <E> The generic type of objects that will be held in the list.
 */
public class ArrayBasedQueue<E> extends AbstractQueue<E> {

	// The array of generic objects that will hold all of the data in the list.
	private E[] data;

	// Integer that will hold the location of the first object in the list.
	private int front;

	// Integer that will hold the index of the location after the last object in the
	// list.
	private int rear;

	// Integer that will hold the total number of objects in the list.
	private int size;

	// If an initial capacity is not given, an ArrayBasedQueue will be created that
	// can hold 10 objects.
	private static final int DEFAULT_CAPACITY = 10;

	/**
	 * Initiates an ArrayBasedQueue that uses and array to hold objects.
	 * 
	 * @param initialCapacity The total number of objects the array can initially
	 *                        hold.
	 */
	@SuppressWarnings("unchecked")
	public ArrayBasedQueue(int initialCapacity) {
		data = (E[]) (new Object[initialCapacity]);
		size = 0;
		front = 0;
		rear = 0;
	}

	/**
	 * Initiates an ArrayBasedQueue that can hold up to 10 objects.
	 */
	public ArrayBasedQueue() {
		this(DEFAULT_CAPACITY);
	}

	@SuppressWarnings("unchecked")
	private void ensureCapacity(int index) {
		if(index >= data.length) {
			E[] lists = (E[]) (new Object[data.length * 2]);
			for(int i = 0; i < size; i++) {
				lists[i] = data[(front + i + size) % data.length];
			}
			data = lists;
			front = 0;
		}
	}

	/**
	 * Adds an object to the very end of the ArrayBasedQueue list.
	 * 
	 * @param value The object that is to be added to the list.
	 */
	public void enqueue(E value) {
		ensureCapacity(size);
		rear = (front + size) % data.length;
		data[rear] = value;
		size++;
	}

	/**
	 * Removes the very first object in the list and returns its value.
	 * 
	 * @return returnVal The object that was previously first in the list before it
	 *         was removed.
	 */
	public E dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			E returnVal = data[front];
			data[front] = null;
			front = (front + 1) % data.length;
			size--;
			return returnVal;
		}
	}

	/**
	 * Returns the object that is located first in the list.
	 * 
	 * @return data[front] The first object in the list.
	 */
	public E front() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			return data[front];
		}
	}

	/**
	 * Returns the total number of objects that are held in the ArrayBasedQueue int
	 * 
	 * @return size The total number of objects that are held in the list.
	 */
	public int size() {
		return size;
	}

}