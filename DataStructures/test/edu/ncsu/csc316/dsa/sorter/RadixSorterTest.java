package edu.ncsu.csc316.dsa.sorter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.data.Student;

/**
 * Test cases for RadixSorter that tests that its functionality is correct.
 * 
 * @author Zachary Snowdon
 *
 */
public class RadixSorterTest {

	/** One of the integer objects that is going to be tested with. */
	private Student sOne;

	/** One of the integer objects that is going to be tested with. */
	private Student sTwo;

	/** One of the integer objects that is going to be tested with. */
	private Student sThree;

	/** One of the integer objects that is going to be tested with. */
	private Student sFour;

	/** One of the integer objects that is going to be tested with. */
	private Student sFive;

	/** Initiates the RadixSorter class and creates an object. */
	private RadixSorter<Student> sorter;

	/**
	 * The set up for the test methods that initiates the student objects and the
	 * RadixSorter class.
	 */
	@Before
	public void setUp() {
		sOne = new Student("OneFirst", "OneLast", 1, 1, 1.0, "oneUnityID");
		sTwo = new Student("TwoFirst", "TwoLast", 2, 2, 2.0, "twoUnityID");
		sThree = new Student("ThreeFirst", "ThreeLast", 3, 3, 3.0, "threeUnityID");
		sFour = new Student("FourFirst", "FourLast", 4, 4, 4.0, "fourUnityID");
		sFive = new Student("FiveFirst", "FiveLast", 5, 5, 5.0, "fiveUnityID");

		sorter = new RadixSorter<Student>();
	}

	/**
	 * Method that tests the CountingSorter classes ability to sort a list of
	 * students.
	 */
	@Test
	public void testSortStudent() {
		Student[] original = { sTwo, sOne, sFour, sThree, sFive };
		sorter.sort(original);
		assertEquals(sOne, original[0]);
		assertEquals(sTwo, original[1]);
		assertEquals(sThree, original[2]);
		assertEquals(sFour, original[3]);
		assertEquals(sFive, original[4]);

		Student[] original1 = { sOne, sTwo, sThree, sFour, sFive };
		sorter.sort(original1);
		assertEquals(sOne, original1[0]);
		assertEquals(sTwo, original1[1]);
		assertEquals(sThree, original1[2]);
		assertEquals(sFour, original1[3]);
		assertEquals(sFive, original1[4]);

		Student[] original2 = { sFive, sFour, sThree, sTwo, sOne };
		sorter.sort(original2);
		assertEquals(sOne, original2[0]);
		assertEquals(sTwo, original2[1]);
		assertEquals(sThree, original2[2]);
		assertEquals(sFour, original2[3]);
		assertEquals(sFive, original2[4]);
	}

}