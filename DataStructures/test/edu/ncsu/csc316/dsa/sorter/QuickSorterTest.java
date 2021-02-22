package edu.ncsu.csc316.dsa.sorter;

import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.Test;

import edu.ncsu.csc316.dsa.data.Student;

/**
 * Tests the QuickSorter classes ability to use the quick sort algorithm to
 * correctly sort a list of objects.
 * 
 * @author Zachary Snowdon
 *
 */
public class QuickSorterTest {

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
	private Integer[] dataAscending = { one, two, thr, fou, fiv };

	/** One of the integer arrays that is going to be tested with. */
	private Integer[] dataDescending = { fiv, fou, thr, two, one };

	/** One of the integer arrays that is going to be tested with. */
	private Integer[] dataRandom = { fou, one, fiv, thr, two };

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

	/** Initiates the QuickSorter class and creates an object. */
	@SuppressWarnings("rawtypes")
	private QuickSorter quickSort;

	/**
	 * Creates a comparator that can be used in testing when initiating QuickSorter
	 */
	private Comparator<Student> comparator;

	/**
	 * Tests QuickSorters ability to sort lists of integers by using the first
	 * element selector in the quick sort algorithm.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testIntegersFirst() {
		quickSort = new QuickSorter(QuickSorter.FIRST_ELEMENT_SELECTOR);

		quickSort.sort(dataAscending);
		assertEquals(one, dataAscending[0]);
		assertEquals(two, dataAscending[1]);
		assertEquals(thr, dataAscending[2]);
		assertEquals(fou, dataAscending[3]);
		assertEquals(fiv, dataAscending[4]);

		quickSort.sort(dataDescending);
		assertEquals(one, dataDescending[0]);
		assertEquals(two, dataDescending[1]);
		assertEquals(thr, dataDescending[2]);
		assertEquals(fou, dataDescending[3]);
		assertEquals(fiv, dataDescending[4]);

		quickSort.sort(dataRandom);
		assertEquals(one, dataRandom[0]);
		assertEquals(two, dataRandom[1]);
		assertEquals(thr, dataRandom[2]);
		assertEquals(fou, dataRandom[3]);
		assertEquals(fiv, dataRandom[4]);
	}

	/**
	 * Tests QuickSorters ability to sort lists of integers by using the last
	 * element selector in the quick sort algorithm.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testIntegersLast() {
		quickSort = new QuickSorter(QuickSorter.LAST_ELEMENT_SELECTOR);

		quickSort.sort(dataAscending);
		assertEquals(one, dataAscending[0]);
		assertEquals(two, dataAscending[1]);
		assertEquals(thr, dataAscending[2]);
		assertEquals(fou, dataAscending[3]);
		assertEquals(fiv, dataAscending[4]);

		quickSort.sort(dataDescending);
		assertEquals(one, dataDescending[0]);
		assertEquals(two, dataDescending[1]);
		assertEquals(thr, dataDescending[2]);
		assertEquals(fou, dataDescending[3]);
		assertEquals(fiv, dataDescending[4]);

		quickSort.sort(dataRandom);
		assertEquals(one, dataRandom[0]);
		assertEquals(two, dataRandom[1]);
		assertEquals(thr, dataRandom[2]);
		assertEquals(fou, dataRandom[3]);
		assertEquals(fiv, dataRandom[4]);
	}

	/**
	 * Tests QuickSorters ability to sort lists of integers by using the middle
	 * element selector in the quick sort algorithm.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testIntegersMiddle() {
		quickSort = new QuickSorter(QuickSorter.MIDDLE_ELEMENT_SELECTOR);

		quickSort.sort(dataAscending);
		assertEquals(one, dataAscending[0]);
		assertEquals(two, dataAscending[1]);
		assertEquals(thr, dataAscending[2]);
		assertEquals(fou, dataAscending[3]);
		assertEquals(fiv, dataAscending[4]);

		quickSort.sort(dataDescending);
		assertEquals(one, dataDescending[0]);
		assertEquals(two, dataDescending[1]);
		assertEquals(thr, dataDescending[2]);
		assertEquals(fou, dataDescending[3]);
		assertEquals(fiv, dataDescending[4]);

		quickSort.sort(dataRandom);
		assertEquals(one, dataRandom[0]);
		assertEquals(two, dataRandom[1]);
		assertEquals(thr, dataRandom[2]);
		assertEquals(fou, dataRandom[3]);
		assertEquals(fiv, dataRandom[4]);
	}

	/**
	 * Tests QuickSorters ability to sort lists of integers by using the random
	 * element selector in the quick sort algorithm.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testIntegersRandom() {
		quickSort = new QuickSorter(QuickSorter.RANDOM_ELEMENT_SELECTOR);

		quickSort.sort(dataAscending);
		assertEquals(one, dataAscending[0]);
		assertEquals(two, dataAscending[1]);
		assertEquals(thr, dataAscending[2]);
		assertEquals(fou, dataAscending[3]);
		assertEquals(fiv, dataAscending[4]);

		quickSort.sort(dataDescending);
		assertEquals(one, dataDescending[0]);
		assertEquals(two, dataDescending[1]);
		assertEquals(thr, dataDescending[2]);
		assertEquals(fou, dataDescending[3]);
		assertEquals(fiv, dataDescending[4]);

		quickSort.sort(dataRandom);
		assertEquals(one, dataRandom[0]);
		assertEquals(two, dataRandom[1]);
		assertEquals(thr, dataRandom[2]);
		assertEquals(fou, dataRandom[3]);
		assertEquals(fiv, dataRandom[4]);
	}

	/**
	 * Tests QuickSorters ability to sort lists of student objects by using the
	 * first element selector in the quick sort algorithm.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testStudentsFirst() {
		quickSort = new QuickSorter(QuickSorter.FIRST_ELEMENT_SELECTOR);

		quickSort.sort(sAscending);
		assertEquals(sOne, sAscending[0]);
		assertEquals(sTwo, sAscending[1]);
		assertEquals(sThree, sAscending[2]);
		assertEquals(sFour, sAscending[3]);
		assertEquals(sFive, sAscending[4]);

		quickSort.sort(sDescending);
		assertEquals(sOne, sAscending[0]);
		assertEquals(sTwo, sAscending[1]);
		assertEquals(sThree, sAscending[2]);
		assertEquals(sFour, sAscending[3]);
		assertEquals(sFive, sAscending[4]);

		quickSort.sort(sRandom);
		assertEquals(sOne, sAscending[0]);
		assertEquals(sTwo, sAscending[1]);
		assertEquals(sThree, sAscending[2]);
		assertEquals(sFour, sAscending[3]);
		assertEquals(sFive, sAscending[4]);
	}

	/**
	 * Tests QuickSorters ability to sort lists of student objects by using the last
	 * element selector in the quick sort algorithm.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testStudentsLast() {
		quickSort = new QuickSorter(QuickSorter.LAST_ELEMENT_SELECTOR);

		quickSort.sort(sAscending);
		assertEquals(sOne, sAscending[0]);
		assertEquals(sTwo, sAscending[1]);
		assertEquals(sThree, sAscending[2]);
		assertEquals(sFour, sAscending[3]);
		assertEquals(sFive, sAscending[4]);

		quickSort.sort(sDescending);
		assertEquals(sOne, sAscending[0]);
		assertEquals(sTwo, sAscending[1]);
		assertEquals(sThree, sAscending[2]);
		assertEquals(sFour, sAscending[3]);
		assertEquals(sFive, sAscending[4]);

		quickSort.sort(sRandom);
		assertEquals(sOne, sAscending[0]);
		assertEquals(sTwo, sAscending[1]);
		assertEquals(sThree, sAscending[2]);
		assertEquals(sFour, sAscending[3]);
		assertEquals(sFive, sAscending[4]);
	}

	/**
	 * Tests QuickSorters ability to sort lists of student objects by using the
	 * middle element selector in the quick sort algorithm.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testStudentsMiddle() {
		quickSort = new QuickSorter(QuickSorter.MIDDLE_ELEMENT_SELECTOR);

		quickSort.sort(sAscending);
		assertEquals(sOne, sAscending[0]);
		assertEquals(sTwo, sAscending[1]);
		assertEquals(sThree, sAscending[2]);
		assertEquals(sFour, sAscending[3]);
		assertEquals(sFive, sAscending[4]);

		quickSort.sort(sDescending);
		assertEquals(sOne, sAscending[0]);
		assertEquals(sTwo, sAscending[1]);
		assertEquals(sThree, sAscending[2]);
		assertEquals(sFour, sAscending[3]);
		assertEquals(sFive, sAscending[4]);

		quickSort.sort(sRandom);
		assertEquals(sOne, sAscending[0]);
		assertEquals(sTwo, sAscending[1]);
		assertEquals(sThree, sAscending[2]);
		assertEquals(sFour, sAscending[3]);
		assertEquals(sFive, sAscending[4]);
	}

	/**
	 * Tests QuickSorters ability to sort lists of student objects by using the
	 * random element selector in the quick sort algorithm.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testStudentsRandom() {
		quickSort = new QuickSorter(QuickSorter.RANDOM_ELEMENT_SELECTOR);

		quickSort.sort(sAscending);
		assertEquals(sOne, sAscending[0]);
		assertEquals(sTwo, sAscending[1]);
		assertEquals(sThree, sAscending[2]);
		assertEquals(sFour, sAscending[3]);
		assertEquals(sFive, sAscending[4]);

		quickSort.sort(sDescending);
		assertEquals(sOne, sAscending[0]);
		assertEquals(sTwo, sAscending[1]);
		assertEquals(sThree, sAscending[2]);
		assertEquals(sFour, sAscending[3]);
		assertEquals(sFive, sAscending[4]);

		quickSort.sort(sRandom);
		assertEquals(sOne, sAscending[0]);
		assertEquals(sTwo, sAscending[1]);
		assertEquals(sThree, sAscending[2]);
		assertEquals(sFour, sAscending[3]);
		assertEquals(sFive, sAscending[4]);
	}

	/**
	 * Tests QuickSorters ability to sort student objects when no PivotSelector is
	 * chosen.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testStudentsNoSorter() {
		quickSort = new QuickSorter();

		quickSort.sort(sAscending);
		assertEquals(sOne, sAscending[0]);
		assertEquals(sTwo, sAscending[1]);
		assertEquals(sThree, sAscending[2]);
		assertEquals(sFour, sAscending[3]);
		assertEquals(sFive, sAscending[4]);

		quickSort.sort(sDescending);
		assertEquals(sOne, sAscending[0]);
		assertEquals(sTwo, sAscending[1]);
		assertEquals(sThree, sAscending[2]);
		assertEquals(sFour, sAscending[3]);
		assertEquals(sFive, sAscending[4]);

		quickSort.sort(sRandom);
		assertEquals(sOne, sAscending[0]);
		assertEquals(sTwo, sAscending[1]);
		assertEquals(sThree, sAscending[2]);
		assertEquals(sFour, sAscending[3]);
		assertEquals(sFive, sAscending[4]);
	}

	/**
	 * Tests QuickSorters ability to sort student objects when the only comparator
	 * is a comparator.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testStudentsOnlyComparator() {
		quickSort = new QuickSorter(comparator);

		quickSort.sort(sAscending);
		assertEquals(sOne, sAscending[0]);
		assertEquals(sTwo, sAscending[1]);
		assertEquals(sThree, sAscending[2]);
		assertEquals(sFour, sAscending[3]);
		assertEquals(sFive, sAscending[4]);

		quickSort.sort(sDescending);
		assertEquals(sOne, sAscending[0]);
		assertEquals(sTwo, sAscending[1]);
		assertEquals(sThree, sAscending[2]);
		assertEquals(sFour, sAscending[3]);
		assertEquals(sFive, sAscending[4]);

		quickSort.sort(sRandom);
		assertEquals(sOne, sAscending[0]);
		assertEquals(sTwo, sAscending[1]);
		assertEquals(sThree, sAscending[2]);
		assertEquals(sFour, sAscending[3]);
		assertEquals(sFive, sAscending[4]);
	}

}