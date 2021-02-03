package edu.ncsu.csc316.dsa.io;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.dsa.data.Student;

/**
 * Test cases for StudentReader that tests that its functionality is correct.
 * 
 * @author Zachary Snowdon
 *
 */
public class StudentReaderTest {

	/**
	 * Test method that tests to see if the StudentReader is properly reading input
	 * files and creating student objects.
	 */
	@Test
	public void testReadFile() {
		Student[] contents = StudentReader.readInputAsArray("input/student_ascendingID.csv");
		assertEquals("Amber", contents[0].getFirst());
		assertEquals("Ara", contents[1].getFirst());
		assertEquals("Lacie", contents[2].getFirst());
		assertEquals("Idalia", contents[3].getFirst());
		assertEquals("Evelin", contents[4].getFirst());
		assertEquals("Lewis", contents[5].getFirst());
		assertEquals("Alicia", contents[6].getFirst());
		assertEquals("Tyree", contents[7].getFirst());
		assertEquals("Loise", contents[8].getFirst());
		assertEquals("Roxann", contents[9].getFirst());
		assertEquals("Nichole", contents[10].getFirst());
		assertEquals("Charlene", contents[11].getFirst());
		assertEquals("Shanti", contents[12].getFirst());
		assertEquals("Cristine", contents[13].getFirst());
		assertEquals("Tanner", contents[14].getFirst());
		assertEquals("Dante", contents[15].getFirst());

		assertEquals("Michael", contents[0].getLast());
		assertEquals("Marsh", contents[1].getLast());
		assertEquals("Mott", contents[2].getLast());
		assertEquals("Pease", contents[3].getLast());
		assertEquals("Seibert", contents[4].getLast());
		assertEquals("Matheson", contents[5].getLast());
		assertEquals("Terrell", contents[6].getLast());
		assertEquals("Runyon", contents[7].getLast());
		assertEquals("Woodbury", contents[8].getLast());
		assertEquals("Carrion", contents[9].getLast());
		assertEquals("Worth", contents[10].getLast());
		assertEquals("Mclendon", contents[11].getLast());
		assertEquals("Dick", contents[12].getLast());
		assertEquals("Greco", contents[13].getLast());
		assertEquals("Bauman", contents[14].getLast());
		assertEquals("Falcon", contents[15].getLast());
	}

}
