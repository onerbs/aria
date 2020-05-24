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

import java.util.ArrayList;
import java.util.List;

/**
 * Primitive Arrays.
 *
 * @author  Alejandro Elí
 * @version 24/05/20
 * @since   1.0
 */
public final class Prima {

	public static final Character[] CHARACTER = new Character[0];

	public static final Boolean[] BOOLEAN = new Boolean[0];

	public static final Integer[] INTEGER = new Integer[0];

	public static final Double[] DOUBLE = new Double[0];

	public static final Float[] FLOAT = new Float[0];

	public static final Short[] SHORT = new Short[0];

	public static final Byte[] BYTE = new Byte[0];

	public static final Long[] LONG = new Long[0];


	public static boolean[] of(final boolean... arr) { return arr; }

	public static double[] of(final double... arr) { return arr; }

	public static short[] of(final short... arr) { return arr; }

	public static float[] of(final float... arr) { return arr; }

	public static byte[] of(final byte... arr) { return arr; }

	public static char[] of(final char... arr) { return arr; }

	public static long[] of(final long... arr) { return arr; }

	public static int[] of(final int... arr) { return arr; }


	public static Character[] of(final Character... arr) { return arr; }

	public static Boolean[] of(final Boolean... arr) { return arr; }

	public static Integer[] of(final Integer... arr) { return arr; }

	public static Double[] of(final Double... arr) { return arr; }

	public static Short[] of(final Short... arr) { return arr; }

	public static Float[] of(final Float... arr) { return arr; }

	public static Byte[] of(final Byte... arr) { return arr; }

	public static Long[] of(final Long... arr) { return arr; }


	/**
	 * Returns an array from the provided list.
	 *
	 * @param list the source list
	 *
	 * @return an array from the provided list
	 */
	public static char[] ofChar(final List<Character> list) {
		var arr = new char[list.size()];
		int w = 0;
		for (var v : list) arr[w++] = v;
		return arr;
	}

	/**
	 * Returns an array from the provided list.
	 *
	 * @param list the source list
	 *
	 * @return an array from the provided list
	 */
	public static boolean[] ofBool(final List<Boolean> list) {
		var arr = new boolean[list.size()];
		int w = 0;
		for (var v : list) arr[w++] = v;
		return arr;
	}

	/**
	 * Returns an array from the provided list.
	 *
	 * @param list the source list
	 *
	 * @return an array from the provided list
	 */
	public static int[] ofInt(final List<Integer> list) {
		var arr = new int[list.size()];
		int w = 0;
		for (var v : list) arr[w++] = v;
		return arr;
	}

	/**
	 * Returns an array from the provided list.
	 *
	 * @param list the source list
	 *
	 * @return an array from the provided list
	 */
	public static double[] ofDouble(final List<Double> list) {
		var arr = new double[list.size()];
		int w = 0;
		for (var v : list) arr[w++] = v;
		return arr;
	}

	/**
	 * Returns an array from the provided list.
	 *
	 * @param list the source list
	 *
	 * @return an array from the provided list
	 */
	public static short[] ofShort(final List<Short> list) {
		var arr = new short[list.size()];
		int w = 0;
		for (var v : list) arr[w++] = v;
		return arr;
	}

	/**
	 * Returns an array from the provided list.
	 *
	 * @param list the source list
	 *
	 * @return an array from the provided list
	 */
	public static float[] ofFloat(final List<Float> list) {
		var arr = new float[list.size()];
		int w = 0;
		for (var v : list) arr[w++] = v;
		return arr;
	}

	/**
	 * Returns an array from the provided list.
	 *
	 * @param list the source list
	 *
	 * @return an array from the provided list
	 */
	public static byte[] ofByte(final List<Byte> list) {
		var arr = new byte[list.size()];
		int w = 0;
		for (var v : list) arr[w++] = v;
		return arr;
	}

