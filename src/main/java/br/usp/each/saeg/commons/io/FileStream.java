package br.usp.each.saeg.commons.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileStream extends Stream {

	private final File file;

	private InputStream is; // Lazy

	public FileStream(final File file) {
		if (file == null) {
			throw new IllegalArgumentException("File can't be null");
		}

		this.file = file;
	}

	@Override
	public InputStream getInputStream() throws IOException {
		if (is == null) {
			is = new FileInputStream(file);
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
