package edu.ncsu.csc316.dsa.data;

import java.util.Comparator;

/**
 * Comparator for comparing Students based on GPA
 * 
 * @author Dr. King
 * @author Zachary Snowdon
 *
 */
public class StudentGPAComparator implements Comparator<Student> {

	/**
	 * Compares students based on GPA in descending order
	 * 
	 * @param one The first student object that is to be compared with the second
	 *            student object.
	 * @param two The second student object that is to be compared with the first
	 *            student object.
	 * @return output The integer value that shows how the two student objects
	 *         compare.
	 */
	@Override
	public int compare(Student one, Student two) {
		Double oneGPA = one.getGpa();
		Double twoGPA = two.getGpa();
		int output = oneGPA.compareTo(twoGPA) * -1;
		return output;
	}

}
