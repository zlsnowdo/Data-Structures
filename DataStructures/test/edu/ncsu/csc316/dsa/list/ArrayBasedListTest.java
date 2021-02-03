package edu.ncsu.csc316.dsa.list;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class ArrayBasedListTest {

	private List<String> list;

	@Before
	public void setUp() {
		list = new ArrayBasedList<String>();
	}

	@Test
	public void testAddIndex() {
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());

		list.add(0, "one");
		assertEquals(1, list.size());
		assertEquals("one", list.get(0));
		assertFalse(list.isEmpty());
		
		list.add(1, "hello");
		assertEquals(2, list.size());
		assertEquals("one", list.get(0));
		assertEquals("hello", list.get(1));
		
		list.add(0, "first");
		assertEquals(3, list.size());
		assertEquals("first", list.get(0));
		assertEquals("one", list.get(1));
		assertEquals("hello", list.get(2));
		
		list.add(3, "word");
		assertEquals(4, list.size());
		assertEquals("first", list.get(0));
		assertEquals("one", list.get(1));
		assertEquals("hello", list.get(2));
		assertEquals("word", list.get(3));
		
		list.add(6, "last");
		assertEquals(5, list.size());
		assertEquals("first", list.get(0));
		assertEquals("one", list.get(1));
		assertEquals("hello", list.get(2));
		assertEquals("word", list.get(3));
		assertEquals("last", list.get(6));
		
		list.add(4, "four");
		assertEquals(6, list.size());
		assertEquals("first", list.get(0));
		assertEquals("one", list.get(1));
		assertEquals("hello", list.get(2));
		assertEquals("word", list.get(3));
		assertEquals("four", list.get(4));
		assertEquals("last", list.get(6));
		
		list.add(5, "five");
		assertEquals(7, list.size());
		assertEquals("first", list.get(0));
		assertEquals("one", list.get(1));
		assertEquals("hello", list.get(2));
		assertEquals("word", list.get(3));
		assertEquals("four", list.get(4));
		assertEquals("five", list.get(5));
		assertEquals("last", list.get(6));
		
		list.add(1,  "newOne");
		assertEquals(8, list.size());
		assertEquals("first", list.get(0));
		assertEquals("newOne", list.get(1));
		assertEquals("one", list.get(2));
		assertEquals("hello", list.get(3));
		assertEquals("word", list.get(4));
		assertEquals("four", list.get(5));
		assertEquals("five", list.get(6));
		assertEquals("last", list.get(7));
		
		list.add(8, "eight");
		assertEquals(9, list.size());
		assertEquals("eight", list.get(8));
		
		list.add(9, "nine");
		assertEquals(10, list.size());
		assertEquals("nine", list.get(9));
		
		list.add(10, "ten");
		assertEquals(11, list.size());
		assertEquals("first", list.get(0));
		assertEquals("newOne", list.get(1));
		assertEquals("one", list.get(2));
		assertEquals("hello", list.get(3));
		assertEquals("word", list.get(4));
		assertEquals("four", list.get(5));
		assertEquals("five", list.get(6));
		assertEquals("last", list.get(7));
		assertEquals("eight", list.get(8));
		assertEquals("nine", list.get(9));
		assertEquals("ten", list.get(10));
		
		try{
			list.add(15,  "fifteen");
		} catch (Exception e) {
			assertTrue(e instanceof IndexOutOfBoundsException);
		}
		
	}

	@Test
	public void testAddLast() {
		list.add(0, "one");
		list.add(1, "two");
		list.add(2, "three");
		list.add(3, "four");
		list.add(4, "five");
		list.add(5, "six");
		assertEquals(6, list.size());
		list.addLast("last");
		assertEquals(7, list.size());
		assertEquals("last", list.get(6));
	}

	@Test
	public void testLast() {
		list.add(0, "one");
		assertEquals("one", list.last());
		list.add(1, "two");
		assertEquals("two", list.last());
		list.add(2, "three");
		assertEquals("three", list.last());
		list.add(3, "four");
		assertEquals("four", list.last());

	}

	@Test
	public void testAddFirst() {
		list.add(0, "one");
		list.add(1, "two");
		list.add(2, "three");
		list.add(3, "four");
		list.add(4, "five");
		list.add(5, "six");
		list.addFirst("First");
		assertEquals(7, list.size());
		assertEquals("First", list.get(0));
		assertEquals("one", list.get(1));
		assertEquals("six", list.get(6));
	}

	@Test
	public void testFirst() {
		list.add(0, "one");
		assertEquals("one", list.first());
		list.add(1, "two");
		list.add(2, "three");
		list.add(3, "four");
		list.add(4, "five");
		list.add(5, "six");
		assertEquals("one", list.first());
	}

	@Test
	public void testIterator() {
		// Start with an empty list
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
		
		// Create an iterator for the empty list
		Iterator<String> it = list.iterator();
		
		// Try different operations to make sure they work
		// as expected for an empty list (at this point)
		try{
			it.remove();
		} catch(Exception e) {
			assertTrue(e instanceof IllegalStateException);
		}
		assertFalse(it.hasNext());

		// Now add an element
		list.addLast("one");
		
		// Use accessor methods to check that the list is correct
		assertEquals(1, list.size());
		assertFalse(list.isEmpty());
		assertEquals("one", list.get(0));
		
		// Create an iterator for the list that has 1 element
		it = list.iterator();
		
		// Try different iterator operations to make sure they work
		// as expected for a list that contains 1 element (at this point)
		assertTrue(it.hasNext());
		assertEquals("one", it.next());
		assertFalse(it.hasNext());
		
		list.addLast("two");
		list.addLast("three");
		list.addLast("four");
		
		it = list.iterator();
		
		assertTrue(it.hasNext());
		assertEquals("one", it.next());
		assertTrue(it.hasNext());
		assertEquals("two", it.next());
		assertTrue(it.hasNext());
		assertEquals("three", it.next());
		assertTrue(it.hasNext());
		assertEquals("four", it.next());
		assertFalse(it.hasNext());
		it.remove();	
		assertEquals(3, list.size());
		assertEquals("one", list.get(0));
		assertEquals("two", list.get(1));
		assertEquals("three", list.get(2));
		assertEquals(null, list.get(3));
		
		it = list.iterator();
		assertTrue(it.hasNext());
		assertEquals("one", it.next());
		it.remove();
		assertEquals(2, list.size());
		assertEquals("two", list.get(0));
		assertEquals("three", list.get(1));
		it.remove();
		assertEquals(2, list.size());
		assertEquals("two", list.get(0));
		assertEquals("three", list.get(1));
		
		try{
			it.next();
		} catch(Exception e) {
			assertTrue(e instanceof NoSuchElementException);
		}

		//TODO: continue this test case
	}

	@Test
	public void testRemoveIndex() {
		list.add(0, "one");
		list.add(1, "two");
		list.add(2, "three");
		list.add(3, "four");
		list.add(4, "five");
		list.add(5, "six");
		assertEquals(6, list.size());
		
		list.remove(5);
		assertEquals(5, list.size());
		assertEquals("one", list.get(0));
		assertEquals("two", list.get(1));
		assertEquals("three", list.get(2));
		assertEquals("four", list.get(3));
		assertEquals("five", list.get(4));
		assertEquals(null, list.get(5));
		
		list.remove(0);
		assertEquals(4, list.size());
		assertEquals("two", list.get(0));
		assertEquals("three", list.get(1));
		assertEquals("four", list.get(2));
		assertEquals("five", list.get(3));
		assertEquals(null, list.get(4));
		
	}

	@Test
	public void testRemoveFirst() {
		list.add(0, "one");
		list.add(1, "two");
		list.add(2, "three");
		list.add(3, "four");
		list.add(4, "five");
		list.add(5, "six");
		list.removeFirst();
		assertEquals("two", list.get(0));
		assertEquals(5, list.size());
	}

	@Test
	public void testRemoveLast() {
		list.add(0, "one");
		list.add(1, "two");
		list.add(2, "three");
		list.add(3, "four");
		list.add(4, "five");
		list.add(5, "six");
		list.removeLast();
		assertEquals(null, list.get(5));
		assertEquals(5, list.size());
	}

	@Test
	public void testSet() {
		list.add(0, "one");
		list.add(1, "two");
		list.add(2, "three");
		list.add(3, "four");
		list.add(4, "five");
		list.add(5, "six");
		list.set(2, "newThree");
		assertEquals(6, list.size());
		assertEquals("newThree", list.get(2));
	}
}