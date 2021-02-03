package edu.ncsu.csc316.dsa.sorter;

import edu.ncsu.csc316.dsa.data.Identifiable;

/**
 * RadixSorter uses the radix sort algorithm to sort data
 * 
 * @author Dr. King
 * @author Zachary Snowdon
 *
 * @param <E> the generic type of data to sort
 */
public class RadixSorter<E extends Identifiable> implements Sorter<E> {

	/**
	 * Method that uses the insertion radix sort algorithm to sort a list of
	 * objects.
	 * 
	 * @param c The list of objects that is to be sorted.
	 */
	@SuppressWarnings("unchecked")
	public void sort(E[] c) {
		int k = 0;
		for (int i = 0; i <= c.length - 1; i++) {
			k = Math.max(k, c[i].getId());
		}
		double x1 = Math.ceil(Math.log10(k + 1));
		int x = (int) x1;
		int p = 1;
		for (int j = 1; j <= x; j++) {
			int[] b = new int[10];
			for (int i = 0; i <= c.length - 1; i++) {
				b[(c[i].getId() / p) % 10] = b[(c[i].getId() / p) % 10] + 1;
			}
			for (int i = 1; i <= 9; i++) {
				b[i] = b[i - 1] + b[i];
			}
			E[] f = (E[]) (new Identifiable[c.length]);
			for (int i = c.length - 1; i >= 0; i--) {
				f[b[(c[i].getId() / p) % 10] - 1] = c[i];
				b[(c[i].getId() / p) % 10] = b[(c[i].getId() / p) % 10] - 1;
			}
			for (int i = 0; i <= c.length - 1; i++) {
				c[i] = f[i];
			}
			p = p * 10;
		}
	}
}
