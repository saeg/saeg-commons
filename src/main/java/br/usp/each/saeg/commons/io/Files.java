package br.usp.each.saeg.commons.io;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

public final class Files {

	private static final int BUFFER_SIZE = 4096;

	private static final int EOF = -1;

	private Files() {
		// no instances
	}

	public static List<File> listRecursive(final File dir, final FilenameFilter filter) {
		if (!dir.isDirectory())
			throw new RuntimeException(dir + " is not a directory");

		final List<File> files = new LinkedList<File>();
		for (final File f : dir.listFiles(filter)) {
			files.add(f);
		}
		for (final File f : dir.listFiles()) {
			if (f.isDirectory())
				files.addAll(listRecursive(f, filter));
		}
		return files;
	}

	public static byte[] toByteArray(final InputStream input) throws IOException {
		final ByteArrayOutputStream output = new ByteArrayOutputStream();
		copy(input, output);
		return output.toByteArray();
	}

	private static void copy(final InputStream input, final ByteArrayOutputStream output)
			throws IOException {

		final byte[] buffer = new byte[BUFFER_SIZE];

		int n = input.read(buffer);
		while (EOF != n) {
			output.write(buffer, 0, n);
			n = input.read(buffer);
		}

		output.flush();
	}

}