	/**
	 * Returns an array from the provided list.
	 *
	 * @param list the source list
	 *
	 * @return an array from the provided list
	 */
	public static long[] ofLong(final List<Long> list) {
		var arr = new long[list.size()];
		int w = 0;
		for (var v : list) arr[w++] = v;
		return arr;
	}


	/**
	 * Returns boxed array from the provided array.
	 *
	 * @param arr the source array
	 *
	 * @return the boxed provided array
	 */
	public static Character[] Of(final char... arr) { return box(arr); }

	/**
	 * Returns boxed array from the provided array.
	 *
	 * @param arr the source array
	 *
	 * @return the boxed provided array
	 */
	public static Boolean[] Of(final boolean... arr) { return box(arr); }

	/**
	 * Returns boxed array from the provided array.
	 *
	 * @param arr the source array
	 *
	 * @return the boxed provided array
	 */
	public static Integer[] Of(final int... arr) { return box(arr); }

	/**
	 * Returns boxed array from the provided array.
	 *
	 * @param arr the source array
	 *
	 * @return the boxed provided array
	 */
	public static Double[] Of(final double... arr) { return box(arr); }

	/**
	 * Returns boxed array from the provided array.
	 *
	 * @param arr the source array
	 *
	 * @return the boxed provided array
	 */
	public static Short[] Of(final short... arr) { return box(arr); }

	/**
	 * Returns boxed array from the provided array.
	 *
	 * @param arr the source array
	 *
	 * @return the boxed provided array
	 */
	public static Float[] Of(final float... arr) { return box(arr); }

	/**
	 * Returns boxed array from the provided array.
	 *
	 * @param arr the source array
	 *
	 * @return the boxed provided array
	 */
	public static Byte[] Of(final byte... arr) { return box(arr); }

	/**
	 * Returns boxed array from the provided array.
	 *
	 * @param arr the source array
	 *
	 * @return the boxed provided array
	 */
	public static Long[] Of(final long... arr) { return box(arr); }


	public static char[] Of(final Character... arr) { return unbox(arr); }

	public static boolean[] Of(final Boolean... arr) { return unbox(arr); }

	public static int[] Of(final Integer... arr) { return unbox(arr); }

	public static double[] Of(final Double... arr) { return unbox(arr); }

	public static short[] Of(final Short... arr) { return unbox(arr); }

	public static float[] Of(final Float... arr) { return unbox(arr); }

	public static byte[] Of(final Byte... arr) { return unbox(arr); }

	public static long[] Of(final Long... arr) { return unbox(arr); }


	public static Character[] OfChar(final List<Character> list) {
		var arr = new Character[list.size()];
		int w = 0;
		for (var v : list) arr[w++] = v;
		return arr;
	}

	public static Boolean[] OfBool(final List<Boolean> list) {
		var arr = new Boolean[list.size()];
		int w = 0;
		for (var v : list) arr[w++] = v;
		return arr;
	}

	public static Integer[] OfInt(final List<Integer> list) {
		var arr = new Integer[list.size()];
		int w = 0;
		for (var v : list) arr[w++] = v;
		return arr;
	}

	public static Double[] OfDouble(final List<Double> list) {
		var arr = new Double[list.size()];
		int w = 0;
		for (var v : list) arr[w++] = v;
		return arr;
	}

	public static Short[] OfShort(final List<Short> list) {
		var arr = new Short[list.size()];
		int w = 0;
		for (var v : list) arr[w++] = v;
		return arr;
	}

	public static Float[] OfFloat(final List<Float> list) {
		var arr = new Float[list.size()];
		int w = 0;
		for (var v : list) arr[w++] = v;
		return arr;
	}

	public static Byte[] OfByte(final List<Byte> list) {
		var arr = new Byte[list.size()];
		int w = 0;
		for (var v : list) arr[w++] = v;
		return arr;
	}

	public static Long[] OfLong(final List<Long> list) {
		var arr = new Long[list.size()];
		int w = 0;
		for (var v : list) arr[w++] = v;
		return arr;
	}


