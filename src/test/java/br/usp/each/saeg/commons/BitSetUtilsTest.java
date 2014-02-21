package br.usp.each.saeg.commons;

import java.util.BitSet;

import org.junit.Assert;
import org.junit.Test;

public class BitSetUtilsTest {

	@Test
	public void testToInteger() {
		Assert.assertEquals(BitSetUtils.toInteger(bitset()), 0);
		Assert.assertEquals(BitSetUtils.toInteger(bitset(1)), 1);
		Assert.assertEquals(BitSetUtils.toInteger(bitset(32)), Integer.MIN_VALUE);
		Assert.assertEquals(BitSetUtils.toInteger(flip(1, 32)), -1);
		Assert.assertEquals(BitSetUtils.toInteger(flip(1, 31)), Integer.MAX_VALUE);
		Assert.assertEquals(BitSetUtils.toInteger(bitset(33)), 0);
	}

	@Test
	public void testToIntArray() {
		int[] array;

		// size 0

		array = BitSetUtils.toIntArray(bitset(), 0);
		Assert.assertEquals(array.length, 0);

		array = BitSetUtils.toIntArray(bitset(1), 0);
		Assert.assertEquals(array.length, 0);

		// size 1

		array = BitSetUtils.toIntArray(bitset(), 1);
		Assert.assertEquals(array.length, 1);
		Assert.assertEquals(array[0], 0);

		array = BitSetUtils.toIntArray(bitset(1), 1);
		Assert.assertEquals(array.length, 1);
		Assert.assertEquals(array[0], 1);

		array = BitSetUtils.toIntArray(bitset(32), 1);
		Assert.assertEquals(array.length, 1);
		Assert.assertEquals(array[0], Integer.MIN_VALUE);

		array = BitSetUtils.toIntArray(flip(1, 32), 1);
		Assert.assertEquals(array.length, 1);
		Assert.assertEquals(array[0], -1);

		array = BitSetUtils.toIntArray(flip(1, 31), 1);
		Assert.assertEquals(array.length, 1);
		Assert.assertEquals(array[0], Integer.MAX_VALUE);

		array = BitSetUtils.toIntArray(bitset(33), 1);
		Assert.assertEquals(array.length, 1);
		Assert.assertEquals(array[0], 0);

		// size 2

		array = BitSetUtils.toIntArray(bitset(), 2);
		Assert.assertEquals(array.length, 2);
		Assert.assertEquals(array[0], 0);
		Assert.assertEquals(array[1], 0);

		array = BitSetUtils.toIntArray(bitset(1), 2);
		Assert.assertEquals(array.length, 2);
		Assert.assertEquals(array[0], 1);
		Assert.assertEquals(array[1], 0);

		array = BitSetUtils.toIntArray(bitset(32), 2);
		Assert.assertEquals(array.length, 2);
		Assert.assertEquals(array[0], Integer.MIN_VALUE);
		Assert.assertEquals(array[1], 0);

		array = BitSetUtils.toIntArray(flip(1, 32), 2);
		Assert.assertEquals(array.length, 2);
		Assert.assertEquals(array[0], -1);
		Assert.assertEquals(array[1], 0);

		array = BitSetUtils.toIntArray(flip(1, 31), 2);
		Assert.assertEquals(array.length, 2);
		Assert.assertEquals(array[0], Integer.MAX_VALUE);
		Assert.assertEquals(array[1], 0);

		array = BitSetUtils.toIntArray(bitset(33), 2);
		Assert.assertEquals(array.length, 2);
		Assert.assertEquals(array[0], 0);
		Assert.assertEquals(array[1], 1);

		array = BitSetUtils.toIntArray(bitset(64), 2);
		Assert.assertEquals(array.length, 2);
		Assert.assertEquals(array[0], 0);
		Assert.assertEquals(array[1], Integer.MIN_VALUE);

		array = BitSetUtils.toIntArray(flip(33, 64), 2);
		Assert.assertEquals(array.length, 2);
		Assert.assertEquals(array[0], 0);
		Assert.assertEquals(array[1], -1);

		array = BitSetUtils.toIntArray(flip(33, 63), 2);
		Assert.assertEquals(array.length, 2);
		Assert.assertEquals(array[0], 0);
		Assert.assertEquals(array[1], Integer.MAX_VALUE);
	}

