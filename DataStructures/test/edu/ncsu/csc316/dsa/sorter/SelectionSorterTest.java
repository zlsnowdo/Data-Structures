package edu.ncsu.csc316.dsa.sorter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.data.Student;

/**
 * Test cases for SelectionSorter that tests that its functionality is correct.
 * 
 * @author Zachary Snowdon
 *
 */
public class SelectionSorterTest {

	/** One of the student objects that is going to be tested with. */
	private Student sOne = new Student("Tanner", "Bauman", 30, 16, 1.23, "baumant");

	/** One of the student objects that is going to be tested with. */
	private Student sTwo = new Student("Roxann", "Carrion", 19, 13, .9, "carrior");

	/** One of the student objects that is going to be tested with. */
	private Student sThree = new Student("Amber", "Michael", 1, 10, 1.10, "michaea");

	/** One of the student objects that is going to be tested with. */
	private Student sFour = new Student("Idalia", "Pease", 5, 9, 2.72, "peasei");

	/** One of the student objects that is going to be tested with. */
	private Student sFive = new Student("Loise", "Woodbury", 17, 13, 1.57, "woodbul");

	/** One of the student arrays that is going to be tested with. */
	private Student[] sAscending = { sOne, sTwo, sThree, sFour, sFive };

	/** One of the student arrays that is going to be tested with. */
	private Student[] sDescending = { sFive, sFour, sThree, sTwo, sOne };

	/** One of the student arrays that is going to be tested with. */
	private Student[] sRandom = { sFour, sOne, sFive, sThree, sTwo };

	/** Initiates the SelectionSorter class and creates an object. */
	@SuppressWarnings("rawtypes")
	private SelectionSorter studentSorter;

	/**
	 * The set up for the test methods that initiates the SelectionSorter class.
	 */
	@SuppressWarnings("rawtypes")
	@Before
	public void setUp() {
		studentSorter = new SelectionSorter();
	}

	/**
	 * Test method that tests the SelectionSorter class and its ability to sort a
	 * list of students.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testStudentSort() {
		studentSorter.sort(sAscending);
		assertEquals(sOne, sAscending[0]);
		assertEquals(sTwo, sAscending[1]);
		assertEquals(sThree, sAscending[2]);
		assertEquals(sFour, sAscending[3]);
		assertEquals(sFive, sAscending[4]);

		studentSorter.sort(sDescending);
		assertEquals(sOne, sDescending[0]);
		assertEquals(sTwo, sDescending[1]);
		assertEquals(sThree, sDescending[2]);
		assertEquals(sFour, sDescending[3]);
		assertEquals(sFive, sDescending[4]);

		studentSorter.sort(sRandom);
		assertEquals(sOne, sRandom[0]);
		assertEquals(sTwo, sRandom[1]);
		assertEquals(sThree, sRandom[2]);
		assertEquals(sFour, sRandom[3]);
		assertEquals(sFive, sRandom[4]);
	}

}