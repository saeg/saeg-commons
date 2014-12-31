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
package br.usp.each.saeg.commons.time;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;

public class TimeWatchTest {

    @Test
    public void testTimeWatchStart() {
        Assert.assertNotNull(TimeWatch.start());
    }

    @Test
    public void testTimeWatchTime() {
        final TimeWatch tw = TimeWatch.start();
        try {
            Thread.sleep(550);
        } catch (final InterruptedException ignore) {
        }
        final long time = tw.time();

        Assert.assertTrue(time >= 500);
        Assert.assertTrue(time < 700);
    }

    @Test
    public void testTimeWatchReset() {
        final TimeWatch tw = TimeWatch.start();
        try {
            Thread.sleep(550);
        } catch (final InterruptedException ignore) {
        }
        tw.reset();
        try {
            Thread.sleep(550);
        } catch (final InterruptedException ignore) {
        }
        final long time = tw.time();

        Assert.assertTrue(time >= 500);
        Assert.assertTrue(time < 700);
    }

    @Test
    public void testTimeWatchTimeConvert() {
        final TimeWatch tw = TimeWatch.start();
        try {
            Thread.sleep(550);
        } catch (final InterruptedException ignore) {
        }
        final long time = tw.time(TimeUnit.NANOSECONDS);

        Assert.assertTrue(time >= TimeUnit.MILLISECONDS.toNanos(500));
        Assert.assertTrue(time < TimeUnit.MILLISECONDS.toNanos(700));
    }

}
