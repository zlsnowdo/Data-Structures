package edu.ncsu.csc316.dsa.list;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

public class SinglyLinkedListTest {

	@Test
	public void testSinglyLinkedList() {
		SinglyLinkedList<String> lists = new SinglyLinkedList<String>();
		assertEquals(0, lists.size());
	}
	
	@Test
	public void testAdd() {
		SinglyLinkedList<String> lists = new SinglyLinkedList<String>();
		lists.add(0, "zero");
		assertEquals(1, lists.size());
		assertEquals("zero", lists.get(0));
		
		
		lists.add(1, "one");
		assertEquals(2, lists.size());
		assertEquals("one", lists.get(1));
		
		lists.add(1, "newOne");
		assertEquals(3, lists.size());
		assertEquals("newOne", lists.get(1));
		assertEquals("one", lists.get(2));
		
		lists.add(0, "newZero");
		assertEquals(4, lists.size());
		assertEquals("newZero", lists.get(0));
		assertEquals("zero", lists.get(1));
		assertEquals("newOne", lists.get(2));
		assertEquals("one", lists.get(3));
	}
	
	@Test
	public void testAddLast() {
		SinglyLinkedList<String> lists = new SinglyLinkedList<String>();
		
		lists.addLast("zero");
		assertEquals(1, lists.size());
		assertEquals("zero", lists.get(0));
		assertEquals("zero", lists.last());
		
		lists.addLast("one");
		assertEquals(2, lists.size());
		assertEquals("zero", lists.get(0));
		assertEquals("one", lists.get(1));
		assertEquals("one", lists.last());
		
		lists.add(1, "newOne");
		assertEquals(3, lists.size());
		assertEquals("zero", lists.get(0));
		assertEquals("newOne", lists.get(1));
		assertEquals("one", lists.get(2));
		assertEquals("one", lists.last());
		
	}
	
	@Test
	public void testSet() {
		SinglyLinkedList<String> lists = new SinglyLinkedList<String>();
		lists.add(0, "zero");
		lists.add(1, "one");
		lists.add(2, "two");
		lists.add(3, "three");
		lists.add(4, "five");
		assertEquals(5, lists.size());
		
		lists.set(4, "four");
		assertEquals(5, lists.size());
		assertEquals("zero", lists.get(0));
		assertEquals("one", lists.get(1));
		assertEquals("two", lists.get(2));
		assertEquals("three", lists.get(3));
		assertEquals("four", lists.get(4));
		
		lists.set(0, "newZero");
		assertEquals("newZero", lists.get(0));
		assertEquals("one", lists.get(1));
		assertEquals("two", lists.get(2));
		assertEquals("three", lists.get(3));
		assertEquals("four", lists.get(4));
	}
	
	@Test
	public void testIterator() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		
		// Start with an empty list
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
		
		// Create an iterator for the empty list
		Iterator<String> it = list.iterator();
		
		assertFalse(it.hasNext());

		list.addLast("zero");
		assertEquals(1, list.size());
		assertFalse(list.isEmpty());
		assertEquals("zero", list.get(0));
		it = list.iterator();
		assertFalse(it.hasNext());
		
		list.addLast("one");
		assertEquals(2, list.size());
		assertEquals("zero", list.get(0));
		assertEquals("one", list.get(1));
		it = list.iterator();
		assertTrue(it.hasNext());
		assertEquals("one", it.next());
		assertFalse(it.hasNext());
		
		list.addLast("two");
		assertEquals(3, list.size());
		assertEquals("two", list.get(2));
		it = list.iterator();
		assertTrue(it.hasNext());
		assertEquals("one", it.next());
		assertTrue(it.hasNext());
		assertEquals("two", it.next());
		assertFalse(it.hasNext());
		
		list.addLast("three");
		list.addLast("four");
		list.addLast("five");
		it = list.iterator();
		assertTrue(it.hasNext());
		assertEquals("one", it.next());
		assertEquals("two", it.next());
		
		it.remove();
		assertEquals(5, list.size());
		assertEquals("zero", list.get(0));
		assertEquals("one", list.get(1));
		assertEquals("three", list.get(2));
		assertEquals("four", list.get(3));
		assertEquals("five", list.get(4));
		
		assertTrue(it.hasNext());
		assertEquals("three", it.next());
		assertTrue(it.hasNext());
		assertEquals("four", it.next());
		it.remove();
		assertEquals(4, list.size());
		assertEquals("zero", list.get(0));
		assertEquals("one", list.get(1));
		assertEquals("three", list.get(2));
		assertEquals("five", list.get(3));

		
//		// Try different operations to make sure they work
//		// as expected for an empty list (at this point)
//		try{
//			it.remove();
//		} catch(Exception e) {
//			assertTrue(e instanceof IllegalStateException);
//		}
		
		
	}

}
