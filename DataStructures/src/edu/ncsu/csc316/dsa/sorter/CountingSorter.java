package edu.ncsu.csc316.dsa.sorter;

import edu.ncsu.csc316.dsa.data.Identifiable;

/**
 * CountingSorter uses the counting sort algorithm to sort data
 * 
 * @author Dr. King
 * @author Zachary Snowdon
 *
 * @param <E> the generic type of data to sort
 */
public class CountingSorter<E extends Identifiable> implements Sorter<E> {

	/**
	 * Method that uses the counting sorter algorithm to sort a list of objects
	 * 
	 * @param c The list that is to be sorted using the counting sorter algorithm.
	 */
	@SuppressWarnings("unchecked")
	public void sort(E[] c) {
		int min = c[0].getId();
		int max = c[0].getId();
		for (int i = 0; i <= c.length - 1; i++) {
			min = Math.min(c[i].getId(), min);
			max = Math.max(c[i].getId(), max);
		}
		int k = (max - min + 1);
		int[] b = new int[k];
		for (int i = 0; i <= c.length - 1; i++) {
			b[c[i].getId() - min] = b[c[i].getId() - min] + 1;
		}
		for (int i = 1; i <= k - 1; i++) {
			b[i] = b[i - 1] + b[i];
		}
		E[] f = (E[]) (new Identifiable[c.length]);
		for (int i = 0; i < c.length; i++) {
			f[b[c[i].getId() - min] - 1] = c[i];
			b[c[i].getId() - min] = b[c[i].getId() - min] - 1;
		}

		for (int i = 0; i < f.length; i++) {
			c[i] = f[i];
		}
	}

}