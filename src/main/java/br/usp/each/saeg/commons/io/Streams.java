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
				throw new IllegalArgumentException("The file extension must be .jar, .zip or " + ext);
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
