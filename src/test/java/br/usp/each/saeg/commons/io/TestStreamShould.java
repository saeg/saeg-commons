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
package br.usp.each.saeg.commons.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.jar.JarFile;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestStreamShould {

    private File file;

    private Stream stream;

    @Before
    public void setUp() {
        file = new File(getClass().getResource("file.jar").getFile());
    }

    @After
    public void tearDown() {
        if (stream != null) {
            try {
                stream.close();
            } catch (final IOException ignore) {
                /* ignore exceptions */
            }
        }
    }

    @Test
    public void ThrowAnExceptionWhenFileIsNull() {
        Exception exception = null;
        try {
            new FileStream(null);
        } catch (final Exception e) {
            exception = e;
        }
        Assert.assertTrue(exception instanceof IllegalArgumentException);
    }

    @Test
    public void ThrowAnExceptionWhenZipFileIsNull() {
        Exception exception = null;
        try {
            new ZipStream(null, "some-bogus-string");
        } catch (final Exception e) {
            exception = e;
        }
        Assert.assertTrue(exception instanceof IllegalArgumentException);
    }

    @Test
    public void ThrowAnExceptionWhenZipEntryNameDoesNotBelongToAZipFile() {
        Exception exception = null;
        try {
            new ZipStream(new JarFile(file), "some-bogus-string");
        } catch (final Exception e) {
            exception = e;
        }
        Assert.assertTrue(exception instanceof IllegalStateException);
    }

    @Test
    public void GetBytesFromAFileCorrectly() throws IOException {
        Assert.assertNotNull(fileStream().getBytes());
    }

    @Test
    public void GetBytesFromAZipFileCorrectly() throws IOException {
        Assert.assertNotNull(zipStream().getBytes());
    }

    @Test
    public void ReturnAInputStreamFromAFile() throws IOException {
        Assert.assertNotNull(fileStream().getInputStream());
    }

    @Test
    public void ReturnAInputStreamFromAZipFile() throws IOException {
        Assert.assertNotNull(zipStream().getInputStream());
    }

    @Test
    public void ReturnTheSameInputStreamFromAFile() throws IOException {
        final InputStream expected = fileStream().getInputStream();
        Assert.assertSame(expected, stream.getInputStream());
    }

    @Test
    public void ReturnTheSameInputStreamFromAZipFile() throws IOException {
        final InputStream expected = zipStream().getInputStream();
        Assert.assertSame(expected, stream.getInputStream());
    }

    // --- auxiliary methods

    private ZipStream zipStream() throws IOException {
        final ZipStream zs = new ZipStream(new JarFile(file), "file.ext");
        stream = zs;
        return zs;
    }

    private FileStream fileStream() {
        final FileStream fs = new FileStream(file);
        stream = fs;
        return fs;
    }

}
