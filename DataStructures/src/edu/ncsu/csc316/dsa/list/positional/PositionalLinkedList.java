package edu.ncsu.csc316.dsa.list.positional;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.ncsu.csc316.dsa.Position;

public class PositionalLinkedList<E> implements PositionalList<E> {

	private PositionalNode<E> front;
	private PositionalNode<E> tail;
	private int size;

	public PositionalLinkedList() {
		front = new PositionalNode<E>(null);
		tail = new PositionalNode<E>(null, null, front);
		front.setNext(tail);
		size = 0;
	}

	//TODO: Complete this class
	
	private Position<E> addBetween(E value, PositionalNode<E> next, PositionalNode<E> prev) {
		PositionalNode<E> newNode = new PositionalNode<E>(value, next, prev);
		prev.next = newNode;
		next.previous = newNode;
        return newNode;
    }
	
	public int size() {
		return size;
	}
	
	public Position<E> addFirst(E value) {
		Position<E> newNode = addBetween(value, front.next, front);
		size++;
		return newNode;
	}
	
	public Position<E> addLast(E value) {
		Position<E> newNode = addBetween(value, tail, tail.previous);;
		size++;
		return newNode;
	}
	
	@Override
	public Position<E> addAfter(Position<E> p, E value) {
		PositionalNode<E> convert = validate(p);
		Position<E> newNode = addBetween(value, convert.next, convert);
		size++;
		return newNode;
	}
	
	@Override
	public Position<E> addBefore(Position<E> p, E value) {
		PositionalNode<E> convert = validate(p);
		Position<E> newNode = addBetween(value, convert, convert.previous);
		size++;
		return newNode;
	}
	
	public Position<E> after(Position<E> p) {
		PositionalNode<E> convert = validate(p);
		Position<E> returnVal = null;
		if(convert.next != null) {
			returnVal = convert.next;
		}
		return returnVal;
	}

	@Override
	public Position<E> before(Position<E> p) {
		PositionalNode<E> convert = validate(p);
		Position<E> returnVal = null;
		if(convert.previous != null) {
			returnVal = convert.previous;
		}
		return returnVal;
	}
	
	@Override
	public Position<E> first() {
		Position<E> returnVal = null;
		if(size > 0) {
			returnVal = front.next;
		}
		return returnVal;
	}
	
	@Override
	public Position<E> last() {
		Position<E> returnVal = null;
		if(size > 0) {
			returnVal = tail.previous;
		}
		return returnVal;
	}
	
	@Override
	public boolean isEmpty() {
		boolean returnVal = false;
		if(size == 0) {
			return true;
		}
		return returnVal;
	}
	
	@Override
	public E set(Position<E> p, E value) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	private PositionalNode<E> validate(Position<E> p) {
        if (p instanceof PositionalNode) {
            return (PositionalNode<E>) p;
        }
        throw new IllegalArgumentException("Position is not a valid positional list node.");
    }

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Position<E>> positions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove(Position<E> p) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private static class PositionalNode<E> implements Position<E> {

        private E element;
        private PositionalNode<E> next;
        private PositionalNode<E> previous;

        public PositionalNode(E value) {
            this(value, null);
        }

        public PositionalNode(E value, PositionalNode<E> next) {
            this(value, next, null);
        }

        public PositionalNode(E value, PositionalNode<E> next, PositionalNode<E> prev) {
            setElement(value);
            setNext(next);
            setPrevious(prev);
        }

        public void setPrevious(PositionalNode<E> prev) {
            previous = prev;
        }

        public PositionalNode<E> getPrevious() {
            return previous;
        }
        
        public void setNext(PositionalNode<E> next) {
            this.next = next;
        }

        public PositionalNode<E> getNext() {
            return next;
        }

        @Override
        public E getElement() {
            return element;
        }
        
        public void setElement(E element) {
            this.element = element;
        }
    }
}