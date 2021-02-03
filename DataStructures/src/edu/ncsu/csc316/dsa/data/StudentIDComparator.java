package edu.ncsu.csc316.dsa.data;

import java.util.Comparator;

/**
 * Comparator to compare students based on id number
 * 
 * @author Dr. King
 * @author Zachary Snowdon
 *
 */
public class StudentIDComparator implements Comparator<Student> {

	/**
	 * Compares students based on id number in ascending order.
	 * 
	 * @param one The first student object that is to be compared to the second
	 *            student object.
	 * @param two The second student object that is to be compared with the first
	 *            student object.
	 * @return int The integer that represents which student objects ID is greater
	 *         than the others.
	 */
	@Override
	public int compare(Student one, Student two) {
		Integer oneID = one.getId();
		Integer twoID = two.getId();
		return oneID.compareTo(twoID);
	}

}
