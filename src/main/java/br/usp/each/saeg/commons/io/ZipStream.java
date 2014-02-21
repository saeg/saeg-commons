package br.usp.each.saeg.commons.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipStream extends Stream {

	private final ZipFile zipFile;

	private final ZipEntry zipEntry;

	private InputStream is; // Lazy

	public ZipStream(final ZipFile zipFile, final String zipEntryName) {
		if (zipFile == null) {
			throw new IllegalArgumentException("ZipFile can't be null");
		}

		this.zipFile = zipFile;
		this.zipEntry = zipFile.getEntry(zipEntryName);

		if (zipEntry == null) {
			throw new IllegalStateException(String.format(
					"%s was not found in ZipFile", zipEntryName));
		}
	}

	@Override
	public InputStream getInputStream() throws IOException {
		if (is == null) {
			is = zipFile.getInputStream(zipEntry);
		}
		return is;
	}

	@Override
	public void close() throws IOException {
		if (is != null) {
			is.close();
			is = null;
		}
	}

}
