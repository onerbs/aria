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
 * Randoms.
 *
 * @author  Alejandro Elí
 * @version 24/05/20
 * @since   1.0
 */
public final class Random {

	/**
	 * Returns a randomly-generated {@code boolean} value.
	 *
	 * @return {@code true} or {@code false}
	 */
	public static boolean getBoolean() {
		return ((Math.random() * 2) >= 1) ? Boolean.TRUE : Boolean.FALSE;
	}


	/**
	 * Returns a randomly-generated {@code byte} number.
	 *
	 * @param min greater than {@code   0} (<i>inclusive</i>)
	 * @param max greater than {@code min} (<i>inclusive</i>)
	 *
	 * @return Any number between {@code min} and {@code max}
	 */
	public static byte getByte(final byte min, final byte max) {
		return (byte) getDouble(min, max);
	}

	/**
	 * Returns a randomly-generated {@code byte} number.
	 *
	 * @param max A number greater than {@code 0} (<i>inclusive</i>)
	 *
	 * @return Any number between {@code 0} and {@code max}
	 */
	public static byte getByte(final byte max) {
		return getByte((byte) 0, max);
	}

	/**
	 * Returns a randomly-generated {@code byte} number.
	 *
	 * @param range min (<i>inclusive</i>), max (<i>inclusive</i>)
	 *
	 * @return Any number between {@code range.getLowestValue()} and {@code
	 * 	range.getHighestValue()}
	 */
	public static byte getByte(final Range.OfByte range) {
		return getByte(range.getLowestValue(), range.getHighestValue());
	}


	/**
	 * Returns a randomly-generated {@code short} number.
	 *
	 * @param min greater than {@code   0} (<i>inclusive</i>)
	 * @param max greater than {@code min} (<i>inclusive</i>)
	 *
	 * @return Any number between {@code min} and {@code max}
	 */
	public static short getShort(final short min, final short max) {
		return (short) getDouble(min, max);
	}

	/**
	 * Returns a randomly-generated {@code short} number.
	 *
	 * @param max A number greater than {@code 0} (<i>inclusive</i>)
	 *
	 * @return Any number between {@code 0} and {@code max}
	 */
	public static short getShort(final short max) {
		return getShort((short) 0, max);
	}

	/**
	 * Returns a randomly-generated {@code short} number.
	 *
	 * @param range min (<i>inclusive</i>), max (<i>inclusive</i>)
	 *
	 * @return Any number between {@code range.getLowestValue()} and {@code
	 * 	range.getHighestValue()}
	 */
	public static short getShort(final Range.OfShort range) {
		return getShort(range.getLowestValue(), range.getHighestValue());
	}


	/**
	 * Returns a randomly-generated {@code int} number.
	 *
	 * @param min greater than {@code   0} (<i>inclusive</i>)
	 * @param max greater than {@code min} (<i>inclusive</i>)
	 *
	 * @return Any number between {@code min} and {@code max}
	 */
	public static int getInteger(final int min, final int max) {
		return (int) Math.floor(getDouble(min, max));
	}

	/**
	 * Returns a randomly-generated {@code int} number.
	 *
	 * @param max A number greater than {@code 0} (<i>inclusive</i>)
	 *
	 * @return Any number between {@code 0} and {@code max}
	 */
	public static int getInteger(final int max) {
		return getInteger(0, max);
	}

	/**
	 * Returns a randomly-generated {@code int} number.
	 *
	 * @param range min (<i>inclusive</i>), max (<i>inclusive</i>)
	 *
	 * @return Any number between {@code range.getLowestValue()} and {@code
	 * 	range.getHighestValue()}
	 */
	public static int getInteger(final Range range) {
		return getInteger(range.getLowestValue(), range.getHighestValue());
	}


	/**
	 * Returns a randomly-generated {@code long} number.
	 *
	 * @param min greater than {@code   0} (<i>inclusive</i>)
	 * @param max greater than {@code min} (<i>inclusive</i>)
	 *
	 * @return Any number between {@code min} and {@code max}
	 */
	public static long getLong(final long min, final long max) {
		return (long) getDouble(min, max);
	}

	/**
	 * Returns a randomly-generated {@code long} number.
	 *
	 * @param max A number greater than {@code 0} (<i>inclusive</i>)
	 *
	 * @return Any number between {@code 0} and {@code max}
	 */
	public static long getLong(final long max) {
		return getLong(0, max);
	}

	/**
	 * Returns a randomly-generated {@code long} number.
	 *
	 * @param range min (<i>inclusive</i>), max (<i>inclusive</i>)
	 *
	 * @return Any number between {@code range.getLowestValue()} and {@code
	 * 	range.getHighestValue()}
	 */
	public static long getLong(final Range.OfLong range) {
		return getLong(range.getLowestValue(), range.getHighestValue());
	}