	public static boolean[] toBooleans(final byte... arr) {
		var ret = new boolean[arr.length];
		var w = 0;
		for (var v : arr) ret[w++] = v > 0;
		return ret;
	}

	public static boolean[] toBooleans(final short... arr) {
		var ret = new boolean[arr.length];
		var w = 0;
		for (var v : arr) ret[w++] = v > 0;
		return ret;
	}

	public static boolean[] toBooleans(final int... arr) {
		var ret = new boolean[arr.length];
		var w = 0;
		for (var v : arr) ret[w++] = v > 0;
		return ret;
	}

	public static boolean[] toBooleans(final Number... arr) {
		var ret = new boolean[arr.length];
		var w = 0;
		for (var v : arr) ret[w++] = v.doubleValue() > 0.0;
		return ret;
	}

	public static boolean[] toBooleans(final Object... arr) {
		var ret = new boolean[arr.length];
		var w = 0;
		for (var v : arr) ret[w++] = v != null;
		return ret;
	}


	public static char[] toChars(final byte... arr) {
		var ret = new char[arr.length];
		var w = 0;
		for (var v : arr) ret[w++] = (char) v;
		return ret;
	}

	public static char[] toChars(final short... arr) {
		var ret = new char[arr.length];
		var w = 0;
		for (var v : arr) ret[w++] = (char) v;
		return ret;
	}

	public static char[] toChars(final int... arr) {
		var ret = new char[arr.length];
		var w = 0;
		for (var v : arr) ret[w++] = (char) v;
		return ret;
	}

	public static char[] toChars(final Number... arr) {
		var ret = new char[arr.length];
		var w = 0;
		for (var v : arr) ret[w++] = (char) v.intValue();
		return ret;
	}


	public static byte[] toBytes(final char... arr) {
		var ret = new byte[arr.length];
		var w = 0;
		for (var v : arr) ret[w++] = (byte) v;
		return ret;
	}

	public static byte[] toBytes(final int... arr) {
		var ret = new byte[arr.length];
		var w = 0;
		for (var v : arr) ret[w++] = (byte) v;
		return ret;
	}

	public static byte[] toBytes(final Number... arr) {
		var ret = new byte[arr.length];
		var w = 0;
		for (var v : arr) ret[w++] = v.byteValue();
		return ret;
	}


	public static int[] toInts(final char... arr) {
		var ret = new int[arr.length];
		var w = 0;
		for (var v : arr) ret[w++] = v;
		return ret;
	}

	public static int[] toInts(final Number... arr) {
		var ret = new int[arr.length];
		var w = 0;
		for (var v : arr) ret[w++] = v.intValue();
		return ret;
	}

	public static int[] toInts(final java.util.stream.IntStream is) {
		var ret = new java.util.ArrayList<Integer>();
		var it = is.iterator();
		int got;
		while ((got = it.next()) != -1) ret.add(got);
		return unbox(ret.toArray(INTEGER));
	}


	public static long[] toLongs(final byte... arr) {
		var ret = new long[arr.length];
		var w = 0;
		for (var v : arr) ret[w++] = v;
		return ret;
	}

	public static long[] toLongs(final short... arr) {
		var ret = new long[arr.length];
		var w = 0;
		for (var v : arr) ret[w++] = v;
		return ret;
	}

	public static long[] toLongs(final int... arr) {
		var ret = new long[arr.length];
		var w = 0;
		for (var v : arr) ret[w++] = v;
		return ret;
	}

	public static long[] toLongs(final Number... arr) {
		var ret = new long[arr.length];
		var w = 0;
		for (var v : arr) ret[w++] = v.longValue();
		return ret;
	}


	public static float[] toFloats(final Number... arr) {
		var ret = new float[arr.length];
		var w = 0;
		for (var v : arr) ret[w++] = v.floatValue();
		return ret;
	}


	public static double[] toDoubles(final float... arr) {
		var ret = new double[arr.length];
		var w = 0;
		for (var v : arr) ret[w++] = v;
		return ret;
	}

