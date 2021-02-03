package edu.ncsu.csc316.dsa.data;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test cases for StudentIDComparator that tests that its functionality is
 * correct.
 * 
 * @author Zachary Snowdon
 *
 */
public class StudentIDComparatorTest {

	/** One of the student objects that is going to be tested with. */
	private Student sOne;

	/** One of the student objects that is going to be tested with. */
	private Student sTwo;

	/** One of the student objects that is going to be tested with. */
	private Student sThree;

	/** One of the student objects that is going to be tested with. */
	private Student sFour;

	/** One of the student objects that is going to be tested with. */
	private Student sFive;

	/** Initiates the ID class and creates an object. */
	private StudentIDComparator comparator;

	/**
	 * The set up for the test methods which places student object values in the
	 * already initiated student objects.
	 */
	@Before
	public void setUp() {
		sOne = new Student("OneFirst", "OneLast", 1, 1, 1.0, "oneUnityID");
		sTwo = new Student("TwoFirst", "TwoLast", 2, 2, 2.0, "twoUnityID");
		sThree = new Student("ThreeFirst", "ThreeLast", 3, 3, 3.0, "threeUnityID");
		sFour = new Student("FourFirst", "FourLast", 4, 4, 4.0, "fourUnityID");
		sFive = new Student("FiveFirst", "FiveLast", 5, 5, 5.0, "fiveUnityID");

		comparator = new StudentIDComparator();
	}

	/**
	 * Test method that tests the compare functionality that compares two student
	 * objects.
	 */
	@Test
	public void testCompare() {
		assertTrue(comparator.compare(sOne, sTwo) < 0);
		assertFalse(comparator.compare(sTwo, sOne) < 0);
		assertTrue(comparator.compare(sTwo, sOne) > 0);
		assertFalse(comparator.compare(sTwo, sOne) < 0);

		assertTrue(comparator.compare(sThree, sFour) < 0);
		assertFalse(comparator.compare(sThree, sFour) > 0);
		assertTrue(comparator.compare(sFour, sThree) > 0);
		assertFalse(comparator.compare(sFour, sThree) < 0);

		assertTrue(comparator.compare(sThree, sFive) < 0);
		assertFalse(comparator.compare(sThree, sFive) > 0);
		assertTrue(comparator.compare(sFive, sThree) > 0);
		assertFalse(comparator.compare(sFive, sThree) < 0);

		assertTrue(comparator.compare(sOne, sOne) == 0);
		assertTrue(comparator.compare(sTwo, sTwo) == 0);
		assertTrue(comparator.compare(sThree, sThree) == 0);
		assertTrue(comparator.compare(sFour, sFour) == 0);
		assertTrue(comparator.compare(sFive, sFive) == 0);
	}

}
