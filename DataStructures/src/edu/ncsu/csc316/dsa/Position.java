package edu.ncsu.csc316.dsa;

/**
 * Interface which holds the data in a node at a specific position.
 * 
 * @author Zachary Snowdon
 *
 * @param <E> A position object which is a node for a specific object.
 */
public interface Position<E> {
	/**
	 * Returns the data at a specific position node in a list.
	 * 
	 * @return The object that is held in the position object.
	 */
	E getElement();
}