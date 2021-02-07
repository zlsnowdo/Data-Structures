package edu.ncsu.csc316.dsa.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementation of a linked list with a dummy front and tail node.
 * 
 * @author Zachary Snowdon
 *
 * @param <E> The generic type of data to be added to the list.
 */
public class SinglyLinkedList<E> extends AbstractList<E> {

	/**
	 * Creates nodes which are used to connect objects in the list.
	 * 
	 * @author Zachary Snowdon
	 *
	 * @param <E> The generic type of data that will be set to a node.
	 */
	private static class LinkedListNode<E> {

		// The object that is held in a LinkedListNode in the list.
		private E data;

		// The next LinkedListNode in the list which holds an object and another node.
		private LinkedListNode<E> next;

		/**
		 * Constructor for the LinkedListNode which adds an object to the node with no
		 * connection node in the next side.
		 * 
		 * @param list The object that is set into the LinkedListNode.
		 */
		public LinkedListNode(E list) {
			this(list, null);
		}

		/**
		 * Constructor for the LinkedListNode which adds an object to the node with
		 * another LinkedListNode connected to it.
		 * 
		 * @param list The object that is set into the LinkedListNode.
		 * @param node The node that is to come after the node that is constructed.
		 */
		public LinkedListNode(E list, LinkedListNode<E> node) {
			this.data = list;
			this.next = node;
		}

		/**
		 * Returns the LinkedListNode that comes after a requested node.
		 * 
		 * @return next The next LinkedListNode in the list.
		 */
		public LinkedListNode<E> getNext() {
			return next;
		}

		/**
		 * Gets the data that is held in the LinkedListNode and returns its value.
		 * 
		 * @return data The data that is stored in the LinkedListNode
		 */
		public E getElement() {
			return data;
		}

		/**
		 * Sets the node that comes after the current node to a requested node.
		 * 
		 * @param node The node that is to be set in the next value.
		 */
		public void setNext(LinkedListNode<E> node) {
			next = node;
		}

		/**
		 * Sets the data inside of a LinkedListNode to a specific value.
		 * 
		 * @param data The data that is to be stored in the LinkedListNode
		 */
		public void setElement(E data) {
			this.data = data;
		}

	}

	// The first LinkedListNode in the list which contains no data inside.
	private LinkedListNode<E> front;

	// The last LinkedListNode in the list which contains no data inside.
	private LinkedListNode<E> tail;

	// The number of LinkedListNodes in the list of nodes.
	private int size;

	/**
	 * Constructor for the SinglyLinkedList which contains a series of
	 * LinkedListNodes.
	 */
	public SinglyLinkedList() {
		front = new LinkedListNode<E>(null);
		tail = null;
		size = 0;
	}

	/**
	 * Adds an object into the list at a specific requested location.
	 * 
	 * @param index The location where the object is to be added to.
	 * @param value The object that is to be added to the list.
	 */
	public void add(int index, E value) throws IndexOutOfBoundsException {
		checkIndexForAdd(index);
		if (index == 0) {
			LinkedListNode<E> newNode = null;
			if (size == 0) {
				tail = new LinkedListNode<E>(value, null);
				front.setNext(tail);
			} else {
				newNode = new LinkedListNode<E>(value, front.next);
				front.setNext(newNode);
			}
			size++;
		} else if(index == size && index != 0) {
			addLast(value);
		} else {
			LinkedListNode<E> current = front;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
			LinkedListNode<E> newNode = new LinkedListNode<E>(value);
			newNode.setNext(current.next);
			current.setNext(newNode);
			size++;
		}
	}

	/**
	 * The last object in the list.
	 * 
	 * @return E The object that is held in the last LinkedListNode in the list.
	 */
	@Override
	public E last() {
		return tail.getElement();
	}

	/**
	 * Adds a new LinkedListNode to the end of the list which contains the parameter
	 * object.
	 * 
	 * @param value The value that is to be added to the end of the list.
	 */
	@Override
	public void addLast(E value) {
		LinkedListNode<E> nodes = new LinkedListNode<E>(value, null);
		if (isEmpty()) {
			tail = nodes;
			front.next = tail;
		} else {
			tail.next = nodes;
		}
		tail = nodes;
		size++;
	}

