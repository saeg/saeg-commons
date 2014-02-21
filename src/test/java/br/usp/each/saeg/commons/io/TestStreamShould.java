package br.usp.each.saeg.commons.io;

import java.io.File;
import java.io.IOException;
import java.util.jar.JarFile;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestStreamShould {

	private File file;

	@Before
	public void setUp() {
		file = new File(getClass().getResource("file.jar").getFile());
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
		Stream stream = null;
		try {
			stream = new FileStream(file);
			Assert.assertNotNull(stream.getBytes());
		} catch (final Exception e) {
			Assert.fail(e.getMessage());
		} finally {
			stream.close();
		}
	}

	@Test
	public void GetBytesFromAZipFileCorrectly() throws IOException {
		Stream stream = null;
		try {
			stream = new ZipStream(new JarFile(file), "file.ext");
			Assert.assertNotNull(stream.getBytes());
		} catch (final Exception e) {
			Assert.fail(e.getMessage());
		} finally {
			stream.close();
		}
	}

}
