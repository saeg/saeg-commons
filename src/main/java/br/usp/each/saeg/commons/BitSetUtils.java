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
