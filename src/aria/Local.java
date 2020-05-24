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

import static java.lang.System.getProperty;
import static java.lang.System.getenv;

/**
 * Local methods and variables.
 *
 * @author  Alejandro Elí
 * @version 24/05/20
 * @since   1.0
 */
public final class Local {

	/** File separator. {@code /} */
	public static final String FS;

	/** Path separator. {@code ;} Windows | {@code :} UNIX */
	public static final String PS;

	/** Line separator. {@code \r\n} Windows | {@code \n} UNIX */
	public static final String LS;

	/** The user's name. */
	public static final String USER;

	/** Path to user home directory. */
	public static final String HOME;

	/** Current working directory. */
	public static final String CWD;

	/** Path to TEMP/TMP directory. */
	public static final String TEMP;

	/** Path to appdata directory. */
	public static final String DATA;

	static {
		FS = getProperty("file.separator");
		PS = getProperty("path.separator");
		LS = getProperty("line.separator");

		USER = getProperty("user.name");
		HOME = getProperty("user.home");
		CWD = getProperty("user.dir");

		TEMP = Host.isWindows() ? getenv("TMP") : "/tmp";

		DATA = Host.isLinux() ? HOME + "/.config"
			: (Host.isWindows() ? getenv("appdata")
			: TEMP + "/.config");
	}

	private Local() {}
}
