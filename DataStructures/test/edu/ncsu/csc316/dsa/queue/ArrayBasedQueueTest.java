package edu.ncsu.csc316.dsa.queue;

import static org.junit.Assert.*;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

/**
 * Test cases for ArrayBasedQueue which make sure the classes functionalities
 * work correctly.
 * 
 * @author Zachary Snowdon
 *
 */
public class ArrayBasedQueueTest {

	// Creates a private class which will hold all of the objects for testing.
	private Queue<String> queue;

	/**
	 * Initiates the queue list for all testing methods with a capacity of 10
	 * objects.
	 */
	@Before
	public void setUp() {
		queue = new ArrayBasedQueue<String>();
	}

	/**
	 * Tests the queues ability to add an object to the very end of the list.
	 */
	@Test
	public void testEnqueue() {
		assertEquals(0, queue.size());
		assertTrue(queue.isEmpty());

		queue.enqueue("one");
		assertEquals(1, queue.size());
		assertFalse(queue.isEmpty());
		queue.enqueue("two");
		assertEquals(2, queue.size());
		queue.enqueue("three");
		assertEquals(3, queue.size());
		queue.enqueue("four");
		queue.enqueue("five");
		queue.enqueue("six");
		queue.enqueue("seven");
		queue.enqueue("eight");
		queue.enqueue("nine");
		queue.enqueue("ten");
		assertEquals(10, queue.size());
		queue.enqueue("eleven");
		assertEquals(11, queue.size());
		queue.enqueue("twelve");
		assertEquals(12, queue.size());
		assertEquals("one", queue.front());
	}

	/**
	 * Tests the queues ability to remove an object from the very front of the list.
	 */
	@Test
	public void testDequeue() {
		assertEquals(0, queue.size());
		queue.enqueue("one");
		queue.enqueue("two");
		queue.enqueue("three");
		queue.enqueue("four");
		queue.enqueue("five");
		queue.enqueue("six");
		assertEquals(6, queue.size());

		assertEquals("one", queue.dequeue());
		assertEquals(5, queue.size());

		assertEquals("two", queue.dequeue());
		assertEquals(4, queue.size());
		assertEquals("three", queue.dequeue());
		assertEquals(3, queue.size());
		assertEquals("four", queue.dequeue());
		assertEquals(2, queue.size());
		assertEquals("five", queue.dequeue());
		assertEquals(1, queue.size());
		assertEquals("six", queue.dequeue());
		assertEquals(0, queue.size());

		try {
			queue.dequeue();
			fail("NoSuchElementException should have been thrown.");
		} catch (Exception e) {
			assertTrue(e instanceof NoSuchElementException);
		}
	}

	/**
	 * Tests the queues ability to return the first object in the list.
	 */
	@Test
	public void testFront() {

		try {
			queue.front();
			fail();
		} catch (Exception e) {
			assertTrue(e instanceof NoSuchElementException);
		}
		queue.enqueue("one");
		assertEquals("one", queue.front());
		assertEquals(1, queue.size());
		queue.enqueue("two");
		assertEquals("one", queue.front());
		assertEquals(2, queue.size());
		queue.dequeue();
		assertEquals(1, queue.size());
		assertEquals("two", queue.front());
		queue.enqueue("three");
		assertEquals("two", queue.front());
		assertEquals(2, queue.size());
		queue.dequeue();
		assertEquals("three", queue.front());
		assertEquals(1, queue.size());
	}

	/**
	 * Added a test case that combines enqueue and dequeue to test that the front
	 * and rear ints connect.
	 */
	@Test
	public void testMix() {
		queue.enqueue("one");
		assertEquals(1, queue.size());
		queue.enqueue("two");
		assertEquals(2, queue.size());
		queue.enqueue("three");
		assertEquals(3, queue.size());
		queue.enqueue("four");
		assertEquals(4, queue.size());
		queue.enqueue("five");
		assertEquals(5, queue.size());
		queue.enqueue("six");
		assertEquals(6, queue.size());
		queue.enqueue("seven");
		assertEquals(7, queue.size());
		queue.enqueue("eight");
		assertEquals(8, queue.size());
		queue.enqueue("nine");
		assertEquals(9, queue.size());
		queue.enqueue("ten");
		assertEquals(10, queue.size());
		queue.dequeue();
		queue.enqueue("eleven");
		assertEquals(10, queue.size());
		queue.enqueue("twelve");
		assertEquals(11, queue.size());

		assertEquals("two", queue.dequeue());
		assertEquals("three", queue.dequeue());
		assertEquals("four", queue.dequeue());
		assertEquals("five", queue.dequeue());
		assertEquals("six", queue.dequeue());
		assertEquals("seven", queue.dequeue());
		assertEquals("eight", queue.dequeue());
		assertEquals("nine", queue.dequeue());
		assertEquals("ten", queue.dequeue());
		assertEquals("eleven", queue.dequeue());
		assertEquals("twelve", queue.dequeue());
	}
}