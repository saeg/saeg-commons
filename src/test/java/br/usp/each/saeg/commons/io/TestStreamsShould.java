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
package br.usp.each.saeg.commons.io;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestStreamsShould {

    private String extFileName;

    private String jarFileName;

    private String zipFileName;

    @Before
    public void setUp() {
        extFileName = getClass().getResource("file.ext").getFile();
        jarFileName = getClass().getResource("file.jar").getFile();
        zipFileName = getClass().getResource("file.zip").getFile();
    }

    @Test
    public void ThrowAnExceptionWhenFileNameDoesNotBelongToAFile() {
        Exception exception = null;
        try {
            new Streams("some-bogus-string", ".ext");
        } catch (final FileNotFoundException e) {
            exception = e;
        }
        Assert.assertNotNull(exception);
    }

    @Test
    public void ThrowAnExceptionWhenFileExtensionDoesNotBelongToAFile() {
        Exception exception = null;
        try {
            new Streams(extFileName, ".txt").get();
        } catch (final IllegalStateException e) {
            exception = e;
        } catch (final Exception e) {
            Assert.fail("Should not happen");
        }
        Assert.assertNotNull(exception);
    }

    @Test
    public void ReturnAListWithOneElementWhenFileNameBelongsToAFile() {
        Assert.assertTrue(streams(extFileName, ".ext") == 1);
        Assert.assertTrue(streams(jarFileName, ".jar") == 1);
        Assert.assertTrue(streams(zipFileName, ".zip") == 1);
    }

    @Test
    public void ReturnAListWithAllFilesFromADirectoryRecursively() {
        Assert.assertTrue(streams("src/main/java", ".java") > 1);
    }

    @Test
    public void ReturnAnEmptyListWhenDirectoryRecursivelyHasNoFiles() {
        Assert.assertTrue(streams("src/main/java", ".class") == 0);
    }

    @Test
    public void ReturnAListWithAllFilesFromAZipFile() {
        Assert.assertTrue(streams(jarFileName, ".ext") == 1);
        Assert.assertTrue(streams(zipFileName, ".ext") == 1);
    }

    private static int streams(final String fileName, final String ext) {
        try {
            return new Streams(fileName, ext).get().size();
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }
}
