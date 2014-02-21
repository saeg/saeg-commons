package br.usp.each.saeg.commons.io;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestStreamsShould {

	private String fileName;

	@Before
	public void setUp() {
		fileName = getClass().getResource("file.jar").getFile();
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
	public void ReturnAListWithOneElementWhenFileNameBelongsToAFile() {
		Assert.assertTrue(streams(fileName, ".jar") == 1);
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
		Assert.assertTrue(streams(fileName, ".ext") == 1);
	}

	private static int streams(final String fileName, final String ext) {
		try {
			return new Streams(fileName, ext).get().size();
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}
	}
}
