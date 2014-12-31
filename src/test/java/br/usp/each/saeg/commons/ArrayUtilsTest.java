/**
 * saeg-commons: common utility methods
 * Copyright (c) 2014, 2015 University of Sao Paulo
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. Neither the name of the copyright holders nor the names of its
 *    contributors may be used to endorse or promote products derived from
 *    this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */
package br.usp.each.saeg.commons;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

public class ArrayUtilsTest {

    @Test
    public void testIndexOf() {
        Assert.assertEquals(-1, ArrayUtils.indexOf(new Integer[] {}, new Object()));
        Assert.assertEquals(0, ArrayUtils.indexOf(new Integer[] { 0 }, 0));
        Assert.assertEquals(1, ArrayUtils.indexOf(new Integer[] { 0, 1 }, 1));
        Assert.assertEquals(-1, ArrayUtils.indexOf(new Integer[] { 0, 1 }, 2));
    }

    @Test
    public void testIndexOfByte() {
        Assert.assertEquals(-1, ArrayUtils.indexOf(new byte[] {}, (byte) 0));
        Assert.assertEquals(0, ArrayUtils.indexOf(new byte[] { 0 }, (byte) 0));
        Assert.assertEquals(1, ArrayUtils.indexOf(new byte[] { 0, 1 }, (byte) 1));
        Assert.assertEquals(-1, ArrayUtils.indexOf(new byte[] { 0, 1 }, (byte) 2));
    }

    @Test
    public void testIndexOfShort() {
        Assert.assertEquals(-1, ArrayUtils.indexOf(new short[] {}, (short) 0));
        Assert.assertEquals(0, ArrayUtils.indexOf(new short[] { 0 }, (short) 0));
        Assert.assertEquals(1, ArrayUtils.indexOf(new short[] { 0, 1 }, (short) 1));
        Assert.assertEquals(-1, ArrayUtils.indexOf(new short[] { 0, 1 }, (short) 2));
    }

    @Test
    public void testIndexOfInt() {
        Assert.assertEquals(-1, ArrayUtils.indexOf(new int[] {}, 0));
        Assert.assertEquals(0, ArrayUtils.indexOf(new int[] { 0 }, 0));
        Assert.assertEquals(1, ArrayUtils.indexOf(new int[] { 0, 1 }, 1));
        Assert.assertEquals(-1, ArrayUtils.indexOf(new int[] { 0, 1 }, 2));
    }

    @Test
    public void testIndexOfLong() {
        Assert.assertEquals(-1, ArrayUtils.indexOf(new long[] {}, 0L));
        Assert.assertEquals(0, ArrayUtils.indexOf(new long[] { 0L }, 0L));
        Assert.assertEquals(1, ArrayUtils.indexOf(new long[] { 0L, 1L }, 1L));
        Assert.assertEquals(-1, ArrayUtils.indexOf(new long[] { 0L, 1L }, 2L));
    }

    @Test
    public void testIndexOfFloat() {
        Assert.assertEquals(-1, ArrayUtils.indexOf(new float[] {}, 0.0f));
        Assert.assertEquals(0, ArrayUtils.indexOf(new float[] { 0.0f }, 0.0f));
        Assert.assertEquals(1, ArrayUtils.indexOf(new float[] { 0.0f, 1.0f }, 1.0f));
        Assert.assertEquals(-1, ArrayUtils.indexOf(new float[] { 0.0f, 1.0f }, 2.0f));
    }

    @Test
    public void testIndexOfDouble() {
        Assert.assertEquals(-1, ArrayUtils.indexOf(new double[] {}, 0.0d));
        Assert.assertEquals(0, ArrayUtils.indexOf(new double[] { 0.0d }, 0.0d));
        Assert.assertEquals(1, ArrayUtils.indexOf(new double[] { 0.0d, 1.0d }, 1.0d));
        Assert.assertEquals(-1, ArrayUtils.indexOf(new double[] { 0.0d, 1.0d }, 2.0d));
    }

    @Test
    public void testIndexOfBoolean() {
        Assert.assertEquals(-1, ArrayUtils.indexOf(new boolean[] {}, true));
        Assert.assertEquals(0, ArrayUtils.indexOf(new boolean[] { true }, true));
        Assert.assertEquals(1, ArrayUtils.indexOf(new boolean[] { true, false }, false));
        Assert.assertEquals(-1, ArrayUtils.indexOf(new boolean[] { false, false }, true));
    }

