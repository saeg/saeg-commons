/**
 * saeg-commons: common utility methods
 * Copyright (c) 2014 University of Sao Paulo
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
        Assert.assertEquals(0, ArrayUtils.indexOf(new long[] { 0 }, 0L));
        Assert.assertEquals(1, ArrayUtils.indexOf(new long[] { 0, 1 }, 1L));
        Assert.assertEquals(-1, ArrayUtils.indexOf(new long[] { 0, 1 }, 2L));
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

}
