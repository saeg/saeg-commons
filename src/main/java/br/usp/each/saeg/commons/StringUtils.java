package br.usp.each.saeg.commons;

public final class StringUtils {

	private StringUtils() {
		// no instances
	}

	public static boolean isEmpty(final CharSequence cs) {
		for (int i = 0; i < cs.length(); i++) {
			if (!Character.isWhitespace(cs.charAt(i))) {
				return false;
			}
		}
		return true;
	}

}
