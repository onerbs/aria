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
 * Dispair.
 *
 * <p>The Dispair object associates two objects. In this implementation,
 * the two objects are instance of different types.</p>
 *
 * @param <K> Key Type
 * @param <V> Value Type
 *
 * @author  Alejandro Elí
 * @version 24/05/20
 * @since   1.0
 */
public class Dispair<K, V> extends Paired<K, V, Dispair<K, V>> {

	/**
	 * Constructs a new Dispair.
	 *
	 * @param key   The key of this pair
	 * @param value The value of this pair
	 */
	public Dispair(final K key, final V value) {
		super(key, value);
	}
}
