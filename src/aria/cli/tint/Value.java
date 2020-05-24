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

package aria.cli.tint;

class Value {

	private final byte tent;

	private byte unit;

	Value(byte tent, byte unit) {
		this.tent = tent;
		this.unit = unit;
	}

	boolean isValid() {
		return this.unit < 8;
	}

	@Override
	public String toString() {
		return String.valueOf(this.tent + this.unit);
	}

	void   black() { unit = 0; }
	void     red() { unit = 1; }
	void   green() { unit = 2; }
	void  yellow() { unit = 3; }
	void    cyan() { unit = 4; }
	void magenta() { unit = 5; }
	void    blue() { unit = 6; }
	void    gray() { unit = 7; }
}