    @Test
    public void testIndexOfChar() {
        Assert.assertEquals(-1, ArrayUtils.indexOf(new char[] {}, 'a'));
        Assert.assertEquals(0, ArrayUtils.indexOf(new char[] { 'a' }, 'a'));
        Assert.assertEquals(1, ArrayUtils.indexOf(new char[] { 'a', 'b' }, 'b'));
        Assert.assertEquals(-1, ArrayUtils.indexOf(new char[] { 'a', 'b' }, 'c'));
    }

    @Test
    public void testIndexOfAcceptNulls() {
        Assert.assertEquals(-1, ArrayUtils.indexOf(new Integer[] {}, null));
        Assert.assertEquals(0, ArrayUtils.indexOf(new Integer[] { null }, null));
        Assert.assertEquals(1, ArrayUtils.indexOf(new Integer[] { 0, null }, null));
        Assert.assertEquals(-1, ArrayUtils.indexOf(new Integer[] { 0, 1 }, null));
    }

    @Test
    public void testIndexOfShouldNotThrowNPEWhenArrayContainsNulls() {
        Assert.assertEquals(-1, ArrayUtils.indexOf(new Integer[] { null }, 0));
        Assert.assertEquals(1, ArrayUtils.indexOf(new Integer[] { null, 1 }, 1));
    }

    @Test
    public void testContains() {
        Assert.assertTrue(ArrayUtils.contains(new Integer[] { 0, 1 }, 1));
        Assert.assertFalse(ArrayUtils.contains(new Integer[] { 0, 1 }, 2));
    }

    @Test
    public void testContainsByte() {
        Assert.assertTrue(ArrayUtils.contains(new byte[] { 0, 1 }, (byte) 1));
        Assert.assertFalse(ArrayUtils.contains(new byte[] { 0, 1 }, (byte) 2));
    }

    @Test
    public void testContainsShort() {
        Assert.assertTrue(ArrayUtils.contains(new short[] { 0, 1 }, (short) 1));
        Assert.assertFalse(ArrayUtils.contains(new short[] { 0, 1 }, (short) 2));
    }

    @Test
    public void testContainsInt() {
        Assert.assertTrue(ArrayUtils.contains(new int[] { 0, 1 }, 1));
        Assert.assertFalse(ArrayUtils.contains(new int[] { 0, 1 }, 2));
    }

    @Test
    public void testContainsLong() {
        Assert.assertTrue(ArrayUtils.contains(new long[] { 0L, 1L }, 1L));
        Assert.assertFalse(ArrayUtils.contains(new long[] { 0L, 1L }, 2L));
    }

    @Test
    public void testContainsFloat() {
        Assert.assertTrue(ArrayUtils.contains(new float[] { 0.0f, 1.0f }, 1.0f));
        Assert.assertFalse(ArrayUtils.contains(new float[] { 0.0f, 1.0f }, 2.0f));
    }

    @Test
    public void testContainsDouble() {
        Assert.assertTrue(ArrayUtils.contains(new double[] { 0.0d, 1.0d }, 1.0d));
        Assert.assertFalse(ArrayUtils.contains(new double[] { 0.0d, 1.0d }, 2.0d));
    }

    @Test
    public void testContainsBoolean() {
        Assert.assertTrue(ArrayUtils.contains(new boolean[] { true, false }, false));
        Assert.assertFalse(ArrayUtils.contains(new boolean[] { false, false }, true));
    }

    @Test
    public void testContainsChar() {
        Assert.assertTrue(ArrayUtils.contains(new char[] { 'a', 'b' }, 'a'));
        Assert.assertFalse(ArrayUtils.contains(new char[] { 'a', 'b' }, 'c'));
    }

    @Test
    public void testMerge() {
        Assert.assertSame(Integer[].class, ArrayUtils.merge(new Integer[0]).getClass());

        Assert.assertArrayEquals(new Integer[] { 1, 2, 3, 4 },
                ArrayUtils.merge(new Integer[] { 1, 2 }, new Integer[] { 3, 4 }));

        Assert.assertArrayEquals(new Integer[] { 1, 2, 3 },
                ArrayUtils.merge(new Integer[] { 1 }, new Integer[] { 2 }, new Integer[] { 3 }));
    }