	public static double[] toDoubles(final Number... arr) {
		var ret = new double[arr.length];
		var w = 0;
		for (var v : arr) ret[w++] = v.doubleValue();
		return ret;
	}


	public static boolean bool(final double value) { return (value > 0.0D); }

	public static boolean bool(final float value) { return (value > 0.0f); }

	public static boolean bool(final long value) { return (value > 0L); }

	public static boolean bool(final char value) { return (value > 31); }

	public static boolean bool(final int value) { return (value > 0); }

	public static int nOfNulls(final boolean... arr) {
		var ret = 0;
		for (var v : arr) if (!v) ret++;
		return ret;
	}

	public static int nOfNulls(final char... arr) {
		var ret = 0;
		for (var v : arr) if (!bool(v)) ret++;
		return ret;
	}

	public static int nOfNulls(final byte... arr) {
		var ret = 0;
		for (var v : arr) if (!bool(v)) ret++;
		return ret;
	}

	public static int nOfNulls(final short... arr) {
		var ret = 0;
		for (var v : arr) if (!bool(v)) ret++;
		return ret;
	}

	public static int nOfNulls(final int... arr) {
		var ret = 0;
		for (var v : arr) if (!bool(v)) ret++;
		return ret;
	}

	public static int nOfNulls(final long... arr) {
		var ret = 0;
		for (var v : arr) if (!bool(v)) ret++;
		return ret;
	}

	public static int nOfNulls(final float... arr) {
		var ret = 0;
		for (var v : arr) if (!bool(v)) ret++;
		return ret;
	}

	public static int nOfNulls(final double... arr) {
		var ret = 0;
		for (var v : arr) if (!bool(v)) ret++;
		return ret;
	}


	public static boolean any(final boolean... arr) {
		return arr[Random.getInteger(arr.length - 1)];
	}

	public static char any(final char... arr) {
		return arr[Random.getInteger(arr.length - 1)];
	}

	public static byte any(final byte... arr) {
		return arr[Random.getInteger(arr.length - 1)];
	}

	public static short any(final short... arr) {
		return arr[Random.getInteger(arr.length - 1)];
	}

	public static int any(final int... arr) {
		return arr[Random.getInteger(arr.length - 1)];
	}

	public static long any(final long... arr) {
		return arr[Random.getInteger(arr.length - 1)];
	}

	public static float any(final float... arr) {
		return arr[Random.getInteger(arr.length - 1)];
	}

	public static double any(final double... arr) {
		return arr[Random.getInteger(arr.length - 1)];
	}


	public static Boolean[] box(final boolean... arr) {
		var ret = new Boolean[arr.length];
		var w = 0;
		for (var v : arr) ret[w++] = v;
		return ret;
	}

	public static Character[] box(final char... arr) {
		var ret = new Character[arr.length];
		var w = 0;
		for (var v : arr) ret[w++] = v;
		return ret;
	}

	public static Byte[] box(final byte... arr) {
		var ret = new Byte[arr.length];
		var w = 0;
		for (var v : arr) ret[w++] = v;
		return ret;
	}

	public static Short[] box(final short... arr) {
		var ret = new Short[arr.length];
		var w = 0;
		for (var v : arr) ret[w++] = v;
		return ret;
	}

	public static Integer[] box(final int... arr) {
		var ret = new Integer[arr.length];
		var w = 0;
		for (var v : arr) ret[w++] = v;
		return ret;
	}

	public static Long[] box(final long... arr) {
		var ret = new Long[arr.length];
		var w = 0;
		for (var v : arr) ret[w++] = v;
		return ret;
	}

	public static Float[] box(final float... arr) {
		var ret = new Float[arr.length];
		var w = 0;
		for (var v : arr) ret[w++] = v;
		return ret;
	}

	public static Double[] box(final double... arr) {
		var ret = new Double[arr.length];
		var w = 0;
		for (var v : arr) ret[w++] = v;
		return ret;
	}


