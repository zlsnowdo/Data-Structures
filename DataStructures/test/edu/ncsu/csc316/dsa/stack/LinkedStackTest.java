package edu.ncsu.csc316.dsa.stack;

import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.Before;
import org.junit.Test;

/**
 * Test cases for LinkedStack which make sure the classes functionalities work
 * correctly.
 * 
 * @author Zachary Snowdon
 *
 */
public class LinkedStackTest {

	// Creates a private class which will hold all of the objects for testing.
	private Stack<String> stack;

	/**
	 * Initiates the stack list for all testing methods.
	 */
	@Before
	public void setUp() {
		stack = new LinkedStack<String>();
	}

	/**
	 * Tests the stacks ability to add an object to the front of the list.
	 */
	@Test
	public void testPush() {
		assertEquals(0, stack.size());
		assertTrue(stack.isEmpty());

		stack.push("one");
		assertEquals(1, stack.size());
		assertFalse(stack.isEmpty());
	}

	/**
	 * Tests the stacks ability to remove and return the first object in the list.
	 */
	@Test
	public void testPop() {
		assertEquals(0, stack.size());
		stack.push("one");
		stack.push("two");
		stack.push("three");
		stack.push("four");
		stack.push("five");
		stack.push("six");
		assertEquals(6, stack.size());

		assertEquals("six", stack.pop());
		assertEquals(5, stack.size());
		assertEquals("five", stack.pop());
		assertEquals(4, stack.size());
		assertEquals("four", stack.pop());
		assertEquals(3, stack.size());
		assertEquals("three", stack.pop());
		assertEquals(2, stack.size());
		assertEquals("two", stack.pop());
		assertEquals(1, stack.size());
		assertEquals("one", stack.pop());
		assertEquals(0, stack.size());

		try {
			stack.pop();
			fail("EmptyStackException should have been thrown.");
		} catch (Exception e) {
			assertTrue(e instanceof EmptyStackException);
		}
	}

	/**
	 * Tests the stacks ability to return the object that is first in the list.
	 */
	@Test
	public void testTop() {
		assertEquals(0, stack.size());
		stack.push("one");
		assertEquals("one", stack.top());
	}

}