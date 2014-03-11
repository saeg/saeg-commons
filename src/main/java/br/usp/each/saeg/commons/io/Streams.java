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
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Generates a List of Stream from the given file
 */
public class Streams {

    private final String fileName;

    private final File file;

    private final String ext;

    /**
     * Constructor
     * 
     * @param fileName
     *            the file from witch the List of Stream will be generated
     * @param ext
     *            the extension filter
     * @throws FileNotFoundException
     *             if fileName does not exists
     */
    public Streams(final String fileName, final String ext) throws FileNotFoundException {
        this.fileName = fileName;
        this.file = new File(fileName);
        this.ext = ext;
        if (!file.exists()) {
            throw new FileNotFoundException("File not found: " + fileName);
        }
    }

    /**
     * Generates the List of Stream from the file
     * 
     * @return the List of Stream created
     * @throws IOException
     *             if an I/O error has occurred
     */
    public List<Stream> get() throws IOException {
        List<Stream> streams = new ArrayList<Stream>();

        List<ZipEntry> zipEntries = Collections.emptyList();
        List<File> fileEntries = Collections.emptyList();

        ZipFile zfile = null;
        if (this.file.isFile()
                && (this.fileName.endsWith(".jar") || this.fileName.endsWith(".zip"))) {

            Enumeration<? extends ZipEntry> entries = null;

            zipEntries = new ArrayList<ZipEntry>();

            if (this.fileName.endsWith(".jar")) {
                zfile = new JarFile(this.file);
            } else {
                zfile = new ZipFile(this.file);
            }

            entries = zfile.entries();

            while (entries.hasMoreElements()) {
                final ZipEntry entry = entries.nextElement();
                final String entryName = entry.getName();

                if (entryName.endsWith(ext)) {
                    zipEntries.add(entry);
                }

            }

        } else if (file.isDirectory()) {
            fileEntries = Files.listRecursive(file, new FilenameFilter() {
                @Override
                public boolean accept(final File dir, final String name) {
                    return name.endsWith(ext);
                }
            });
        } else {

            if (!this.fileName.endsWith(ext)) {
                throw new IllegalArgumentException("The file extension must be .jar, .zip or "
                        + ext);
            }

        }

        if (!zipEntries.isEmpty() || !fileEntries.isEmpty()) {

            for (final ZipEntry zentry : zipEntries) {
                streams.add(new ZipStream(zfile, zentry.getName()));
            }
            for (final File file : fileEntries) {
                streams.add(new FileStream(file));
            }

            // Closing resource :)
            if (zfile != null)
                zfile.close();

        } else {
            if (file.isFile() && this.fileName.endsWith(ext))
                streams = Collections.singletonList((Stream) new FileStream(this.file));
        }

        return streams;
    }

}
