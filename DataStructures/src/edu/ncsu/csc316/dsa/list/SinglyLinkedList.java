package edu.ncsu.csc316.dsa.list;

import java.util.Iterator;

public class SinglyLinkedList<E> extends AbstractList<E>{
	
	private static class LinkedListNode<E> {
		
		private E data;
		
		private LinkedListNode<E> next;
		
		public LinkedListNode(E list) {
			this(list, null);
		}
		
		public LinkedListNode(E list, LinkedListNode<E> node) {
			this.data = list;
			this.next = node;
		}
		
		public LinkedListNode<E> getNext() {
			return next;
		}
		
		public E getElement() {
			return data;
		}
		
		public void setNext(LinkedListNode<E> node) {
			next = node;
		}
		
		public void setElement(E data) {
			this.data = data;
		}
		
	}

	private LinkedListNode<E> front;
	
	private LinkedListNode<E> tail;
	
	private int size;
		
	public SinglyLinkedList() {
		front = new LinkedListNode<E>(null);
		tail = null;
		size = 0;
	}
	
	public void add(int index, E value) {
		if(index == 0) {
			front = new LinkedListNode<E>(value, front);
		} else {
			LinkedListNode<E> current = front;
			for(int i = 0; i < index - 1; i++) {
				current = current.getNext();
			}
			current.next = new LinkedListNode<E>(value, current.next);
		}
		size++;
	}
	
	@Override
	public E last() {
		return tail.getElement();
	}
	
	@Override
	public void addLast(E value) {
		LinkedListNode<E> nodes = new LinkedListNode<E>(value, null);
		if(size() == 0) {
			front = nodes;
		} else {
			tail.setNext(nodes);
		}
		tail = nodes;
		size++;
	}
	
	@Override
	public Iterator<E> iterator() {
		return new ElementIterator(front.getNext());
	}
	
	public int size() {
		return size;
	}
	
	@Override
	public E get(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		LinkedListNode<E> current = front;
		for (int i = 0; i < this.size(); i++) {
			if (i == index) {
				return current.data;
			}
			current = current.getNext();
		}
		return null;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E set(int index, E value) {
		if (index < 0 || index >= this.size()) {
			throw new IndexOutOfBoundsException();
		}
		LinkedListNode<E> current = front;
		E cData = null;
		for (int i = 0; i < size; i++) {
			if (i == index) {
				cData = current.data;
				current.setElement(value);;
				return cData;
			}
			current = current.next;
		}
		return cData;
	}
	
	private class ElementIterator implements Iterator<E> {
		
	    // Keep track of the next node that will be processed
	    private LinkedListNode<E> current;
	    
	    // Keep track of the node that was processed on the last call to 'next'
	    private LinkedListNode<E> prev;
	    
	    // Keep track of the previous-previous node that was processed
	    // so that we can update 'next' links when removing
	    private LinkedListNode<E> prevPrev;
	    
	    private boolean removeOK;

	    public ElementIterator(LinkedListNode<E> start) {
	        this.prev = null;
	        this.prevPrev = null;
	        this.current = start;
	        removeOK = false;
	    }

	    public boolean hasNext() {
	    	boolean returnVal = true;
	    	if(current == null) {
	    		returnVal = false;
	    	}
	        return returnVal;
	    }

	    public E next() {
            prevPrev = prev;
            prev = current;
            current = current.getNext();
            removeOK = true;
	        return prev.data;
	    }
	        
	    public void remove() {
	        if(removeOK) {
	        	prevPrev.next = prev.next;
	        }
	        size--;
	        removeOK = false;
	    }
	}
	
}