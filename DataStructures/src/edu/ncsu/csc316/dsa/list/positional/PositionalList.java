package edu.ncsu.csc316.dsa.list.positional;

import edu.ncsu.csc316.dsa.Position;

/**
 * Interface used by PositonalLinkedList that helps import certain
 * functionalities to Position items.
 * 
 * @author Zachary Snowdon
 *
 * @param <E> Generic type of objects that are held in the lists.
 */
public interface PositionalList<E> extends Iterable<E> {

	/**
	 * Adds an object after a given position object and returns the position object
	 * with the new object in it.
	 * 
	 * @param p     The position that is going to be before the inserted object.
	 * @param value The object that is going to be inserted after the given position
	 *              object.
	 * @return Position<E> The new position object with the parameter object in it.
	 */
	Position<E> addAfter(Position<E> p, E value);

	/**
	 * Adds an object before a given position object and returns the position object
	 * with the new object in it.
	 * 
	 * @param p     The position that is going to be after the inserted object.
	 * @param value The object that is going to be inserted before the given
	 *              position object.
	 * @return Position<E> The new position object with the parameter object in it.
	 */
	Position<E> addBefore(Position<E> p, E value);

	/**
	 * Adds a new position with an object in it to the very front of the list.
	 * 
	 * @param value The object to be added to the very front of the list.
	 * @return Position<E> The position object with the parameter object in it.
	 */
	Position<E> addFirst(E value);

	/**
	 * Adds a new position with an object in it to the very end of the list.
	 * 
	 * @param value The object to be added to the very end of the list.
	 * @return Position<E> The position object with the parameter object in it.
	 */
	Position<E> addLast(E value);

	/**
	 * Adds an position object after another position object.
	 * 
	 * @param p The object that is to be added after the given position.
	 * @return Position<E> The position that is going to come after the parameter
	 *         position.
	 */
	Position<E> after(Position<E> p);

	/**
	 * Adds an position object after another position object.
	 * 
	 * @param p The object that is to be added after the given position.
	 * @return Position<E> The position that is going to come before the parameter
	 *         position.
	 */
	Position<E> before(Position<E> p);

	/**
	 * Returns the very first position object in the list.
	 * 
	 * @return Position<E> The first position object in the list.
	 */
	Position<E> first();

	/**
	 * Tells weather or not the list has any object or not.
	 * 
	 * @return Weather or not the list has anything in it.
	 */
	boolean isEmpty();

	/**
	 * Returns the last position object in the list.
	 * 
	 * @return Position<E> The position object that is at the very end of the list.
	 */
	Position<E> last();

	/**
	 * Initiates the positions iterable which allows the user to iterate through the
	 * position.
	 * 
	 * @return Iterable<Position<E>> The iterable which allow the user to iterate
	 *         through positions.
	 */
	Iterable<Position<E>> positions();

	/**
	 * Removes a position object from the list of positions.
	 * 
	 * @param p The position object that is to be removed from the list
	 * @return E The object that was held in the position node that was removed.
	 */
	E remove(Position<E> p);

	/**
	 * Sets a position object to a specific location index in the list.
	 * 
	 * @param p     The position object that is to be added to the list.
	 * @param value The index location where the position is to be added in the
	 *              list.
	 * @return E the object that was removed from the list.
	 */
	E set(Position<E> p, E value);

	/**
	 * Returns how many objects are currently in the list.
	 * 
	 * @return The number of objects in the list currently.
	 */
	int size();
}