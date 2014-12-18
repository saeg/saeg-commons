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

import java.util.BitSet;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BitSetIteratorTest {

    private BitSet bs;

    @Before
    public void setUp() {
        bs = new BitSet();
    }

    @Test
    public void testHasNext() {
        bs.set(0);
        Assert.assertTrue(new BitSetIterator(bs).hasNext());
    }

    @Test
    public void testHasNoNext() {
        Assert.assertFalse(new BitSetIterator(bs).hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void testNextTrowsAnException() {
        new BitSetIterator(bs).next();
    }

    @Test
    public void testNext() {
        bs.set(3);
        Assert.assertEquals(3, new BitSetIterator(bs).next());
    }

    @Test
    public void testNextAndHasNext() {
        bs.set(3);
        bs.set(8);
        final BitSetIterator it = new BitSetIterator(bs);
        it.next();
        Assert.assertTrue(it.hasNext());
    }

    @Test
    public void testNextAndHasNoNext() {
        bs.set(5);
        final BitSetIterator it = new BitSetIterator(bs);
        it.next();
        Assert.assertFalse(it.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void testNextAndNextTrowsAnException() {
        bs.set(2);
        final BitSetIterator it = new BitSetIterator(bs);
        it.next();
        it.next();
    }

    @Test
    public void testNextAndNext() {
        bs.set(1);
        bs.set(3);
        final BitSetIterator it = new BitSetIterator(bs);
        it.next();
        Assert.assertEquals(3, it.next());
    }

    @Test
    public void testSize() {
        final BitSet bs = new BitSet();
        Assert.assertEquals(0, new BitSetIterator(bs).size());
        bs.set(4);
        Assert.assertEquals(1, new BitSetIterator(bs).size());
        bs.set(2);
        Assert.assertEquals(2, new BitSetIterator(bs).size());
    }

}
