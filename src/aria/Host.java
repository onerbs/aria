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

package aria;

/**
 * Host.
 *
 * @author  Alejandro Elí
 * @version 24/05/20
 * @since   1.0
 */
public final class Host {

	/** The Host architecture. */
	public static final String ARCH = System.getProperty("os.arch");

	/** The Host name. */
	public static final String NAME = System.getProperty("os.name");

	/** The Host version. */
	public static final String VERSION = System.getProperty("os.version");

	/**
	 * Check whether the Host OS is Linux or not.
	 *
	 * @return {@code true} if the OS of this Host is Linux
	 */
	public static boolean isLinux() {
		return NAME.startsWith("Linux");
	}

	/**
	 * Check whether the Host OS is Windows or not.
	 *
	 * @return {@code true} if the OS of this Host is Windows
	 */
	public static boolean isWindows() {
		return NAME.startsWith("Windows");
	}

	private Host() {}
}
