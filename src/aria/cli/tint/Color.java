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

import java.util.StringJoiner;

class Color {

	protected final Value fore;

	protected final Value back;

	private final boolean[] modes;

	Color() {
		modes = new boolean[9];
		fore = new Value((byte) 30, (byte) 9);
		back = new Value((byte) 40, (byte) 9);
	}

	private void toggle(byte index) {
		this.modes[index] = !this.modes[index];
	}

	void bold()        { toggle((byte) 0); }

	void faint()       { toggle((byte) 1); }

	void italic()      { toggle((byte) 2); }

	void underline()   { toggle((byte) 3); }

	void blink()       { toggle((byte) 4); }

	void rapid_blink() { toggle((byte) 5); }

	void invert()      { toggle((byte) 6); }

	void hide()        { toggle((byte) 7); }

	void strike()      { toggle((byte) 8); }

	@Override
	public String toString() {
		var ret = new StringJoiner(";");
		if (fore.isValid()) {
			ret.add(fore.toString());
		}
		if (back.isValid()) {
			ret.add(back.toString());
		}
		for (byte i = 0; i < modes.length; i++) {
			if (modes[i]) {
				ret.add(String.valueOf(i + 1));
			}
		}
		return ret.toString();
	}
}
