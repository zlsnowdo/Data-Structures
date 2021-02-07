package edu.ncsu.csc316.dsa.list.positional;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.Position;

/**
 * Tests PositionLinkedLists functionalities to make sure that they all work
 * correctly.
 * 
 * @author Zachary Snowdon
 *
 */
public class PositionalLinkedListTest {

	// A PositionalLinkedList that holds all the values in it for testing purposes.
	private PositionalList<String> list;

	/**
	 * Initiates the PositionalLinkedList so that it is able to be used in all of
	 * the testing methods.
	 */
	@Before
	public void setUp() {
		list = new PositionalLinkedList<String>();
	}

	/**
	 * Method that finds the object that is located at the very first spot in the
	 * list.
	 */
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

		list.addFirst("newVal");
		assertEquals(3, list.size());
		assertEquals("newVal", list.first().getElement());
		assertEquals("newOne", list.after(list.first()).getElement());
	}

	/**
	 * Tests the programs ability to find the object that is located at the very end
	 * of the list.
	 */
	@Test
	public void testLast() {
		Position<String> first = list.addLast("one");
		assertEquals(1, list.size());
		assertEquals(first, list.last());
		first = list.addLast("two");
		assertEquals(2, list.size());
		assertEquals(first, list.last());

		list.addLast("finalVal");
		assertEquals(3, list.size());
		assertEquals("finalVal", list.last().getElement());
		assertEquals("two", list.before(list.last()).getElement());
	}

	/**
	 * Tests the programs ability to add a new element at the very front of the
	 * list.
	 */
	@Test
	public void testAddFirst() {
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
		list.addFirst("one");
		assertEquals(1, list.size());
		assertFalse(list.isEmpty());

		list.addFirst("newOne");
		assertEquals(2, list.size());
		assertEquals("newOne", list.first().getElement());
		assertEquals("one", list.last().getElement());

		list.addFirst("first");
		assertEquals(3, list.size());
		assertEquals("first", list.first().getElement());
		assertEquals("newOne", list.after(list.first()).getElement());
		assertEquals("one", list.last().getElement());
	}

	/**
	 * Tests the programs ability to add a new object to the very end of the list.
	 */
	@Test
	public void testAddLast() {
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
		Position<String> first = list.addLast("one");
		assertEquals(1, list.size());
		assertEquals(first, list.last());

		list.addLast("two");
		assertEquals(2, list.size());
		assertEquals("one", list.first().getElement());
		assertEquals("two", list.last().getElement());

		list.addLast("three");
		assertEquals(3, list.size());
		assertEquals("one", list.first().getElement());
		assertEquals("two", list.after(list.first()).getElement());
		assertEquals("three", list.last().getElement());
	}

	/**
	 * Tests the programs ability to add a new object before a specific position in
	 * the list.
	 */
	@Test
	public void testAddBefore() {
		list.addFirst("three");
		list.addFirst("two");
		list.addFirst("one");
		list.addLast("five");
		list.addBefore(list.last(), "four");
		assertEquals("four", list.before(list.last()).getElement());

		list.addBefore(list.first(), "first");
		assertEquals("first", list.first().getElement());
		assertEquals("one", list.after(list.first()).getElement());
	}

	/**
	 * Tests the programs ability to add a new object directly after a specific
	 * position in the list.
	 */
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

		assertEquals("five", list.last().getElement());
	}

	/**
	 * Tests the programs ability to find the position object that comes directly
	 * after another position in the list.
	 */
	@Test
	public void testAfter() {
		Position<String> first = list.addLast("one");
		Position<String> second = list.addAfter(first, "two");
		assertNull(list.after(list.last()));
		assertEquals(second, list.after(first));

		list.addLast("last1");
		assertEquals("last1", list.after(second).getElement());

		list.addLast("finalLast");
		assertEquals("finalLast", list.after(list.after(second)).getElement());
	}

	/**
	 * Tests the programs ability to find the position object that comes directly
	 * before another position in the list.
	 */
	@Test
	public void testBefore() {
		list.addLast("zero");
		list.addLast("one");
		list.addLast("two");
		list.addLast("four");

		assertEquals("four", list.last().getElement());
		assertEquals("two", list.before(list.last()).getElement());
		assertEquals("one", list.before(list.before(list.last())).getElement());
		assertEquals("zero", list.before(list.before(list.before(list.last()))).getElement());
	}

	/**
	 * Tests the programs ability to set an object to a specific location in the
	 * list.
	 */
	@Test
	public void testSet() {
		list.addFirst("two");
		Position<String> first = list.addFirst("one");
		Position<String> second = list.addLast("three");
		String lister = list.set(second, "newThree");
		assertEquals(lister, "three");
		assertEquals(3, list.size());
		assertEquals("one", list.first().getElement());
		assertEquals("two", list.after(first).getElement());
		assertEquals("newThree", list.last().getElement());
		assertEquals("one", list.set(list.first(), "newOne"));
		assertEquals("newOne", list.first().getElement());
	}

	/**
	 * Tests the programs remove functionality which will remove a node from the
	 * linked list.
	 */
	@Test
	public void testRemove() {
		list.addFirst("one");
		list.addAfter(list.first(), "two");
		list.addAfter(list.last(), "three");
		list.addAfter(list.last(), "four");
		String word = list.remove(list.before(list.last()));
		assertEquals("three", word);
		assertEquals(3, list.size());
		assertEquals("two", list.before(list.last()).getElement());
	}

	/**
	 * Tests the programs iterator functionality which will allow the user to
	 * iterate/move through the list.
	 */
	@Test
	public void testIterator() {
		list = new PositionalLinkedList<String>();
		Iterator<String> it = list.iterator();
		assertFalse(it.hasNext());

		list.addFirst("zero");
		list.addLast("one");
		list.addLast("two");

		it = list.iterator();
		assertTrue(it.hasNext());
		assertEquals("zero", it.next());
		assertTrue(it.hasNext());
		assertEquals("one", it.next());
		assertTrue(it.hasNext());
		assertEquals("two", it.next());
		assertFalse(it.hasNext());
		try {
			it.next();
			fail();
		} catch (Exception e) {
			assertTrue(e instanceof NoSuchElementException);
		}

		it = list.iterator();
		it.next();
		it.remove();
		try {
			it.remove();
			fail();
		} catch (Exception e) {
			assertTrue(e instanceof IllegalStateException);
		}
		assertEquals(2, list.size());
		assertEquals("one", it.next());

		list = new PositionalLinkedList<String>();
		it = list.iterator();
		assertFalse(it.hasNext());

		list.addFirst("zero");
		it = list.iterator();
		assertEquals("zero", it.next());
		it.remove();
	}

	/**
	 * Tests the programs position iterator which will allow the user to iterate
	 * through the positions in the list.
	 */
	@Test
	public void testPositions() {
		assertEquals(0, list.size());
		Position<String> first = list.addFirst("one");
		Position<String> second = list.addLast("two");
		Position<String> third = list.addLast("three");
		assertEquals(3, list.size());

		Iterator<Position<String>> it = list.positions().iterator();
		assertTrue(it.hasNext());
		assertEquals(first, it.next());
		assertTrue(it.hasNext());
		assertEquals(second, it.next());
		assertTrue(it.hasNext());
		assertEquals(third, it.next());
		assertFalse(it.hasNext());
		try {
			it.next();
			fail();
		} catch (Exception e) {
			assertTrue(e instanceof NoSuchElementException);
		}

		it = list.positions().iterator();
		it.next();
		it.remove();
		assertEquals(2, list.size());
		assertEquals("two", list.first().getElement());
		try {
			it.remove();
			fail();
		} catch (Exception e) {
			assertTrue(e instanceof IllegalStateException);
		}
	}
}