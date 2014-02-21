package br.usp.each.saeg.commons.time;

import java.util.concurrent.TimeUnit;

public final class TimeWatch {

	private long starts;

	public static TimeWatch start() {
		return new TimeWatch();
	}

	private TimeWatch() {
		reset();
	}

	public TimeWatch reset() {
		starts = System.currentTimeMillis();
		return this;
	}

	public long time() {
		final long ends = System.currentTimeMillis();
		return ends - starts;
	}

	public long time(final TimeUnit unit) {
		return unit.convert(time(), TimeUnit.MILLISECONDS);
	}

}
