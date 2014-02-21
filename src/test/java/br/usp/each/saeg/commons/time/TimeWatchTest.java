package br.usp.each.saeg.commons.time;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;

public class TimeWatchTest {

	@Test
	public void testTimeWatchStart() {
		Assert.assertNotNull(TimeWatch.start());
	}

	@Test
	public void testTimeWatchTime() {
		final TimeWatch tw = TimeWatch.start();
		try {
			Thread.sleep(550);
		} catch (final InterruptedException ignore) {
		}
		final long time = tw.time();

		Assert.assertTrue(time >= 500);
		Assert.assertTrue(time < 700);
	}

	@Test
	public void testTimeWatchReset() {
		final TimeWatch tw = TimeWatch.start();
		try {
			Thread.sleep(550);
		} catch (final InterruptedException ignore) {
		}
		tw.reset();
		try {
			Thread.sleep(550);
		} catch (final InterruptedException ignore) {
		}
		final long time = tw.time();

		Assert.assertTrue(time >= 500);
		Assert.assertTrue(time < 700);
	}

	@Test
	public void testTimeWatchTimeConvert() {
		final TimeWatch tw = TimeWatch.start();
		try {
			Thread.sleep(550);
		} catch (final InterruptedException ignore) {
		}
		final long time = tw.time(TimeUnit.NANOSECONDS);

		Assert.assertTrue(time >= TimeUnit.MILLISECONDS.toNanos(500));
		Assert.assertTrue(time < TimeUnit.MILLISECONDS.toNanos(700));
	}

}