	public static boolean[] unbox(final Boolean... arr) {
		var ret = new boolean[arr.length];
		var w = 0;
		for (var v : arr) ret[w++] = v;
		return ret;
	}

	public static char[] unbox(final Character... arr) {
		var ret = new char[arr.length];
		var w = 0;
		for (var v : arr) ret[w++] = v;
		return ret;
	}

	public static byte[] unbox(final Byte... arr) {
		var ret = new byte[arr.length];
		var w = 0;
		for (var v : arr) ret[w++] = v;
		return ret;
	}

	public static short[] unbox(final Short... arr) {
		var ret = new short[arr.length];
		var w = 0;
		for (var v : arr) ret[w++] = v;
		return ret;
	}

	public static int[] unbox(final Integer... arr) {
		var ret = new int[arr.length];
		var w = 0;
		for (var v : arr) ret[w++] = v;
		return ret;
	}

	public static long[] unbox(final Long... arr) {
		var ret = new long[arr.length];
		var w = 0;
		for (var v : arr) ret[w++] = v;
		return ret;
	}

	public static float[] unbox(final Float... arr) {
		var ret = new float[arr.length];
		var w = 0;
		for (var v : arr) ret[w++] = v;
		return ret;
	}

	public static double[] unbox(final Double... arr) {
		var ret = new double[arr.length];
		var w = 0;
		for (var v : arr) ret[w++] = v;
		return ret;
	}


	public static boolean[] clean(final boolean... arr) {
		var ret = new boolean[arr.length - nOfNulls(arr)];
		var w = 0;
		for (var v : arr) if (v) ret[w++] = v;
		return ret;
	}

	public static char[] clean(final char... arr) {
		var ret = new char[arr.length - nOfNulls(arr)];
		var w = 0;
		for (var v : arr) if (bool(v)) ret[w++] = v;
		return ret;
	}

	public static byte[] clean(final byte... arr) {
		var ret = new byte[arr.length - nOfNulls(arr)];
		var w = 0;
		for (var v : arr) if (bool(v)) ret[w++] = v;
		return ret;
	}

	public static short[] clean(final short... arr) {
		var ret = new short[arr.length - nOfNulls(arr)];
		var w = 0;
		for (var v : arr) if (bool(v)) ret[w++] = v;
		return ret;
	}

	public static int[] clean(final int... arr) {
		var ret = new int[arr.length - nOfNulls(arr)];
		var w = 0;
		for (var v : arr) if (bool(v)) ret[w++] = v;
		return ret;
	}

	public static long[] clean(final long... arr) {
		var ret = new long[arr.length - nOfNulls(arr)];
		var w = 0;
		for (var v : arr) if (bool(v)) ret[w++] = v;
		return ret;
	}

	public static float[] clean(final float... arr) {
		var ret = new float[arr.length - nOfNulls(arr)];
		var w = 0;
		for (var v : arr) if (bool(v)) ret[w++] = v;
		return ret;
	}

	public static double[] clean(final double... arr) {
		var ret = new double[arr.length - nOfNulls(arr)];
		var w = 0;
		for (var v : arr) if (bool(v)) ret[w++] = v;
		return ret;
	}


	public static ArrayList<Boolean> list(final boolean... arr) {
		var ret = new ArrayList<Boolean>();
		for (var v : arr) ret.add(v);
		return ret;
	}

	public static ArrayList<Character> list(final char... arr) {
		var ret = new ArrayList<Character>();
		for (var v : arr) ret.add(v);
		return ret;
	}

	public static ArrayList<Byte> list(final byte... arr) {
		var ret = new ArrayList<Byte>();
		for (var v : arr) ret.add(v);
		return ret;
	}

	public static ArrayList<Short> list(final short... arr) {
		var ret = new ArrayList<Short>();
		for (var v : arr) ret.add(v);
		return ret;
	}

