package edu.ncsu.csc316.dsa.data;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test cases for Student that tests that its functionality is correct.
 * 
 * @author Zachary Snowdon
 *
 */
public class StudentTest {

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
	}

	/**
	 * Method that tests the functionality of the setFirst method which sets the
	 * first name of a student object to a String.
	 */
	@Test
	public void testSetFirst() {
		sOne.setFirst("newOne");
		assertEquals("newOne", sOne.getFirst());
	}

	/**
	 * Method that tests the functionality of the setLast method which sets the last
	 * name of a student object to a String.
	 */
	@Test
	public void testSetLast() {
		sOne.setLast("newOne");
		assertEquals("newOne", sOne.getLast());
	}

	/**
	 * Method that tests the functionality of the setId method which sets the id of
	 * a student object to a int.
	 */
	@Test
	public void testSetId() {
		sOne.setId(100);
		assertEquals(100, sOne.getId());
	}

	/**
	 * Method that tests the functionality of the setGpa method which sets the GPA
	 * of a student object to a double.
	 */
	@Test
	public void testSetGpa() {
		sFive.setGpa(3.51);
		assertEquals(3.51, sFive.getGpa(), 0.001);
	}

	/**
	 * Method that tests the functionality of the setUnityId method which sets the
	 * Unity ID of a student object to a String.
	 */
	@Test
	public void testSetUnityID() {
		sOne.setUnityID("oneUnity");
		assertEquals("oneUnity", sOne.getUnityID());
	}

	/**
	 * Method that tests the functionality of the setCreditHours method which sets
	 * the credit hours of a student object to an int.
	 */
	@Test
	public void testSetCredits() {
		sOne.setCreditHours(5);
		assertEquals(5, sOne.getCreditHours());
	}

	/**
	 * Method which tests the compareTo method which compares two student objects to
	 * show which one comes before the other when sorting.
	 */
	@Test
	public void testCompareTo() {
		assertTrue(sOne.compareTo(sTwo) < 0);
		assertTrue(sTwo.compareTo(sOne) > 0);
		assertTrue(sOne.compareTo(sOne) == 0);
		assertTrue(sTwo.compareTo(sTwo) == 0);
		Student sOnes = new Student("ZneFirst", "OneLast", 1, 1, 1.0, "oneUnityID");
		assertTrue(sOnes.compareTo(sOne) > 0);
		sOnes.setFirst("AneFirst");
		assertTrue(sOnes.compareTo(sOne) < 0);
		sOnes = new Student("OneFirst", "OneLast", 1, 1, 1.0, "oneUnityID");
		sOnes.setId(5);
		assertTrue(sOnes.compareTo(sOne) > 0);
		sOne.setId(6);
		assertTrue(sOnes.compareTo(sOne) < 0);
	}

	/**
	 * Method which tests the equals method which shows if two student objects have
	 * the same first name, last name, and id.
	 */
	@Test
	public void testEquals() {
		assertTrue(sOne.equals(sOne));
		assertFalse(sFour.equals(sThree));
		Student sOnes = new Student("OneFirst", "OneLast", 5, 1, 1.0, "oneUnityID");
		assertFalse(sOne.equals(sOnes));
		sOnes.setLast(null);
		assertFalse(sOne.equals(sOnes));
	}

	/**
	 * Method which tests the toString method which creates a String representation
	 * of a student object.
	 */
	@Test
	public void testToString() {
		assertEquals("Student [first=OneFirst, last=OneLast, id=1, creditHours=1," + " gpa=1.0, unityID=oneUnityID]",
				sOne.toString());
	}

	/**
	 * Method which tests the hashCode method which creates a unique hashCode for
	 * each student object.
	 */
	@Test
	public void testHashCode() {
		Student sOnes = new Student("OneFirst", "OneLast", 1, 1, 1.0, "oneUnityID");
		assertEquals(sOnes.hashCode(), sOne.hashCode());
		sOnes.setFirst("Nope");
		assertFalse(sOnes.hashCode() == sOne.hashCode());
	}

}
