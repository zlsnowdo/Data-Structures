package edu.ncsu.csc316.dsa.data;

/**
 * A student is comparable and identifiable. Students have a first name, last
 * name, id number, number of credit hours, gpa, and unityID.
 * 
 * @author Dr. King
 * @author Zachary Snowdon
 *
 */
public class Student implements Comparable<Student>, Identifiable {

	/** Private String variable that holds the first name of the student object */
	private String first;

	/** Private String variable that holds the last name of the student object */
	private String last;

	/** Private int variable that holds the student id of the student object */
	private int id;

	/** Private int variable that holds the credit hours the student is taking */
	private int creditHours;

	/** Private double variable that holds the GPA of the student object */
	private double gpa;

	/** Private String variable that holds the unity ID of the student object */
	private String unityID;

	/**
	 * The constructor for student objects which sets the parameters of the student.
	 * 
	 * @param first       The first name of the student that is to be set for the
	 *                    student object.
	 * @param last        The last name of the student that is to be set for the
	 *                    student object.
	 * @param id          The id name of the student that is to be set for the
	 *                    student object.
	 * @param creditHours The credit hours of the student that is to be set for the
	 *                    student object.
	 * @param gpa         The gpa of the student that is to be set for the student
	 *                    object.
	 * @param unityID     The unity id of the student that is to be set for the
	 *                    student object.
	 */
	public Student(String first, String last, int id, int creditHours, double gpa, String unityID) {
		setFirst(first);
		setLast(last);
		setId(id);
		setCreditHours(creditHours);
		setGpa(gpa);
		setUnityID(unityID);
	}

	/**
	 * Method that finds the first name of the student from the object and returns a
	 * string of the name.
	 * 
	 * @return first The first name of the student that is held in the student
	 *         object.
	 */
	public String getFirst() {
		return first;
	}

	/**
	 * Method that sets the first name of the student and sets the value in the
	 * student object.
	 * 
	 * @param newF The first name of the student that is to be set in the object.
	 */
	public void setFirst(String newF) {
		this.first = newF;
	}

	/**
	 * Method that finds the last name of the student from the object and returns a
	 * string of the name.
	 * 
	 * @return last The last name of the student that is held in the student object.
	 */
	public String getLast() {
		return last;
	}

	/**
	 * Method that sets the last name of the student and sets the value in the
	 * student object.
	 * 
	 * @param newL The last name of the student that is to be set in the object.
	 */
	public void setLast(String newL) {
		this.last = newL;
	}

	/**
	 * Method that finds the id of the student from the object and returns a int of
	 * the id.
	 * 
	 * @return id The id of the student that is held in the student object.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Method that sets the ID of the student and sets the value in the student
	 * object.
	 * 
	 * @param newId The ID of the student that is to be set in the object.
	 */
	public void setId(int newId) {
		this.id = newId;
	}

	/**
	 * Method that finds the credit hours of the student from the object and returns
	 * a int of the number of credit hours.
	 * 
	 * @return creditHours The credit hours of the student that is held in the
	 *         student object.
	 */
	public int getCreditHours() {
		return creditHours;
	}

	/**
	 * Method that sets the credit hours of the student and sets the value in the
	 * student object.
	 * 
	 * @param newCreditH The credit hours of the student that is to be set in the
	 *                   object.
	 */
	public void setCreditHours(int newCreditH) {
		this.creditHours = newCreditH;
	}

	/**
	 * Method that finds the GPA of the student from the object and returns a double
	 * of the students GPA.
	 * 
	 * @return gpa The GPA of the student that is held in the student object.
	 */
	public double getGpa() {
		return gpa;
	}

	/**
	 * Method that sets the GPA of the student and sets the value in the student
	 * object.
	 * 
	 * @param newGpa The GPA of the student that is to be set in the object.
	 */
	public void setGpa(double newGpa) {
		this.gpa = newGpa;
	}

	/**
	 * Method that finds the Unity ID of the student from the object and returns a
	 * String of the students Unity ID.
	 * 
	 * @return unityID The Unity ID of the student that is held in the student
	 *         object.
	 */
	public String getUnityID() {
		return unityID;
	}

	/**
	 * Method that sets the Unity ID of the student and sets the value in the
	 * student object.
	 * 
	 * @param newUnity The Unity ID of the student that is to be set in the object.
	 */
	public void setUnityID(String newUnity) {
		this.unityID = newUnity;
	}

	/**
	 * Method that creates a hashCode for the student object so it can be
	 * identified.
	 * 
	 * @return result The hashCode integer that was generated from the student
	 *         object.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + id;
		result = prime * result + ((last == null) ? 0 : last.hashCode());
		return result;
	}

	/**
	 * Method that tests to see if two student objects are equal by comparing the
	 * first names, last names, and id. A boolean value is then returned which shows
	 * if they are equal or not.
	 * 
	 * @param obj The object that is to be compared with the previously used object.
	 * @return boolean Weather or not the two student objects compared are equal.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (first == null) {
			if (other.first != null)
				return false;
		} else if (!first.equals(other.first))
			return false;
		if (id != other.id)
			return false;
		if (last == null) {
			if (other.last != null)
				return false;
		} else if (!last.equals(other.last))
			return false;
		return true;
	}

	/**
	 * Method that compares two student objects by last name, first name, then ID.
	 * The method then returns an integer value which shows which student has a
	 * higher value.
	 * 
	 * @param o The student object that is to be compared with the previously used
	 *          student object.
	 * @return returnNumber An integer that represents which student should come
	 *         before the other student in the sort methods.
	 */
	@Override
	public int compareTo(Student o) {
		int returnNumber = 0;
		String studentFirst = o.getFirst().toLowerCase();
		String studentLast = o.getLast().toLowerCase();
		Integer studentID = o.getId();
		String otherFirst = first.toLowerCase();
		String otherLast = last.toLowerCase();
		Integer otherID = id;
		if (otherLast.compareTo(studentLast) < 0) {
			returnNumber = -1;
		} else if (otherLast.compareTo(studentLast) == 0) {
			if (otherFirst.compareTo(studentFirst) < 0) {
				returnNumber = -1;
			} else if (otherFirst.compareTo(studentFirst) == 0) {
				if (otherID.compareTo(studentID) < 0) {
					returnNumber = -1;
				} else if (otherID.compareTo(studentID) == 0) {
					returnNumber = 0;
				} else if (otherID.compareTo(studentID) > 0) {
					returnNumber = 1;
				}
			} else if (otherFirst.compareTo(studentFirst) > 0) {
				returnNumber = 1;
			}
		} else if (otherLast.compareTo(studentLast) > 0) {
			returnNumber = 1;
		}
		return returnNumber;
	}

	/**
	 * Method that creates a string value which an objects parameter and return that
	 * string.
	 * 
	 * @return String The string value equivalent of the object that is used.
	 */
	@Override
	public String toString() {
		return "Student [first=" + first + ", last=" + last + ", id=" + id + ", creditHours=" + creditHours + ", gpa="
				+ gpa + ", unityID=" + unityID + "]";
	}

}
