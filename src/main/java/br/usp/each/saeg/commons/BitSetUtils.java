package br.usp.each.saeg.commons;

import java.util.BitSet;

public final class BitSetUtils {

	private BitSetUtils() {
		// no instances
	}

	public static int toInteger(final BitSet bits) {
		int value = 0;
		for (int i = 0; i < 32; ++i) {
			value += bits.get(i) ? (1 << i) : 0;
		}
		return value;
	}

	public static long toLong(final BitSet bits) {
		long value = 0L;
		for (int i = 0; i < 64; ++i) {
			value += bits.get(i) ? (1L << i) : 0L;
		}
		return value;
	}

	public static int[] toIntArray(final BitSet bits, final int size) {
		final int[] array = new int[size];

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < 32; j++) {
				if (bits.get(i * 32 + j)) {
					array[i] |= 1 << j;
				}
			}
		}

		return array;
	}

	public static long[] toLongArray(final BitSet bits, final int size) {
		final long[] array = new long[size];

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < 64; j++) {
				if (bits.get(i * 64 + j)) {
					array[i] |= 1L << j;
				}
			}
		}

		return array;
	}

	public static BitSet valueOf(final int... values) {
		final BitSet bits = new BitSet(values.length * 32);
		for (int i = 0; i < values.length; i++) {
			int index = 0;
			int value = values[i];
			while (value != 0) {
				if (value % 2 != 0) {
					bits.set(i * 32 + index);
				}
				++index;
				value = value >>> 1;
			}
		}
		return bits;
	}

	public static BitSet valueOf(final long... values) {
		final BitSet bits = new BitSet(values.length * 64);
		for (int i = 0; i < values.length; i++) {
			int index = 0;
			long value = values[i];
			while (value != 0L) {
				if (value % 2L != 0) {
					bits.set(i * 64 + index);
				}
				++index;
				value = value >>> 1;
			}
		}
		return bits;
	}

}
