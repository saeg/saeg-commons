package br.usp.each.saeg.commons.io;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

public abstract class Stream implements Closeable {

	public abstract InputStream getInputStream() throws IOException;

	public byte[] getBytes() throws IOException {
		return Files.toByteArray(getInputStream());
	}

}
