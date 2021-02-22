package edu.ncsu.csc316.dsa.stack;

import java.util.EmptyStackException;

import edu.ncsu.csc316.dsa.list.SinglyLinkedList;

/**
 * Class which creates a stack list using an array to hold the objects.
 * 
 * @author Zachary Snowdon
 *
 * @param <E> The generic type of objects that will be held in the list.
 */
public class LinkedStack<E> extends AbstractStack<E> {

	// The linked list of generic objects that will hold all of the data in the
	// list.
	private SinglyLinkedList<E> list;

	/**
	 * Initiates the SinglyLinkedList which will hold all objects in the list.
	 */
	public LinkedStack() {
		list = new SinglyLinkedList<E>();
	}

	/**
	 * Adds and object to the front/top of the list.
	 * 
	 * @param value The object that is to be added to the front/top of the list.
	 */
	public void push(E value) {
		list.addFirst(value);
	}

	/**
	 * Removes and returns the object at the front/top of the list.
	 * 
	 * @return list.removeFirst() The object that was at the front/top of the list.
	 */
	public E pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		} else {
			return list.removeFirst();
		}
	}

	/**
	 * Returns the object that is located at the front/top of the list.
	 * 
	 * @return list.first() The object that is located at the front/top of the list.
	 */
	public E top() {
		if (isEmpty()) {
			throw new EmptyStackException();
		} else {
			return list.first();
		}
	}

	/**
	 * Tells the user how many objects are held in the stack.
	 * 
	 * @return list.size() The total number of objects that are held in the list.
	 */
	public int size() {
		return list.size();
	}
}