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
 * Abstract Pair.
 *
 * @param <K> Key Tpe
 * @param <V> Value Type
 * @param <P> Pair Type
 *
 * @author  Alejandro Elí
 * @version 24/05/20
 * @since   1.0
 */
public abstract class Paired<K, V, P extends Paired<K, V, P>> implements PairedInterface<K, V, P> {

	/** This object's key. */
	private K key;

	/** This object's value. */
	private V value;

	/**
	 * Constructs a new pair of {@code (K, V)}.
	 *
	 * @param key   The key of this pair
	 * @param value The value of this pair
	 */
	public Paired(final K key, final V value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public K getKey() {
		return key;
	}

	@Override
	@SuppressWarnings("unchecked")
	public P setKey(final K key) {
		this.key = key;
		return (P) this;
	}

	@Override
	public V getValue() {
		return value;
	}

	@Override
	@SuppressWarnings("unchecked")
	public P setValue(final V value) {
		this.value = value;
		return (P) this;
	}

	@Override
	@SuppressWarnings("unchecked")
	public P set(final K key, final V value) {
		this.key = key;
		this.value = value;
		return (P) this;
	}

	@Override
	public String toString() {
		return getKey() + " -> " + getValue();
	}
}


/**
 * Pair Interface.
 *
 * @param <K> Key Type
 * @param <V> Value Type
 * @param <P> Pair Type
 *
 * @author  Alejandro Elí
 * @version 24/05/20
 * @since   1.0
 */
interface PairedInterface<K, V, P extends PairedInterface<K, V, P>> {

	/**
	 * Returns the key object of this pair.
	 *
	 * @return the key object of this pair
	 */
	K getKey();

	/**
	 * Replace the key object of this pair with the specified one.
	 *
	 * @param key the new key object
	 *
	 * @return self
	 */
	P setKey(K key);

	/**
	 * Returns the value object of this pair.
	 *
	 * @return the value object of this pair
	 */
	V getValue();

	/**
	 * Replace the value object of this pair with the specified one.
	 *
	 * @param value the new value object
	 *
	 * @return self
	 */
	P setValue(V value);

	/**
	 * Replace the key and value objects of this pair with the specified ones.
	 *
	 * @param key   the new key object
	 * @param value the new value object
	 *
	 * @return self
	 */
	P set(K key, V value);

	/**
	 * Returns a string representation of this pair.
	 *
	 * <p>The string is constructed by placing the string representation
	 * of {@code this.key}, followed by an "arrow" ({@code ->}) and finally the
	 * string representation of {@code this.value}.</p>
	 *
	 * <p>There is an space between the key and the "arrow" and between
	 * the "arrow" and the value.</p>
	 *
	 * @return String representation of this pair. ({@code key -> value})
	 */
	@Override
	String toString();
}
