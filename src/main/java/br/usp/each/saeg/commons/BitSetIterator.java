package br.usp.each.saeg.commons;

import java.util.BitSet;
import java.util.NoSuchElementException;

public class BitSetIterator {

	private final BitSet bs;

	private int cur;

	public BitSetIterator(final BitSet bs) {
		this.bs = (BitSet) bs.clone();
		cur = bs.nextSetBit(0);
	}

	public boolean hasNext() {
		return cur != -1;
	}

	public int next() {
		if (cur == -1)
			throw new NoSuchElementException();

		final int oldCur = cur;
		cur = bs.nextSetBit(cur + 1);
		return oldCur;
	}

	public int size() {
		return bs.cardinality();
	}

}
