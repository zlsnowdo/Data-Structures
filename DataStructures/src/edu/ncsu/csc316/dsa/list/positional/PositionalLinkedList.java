package edu.ncsu.csc316.dsa.list.positional;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.ncsu.csc316.dsa.Position;

/**
 * Implements a positional linked list with provides easy access to nodes.
 * Received help from the textbook page 281 with the iterator.
 * 
 * @author Zachary Snowdon
 *
 * @param <E> Generic type of objects that are added to the list
 */
public class PositionalLinkedList<E> implements PositionalList<E> {

	// A PositionalNode with represents the null dummy node at the start of the list
	// with points to the first object.
	private PositionalNode<E> front;

	// A positional node with null data and no next. It is the last node at the end
	// of
	// the list. The previous value is the last data in the list.
	private PositionalNode<E> tail;

	// Integer which holds the total number of objects in the list.
	private int size;

	/**
	 * Initiates the PositionalLinkedList with a head and tail node.
	 */
	public PositionalLinkedList() {
		front = new PositionalNode<E>(null);
		tail = new PositionalNode<E>(null, null, front);
		front.setNext(tail);
		size = 0;
	}

	/**
	 * Creates a new node that contains the parameter object, then places this node
	 * between two nodes that are passed in from the method call.
	 * 
	 * @param value The object that is to be added in between the two nodes in the
	 *              list.
	 * @param next  The node that is going to be the .next value for the node that
	 *              will be created.
	 * @param prev  The node that is going to be the .previous value for the node
	 *              that will be created.
	 * @return newNode The new node that was created that contains the new object
	 *         and points to the next and previous nodes.
	 */
	private Position<E> addBetween(E value, PositionalNode<E> next, PositionalNode<E> prev) {
		PositionalNode<E> newNode = new PositionalNode<E>(value, next, prev);
		prev.next = newNode;
		next.previous = newNode;
		return newNode;
	}

	/**
	 * Method that returns how many objects are held in the list.
	 * 
	 * @return size The total number of objects in the list.
	 */
	public int size() {
		return size;
	}

	/**
	 * Creates a new node and places a new object at the very front of the list.
	 * 
	 * @param value The object that is to be added to the front of the list.
	 * @return newNode The position of where the object was placed.
	 */
	public Position<E> addFirst(E value) {
		Position<E> newNode = addBetween(value, front.next, front);
		size++;
		return newNode;
	}

	/**
	 * Creates a new node and places a new object at the very end of the list.
	 * 
	 * @param value The object that is to be added to the end of the list.
	 * @return newNode The position of where the object was placed.
	 */
	public Position<E> addLast(E value) {
		Position<E> newNode = addBetween(value, tail, tail.previous);
		size++;
		return newNode;
	}

	/**
	 * Adds a new object to the list after a node that is passed in from the method
	 * call.
	 * 
	 * @param p     The position node that the new object is to be added after.
	 * @param value The object that is to be added after the node that was passed in
	 *              from the method call.
	 * @return newNode The position of where the new node is which holds the new
	 *         object.
	 */
	@Override
	public Position<E> addAfter(Position<E> p, E value) {
		PositionalNode<E> convert = validate(p);
		Position<E> newNode = addBetween(value, convert.next, convert);
		size++;
		return newNode;
	}

	/**
	 * Adds a new object to the list before a node that is passed in from the method
	 * call.
	 * 
	 * @param p     The position node that the new object is to be added before.
	 * @param value The object that is to be added before the node that was passed
	 *              in from the method call.
	 * @return newNode The position of where the new node is which holds the new
	 *         object.
	 */
	@Override
	public Position<E> addBefore(Position<E> p, E value) {
		PositionalNode<E> convert = validate(p);
		Position<E> newNode = addBetween(value, convert, convert.previous);
		size++;
		return newNode;
	}

	/**
	 * Takes an input node and finds the node that comes directly after it.
	 * 
	 * @param p The node that is inputed to find the node that comes directly after
	 *          it.
	 * @return returnVal The node that comes directly after the passed in node.
	 */
	public Position<E> after(Position<E> p) {
		PositionalNode<E> convert = validate(p);
		if (convert.next != tail) {
			return convert.next;
		} else {
			return null;
		}
	}

	/**
	 * Takes an input node and finds the node that comes directly before it.
	 * 
	 * @param p The node that is inputed to find the node that comes directly before
	 *          it.
	 * @return returnVal The node that comes directly before the passed in node.
	 */
	@Override
	public Position<E> before(Position<E> p) {
		PositionalNode<E> convert = validate(p);
		if (convert.previous != front) {
			return convert.previous;
		} else {
			return null;
		}

	}

