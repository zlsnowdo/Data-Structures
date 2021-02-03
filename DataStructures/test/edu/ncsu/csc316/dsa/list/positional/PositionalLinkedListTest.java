package edu.ncsu.csc316.dsa.list.positional;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.Position;

public class PositionalLinkedListTest {

	private PositionalList<String> list;
	
	@Before
	public void setUp() {
		list = new PositionalLinkedList<String>();
	}
	
	@Test
	public void testFirst() {
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
		assertNull(list.first());
		
		Position<String> first = list.addFirst("one");
		assertEquals(1, list.size());
		assertEquals(first, list.first());
		first = list.addFirst("newOne");
		assertEquals(2, list.size());
		assertEquals(first, list.first());
		
		//TODO: complete this test case
	}
	
	@Test
	public void testLast() {
		Position<String> first = list.addLast("one");
		assertEquals(1, list.size());
		assertEquals(first, list.last());
		first = list.addLast("two");
		assertEquals(2, list.size());
		assertEquals(first, list.last());
	}
	
	@Test
	public void testAddFirst() {
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
		Position<String> first = list.addFirst("one");
		assertEquals(1, list.size());
		assertFalse(list.isEmpty());
		
		//TODO: complete this test case
	}
	
	@Test
	public void testAddLast() {
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
		Position<String> first = list.addLast("one");
		assertEquals(1, list.size());
		assertEquals(first, list.last());
		//TODO: complete this test case
	}
	
	@Test
	public void testAddBefore() {
        list.addFirst("three");
        list.addFirst("two");
        list.addFirst("one");
        list.addLast("five");
        list.addBefore(list.last(), "four");
        assertEquals("four", list.before(list.last()).getElement());
        
	}
	
	@Test
	public void testAddAfter() {
		Position<String> first = list.addLast("one");
		Position<String> second = list.addAfter(first, "two");
		assertEquals(2, list.size());
		assertEquals(second, list.last());
		assertEquals("two", second.getElement());
		
		list = new PositionalLinkedList<String>();
		
		list.addFirst("three");
		list.addFirst("two");
		list.addFirst("one");
		list.addLast("four");
		list.addAfter(list.last(), "five");
		
	}
	
	
	@Test
	public void testAfter() {
		Position<String> first = list.addLast("one");
		Position<String> second = list.addAfter(first, "two");
		assertEquals(second, list.after(first));
	}

//	@Test
//	public void testSet() {
//		//TODO: complete this test case
//	}
//	
//	@Test
//	public void testRemove() {
//		//TODO: complete this test case
//	}
//	
//	@Test
//	public void testIterator() {
//		//TODO: complete this test case
//		// Use your ArrayBasedList and SinglyLinkedList test cases as a guide
//	}
//	
//	@Test
//	public void testPositions() {
//		assertEquals(0, list.size());
//		Position<String> first = list.addFirst("one");
//		Position<String> second = list.addLast("two");
//		Position<String> third = list.addLast("three");
//		assertEquals(3, list.size());
//		
//		Iterator<Position<String>> it = list.positions().iterator();
//		assertTrue(it.hasNext());
//		assertEquals(first, it.next());
//		assertEquals(second, it.next());
//		assertEquals(third, it.next());
//		
//		//TODO: complete this test case
//	}

}