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

package aria.io;

import aria.util.Tools;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Folder.
 *
 * @author  Alejandro Elí
 * @version 24/05/20
 * @since   1.0
 */
public class Folder extends File implements FolderInterface {

	private static final long serialVersionUID = 5012166463909776022L;

	/**
	 * Initialize a Folder.
	 *
	 * <p>This folder will represent the current working directory</p>
	 */
	public Folder() {
		super("");
	}

	/**
	 * Initialize a Folder from a path.
	 *
	 * <p>Initialize a Folder from the specified path</p>
	 *
	 * @param path The path to the folder
	 */
	public Folder(final String path) {
		super(path);
	}

	/**
	 * Initialize a Folder from a path.
	 *
	 * <p>Initialize a Folder from the specified path</p>
	 *
	 * @param path The path to the folder
	 */
	public Folder(final java.nio.file.Path path) {
		super(path.toAbsolutePath().toString());
	}

	/**
	 * Initialize a Folder from a {@code java.io.File}.
	 *
	 * <p>This file will contain the same path as the specified file</p>
	 *
	 * @param origin The origin file
	 */
	public Folder(final java.io.File origin) {
		super(origin.getAbsolutePath());
	}

	/**
	 * Initialize a Folder from a composed path.
	 *
	 * <p>Initialize a Folder from the specified path. The path will be
	 * created by joining {@code parent} and {@code child} strings by a {@code
	 * /}.</p>
	 *
	 * @param parent The parent file path
	 * @param child  The name of the file
	 */
	public Folder(final String parent, final String child) {
		this(String.format("%s/%s", parent, child));
	}

	/**
	 * Initialize a Folder from a composed path.
	 *
	 * <p>Initialize a Folder from the specified path. The path will be
	 * created by joining {@code parent.toAbsolutePath().toString()} and {@code
	 * child} strings by a {@code /}.</p>
	 *
	 * @param parent The parent file path
	 * @param child  The name of the file
	 */
	public Folder(final java.nio.file.Path parent, final String child) {
		this(parent.toAbsolutePath().toString(), child);
	}

	/**
	 * Initialize a Folder from a composed path.
	 *
	 * <p>Initialize a Folder from the specified path. The path will be
	 * created by joining {@code parent.toAbsolutePath()} and {@code child}
	 * strings by the platform-specific file separator.</p>
	 *
	 * @param parent The parent file path
	 * @param child  The name of the file
	 *
	 * @see aria.Local#FS
	 */
	public Folder(final java.io.File parent, final String child) {
		this(String.format("%s%s%s", parent.getAbsolutePath(), aria.Local.FS, child));
	}
}


/**
 * Folder Interface.
 *
 * @author  Alejandro Elí
 * @version 24/05/20
 * @since   1.0
 */
interface FolderInterface extends FileInterface {

	/**
	 * Delete the file named {@code name} inside this folder.
	 *
	 * @param name The name of the file to be deleted
	 *
	 * @return {@code true} if the operation was successful
	 *
	 * @see java.io.File#delete()
	 */
	default boolean delete(String name) {
		return new File(Tools.path(getAbsolutePath(), name)).delete();
	}

	/**
	 * Delete the empty folders inside this folder.
	 *
	 * @param recursive Delete recursively?
	 *
	 * @return {@code true} if the operation was successful
	 */
	default boolean deleteEmptyFolders(boolean recursive) {
		boolean status = true;
		for (var v : getFolders()) {
			if (!v.safeDelete()) {
				System.err.println(v.getAbsolutePath() + " is not empty");
				status = false;
			}
		}
		return status;
	}

	/**
	 * Delete the empty folders inside this folder (non recursive).
	 *
	 * @return {@code true} if the operation was successful
	 */
	default boolean deleteEmptyFolders() {
		return deleteEmptyFolders(false);
	}

	/**
	 * Returns a list of the files inside this directory.
	 *
	 * @return A list of the files inside this directory
	 */
	default ArrayList<File> getFiles() {
		final var files = f(listFiles(java.io.File::isFile));
		return new ArrayList<>(Arrays.asList(files));
	}

	/**
	 * Returns a list of the folders inside this directory.
	 *
	 * @return A list of the folders inside this directory
	 */
	default ArrayList<Folder> getFolders() {
		final var dirs = d(listFiles(java.io.File::isDirectory));
		return new ArrayList<>(Arrays.asList(dirs));
	}

	/**
	 * Check if this folder is empty or not.
	 *
	 * @return {@code true} if this folder is empty
	 */
	default boolean isEmpty() {
		return null == listFiles();
	}

	/**
	 * Delete this folder if is empty.
	 *
	 * @param recursive Recursively delete empty folders?
	 *
	 * @return {@code true} if the operation was successful
	 */
	default boolean safeDelete(boolean recursive) {
		if (recursive) for (var d : getFolders()) {
			d.safeDelete(true);
		}
		if (isEmpty()) {
			if (!delete()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Delete this folder if is empty (non recursive).
	 *
	 * @return {@code true} if the operation was successful
	 */
	default boolean safeDelete() {
		return safeDelete(false);
	}

	/**
	 * Convert from {@code java.io.File[]} to {@code aria.io.Folder[]}.
	 *
	 * @param input The input array
	 *
	 * @return An array of {@code Folder} from an array of {@code java.io.File}
	 */
	private static Folder[] d(final java.io.File[] input) {
		var ret = new Folder[input.length];
		for (var i = 0; i < input.length; i++)
			ret[i] = new Folder(input[i]);
		return ret;
	}

	/**
	 * Convert from {@code java.io.File[]} to {@code aria.io.File[]}.
	 *
	 * @param input The input array
	 *
	 * @return An array of {@code File} from an array of {@code java.io.File}
	 */
	private static File[] f(final java.io.File[] input) {
		var ret = new File[input.length];
		for (var i = 0; i < input.length; i++)
			ret[i] = new File(input[i]);
		return ret;
	}
}