	public static ArrayList<Integer> list(final int... arr) {
		var ret = new ArrayList<Integer>();
		for (var v : arr) ret.add(v);
		return ret;
	}

	public static ArrayList<Long> list(final long... arr) {
		var ret = new ArrayList<Long>();
		for (var v : arr) ret.add(v);
		return ret;
	}

	public static ArrayList<Float> list(final float... arr) {
		var ret = new ArrayList<Float>();
		for (var v : arr) ret.add(v);
		return ret;
	}

	public static ArrayList<Double> list(final double... arr) {
		var ret = new ArrayList<Double>();
		for (var v : arr) ret.add(v);
		return ret;
	}


	public static ArrayList<Character> uniqueList(final char... arr) {
		var ret = new ArrayList<Character>();
		for (var v : arr) if (!ret.contains(v)) ret.add(v);
		return ret;
	}

	public static ArrayList<Byte> uniqueList(final byte... arr) {
		var ret = new ArrayList<Byte>();
		for (var v : arr) if (!ret.contains(v)) ret.add(v);
		return ret;
	}

	public static ArrayList<Short> uniqueList(final short... arr) {
		var ret = new ArrayList<Short>();
		for (var v : arr) if (!ret.contains(v)) ret.add(v);
		return ret;
	}

	public static ArrayList<Integer> uniqueList(final int... arr) {
		var ret = new ArrayList<Integer>();
		for (var v : arr) if (!ret.contains(v)) ret.add(v);
		return ret;
	}

	public static ArrayList<Long> uniqueList(final long... arr) {
		var ret = new ArrayList<Long>();
		for (var v : arr) if (!ret.contains(v)) ret.add(v);
		return ret;
	}

	public static ArrayList<Float> uniqueList(final float... arr) {
		var ret = new ArrayList<Float>();
		for (var v : arr) if (!ret.contains(v)) ret.add(v);
		return ret;
	}

	public static ArrayList<Double> uniqueList(final double... arr) {
		var ret = new ArrayList<Double>();
		for (var v : arr) if (!ret.contains(v)) ret.add(v);
		return ret;
	}


	public static boolean[] reverse(final boolean... arr) {
		var len = arr.length;
		var ret = new boolean[len];
		for (int i = 0, j = len - 1; j >= 0; i++, j--)
			ret[i] = arr[j];
		return ret;
	}

	public static char[] reverse(final char... arr) {
		var len = arr.length;
		var ret = new char[len];
		for (int i = 0, j = len - 1; j >= 0; i++, j--)
			ret[i] = arr[j];
		return ret;
	}

	public static byte[] reverse(final byte... arr) {
		var len = arr.length;
		var ret = new byte[len];
		for (int i = 0, j = len - 1; j >= 0; i++, j--)
			ret[i] = arr[j];
		return ret;
	}

	public static short[] reverse(final short... arr) {
		var len = arr.length;
		var ret = new short[len];
		for (int i = 0, j = len - 1; j >= 0; i++, j--)
			ret[i] = arr[j];
		return ret;
	}

	public static int[] reverse(final int... arr) {
		var len = arr.length;
		var ret = new int[len];
		for (int i = 0, j = len - 1; j >= 0; i++, j--)
			ret[i] = arr[j];
		return ret;
	}

	public static long[] reverse(final long... arr) {
		var len = arr.length;
		var ret = new long[len];
		for (int i = 0, j = len - 1; j >= 0; i++, j--)
			ret[i] = arr[j];
		return ret;
	}

	public static float[] reverse(final float... arr) {
		var len = arr.length;
		var ret = new float[len];
		for (int i = 0, j = len - 1; j >= 0; i++, j--)
			ret[i] = arr[j];
		return ret;
	}

	public static double[] reverse(final double... arr) {
		var len = arr.length;
		var ret = new double[len];
		for (int i = 0, j = len - 1; j >= 0; i++, j--)
			ret[i] = arr[j];
		return ret;
	}

	private Prima() {}
}