	/**
	 * Finds the very first node that is held in the list and returns it.
	 * 
	 * @return returnVal The node that is held at the very front of the list.
	 */
	@Override
	public Position<E> first() {
		Position<E> returnVal = null;
		if (size > 0) {
			returnVal = front.next;
		}
		return returnVal;
	}

	/**
	 * Finds the very last node that is held in the list and returns it.
	 * 
	 * @return returnVal The node that is held at the very front of the list.
	 */
	@Override
	public Position<E> last() {
		Position<E> returnVal = null;
		if (size > 0) {
			returnVal = tail.previous;
		}
		return returnVal;
	}

	/**
	 * Method that tests to see if the list has any objects held in it.
	 * 
	 * @return returnVal Weather or not the list has any objects in it.
	 */
	@Override
	public boolean isEmpty() {
		boolean returnVal = false;
		if (size == 0) {
			return true;
		}
		return returnVal;
	}

	/**
	 * Method that sets the object in a specific node to an object that is passed in
	 * from the method call.
	 * 
	 * @param p     The node that is to be edited to add the new object in it.
	 * @param value The object that is to be set to a specific node in the list.
	 * @return returnVal The object that was previously held in the list before the
	 *         new object was added into that node.
	 */
	@Override
	public E set(Position<E> p, E value) {
		PositionalNode<E> convert = validate(p);
		E returnVal = convert.getElement();
		convert.setElement(value);
		return returnVal;
	}

	/**
	 * Removes a node from the list that was passed in from the method call and
	 * returns the object that the node held.
	 * 
	 * @param p The node that is to be removed from the list.
	 * @return convert.getElement() The object that was held in the node.
	 */
	@Override
	public E remove(Position<E> p) {
		PositionalNode<E> convert = validate(p);
		convert.previous.next = convert.next;
		convert.next.previous = convert.getPrevious();
		size--;
		return convert.getElement();
	}

	/**
	 * Method that confirms that the position object is of the PositionalNode type.
	 * 
	 * @param p The position object that is to be tested to see if it is a
	 *          PositionalNode.
	 * @return PositionalNode The position object that is set to the PositionalNode
	 *         type.
	 * @throws IllegalArgumentException if the position object is not of
	 *                                  PositionalNode type.
	 */
	private PositionalNode<E> validate(Position<E> p) {
		if (p instanceof PositionalNode) {
			return (PositionalNode<E>) p;
		}
		throw new IllegalArgumentException("Position is not a valid positional list node.");
	}

	/**
	 * Method that initiates the ElementIterator to allow the user to iterate or
	 * move through the list.
	 * 
	 * @return ElementIterator The ElementIterator object that allows the iteration
	 *         through the list.
	 */
	@Override
	public Iterator<E> iterator() {
		return new ElementIterator(front.getNext());
	}

	/**
	 * Initiates the positions iterable for position objects which creates an
	 * iterable.
	 * 
	 * @return PositionIterable() The Iterable<Position<E>> that was created from
	 *         the PositionIterable() class.
	 */
	@Override
	public Iterable<Position<E>> positions() {
		return new PositionIterable();
	}

	/**
	 * Class which initiates the iterator that lets the user iterate through
	 * position objects in the list.
	 * 
	 * @author Zachary Snowdon
	 * 
	 */
	private class PositionIterable implements Iterable<Position<E>> {

		/**
		 * Initiates the iterator to let the user iterate through the list.
		 * 
		 * @return PositionIterator(front.getNext()) The position iterator that is
		 *         initiated.
		 */
		@Override
		public Iterator<Position<E>> iterator() {
			return new PositionIterator(front.getNext());
		}
	}

	/**
	 * Class which allows the user to iterator or move through a list of nodes.
	 * 
	 * @author Zachary Snowdon
	 * 
	 */
	private class PositionIterator implements Iterator<Position<E>> {

		// The position node that is the current node being iterated in the list.
		private Position<E> current;

		// The position of the last position that was called from .next()
		private Position<E> nodePrev;

		// Weather or not the next() method was previously called so that the remove()
		// method can be called.
		private boolean removeOK;

		/**
		 * Constructs the position iterator which sets the current node the the start
		 * PositionalNode.
		 * 
		 * @param start The first node in the list where the iteration starts.
		 */
		public PositionIterator(PositionalNode<E> start) {
			this.current = start;
			this.nodePrev = null;
			removeOK = false;
		}

		/**
		 * Weather or not the current node has a node after it.
		 * 
		 * @return boolean Weather or not the current node has a node after it.
		 */
		@Override
		public boolean hasNext() {
			if (size == 0) {
				return false;
			} else {
				return current != null;
			}
		}

