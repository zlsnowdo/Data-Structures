package edu.ncsu.csc316.dsa.sorter;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.data.Student;

/**
 * Test cases for InsertionSorter that tests that its functionality is correct.
 * 
 * @author Zachary Snowdon
 *
 */
public class InsertionSorterTest {

	/** One of the integer objects that is going to be tested with. */
	private Integer one = 1;

	/** One of the integer objects that is going to be tested with. */
	private Integer two = 2;

	/** One of the integer objects that is going to be tested with. */
	private Integer thr = 3;

	/** One of the integer objects that is going to be tested with. */
	private Integer fou = 4;

	/** One of the integer objects that is going to be tested with. */
	private Integer fiv = 5;

	/** One of the integer arrays that is going to be tested with. */
	private Integer[] dataAscending = { 1, 2, 3, 4, 5 };

	/** One of the integer arrays that is going to be tested with. */
	private Integer[] dataDescending = { 5, 4, 3, 2, 1 };

	/** One of the integer arrays that is going to be tested with. */
	private Integer[] dataRandom = { 4, 1, 5, 3, 2 };

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

	/** One of the student array that is going to be tested with. */
	private Student[] sAscending = { sOne, sTwo, sThree, sFour, sFive };

	/** One of the student array that is going to be tested with. */
	private Student[] sDescending = { sFive, sFour, sThree, sTwo, sOne };

	/** One of the student array that is going to be tested with. */
	private Student[] sRandom = { sFour, sOne, sFive, sThree, sTwo };

	/** Initiates the InsertionSorter class and creates an object. */
	@SuppressWarnings("rawtypes")
	private InsertionSorter integerSorter;

	/** Initiates the InsertionSorter class and creates an object. */
	@SuppressWarnings("rawtypes")
	private InsertionSorter studentSorter;

	/**
	 * The set up for the test methods that initiates the InsertionSorter class.
	 */
	@SuppressWarnings("rawtypes")
	@Before
	public void setUp() {
		integerSorter = new InsertionSorter();
		studentSorter = new InsertionSorter();
	}

	/**
	 * Test Method that tests the InsertionSorter class and its ability to sort a
	 * list of integers.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testSortIntegers() {
		integerSorter.sort(dataAscending);
		assertEquals(one, dataAscending[0]);
		assertEquals(two, dataAscending[1]);
		assertEquals(thr, dataAscending[2]);
		assertEquals(fou, dataAscending[3]);
		assertEquals(fiv, dataAscending[4]);

		integerSorter.sort(dataDescending);
		assertEquals(one, dataDescending[0]);
		assertEquals(two, dataDescending[1]);
		assertEquals(thr, dataDescending[2]);
		assertEquals(fou, dataDescending[3]);
		assertEquals(fiv, dataDescending[4]);

		integerSorter.sort(dataRandom);
		assertEquals(one, dataRandom[0]);
		assertEquals(two, dataRandom[1]);
		assertEquals(thr, dataRandom[2]);
		assertEquals(fou, dataRandom[3]);
		assertEquals(fiv, dataRandom[4]);
	}

	/**
	 * Test Method that tests the InsertionSorter class and its ability to sort a
	 * list of students.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testSortStudent() {
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