    @Test
    public void testMergeByte() {
        Assert.assertSame(byte[].class, ArrayUtils.merge(new byte[0]).getClass());

        Assert.assertArrayEquals(new byte[] { 1, 2, 3, 4 },
                ArrayUtils.merge(new byte[] { 1, 2 }, new byte[] { 3, 4 }));

        Assert.assertArrayEquals(new byte[] { 1, 2, 3 },
                ArrayUtils.merge(new byte[] { 1 }, new byte[] { 2 }, new byte[] { 3 }));
    }

    @Test
    public void testMergeShort() {
        Assert.assertSame(short[].class, ArrayUtils.merge(new short[0]).getClass());

        Assert.assertArrayEquals(new short[] { 1, 2, 3, 4 },
                ArrayUtils.merge(new short[] { 1, 2 }, new short[] { 3, 4 }));

        Assert.assertArrayEquals(new short[] { 1, 2, 3 },
                ArrayUtils.merge(new short[] { 1 }, new short[] { 2 }, new short[] { 3 }));
    }

    @Test
    public void testMergeInt() {
        Assert.assertSame(int[].class, ArrayUtils.merge(new int[0]).getClass());

        Assert.assertArrayEquals(new int[] { 1, 2, 3, 4 },
                ArrayUtils.merge(new int[] { 1, 2 }, new int[] { 3, 4 }));

        Assert.assertArrayEquals(new int[] { 1, 2, 3 },
                ArrayUtils.merge(new int[] { 1 }, new int[] { 2 }, new int[] { 3 }));
    }

    @Test
    public void testMergeLong() {
        Assert.assertSame(long[].class, ArrayUtils.merge(new long[0]).getClass());

        Assert.assertArrayEquals(new long[] { 1L, 2L, 3L, 4L },
                ArrayUtils.merge(new long[] { 1L, 2L }, new long[] { 3L, 4L }));

        Assert.assertArrayEquals(new long[] { 1L, 2L, 3L },
                ArrayUtils.merge(new long[] { 1L }, new long[] { 2L }, new long[] { 3L }));
    }

    @Test
    public void testMergeFloat() {
        Assert.assertSame(float[].class, ArrayUtils.merge(new float[0]).getClass());

        Assert.assertArrayEquals(new float[] { 1.0f, 2.0f, 3.0f, 4.0f },
                ArrayUtils.merge(new float[] { 1.0f, 2.0f }, new float[] { 3.0f, 4.0f }), 0.0f);

        Assert.assertArrayEquals(new float[] { 1.0f, 2.0f, 3.0f },
                ArrayUtils.merge(new float[] { 1.0f }, new float[] { 2.0f }, new float[] { 3.0f }), 0.0f);
    }

    @Test
    public void testMergeDouble() {
        Assert.assertSame(double[].class, ArrayUtils.merge(new double[0]).getClass());

        Assert.assertArrayEquals(new double[] { 1.0d, 2.0d, 3.0d, 4.0d },
                ArrayUtils.merge(new double[] { 1.0d, 2.0d }, new double[] { 3.0d, 4.0d }), 0.0d);

        Assert.assertArrayEquals(new double[] { 1.0d, 2.0d, 3.0d },
                ArrayUtils.merge(new double[] { 1.0d }, new double[] { 2.0d }, new double[] { 3.0d }), 0.0d);
    }

    @Test
    public void testMergeBoolean() {
        Assert.assertSame(boolean[].class, ArrayUtils.merge(new boolean[0]).getClass());

        Assert.assertArrayEquals(new boolean[] { false, true, true, false },
                ArrayUtils.merge(new boolean[] { false, true }, new boolean[] { true, false }));

        Assert.assertArrayEquals(new boolean[] { true, false, true },
                ArrayUtils.merge(new boolean[] { true }, new boolean[] { false }, new boolean[] { true }));
    }

    @Test
    public void testMergeChar() {
        Assert.assertSame(char[].class, ArrayUtils.merge(new char[0]).getClass());

        Assert.assertArrayEquals(new char[] { 'a', 'b', 'c', 'd' },
                ArrayUtils.merge(new char[] { 'a', 'b' }, new char[] { 'c', 'd' }));

        Assert.assertArrayEquals(new char[] { 'a', 'b', 'c' },
                ArrayUtils.merge(new char[] { 'a' }, new char[] { 'b' }, new char[] { 'c' }));
    }

