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

import java.util.stream.IntStream;

/**
 * Abstract Range.
 *
 * @param <N> Number Type
 *
 * @author Alejandro Elí
 * @version 02/11/19
 * @since 1.0
 */
public abstract class AbstractRange<N extends Number> implements RangeInterface<N> {

	/** The starting value of this range (inclusive). */
	protected N startValue;

	/** The final value of this range (inclusive). */
	protected N finalValue;

	/** The highest value of this range. */
	protected N highestValue;

	/** The lowest value of this range. */
	protected N lowestValue;

	/** The order of this range. */
	protected boolean descending;

	AbstractRange(final N alpha, final N omega) {
		startValue = alpha;
		finalValue = omega;
		if (descending = startValue.doubleValue() > finalValue.doubleValue()) {
			highestValue = startValue;
			lowestValue = finalValue;
		} else {
			highestValue = finalValue;
			lowestValue = startValue;
		}
	}

	@Override
	public N getStartValue() {
		return startValue;
	}

	@Override
	public N getFinalValue() {
		return finalValue;
	}

	@Override
	public N getHighestValue() {
		return highestValue;
	}

	@Override
	public N getLowestValue() {
		return lowestValue;
	}

	@Override
	public boolean isDescending() {
		return descending;
	}

}


/**
 * Abstract Integer Range.
 *
 * <p>This class provides the {@code stream()} and {@code stream(int step)}
 * methods for {@code Range}, {@code Range.OfByte} and {@code Range.OfShort}
 * classes.</p>
 *
 * @param <N> Number Type
 *
 * @author Alejandro Elí
 * @version 24/05/20
 * @since 1.0
 */
abstract class AbstractIntRange<N extends Number> extends AbstractRange<N> {

	AbstractIntRange(final N startValue, final N finalValue) {
		super(startValue, finalValue);
	}

	public IntStream stream() {
		return IntStream.rangeClosed(startValue.intValue(), finalValue.intValue());
	}

	public IntStream stream(final int step) {
		var builder = IntStream.builder();
		int beg = startValue.intValue();
		int end = finalValue.intValue();
		int stp = (0 == step) ? 1 : Math.abs(step);
		if (isDescending()) for (; beg >= end; beg -= stp) builder.add(beg);
		else for (; beg <= end; beg += stp) builder.add(beg);
		return builder.build();
	}

}