	/**
	 * Initiates the iterator which allows the user to move through the list one by
	 * one.
	 * 
	 * @return ElementIterator() The ElementIterator object which iterates through
	 *         the list.
	 */
	@Override
	public Iterator<E> iterator() {
		return new ElementIterator(front.getNext());
	}

	/**
	 * Returns the current number of objects that are held in the list.
	 * 
	 * @return size The number of objects currently in the list.
	 */
	public int size() {
		return size;
	}

	/**
	 * Finds the LinkedListNode at the requested index location and returns the
	 * object it holds.
	 * 
	 * @param index The location where the requested object is held and returned.
	 * @return E The object that is located at the specific index location.
	 */
	@Override
	public E get(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		if (index == 0) {
			return front.next.data;
		} else if (index == size - 1) {
			return last();
		} else {
			LinkedListNode<E> current = front;
			for (int i = 0; i <= index; i++) {
				current = current.next;
			}
			return current.data;
		}
	}

	/**
	 * Removes an object from the list that is located at the requested index.
	 * 
	 * @param index The location of the of the object to be removed from the list.
	 * @return removedVariable The object that was removed from the list.
	 */
	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		checkIndex(index);
		E removedVariable = null;
		LinkedListNode<E> current = front;
		// if index is 0
		if (index == 0) {
			LinkedListNode<E> valu = front.next;
			removedVariable = valu.data;
			front.next = valu.next;
			size--;
		} else {
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
			removedVariable = current.next.data;
			current.next = current.next.next;
			size--;
		}
		return removedVariable;
	}

	/**
	 * Sets the LinkedListNodes value at a certain index to a requested value.
	 * 
	 * @param index The location where the LinkedListNode is located that should be
	 *              edited.
	 * @param value The object to be added to the LinkedListNode at the index
	 *              location.
	 * @return E The object that was originally located at the requested index
	 *         before the new object was set into it.
	 */
	@Override
	public E set(int index, E value) {
		if (index < 0 || index >= this.size()) {
			throw new IndexOutOfBoundsException();
		}
		LinkedListNode<E> current = front;
		E cData = null;
		for (int i = 0; i <= index; i++) {
			current = current.next;
		}
		cData = current.data;
		current.setElement(value);
		return cData;
	}

	/**
	 * ElementIterator that lets the user iterate through the list.
	 * 
	 * @author Zachary Snowdon
	 * 
	 */
	private class ElementIterator implements Iterator<E> {

		// Keep track of the next node that will be processed
		private LinkedListNode<E> current;

		// Keep track of the node that was processed on the last call to 'next'
		private LinkedListNode<E> prev;

		// Keep track of the previous-previous node that was processed
		// so that we can update 'next' links when removing
		private LinkedListNode<E> prevPrev;

		// Tells the remove() method is the next() method was previously called.
		private boolean removeOK;

		/**
		 * Constructor for the ElementIterator that starts at the parameter node.
		 * 
		 * @param start The node whre the iterator should start at.
		 */
		public ElementIterator(LinkedListNode<E> start) {
			this.current = start;
			this.prev = new LinkedListNode<E>(null, current);
			this.prevPrev = new LinkedListNode<E>(null, prev);
			removeOK = false;
		}

		/**
		 * Finds if the current node has a .next().
		 * 
		 * @return returnVal Weather or not the node has a next value that is not null.
		 */
		public boolean hasNext() {
			if (size == 0) {
				return false;
			} else {
				return current != null;
			}
		}

		/**
		 * Finds what the current values next node is and returns it.
		 * 
		 * @return E The node that comes after the current node.
		 */
		public E next() {
			if (current == null) {
				throw new NoSuchElementException();
			}
			prevPrev = prev;
			prev = current;
			current = current.next;
			removeOK = true;
			return prev.data;
		}

		/**
		 * Removes the node that was previously returned by the next() call.
		 */
		public void remove() {
			if (removeOK) {
				try {
					prevPrev.next = prev.next;
				} catch (NoSuchElementException e) {
					throw new IllegalStateException();
				}
			} else {
				throw new IllegalStateException();
			}
			size--;
			removeOK = false;
		}
	}

}