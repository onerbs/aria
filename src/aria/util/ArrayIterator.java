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

/**
 * Array Iterator.
 *
 * @param <E> Element Type
 *
 * @author  Alejandro Elí
 * @version 24/05/20
 * @since   1.0
 */
public class ArrayIterator<E> implements Iterator<E> {

	/** The array to iterate */
	private final E[] inner;

	/** The current position */
	private int current;

	/**
	 * Initialize an iterator from the specified array.
	 *
	 * @param source The source array
	 */
	public ArrayIterator(final E[] source) {
		inner = source;
		current = 0;
	}

	@Override
	public boolean hasNext() {
		return current < inner.length;
	}

	@Override
	public E next() {
		return inner[current++];
	}
}