	@Test
	public void testToLong() {
		Assert.assertEquals(BitSetUtils.toLong(bitset()), 0L);
		Assert.assertEquals(BitSetUtils.toLong(bitset(1)), 1L);
		Assert.assertEquals(BitSetUtils.toLong(bitset(64)), Long.MIN_VALUE);
		Assert.assertEquals(BitSetUtils.toLong(flip(1, 64)), -1L);
		Assert.assertEquals(BitSetUtils.toLong(flip(1, 63)), Long.MAX_VALUE);
		Assert.assertEquals(BitSetUtils.toLong(bitset(65)), 0L);
	}

	@Test
	public void testToLongArray() {
		long[] array;

		// size 0

		array = BitSetUtils.toLongArray(bitset(), 0);
		Assert.assertEquals(array.length, 0);

		array = BitSetUtils.toLongArray(bitset(1), 0);
		Assert.assertEquals(array.length, 0);

		// size 1

		array = BitSetUtils.toLongArray(bitset(), 1);
		Assert.assertEquals(array.length, 1);
		Assert.assertEquals(array[0], 0L);

		array = BitSetUtils.toLongArray(bitset(1), 1);
		Assert.assertEquals(array.length, 1);
		Assert.assertEquals(array[0], 1L);

		array = BitSetUtils.toLongArray(bitset(64), 1);
		Assert.assertEquals(array.length, 1);
		Assert.assertEquals(array[0], Long.MIN_VALUE);

		array = BitSetUtils.toLongArray(flip(1, 64), 1);
		Assert.assertEquals(array.length, 1);
		Assert.assertEquals(array[0], -1L);

		array = BitSetUtils.toLongArray(flip(1, 63), 1);
		Assert.assertEquals(array.length, 1);
		Assert.assertEquals(array[0], Long.MAX_VALUE);

		array = BitSetUtils.toLongArray(bitset(65), 1);
		Assert.assertEquals(array.length, 1);
		Assert.assertEquals(array[0], 0L);

		// size 2

		array = BitSetUtils.toLongArray(bitset(), 2);
		Assert.assertEquals(array.length, 2);
		Assert.assertEquals(array[0], 0L);
		Assert.assertEquals(array[1], 0L);

		array = BitSetUtils.toLongArray(bitset(1), 2);
		Assert.assertEquals(array.length, 2);
		Assert.assertEquals(array[0], 1L);
		Assert.assertEquals(array[1], 0L);

		array = BitSetUtils.toLongArray(bitset(64), 2);
		Assert.assertEquals(array.length, 2);
		Assert.assertEquals(array[0], Long.MIN_VALUE);
		Assert.assertEquals(array[1], 0L);

		array = BitSetUtils.toLongArray(flip(1, 64), 2);
		Assert.assertEquals(array.length, 2);
		Assert.assertEquals(array[0], -1L);
		Assert.assertEquals(array[1], 0L);

		array = BitSetUtils.toLongArray(flip(1, 63), 2);
		Assert.assertEquals(array.length, 2);
		Assert.assertEquals(array[0], Long.MAX_VALUE);
		Assert.assertEquals(array[1], 0L);

		array = BitSetUtils.toLongArray(bitset(65), 2);
		Assert.assertEquals(array.length, 2);
		Assert.assertEquals(array[0], 0L);
		Assert.assertEquals(array[1], 1L);

		array = BitSetUtils.toLongArray(bitset(128), 2);
		Assert.assertEquals(array.length, 2);
		Assert.assertEquals(array[0], 0L);
		Assert.assertEquals(array[1], Long.MIN_VALUE);

		array = BitSetUtils.toLongArray(flip(65, 128), 2);
		Assert.assertEquals(array.length, 2);
		Assert.assertEquals(array[0], 0L);
		Assert.assertEquals(array[1], -1L);

		array = BitSetUtils.toLongArray(flip(65, 127), 2);
		Assert.assertEquals(array.length, 2);
		Assert.assertEquals(array[0], 0L);
		Assert.assertEquals(array[1], Long.MAX_VALUE);
	}

