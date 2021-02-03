package edu.ncsu.csc316.dsa.list;

public interface List<E> extends Iterable<E> {
	
    void add(int index, E value);
    
    void addFirst(E value);
    
    void addLast(E value);
    
    E first();
    
    E get(int index);
    
    boolean isEmpty();
    
    E last();
    
    E remove(int index);
    
    E removeFirst();
    
    E removeLast();
    
    E set(int index, E value);
    
    int size();
    
}