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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("unchecked")
public class PredicateChainTest {

    private PredicateChain<Object> chain;

    private Predicate<Object> truePredicate;

    private Predicate<Object> falsePredicate;

    @Before
    public void init() {
        chain = new PredicateChain<Object>();
        truePredicate = mock(Predicate.class);
        falsePredicate = mock(Predicate.class);
        when(truePredicate.test(any())).thenReturn(true);
        when(falsePredicate.test(any())).thenReturn(false);
    }

    @Test
    public void testFilterChainWithoutRules() {
        assertTrue(chain.test("some.object"));
    }

    @Test
    public void test0() {
        chain.add(truePredicate);
        assertTrue(chain.test("some.object"));
        verify(truePredicate, times(1)).test("some.object");
    }

    @Test
    public void test1() {
        chain.add(falsePredicate);
        assertFalse(chain.test("some.object"));
        verify(falsePredicate, times(1)).test("some.object");
    }

    @Test
    public void test2() {
        chain.add(truePredicate);
        chain.add(truePredicate);
        assertTrue(chain.test("some.object"));
        verify(truePredicate, times(2)).test("some.object");
    }

    @Test
    public void test3() {
        chain.add(truePredicate);
        chain.add(falsePredicate);
        assertFalse(chain.test("some.object"));
        verify(truePredicate, times(1)).test("some.object");
        verify(falsePredicate, times(1)).test("some.object");
    }

    @Test
    public void test4() {
        chain.add(falsePredicate);
        chain.add(truePredicate);
        assertFalse(chain.test("some.object"));
        verify(falsePredicate, times(1)).test("some.object");
        verify(truePredicate, times(0)).test(any());
    }

}
