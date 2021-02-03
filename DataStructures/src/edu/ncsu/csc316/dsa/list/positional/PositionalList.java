package edu.ncsu.csc316.dsa.list.positional;

import edu.ncsu.csc316.dsa.Position;

public interface PositionalList<E> extends Iterable<E> {
	
	Position<E> addAfter(Position<E> p, E value);
	Position<E> addBefore(Position<E> p, E value);
	Position<E> addFirst(E value);
	Position<E> addLast(E value);
	Position<E> after(Position<E> p);
	Position<E> before(Position<E> p);
	Position<E> first();
	boolean isEmpty();
	Position<E> last();
	Iterable<Position<E>> positions();
	E remove(Position<E> p);
	E set(Position<E> p, E value);
	int size();
}