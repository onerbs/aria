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

public class Tint {

	private final Color color;

	private final String text;

	public String toOpenString() {
		return "\033[" + color + "m" + text;
	}

	@Override
	public String toString() {
		return toOpenString() + "\033[m";
	}

	private Tint(final String text) {
		this.color = new Color();
		this.text = text;
	}

	public static Tint        black(String s) { return new Tint(s).black        (); }
	public static Tint          red(String s) { return new Tint(s).red          (); }
	public static Tint        green(String s) { return new Tint(s).green        (); }
	public static Tint       yellow(String s) { return new Tint(s).yellow       (); }
	public static Tint         blue(String s) { return new Tint(s).blue         (); }
	public static Tint      magenta(String s) { return new Tint(s).magenta      (); }
	public static Tint         cyan(String s) { return new Tint(s).cyan         (); }
	public static Tint         gray(String s) { return new Tint(s).gray         (); }

	public static Tint   over_black(String s) { return new Tint(s).over_black   (); }
	public static Tint     over_red(String s) { return new Tint(s).over_red     (); }
	public static Tint   over_green(String s) { return new Tint(s).over_green   (); }
	public static Tint  over_yellow(String s) { return new Tint(s).over_yellow  (); }
	public static Tint    over_blue(String s) { return new Tint(s).over_blue    (); }
	public static Tint over_magenta(String s) { return new Tint(s).over_magenta (); }
	public static Tint    over_cyan(String s) { return new Tint(s).over_cyan    (); }
	public static Tint    over_gray(String s) { return new Tint(s).over_gray    (); }

	public static Tint         bold(String s) { return new Tint(s).bold         (); }
	public static Tint        faint(String s) { return new Tint(s).faint        (); }
	public static Tint       italic(String s) { return new Tint(s).italic       (); }
	public static Tint    underline(String s) { return new Tint(s).underline    (); }
	public static Tint        blink(String s) { return new Tint(s).blink        (); }
	public static Tint  rapid_blink(String s) { return new Tint(s).rapid_blink  (); }
	public static Tint       invert(String s) { return new Tint(s).invert       (); }
	public static Tint         hide(String s) { return new Tint(s).hide         (); }
	public static Tint       strike(String s) { return new Tint(s).strike       (); }

	public Tint        black() { this.color.fore.black   (); return this; }
	public Tint          red() { this.color.fore.red     (); return this; }
	public Tint        green() { this.color.fore.green   (); return this; }
	public Tint       yellow() { this.color.fore.yellow  (); return this; }
	public Tint         blue() { this.color.fore.blue    (); return this; }
	public Tint      magenta() { this.color.fore.magenta (); return this; }
	public Tint         cyan() { this.color.fore.cyan    (); return this; }
	public Tint         gray() { this.color.fore.gray    (); return this; }

	public Tint   over_black() { this.color.back.black   (); return this; }
	public Tint     over_red() { this.color.back.red     (); return this; }
	public Tint   over_green() { this.color.back.green   (); return this; }
	public Tint  over_yellow() { this.color.back.yellow  (); return this; }
	public Tint    over_blue() { this.color.back.blue    (); return this; }
	public Tint over_magenta() { this.color.back.magenta (); return this; }
	public Tint    over_cyan() { this.color.back.cyan    (); return this; }
	public Tint    over_gray() { this.color.back.gray    (); return this; }

	public Tint         bold() { this.color.bold         (); return this; }
	public Tint        faint() { this.color.faint        (); return this; }
	public Tint       italic() { this.color.italic       (); return this; }
	public Tint    underline() { this.color.underline    (); return this; }
	public Tint        blink() { this.color.blink        (); return this; }
	public Tint  rapid_blink() { this.color.rapid_blink  (); return this; }
	public Tint       invert() { this.color.invert       (); return this; }
	public Tint         hide() { this.color.hide         (); return this; }
	public Tint       strike() { this.color.strike       (); return this; }
}
