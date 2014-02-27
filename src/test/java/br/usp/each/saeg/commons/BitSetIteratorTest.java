package br.usp.each.saeg.commons;

import java.util.BitSet;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BitSetIteratorTest {

	private BitSet bs;

	@Before
	public void setUp() {
		bs = new BitSet();
	}

	@Test
	public void testHasNext() {
		bs.set(0);
		Assert.assertTrue(new BitSetIterator(bs).hasNext());
	}

	@Test
	public void testHasNoNext() {
		Assert.assertFalse(new BitSetIterator(bs).hasNext());
	}

	@Test(expected = NoSuchElementException.class)
	public void testNextTrowsAnException() {
		new BitSetIterator(bs).next();
	}

	@Test
	public void testNext() {
		bs.set(3);
		Assert.assertEquals(3, new BitSetIterator(bs).next());
	}

	@Test
	public void testNextAndHasNext() {
		bs.set(3);
		bs.set(8);
		final BitSetIterator it = new BitSetIterator(bs);
		it.next();
		Assert.assertTrue(it.hasNext());
	}

	@Test
	public void testNextAndHasNoNext() {
		bs.set(5);
		final BitSetIterator it = new BitSetIterator(bs);
		it.next();
		Assert.assertFalse(it.hasNext());
	}

	@Test(expected = NoSuchElementException.class)
	public void testNextAndNextTrowsAnException() {
		bs.set(2);
		final BitSetIterator it = new BitSetIterator(bs);
		it.next();
		it.next();
	}

	@Test
	public void testNextAndNext() {
		bs.set(1);
		bs.set(3);
		final BitSetIterator it = new BitSetIterator(bs);
		it.next();
		Assert.assertEquals(3, it.next());
	}

}
