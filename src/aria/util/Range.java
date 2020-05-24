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

import java.util.Iterator;

import static aria.util.Tools.fit;

/**
 * Range of Integer.
 *
 * @author  Alejandro Elí
 * @version 24/05/20
 * @since   1.0
 */
public class Range extends AbstractIntRange<Integer> {

	/**
	 * Create a new Range from {@code startValue} to {@code finalValue}.
	 *
	 * @param startValue the start value of this range (inclusive)
	 * @param finalValue the final value of this range (inclusive)
	 */
	public Range(final int startValue, final int finalValue) {
		super(startValue, finalValue);
	}

	@Override
	public Integer[] toArray(final Integer step) {
		var arr = new Integer[fit(step, highestValue - lowestValue)[0] + 1];
		Tools.seq(arr, startValue, step, descending);
		return arr;
	}

	@Override
	public Integer[] toArray() {
		return toArray(1);
	}

	/**
	 * Range of Byte.
	 *
	 * @author  Alejandro Elí
	 * @version 24/05/20
	 * @since   1.0
	 */
	public static class OfByte extends AbstractIntRange<Byte> {

		/**
		 * Create a new Range from {@code startValue} to {@code finalValue}.
		 *
		 * @param startValue the start value of this range (inclusive)
		 * @param finalValue the final value of this range (inclusive)
		 */
		public OfByte(final byte startValue, final byte finalValue) {
			super(startValue, finalValue);
		}

		@Override
		public Byte[] toArray(final Byte step) {
			var arr = new Byte[fit(step, highestValue - lowestValue)[0] + 1];
			Tools.seq(arr, startValue, step, descending);
			return arr;
		}

		@Override
		public Byte[] toArray() {
			return toArray((byte) 1);
		}
	}


	/**
	 * Range of Short.
	 *
	 * @author  Alejandro Elí
	 * @version 24/05/20
	 * @since   1.0
	 */
	public static class OfShort extends AbstractIntRange<Short> {

		/**
		 * Create a new Range from {@code startValue} to {@code finalValue}.
		 *
		 * @param startValue the start value of this range (inclusive)
		 * @param finalValue the final value of this range (inclusive)
		 */
		public OfShort(final short startValue, final short finalValue) {
			super(startValue, finalValue);
		}

		@Override
		public Short[] toArray(final Short step) {
			var arr = new Short[fit(step, highestValue - lowestValue)[0] + 1];
			Tools.seq(arr, startValue, step, descending);
			return arr;
		}

		@Override
		public Short[] toArray() {
			return toArray((short) 1);
		}
	}


	/**
	 * Range of Long.
	 *
	 * @author  Alejandro Elí
	 * @version 24/05/20
	 * @since   1.0
	 */
	public static class OfLong extends AbstractRange<Long> {

		/**
		 * Create a new Range from {@code startValue} to {@code finalValue}.
		 *
		 * @param startValue the start value of this range (inclusive)
		 * @param finalValue the final value of this range (inclusive)
		 */
		public OfLong(final long startValue, final long finalValue) {
			super(startValue, finalValue);
		}

		@Override
		public Long[] toArray(final Long step) {
			var arr = new Long[fit((int) (long) step, (int) (highestValue - lowestValue))[0] + 1];
			Tools.seq(arr, startValue, step, descending);
			return arr;
		}

		@Override
		public Long[] toArray() {
			return toArray((long) 1);
		}
	}


	/**
	 * Range of Float.
	 *
	 * @author  Alejandro Elí
	 * @version 24/05/20
	 * @since   1.0
	 */
	public static class OfFloat extends AbstractRange<Float> {

		/**
		 * Create a new Range from {@code startValue} to {@code finalValue}.
		 *
		 * @param startValue the start value of this range (inclusive)
		 * @param finalValue the final value of this range (inclusive)
		 */
		public OfFloat(final float startValue, final float finalValue) {
			super(startValue, finalValue);
		}

		@Override
		public Float[] toArray(final Float step) {
			var arr = new Float[fit((int) (float) step, (int) (highestValue - lowestValue))[0] + 1];
			Tools.seq(arr, startValue, step, descending);
			return arr;
		}

