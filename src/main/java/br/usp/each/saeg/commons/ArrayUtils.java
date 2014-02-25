package br.usp.each.saeg.commons;

public class ArrayUtils {

	private ArrayUtils() {
		// No instances
	}

	public static <T> int indexOf(final T[] array, final Object object) {
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(object))
				return i;
		}
		return -1;
	}

	public static <T> boolean contains(final T[] array, final Object object) {
		return indexOf(array, object) != -1;
	}

}