	/**
	 * Returns a randomly-generated {@code float} number.
	 *
	 * @param min greater than {@code   0} (<i>inclusive</i>)
	 * @param max greater than {@code min} (<i>inclusive</i>)
	 *
	 * @return Any number between {@code min} and {@code max}
	 */
	public static float getFloat(final float min, final float max) {
		return (float) getDouble(min, max);
	}

	/**
	 * Returns a randomly-generated {@code float} number.
	 *
	 * @param max A number greater than {@code 0} (<i>inclusive</i>)
	 *
	 * @return Any number between {@code 0} and {@code max}
	 */
	public static float getFloat(final float max) {
		return getFloat(0, max);
	}

	/**
	 * Returns a randomly-generated {@code float} number.
	 *
	 * @param range min (<i>inclusive</i>), max (<i>inclusive</i>)
	 *
	 * @return Any number between {@code range.getLowestValue()} and {@code
	 * 	range.getHighestValue()}
	 */
	public static float getFloat(final Range.OfFloat range) {
		return getFloat(range.getLowestValue(), range.getHighestValue());
	}


	/**
	 * Returns a randomly-generated {@code double} value.
	 *
	 * @param min greater than {@code   0} (<i>inclusive</i>)
	 * @param max greater than {@code min} (<i>inclusive</i>)
	 *
	 * @return Any number between {@code min} and {@code max}
	 */
	public static double getDouble(final double min, final double max) { //*
		if (min < 0 || max < min) throw new IllegalArgumentException();
		return (Math.random() * ((max + 1d) - min)) + min;
	}

	/**
	 * Returns a randomly-generated {@code double} value.
	 *
	 * @param max A number greater than {@code 0} (<i>inclusive</i>)
	 *
	 * @return Any number between {@code 0} and {@code max}
	 */
	public static double getDouble(final double max) {
		return getDouble(0, max);
	}

	/**
	 * Returns a randomly-generated {@code double} value.
	 *
	 * @param range min (<i>inclusive</i>), max (<i>inclusive</i>)
	 *
	 * @return Any number between {@code range.getLowestValue()} and {@code
	 * 	range.getHighestValue()}
	 */
	public static double getDouble(final Range.OfDouble range) {
		return getDouble(range.getLowestValue(), range.getHighestValue());
	}


	/**
	 * Returns a randomly-generated {@code char}.
	 *
	 * <p>The returned {@code char} will be uppercase if
	 * {@code uppercase == true}, lowercase otherwise.</p>
	 *
	 * @param uppercase force uppercase?
	 *
	 * @return random {@code char}
	 */
	public static char getCharacter(final boolean uppercase) {
		return (char) getByte(uppercase ? Tools.UPPERCASE : Tools.LOWERCASE);
	}

	/**
	 * Returns a randomly-generated {@code char}.
	 *
	 * <p>The returned {@code char} may be lowercase or uppercase.</p>
	 *
	 * @return random char, random case. ({@code [a-zA-Z]})
	 */
	public static char getCharacter() {
		return getCharacter(getBoolean());
	}

	/**
	 * Returns an array of randomly-generated {@code char}s.
	 *
	 * <p>The returned {@code char} will be uppercase if
	 * {@code uppercase == true}.</p>
	 *
	 * @param length    returned array length
	 * @param uppercase force uppercase?
	 *
	 * @return char[len] filled with random characters
	 */
	public static char[] getCharacters(final int length, final boolean uppercase) {
		if (length < 0)
			throw new IllegalArgumentException("Unexpected length < 0. got: " + length);
		var ret = new char[length];
		for (int i = 0; i < length; i++)
			ret[i] = getBoolean() ? getCharacter() : getNumber();
		return ret;
	}

	/**
	 * Returns an array of randomly-generated {@code char}s.
	 *
	 * <p>The returned {@code char} will be uppercase if
	 * {@code uppercase == true}.</p>
	 *
	 * @param length returned array length
	 *
	 * @return char[len] filled with random characters
	 */
	public static char[] getCharacters(final int length) {
		return getCharacters(length, getBoolean());
	}


	/**
	 * Returns a randomly-generated {@code char} number.
	 *
	 * @return random numeric character [0-9]
	 */
	public static char getNumber() {
		return (char) getByte(Tools.NUMERIC);
	}

	/**
	 * Returns a randomly-generated {@code char} number.
	 *
	 * @param length returned array length
	 *
	 * @return random numeric character [0-9]
	 */
	public static char[] getNumbers(final int length) {
		if (length < 0)
			throw new IllegalArgumentException("Unexpected length < 0. got: " + length);
		var ret = new char[length];
		for (int i = 0; i < length; i++) ret[i] = getNumber();
		return ret;
	}


	/**
	 * Return a randomly-generated {@code String}.
	 *
	 * @return random String of length 16
	 */
	public static String getString() {
		return getString(16);
	}

	/**
	 * Return a randomly-generated {@code String}.
	 *
	 * @param length The length of the string
	 *
	 * @return random String of specified length
	 */
	public static String getString(final int length) {
		return new String(getCharacters(length));
	}

	private Random() {}
}