	@Test
	public void testValueOfInt() {
		BitSet bitset;

		bitset = BitSetUtils.valueOf(0);
		Assert.assertEquals(bitset.cardinality(), 0);

		bitset = BitSetUtils.valueOf(1);
		Assert.assertEquals(bitset.cardinality(), 1);
		Assert.assertTrue(bitset.get(0));

		bitset = BitSetUtils.valueOf(-1);
		Assert.assertEquals(bitset.cardinality(), 32);
		bitset.xor(flip(1, 32));
		Assert.assertEquals(bitset.cardinality(), 0);

		bitset = BitSetUtils.valueOf(Integer.MIN_VALUE);
		Assert.assertEquals(bitset.cardinality(), 1);
		Assert.assertTrue(bitset.get(31));

		bitset = BitSetUtils.valueOf(Integer.MAX_VALUE);
		Assert.assertEquals(bitset.cardinality(), 31);
		bitset.xor(flip(1, 31));
		Assert.assertEquals(bitset.cardinality(), 0);
	}

	@Test
	public void testValueOfLong() {
		BitSet bitset;

		bitset = BitSetUtils.valueOf(0L);
		Assert.assertEquals(bitset.cardinality(), 0);

		bitset = BitSetUtils.valueOf(1L);
		Assert.assertEquals(bitset.cardinality(), 1);
		Assert.assertTrue(bitset.get(0));

		bitset = BitSetUtils.valueOf(-1L);
		Assert.assertEquals(bitset.cardinality(), 64);
		bitset.xor(flip(1, 64));
		Assert.assertEquals(bitset.cardinality(), 0);

		bitset = BitSetUtils.valueOf(Long.MIN_VALUE);
		Assert.assertEquals(bitset.cardinality(), 1);
		Assert.assertTrue(bitset.get(63));

		bitset = BitSetUtils.valueOf(Long.MAX_VALUE);
		Assert.assertEquals(bitset.cardinality(), 63);
		bitset.xor(flip(1, 63));
		Assert.assertEquals(bitset.cardinality(), 0);
	}

	@Test
	public void testValueOfIntArray() {
		BitSet bitset;

		// size 0

		bitset = BitSetUtils.valueOf(new int[0]);
		Assert.assertEquals(bitset.cardinality(), 0);

		// size 1

		bitset = BitSetUtils.valueOf(new int[] { 0 });
		Assert.assertEquals(bitset.cardinality(), 0);

		bitset = BitSetUtils.valueOf(new int[] { 1 });
		Assert.assertEquals(bitset.cardinality(), 1);
		Assert.assertTrue(bitset.get(0));

		bitset = BitSetUtils.valueOf(new int[] { Integer.MIN_VALUE });
		Assert.assertEquals(bitset.cardinality(), 1);
		Assert.assertTrue(bitset.get(31));

		bitset = BitSetUtils.valueOf(new int[] { -1 });
		Assert.assertEquals(bitset.cardinality(), 32);
		bitset.xor(flip(1, 32));
		Assert.assertEquals(bitset.cardinality(), 0);

		bitset = BitSetUtils.valueOf(new int[] { Integer.MAX_VALUE });
		Assert.assertEquals(bitset.cardinality(), 31);
		bitset.xor(flip(1, 31));
		Assert.assertEquals(bitset.cardinality(), 0);

		// size 2

		bitset = BitSetUtils.valueOf(new int[] { 0, 0 });
		Assert.assertEquals(bitset.cardinality(), 0);

		bitset = BitSetUtils.valueOf(new int[] { 1, 0 });
		Assert.assertEquals(bitset.cardinality(), 1);
		Assert.assertTrue(bitset.get(0));

		bitset = BitSetUtils.valueOf(new int[] { Integer.MIN_VALUE, 0 });
		Assert.assertEquals(bitset.cardinality(), 1);
		Assert.assertTrue(bitset.get(31));

		bitset = BitSetUtils.valueOf(new int[] { -1, 0 });
		Assert.assertEquals(bitset.cardinality(), 32);
		bitset.xor(flip(1, 32));
		Assert.assertEquals(bitset.cardinality(), 0);

		bitset = BitSetUtils.valueOf(new int[] { Integer.MAX_VALUE, 0 });
		Assert.assertEquals(bitset.cardinality(), 31);
		bitset.xor(flip(1, 31));
		Assert.assertEquals(bitset.cardinality(), 0);

		bitset = BitSetUtils.valueOf(new int[] { 0, 1 });
		Assert.assertEquals(bitset.cardinality(), 1);
		Assert.assertTrue(bitset.get(32));

		bitset = BitSetUtils.valueOf(new int[] { 0, Integer.MIN_VALUE });
		Assert.assertEquals(1, bitset.cardinality());
		Assert.assertTrue(bitset.get(63));

		bitset = BitSetUtils.valueOf(new int[] { 0, -1 });
		Assert.assertEquals(bitset.cardinality(), 32);
		bitset.xor(flip(33, 64));
		Assert.assertEquals(bitset.cardinality(), 0);

		bitset = BitSetUtils.valueOf(new int[] { 0, Integer.MAX_VALUE });
		Assert.assertEquals(bitset.cardinality(), 31);
		bitset.xor(flip(33, 63));
		Assert.assertEquals(bitset.cardinality(), 0);
	}