		/**
		 * Takes the current node in the iterator, and returns the node that comes after
		 * it.
		 * 
		 * @return after(current) The position of the node that comes directly after it.
		 * @throws NoSuchElementException if the current object is null meaning there is
		 *                                not next object.
		 */
		@Override
		public Position<E> next() throws NoSuchElementException {
			if (current == null) {
				throw new NoSuchElementException();
			}
			nodePrev = current;
			current = after(current);
			removeOK = true;
			return nodePrev;
		}

		/**
		 * Method that removes the node that was previously called from the next() call
		 * from the list.
		 * 
		 * @throws IllegalStateException if the next() method was not previously called.
		 */
		@Override
		public void remove() throws IllegalStateException {
			if (removeOK) {
				if (current == tail && size > 0) {
					current = tail.previous;
				}
				PositionalLinkedList.this.remove(nodePrev);
			} else {
				throw new IllegalStateException();
			}
			removeOK = false;
		}
	}

	/**
	 * Class which allows the user to iterator or move through a list of objects.
	 * 
	 * @author Zachary Snowdon
	 * 
	 */
	private class ElementIterator implements Iterator<E> {

		// The iterator that is initiated to iterate through the list of nodes to get
		// the objects.
		private Iterator<Position<E>> it;

		/**
		 * The constructor for the ElementIterator which starts the PositionIterator to
		 * iterate through the objects to get the elements.
		 * 
		 * @param start The first PositionalNode in the list.
		 */
		public ElementIterator(PositionalNode<E> start) {
			it = new PositionIterator(start);
		}

		/**
		 * Weather or not the current node has a node after it.
		 */
		@Override
		public boolean hasNext() {
			return it.hasNext();
		}

		/**
		 * Returns the element that is held in the node that comes after the current
		 * node.
		 * 
		 * @return it.next().getElement() The element that is held in the node that
		 *         comes after the current.
		 */
		@Override
		public E next() {
			return it.next().getElement();
		}

		/**
		 * Removes the node that was previously called for the .next() method.
		 */
		@Override
		public void remove() {
			it.remove();
		}
	}

	/**
	 * Constructs the PositionalNodes which will be used as the nodes in the linked
	 * list.
	 * 
	 * @author Zachary Snowdon
	 *
	 * @param <E> Generic type of the objects that will be held in the nodes.
	 */
	private static class PositionalNode<E> implements Position<E> {

		// The object that is held in the current PositionalNode
		private E element;

		// The node that comes after the current node in the list.
		private PositionalNode<E> next;

		// The node that comes before the current node in the list.
		private PositionalNode<E> previous;

		/**
		 * Constructor for the PositionalNode which adds an object to the node, but does
		 * not have a .next() node which comes after it.
		 * 
		 * @param value value The object that is to be added to the positional node.
		 */
		public PositionalNode(E value) {
			this(value, null);
		}

		/**
		 * Constructor for the positional node which adds an object to the node, and a
		 * node that comes after it, but no previous node.
		 * 
		 * @param value The object that is to be added to the node.
		 * @param next  The node that is going to come after the node that is
		 *              constructed here.
		 */
		public PositionalNode(E value, PositionalNode<E> next) {
			this(value, next, null);
		}

		/**
		 * Constructor for the positional node which adds an object to the node, a node
		 * that comes after it, and a node that comes before it.
		 * 
		 * @param value The object that is to be added to the node.
		 * @param next  The node that is going to come after the node that is
		 *              constructed here.
		 * @param prev  The node that is going to come before the node that is
		 *              constructed here.
		 */
		public PositionalNode(E value, PositionalNode<E> next, PositionalNode<E> prev) {
			setElement(value);
			setNext(next);
			setPrevious(prev);
		}

		/**
		 * Sets the node that comes before the current node to a specific node.
		 * 
		 * @param prev The node that is going to come before the node that is currently
		 *             being used.
		 */
		public void setPrevious(PositionalNode<E> prev) {
			previous = prev;
		}

		/**
		 * Gets the node that comes directly before the current node.
		 * 
		 * @return previous The node that comes directly before the current node.
		 */
		public PositionalNode<E> getPrevious() {
			return previous;
		}

		/**
		 * Sets the node that comes directly after the current node to a specific node.
		 * 
		 * @param next The node that is going to come directly after the node that is
		 *             currently being used.
		 */
		public void setNext(PositionalNode<E> next) {
			this.next = next;
		}

		/**
		 * Gets the node that comes directly after the current node.
		 * 
		 * @return next The node that comes directly after the current node.
		 */
		public PositionalNode<E> getNext() {
			return next;
		}

		/**
		 * Gets the object that the current node holds.
		 * 
		 * @return element The data/object that the node being currently used holds.
		 */
		@Override
		public E getElement() {
			return element;
		}

		/**
		 * Sets an object to the node that is currently being used.
		 * 
		 * @param element The element that is to be added to the current node.
		 */
		public void setElement(E element) {
			this.element = element;
		}
	}
}