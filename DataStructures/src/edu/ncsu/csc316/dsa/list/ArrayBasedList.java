package edu.ncsu.csc316.dsa.list;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayBasedList<E> extends AbstractList<E> {

	private final static int DEFAULT_CAPACITY = 10;
	
	private E[] data;

	private int size;

	public ArrayBasedList() {
		this(DEFAULT_CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public ArrayBasedList(int capacity) {
		data = (E[]) (new Object[capacity]);
		size = 0;
	}

	@Override
	public void add(int index, E value) {
		ensureCapacity(index + 1);
		int number = size;
		for(int i = number; i > index; i--) {
			if(data[i - 1] != null) {
				data[i] = data[i - 1];
			}
		}
		data[index] = value;
		size++;
	}
	
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

	@Override
	public E get(int index) {
		return data[index];
	}

	@Override
	public E remove(int index) {
		E removedE = data[index];
		if(index == size() - 1) {
			data[index] = null;
		} else {
			for(int i = index; i < size(); i++) {
				data[i] = data[i + 1];
			}
		}
		size--;
		return removedE;
	}

	@Override
	public E set(int index, E value) {
		E removedE = data[index];
		data[index] = value;
		return removedE;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Iterator<E> iterator() {
		return new ElementIterator();
	}
	
	private class ElementIterator implements Iterator<E> {
		
	    private int position;
	    
	    private boolean removeOK;

	    public ElementIterator() {
	        position = 0;
	        removeOK = false;
	    }

	    public boolean hasNext() {
	    	boolean returnVal = true;
	    	if(data[position] == null) {
	    		returnVal = false;
	    	}
	        return returnVal;
	    }

	    public E next() {
	    	E nextVal = data[position];
	    	position++;
	    	removeOK = true;
	        return nextVal;
	    }
	        
	    public void remove() {
	    	if(removeOK) {
	    		int pos = position - 1;
		        if(pos == size() - 1) {
		        	data[pos] = null;
		        } else {
		        	for(int i = pos; i < size(); i++) {
						data[i] = data[i + 1];
					}
		        }
		        size--;
		        removeOK = false;
	    	}
	    }
	}
	
}