	@Test
	public void testValueOfLongArray() {
		BitSet bitset;

		// size 0

		bitset = BitSetUtils.valueOf(new long[0]);
		Assert.assertEquals(bitset.cardinality(), 0);

		// size 1

		bitset = BitSetUtils.valueOf(new long[] { 0 });
		Assert.assertEquals(bitset.cardinality(), 0);

		bitset = BitSetUtils.valueOf(new long[] { 1 });
		Assert.assertEquals(bitset.cardinality(), 1);
		Assert.assertTrue(bitset.get(0));

		bitset = BitSetUtils.valueOf(new long[] { Long.MIN_VALUE });
		Assert.assertEquals(bitset.cardinality(), 1);
		Assert.assertTrue(bitset.get(63));

		bitset = BitSetUtils.valueOf(new long[] { -1L });
		Assert.assertEquals(bitset.cardinality(), 64);
		bitset.xor(flip(1, 64));
		Assert.assertEquals(bitset.cardinality(), 0);

		bitset = BitSetUtils.valueOf(new long[] { Long.MAX_VALUE });
		Assert.assertEquals(bitset.cardinality(), 63);
		bitset.xor(flip(1, 63));
		Assert.assertEquals(bitset.cardinality(), 0);

		// size 2

		bitset = BitSetUtils.valueOf(new long[] { 0L, 0L });
		Assert.assertEquals(bitset.cardinality(), 0);

		bitset = BitSetUtils.valueOf(new long[] { 1L, 0L });
		Assert.assertEquals(bitset.cardinality(), 1);
		Assert.assertTrue(bitset.get(0));

		bitset = BitSetUtils.valueOf(new long[] { Long.MIN_VALUE, 0L });
		Assert.assertEquals(bitset.cardinality(), 1);
		Assert.assertTrue(bitset.get(63));

		bitset = BitSetUtils.valueOf(new long[] { -1L, 0L });
		Assert.assertEquals(bitset.cardinality(), 64);
		bitset.xor(flip(1, 64));
		Assert.assertEquals(bitset.cardinality(), 0);

		bitset = BitSetUtils.valueOf(new long[] { Long.MAX_VALUE, 0L });
		Assert.assertEquals(bitset.cardinality(), 63);
		bitset.xor(flip(1, 63));
		Assert.assertEquals(bitset.cardinality(), 0);

		bitset = BitSetUtils.valueOf(new long[] { 0L, 1L });
		Assert.assertEquals(bitset.cardinality(), 1);
		Assert.assertTrue(bitset.get(64));

		bitset = BitSetUtils.valueOf(new long[] { 0L, Long.MIN_VALUE });
		Assert.assertEquals(1, bitset.cardinality());
		Assert.assertTrue(bitset.get(127));

		bitset = BitSetUtils.valueOf(new long[] { 0L, -1L });
		Assert.assertEquals(bitset.cardinality(), 64);
		bitset.xor(flip(65, 128));
		Assert.assertEquals(bitset.cardinality(), 0);

		bitset = BitSetUtils.valueOf(new long[] { 0L, Long.MAX_VALUE });
		Assert.assertEquals(bitset.cardinality(), 63);
		bitset.xor(flip(65, 127));
		Assert.assertEquals(bitset.cardinality(), 0);
	}

	private BitSet bitset(final int... idx) {
		final BitSet bitset = new BitSet();
		for (final int i : idx) {
			bitset.set(i - 1);
		}
		return bitset;
	}

	private BitSet flip(final int from, final int to) {
		final BitSet bitset = bitset();
		bitset.flip(from - 1, to);
		return bitset;
	}

}
