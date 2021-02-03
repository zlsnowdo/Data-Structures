package edu.ncsu.csc316.dsa.manager;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.data.Student;

/**
 * Test cases for StudentManager that tests that its functionality is correct.
 * 
 * @author Zachary Snowdon
 *
 */
public class StudentManagerTest {

	/** Initiates the StudentManager class and creates the StudentManager object */
	private StudentManager sm;

	/**
	 * The set up for the test methods which starts the StudentManager object
	 */
	@Before
	public void setUp() {
		sm = new StudentManager("input/student_ascendingID.csv");
	}

	/**
	 * Method that tests the sort functionality in StudentManager which sorts a list
	 * of students based on a number of factors.
	 */
	@Test
	public void testSort() {
		Student[] sorted = sm.sort();
		assertEquals("Tanner", sorted[0].getFirst());
		assertEquals("Roxann", sorted[1].getFirst());
		assertEquals("Shanti", sorted[2].getFirst());
		assertEquals("Dante", sorted[3].getFirst());
		assertEquals("Cristine", sorted[4].getFirst());
		assertEquals("Ara", sorted[5].getFirst());
		assertEquals("Lewis", sorted[6].getFirst());
		assertEquals("Charlene", sorted[7].getFirst());
		assertEquals("Amber", sorted[8].getFirst());
		assertEquals("Lacie", sorted[9].getFirst());
		assertEquals("Idalia", sorted[10].getFirst());
		assertEquals("Tyree", sorted[11].getFirst());
		assertEquals("Evelin", sorted[12].getFirst());
		assertEquals("Alicia", sorted[13].getFirst());
		assertEquals("Loise", sorted[14].getFirst());
		assertEquals("Nichole", sorted[15].getFirst());

		assertEquals("Bauman", sorted[0].getLast());
		assertEquals("Carrion", sorted[1].getLast());
		assertEquals("Dick", sorted[2].getLast());
		assertEquals("Falcon", sorted[3].getLast());
		assertEquals("Greco", sorted[4].getLast());
		assertEquals("Marsh", sorted[5].getLast());
		assertEquals("Matheson", sorted[6].getLast());
		assertEquals("Mclendon", sorted[7].getLast());
		assertEquals("Michael", sorted[8].getLast());
		assertEquals("Mott", sorted[9].getLast());
		assertEquals("Pease", sorted[10].getLast());
		assertEquals("Runyon", sorted[11].getLast());
		assertEquals("Seibert", sorted[12].getLast());
		assertEquals("Terrell", sorted[13].getLast());
		assertEquals("Woodbury", sorted[14].getLast());
		assertEquals("Worth", sorted[15].getLast());

	}

}