    @Test
    public void testToArrayByte() {
        final Collection<Byte> bytes = new ArrayList<Byte>();
        bytes.add((byte) 0xa);
        bytes.add((byte) 0xb);
        bytes.add((byte) 0xc);
        Assert.assertArrayEquals(new byte[] { 0xa, 0xb, 0xc }, ArrayUtils.toArray(bytes, new byte[0]));
        Assert.assertArrayEquals(new byte[] { 0xa, 0xb, 0xc }, ArrayUtils.toArray(bytes, new byte[3]));
    }

    @Test
    public void testToArrayShort() {
        final Collection<Short> shorts = new ArrayList<Short>();
        shorts.add((short) 0xaa);
        shorts.add((short) 0xbb);
        shorts.add((short) 0xcc);
        Assert.assertArrayEquals(new short[] { 0xaa, 0xbb, 0xcc }, ArrayUtils.toArray(shorts, new short[0]));
        Assert.assertArrayEquals(new short[] { 0xaa, 0xbb, 0xcc }, ArrayUtils.toArray(shorts, new short[3]));
    }

    @Test
    public void testToArrayInt() {
        final Collection<Integer> ints = new ArrayList<Integer>();
        ints.add(0);
        ints.add(1);
        ints.add(2);
        Assert.assertArrayEquals(new int[] { 0, 1, 2 }, ArrayUtils.toArray(ints, new int[0]));
        Assert.assertArrayEquals(new int[] { 0, 1, 2 }, ArrayUtils.toArray(ints, new int[3]));
    }

    @Test
    public void testToArrayLong() {
        final Collection<Long> longs = new ArrayList<Long>();
        longs.add(0L);
        longs.add(1L);
        longs.add(2L);
        Assert.assertArrayEquals(new long[] { 0L, 1L, 2L }, ArrayUtils.toArray(longs, new long[0]));
        Assert.assertArrayEquals(new long[] { 0L, 1L, 2L }, ArrayUtils.toArray(longs, new long[3]));
    }

    @Test
    public void testToArrayFloat() {
        final Collection<Float> floats = new ArrayList<Float>();
        floats.add(1.1f);
        floats.add(2.2f);
        floats.add(3.3f);
        Assert.assertArrayEquals(new float[] { 1.1f, 2.2f, 3.3f }, ArrayUtils.toArray(floats, new float[0]), 0.0f);
        Assert.assertArrayEquals(new float[] { 1.1f, 2.2f, 3.3f }, ArrayUtils.toArray(floats, new float[3]), 0.0f);
    }

    @Test
    public void testToArrayDouble() {
        final Collection<Double> doubles = new ArrayList<Double>();
        doubles.add(1.1d);
        doubles.add(2.2d);
        doubles.add(3.3d);
        Assert.assertArrayEquals(new double[] { 1.1d, 2.2d, 3.3d }, ArrayUtils.toArray(doubles, new double[0]), 0.0d);
        Assert.assertArrayEquals(new double[] { 1.1d, 2.2d, 3.3d }, ArrayUtils.toArray(doubles, new double[3]), 0.0d);
    }

    @Test
    public void testToArrayBoolean() {
        final Collection<Boolean> booleans = new ArrayList<Boolean>();
        booleans.add(true);
        booleans.add(false);
        booleans.add(true);
        Assert.assertArrayEquals(new boolean[] { true, false, true }, ArrayUtils.toArray(booleans, new boolean[0]));
        Assert.assertArrayEquals(new boolean[] { true, false, true }, ArrayUtils.toArray(booleans, new boolean[3]));
    }

    @Test
    public void testToArrayChar() {
        final Collection<Character> characters = new ArrayList<Character>();
        characters.add('a');
        characters.add('b');
        characters.add('c');
        Assert.assertArrayEquals(new char[] { 'a', 'b', 'c' }, ArrayUtils.toArray(characters, new char[0]));
        Assert.assertArrayEquals(new char[] { 'a', 'b', 'c' }, ArrayUtils.toArray(characters, new char[3]));
    }

}
