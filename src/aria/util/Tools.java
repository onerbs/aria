/*
 * Copyright (C) 2020 Alejandro Elí
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package aria.util;

/**
 * Tools.
 *
 * @author  Alejandro Elí
 * @version 24/05/20
 * @since   1.0
 */
public final class Tools {

	/** The numeric characters Range. [0-9] */
	public static final Range.OfByte NUMERIC = new Range.OfByte((byte) 48, (byte) 57);

	/** The uppercase letters Range. [A-Z] */
	public static final Range.OfByte UPPERCASE = new Range.OfByte((byte) 65, (byte) 90);

	/** The lowercase letters Range. [a-z] */
	public static final Range.OfByte LOWERCASE = new Range.OfByte((byte) 97, (byte) 122);

	public static boolean bool(final Number n) {
		return !(n.doubleValue() == 0);
	}

	public static boolean bool(final String str) {
		return !(null == str || str.isBlank());
	}

	//@!fmt
	public static Boolean   box(final boolean b) { return b; }

	public static Character box(final char c)    { return c; }

	public static Byte      box(final byte n)    { return n; }

	public static Short     box(final short n)   { return n; }

	public static Integer   box(final int n)     { return n; }

	public static Long      box(final long n)    { return n; }

	public static Float     box(final float n)   { return n; }

	public static Double    box(final double n)  { return n; }
	//@fmt

	private static boolean checkCase(final Range.OfByte range, final String str) {
		for (int i = 0; i < str.length(); i++) {
			if (!range.admit(str.codePointAt(i))) {
				return false;
			}
		}
		return true;
	}

	@SafeVarargs
	public static <G> boolean equalsAll(final G obj, final G... args) {
		for (G e : args) if (!obj.equals(e)) return false;
		return true;
	}

	/**
	 * Check how many times A fits on B.
	 *
	 * @param min (A)
	 * @param max (B)
	 *
	 * @return [times, rest?]
	 */
	public static int[] fit(final int min, final int max) {
		int i = 0;
		int m = max;
		for (; m >= min; i++) m -= min;
		return new int[]{i, ((i * min) < max) ? (max - (i * min)) : 0};
	}

	/**
	 * Check if the provided number is even.
	 *
	 * @param n The number to be checked
	 *
	 * @return {@code true} if the provided number is par
	 */
	public static boolean isEven(final Number n) {
		var s = String.valueOf(n.doubleValue());
		var e = Math.pow(10, (s.length() - 1) - s.indexOf('.'));
		return ((n.doubleValue() * e) % 2 == 0);
	}

	/**
	 * Check if the provided character is an alpha character. [a-zA-Z]
	 *
	 * @param c The character to be checked
	 *
	 * @return {@code true} if the provided character is an alpha character
	 */
	public static boolean isLetter(final char c) {
		return isLowerCase(c) || isUpperCase(c);
	}

	public static boolean isLowerCase(final char ch) {
		return LOWERCASE.admit((int) ch);
	}

	public static boolean isLowerCase(final String seq) {
		return checkCase(LOWERCASE, seq);
	}

	public static boolean isNumber(final char ch) {
		return NUMERIC.admit((int) ch);
	}

	public static boolean isUpperCase(final char ch) {
		return UPPERCASE.admit((int) ch);
	}

	public static boolean isUpperCase(final String seq) {
		return checkCase(UPPERCASE, seq);
	}

	/**
	 * Normalize a number.
	 *
	 * <p><b>Example</b>:<pre>{@code
	 * normalize(-1, 0, 5); // => 4
	 * normalize(0, 0, 5);  // => 0
	 * normalize(5, 0, 5);  // => 0
	 * normalize(6, 0, 5);  // => 1
	 * }</pre>
	 *
	 * <p>Note that for this work properly, {@code max} should be greater than or
	 * equal to {@code min}.
	 *
	 * @param number the number to be normalized
	 * @param min    the lowest value  (inclusive)
	 * @param max    the highest value (exclusive)
	 *
	 * @return the normalized value
	 */
	public static int normalize(final int number, final int min, final int max) {
		final int delta = max - min + (min == 0 ? 1 : 0);
		int n = number;
		while (n > max) n -= delta;
		while (n < min) n += delta;
		return n;
	}

	/**
	 * Normalize numbers.
	 *
	 * @param min inclusive
	 * @param max inclusive
	 * @param ns  numbers to be normalized
	 *
	 * @return an array of the normalized numbers in the provided order
	 *
	 * @see #normalize(int, int, int)
	 */
	public static int[] normalizeArray(final int min, final int max, final int... ns) {
		var normalized = new int[ns.length];
		for (int i = 0; i < ns.length; i++) {
			normalized[i] = normalize(ns[i], min, max);
		}
		return normalized;
	}

	/**
	 * Generate a path from the provided arguments.
	 *
	 * @param args The parts of the path
	 *
	 * @return A string representation of the generated path
	 */
	public static String path(final String... args) {
		var path = new java.util.StringJoiner(aria.Local.FS);
		for (var arg : args) {
			if (bool(arg)) path.add(arg);
		}
		return path.toString();
	}

	@SuppressWarnings("unchecked")
	public static <T extends Number> void seq(T[] src, T from, T step, boolean descending) {
		for (int i = 0; i < src.length; i++) {
			final var next = step.doubleValue() * i * (descending ? -1 : 1);
			src[i] = (T) box(from.doubleValue() + next);
		}
	}

	private Tools() {}
}