		@Override
		public Float[] toArray() {
			return toArray((float) 1);
		}
	}


	/**
	 * Range of Double.
	 *
	 * @author  Alejandro Elí
	 * @version 24/05/20
	 * @since   1.0
	 */
	public static class OfDouble extends AbstractRange<Double> {

		/**
		 * Create a new Range from {@code startValue} to {@code finalValue}.
		 *
		 * @param startValue the start value of this range (inclusive)
		 * @param finalValue the final value of this range (inclusive)
		 */
		public OfDouble(final double startValue, final double finalValue) {
			super(startValue, finalValue);
		}

		@Override
		public Double[] toArray(final Double step) {
			var arr = new Double[fit((int) (double) step, (int) (highestValue - lowestValue))[0] + 1];
			Tools.seq(arr, startValue, step, descending);
			return arr;
		}

		@Override
		public Double[] toArray() {
			return toArray((double) 1);
		}
	}
}


/**
 * Range Interface.
 *
 * @param <N> Number Type
 *
 * @author  Alejandro Elí
 * @version 24/05/20
 * @since   1.0
 */
interface RangeInterface<N extends Number> extends Iterable<N> {

	/**
	 * Check if the provided number fits within this range.
	 *
	 * @param number The number to be checked
	 *
	 * @return {@code true} if the provided number fits within the inner array
	 * 	boundaries
	 */
	default boolean admit(final Number number) {
		if (null == number) return false;
		var lowest = getLowestValue().doubleValue();
		var highest = getHighestValue().doubleValue();
		var n = number.doubleValue();
		return ((lowest <= n) && (n <= highest));
	}

	/**
	 * Check if the provided range fits within this range.
	 *
	 * @param range The number to be checked
	 *
	 * @return {@code true} if the provided number fits within the inner array
	 * 	boundaries
	 */
	default boolean admit(RangeInterface<N> range) {
		if (null == range) return false;
		return getLowestValue().doubleValue() <= range.getLowestValue().doubleValue() && getHighestValue().doubleValue() >= range.getHighestValue().doubleValue();
	}

	/**
	 * Retrieve the final value of this range.
	 *
	 * @return the final value of this range
	 */
	N getFinalValue();

	/**
	 * Retrieve the highest value of this range.
	 *
	 * @return the highest value of this range
	 */
	N getHighestValue();

	/**
	 * Retrieve the lowest value of this range.
	 *
	 * @return the lowest value of this range
	 */
	N getLowestValue();

	/**
	 * Retrieve the start value of this range.
	 *
	 * @return the start value of this range
	 */
	N getStartValue();

	/**
	 * Know if this range is in descending order.
	 *
	 * @return {@code true} if this range is in descending order (i.e. {@code
	 * 	startValue > finalValue}).
	 */
	boolean isDescending();

	/**
	 * Returns an iterator over this range.
	 *
	 * @return an iterator over this range
	 *
	 * @see #toArray()
	 */
	@Override
	default Iterator<N> iterator() {
		return new ArrayIterator<>(toArray());
	}

	/**
	 * Returns an iterator over this range.
	 *
	 * @param step Incremental step
	 *
	 * @return an iterator over this range
	 *
	 * @see #toArray(Number))
	 */
	default Iterator<N> iterator(final N step) {
		return new ArrayIterator<>(toArray(step));
	}

	/**
	 * Create an array of numbers from this range, incrementing by {@code step}.
	 *
	 * <p><b>Example:</b> If this is a range {@code 1 -> 5} and the step
	 * is set to 2, then the array will be {@code [1, 3, 5]}.</p>
	 *
	 * <p>Possible loss of data is warned (i.e. The ranges {@code 1 -> 5}
	 * and {@code 1 -> 6} will give the same array as result if the step is set to
	 * 2).</p>
	 *
	 * @param step The step
	 *
	 * @return An array of numbers from this range
	 */
	N[] toArray(N step);

	/**
	 * Create an array of numbers from this range.
	 *
	 * <p><b>Example:</b> If this is a range {@code 1 -> 5},
	 * then the array will be {@code [1, 2, 3, 4, 5]}.</p>
	 *
	 * @return An array of numbers from this range
	 */
	N[] toArray();
}
