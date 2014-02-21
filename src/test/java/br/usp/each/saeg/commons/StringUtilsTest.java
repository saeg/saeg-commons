package br.usp.each.saeg.commons;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilsTest {

	@Test
	public void testIsEmpty() {
		Assert.assertTrue(StringUtils.isEmpty(""));
		Assert.assertTrue(StringUtils.isEmpty(" "));
		Assert.assertFalse(StringUtils.isEmpty("string"));
		Assert.assertFalse(StringUtils.isEmpty("  str  "));
	}

}
