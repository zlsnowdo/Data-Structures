package edu.ncsu.csc316.dsa.list;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

/**
 * Tests to make sure that SinglyLinkedLists functionalities all work correctly.
 * 
 * @author Zachary Snowdon
 *
 */
public class SinglyLinkedListTest {

	/**
	 * Tests the functionality that initiates the SinglyLinkedList to make sure that
	 * it holds no value at the start.
	 */
	@Test
	public void testSinglyLinkedList() {
		SinglyLinkedList<String> lists = new SinglyLinkedList<String>();
		assertEquals(0, lists.size());
		assertTrue(lists.isEmpty());
	}

	/**
	 * Tests the programs ability to add an object to a specific spot in the list.
	 */
	@Test
	public void testAdd() {
		SinglyLinkedList<String> lists = new SinglyLinkedList<String>();
		lists.add(0, "one");
		assertEquals(1, lists.size());
		assertEquals("one", lists.get(0));

		lists.add(0, "zero");
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

		lists.add(0, "newZero");
		assertEquals(4, lists.size());
		assertEquals("newZero", lists.first());
		assertEquals("newZero", lists.get(0));
		assertEquals("zero", lists.get(1));
		assertEquals("newOne", lists.get(2));
		assertEquals("one", lists.get(3));
		assertEquals("one", lists.last());

		lists.add(3, "prev");
		assertEquals(5, lists.size());
		assertEquals("newZero", lists.get(0));
		assertEquals("zero", lists.get(1));
		assertEquals("newOne", lists.get(2));
		assertEquals("prev", lists.get(3));
		assertEquals("one", lists.get(4));
		assertEquals("one", lists.last());

		lists.addLast("final");
		assertEquals(6, lists.size());

		try {
			lists.add(7, "fail");
			fail();
		} catch (Exception e) {
			assertTrue(e instanceof IndexOutOfBoundsException);
		}
		
		lists = new SinglyLinkedList<String>();
		lists.add(0, "zero");
		assertEquals("zero", lists.get(0));
		lists.add(1, "one");
		assertEquals("one", lists.get(1));
	}

	/**
	 * Tests the programs ability to add a new object to the very last spot in the
	 * list.
	 */
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

		lists.addLast("newOne");
		assertEquals(3, lists.size());
		assertEquals("zero", lists.get(0));
		assertEquals("one", lists.get(1));
		assertEquals("newOne", lists.get(2));

		lists.add(1, "afterZ");
		assertEquals(4, lists.size());
		assertEquals("zero", lists.get(0));
		assertEquals("afterZ", lists.get(1));
		assertEquals("one", lists.get(2));
		assertEquals("newOne", lists.get(3));

		lists.addLast("final");
		assertEquals(5, lists.size());
		assertEquals("zero", lists.get(0));
		assertEquals("afterZ", lists.get(1));
		assertEquals("one", lists.get(2));
		assertEquals("newOne", lists.get(3));
		assertEquals("final", lists.get(4));
		assertEquals("final", lists.last());
	}

	/**
	 * Tests the programs ability to set an object to a specific location in the
	 * list which will replace the object that is currently at that index.
	 */
	@Test
	public void testSet() {
		SinglyLinkedList<String> lists = new SinglyLinkedList<String>();
		lists.addLast("zero");
		lists.addLast("one");
		lists.addLast("two");
		lists.addLast("three");
		lists.addLast("five");
		assertEquals(5, lists.size());
		assertEquals("zero", lists.get(0));
		assertEquals("one", lists.get(1));
		assertEquals("two", lists.get(2));
		assertEquals("three", lists.get(3));
		assertEquals("five", lists.get(4));

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

	/**
	 * Tests the programs ability to remove an object from the list at a specific
	 * location.
	 */
	@Test
	public void testRemove() {
		SinglyLinkedList<String> lists = new SinglyLinkedList<String>();
		lists.addLast("zero");
		lists.addLast("one");
		lists.addLast("two");
		lists.addLast("three");
		lists.addLast("four");

		lists.remove(0);
		assertEquals(4, lists.size());
		assertEquals("one", lists.get(0));
		assertEquals("two", lists.get(1));
		assertEquals("three", lists.get(2));
		assertEquals("four", lists.get(3));

		lists.remove(2);
		assertEquals(3, lists.size());
		assertEquals("one", lists.get(0));
		assertEquals("two", lists.get(1));
		assertEquals("four", lists.get(2));

		lists.remove(1);
		assertEquals(2, lists.size());
		assertEquals("one", lists.get(0));
		assertEquals("four", lists.get(1));

		lists.remove(0);
		assertEquals(1, lists.size());
		assertEquals("four", lists.get(0));

		lists.remove(0);
		assertEquals(0, lists.size());
	}

	/**
	 * Tests the programs iterator ability which allows the user to iterate/move
	 * through the list of objects.
	 */
	@Test
	public void testIterator() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();

		// Start with an empty list
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());

		// Create an iterator for the empty list
		Iterator<String> it = list.iterator();

		// Try different operations to make sure they work
		// as expected for an empty list (at this point)
		try {
			it.remove();
			fail();
		} catch (Exception e) {
			assertTrue(e instanceof IllegalStateException);
		}

		assertFalse(it.hasNext());

		list.add(0, "zero");
		it = list.iterator();
		assertTrue(it.hasNext());
		assertEquals("zero", it.next());
		assertFalse(it.hasNext());

		list.add(1, "one");
		it = list.iterator();
		assertTrue(it.hasNext());
		assertEquals("zero", it.next());
		assertTrue(it.hasNext());
		assertEquals("one", it.next());
		assertFalse(it.hasNext());
		try {
			it.next();
			fail();
		} catch (Exception e) {
			assertTrue(e instanceof NoSuchElementException);
		}

		it.remove();
		assertEquals(1, list.size());
		try {
			it.remove();
			fail();
		} catch (Exception e) {
			assertTrue(e instanceof IllegalStateException);
		}

		list.addLast("one");
		it = list.iterator();
		assertEquals("zero", it.next());
		it.remove();
	}
}