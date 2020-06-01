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

import java.io.File;
import java.nio.file.LinkOption;
import java.nio.file.Path;

/**
 * Base File Interface.
 *
 * <p>Based on {@code java.io.File}</p>
 *
 * @author  Alejandro Elí
 * @version 24/05/20
 * @since   1.0
 *
 * @see java.io.File
 */
interface BaseFileInterface extends java.io.Serializable, Comparable<java.io.File> {

	/**
	 * Tests whether the application can execute the file denoted by this abstract
	 * pathname. On some platforms it may be possible to start the Java virtual
	 * machine with special privileges that allow it to execute files that are not
	 * marked executable. Consequently this method may return {@code true} even
	 * though the file does not have execute permissions.
	 *
	 * @return {@code true} if and only if the abstract pathname exists
	 * 	<em>and</em> the application is allowed to execute the file
	 *
	 * @throws SecurityException If a security manager exists and its {@link
	 *                           java.lang.SecurityManager#checkExec(java.lang.String)}
	 *                           method denies execute access to the file
	 */
	boolean canExecute();

	/**
	 * Tests whether the application can read the file denoted by this abstract
	 * pathname. On some platforms it may be possible to start the Java virtual
	 * machine with special privileges that allow it to read files that are marked
	 * as unreadable. Consequently this method may return {@code true} even though
	 * the file does not have read permissions.
	 *
	 * @return {@code true} if and only if the file specified by this abstract
	 * 	pathname exists <em>and</em> can be read by the application; {@code false}
	 * 	otherwise
	 *
	 * @throws SecurityException If a security manager exists and its {@link
	 *                           java.lang.SecurityManager#checkRead(java.lang.String)}
	 *                           method denies read access to the file
	 */
	boolean canRead();

	/**
	 * Tests whether the application can modify the file denoted by this abstract
	 * pathname. On some platforms it may be possible to start the Java virtual
	 * machine with special privileges that allow it to modify files that are
	 * marked read-only. Consequently this method may return {@code true} even
	 * though the file is marked read-only.
	 *
	 * @return {@code true} if and only if the file system actually contains a
	 * 	file denoted by this abstract pathname <em>and</em> the application is
	 * 	allowed to write to the file; {@code false} otherwise.
	 *
	 * @throws SecurityException If a security manager exists and its {@link
	 *                           java.lang.SecurityManager#checkWrite(java.lang.String)}
	 *                           method denies write access to the file
	 */
	boolean canWrite();

	/**
	 * Compares two abstract pathnames lexicographically.  The ordering defined by
	 * this method depends upon the underlying system.  On UNIX systems,
	 * alphabetic case is significant in comparing pathnames; on Microsoft Windows
	 * systems it is not.
	 *
	 * @param other The abstract pathname to be compared to this abstract
	 *              pathname
	 *
	 * @return Zero if the argument is equal to this abstract pathname, a value
	 * 	less than zero if this abstract pathname is lexicographically less than
	 * 	the argument, or a value greater than zero if this abstract pathname is
	 * 	lexicographically greater than the argument
	 */
	@Override int compareTo(java.io.File other);

	/**
	 * Atomically creates a new, empty file named by this abstract pathname if and
	 * only if a file with this name does not yet exist.
	 *
	 * <p>The check for the existence of the file and the creation of the file
	 * if it does not exist are a single operation that is atomic with respect to
	 * all other filesystem activities that might affect the file.</p>
	 *
	 * <p><b>Note:</b> this method should <i>not</i> be used for file-locking,
	 * as the resulting protocol cannot be made to work reliably. The {@link
	 * java.nio.channels.FileLock FileLock} facility should be used instead.</p>
	 *
	 * @return {@code true} if the named file does not exist and was successfully
	 * 	created; {@code false} if the named file already exists
	 *
	 * @throws java.io.IOException If an I/O error occurred
	 * @throws SecurityException   If a security manager exists and its {@link
	 *                             java.lang.SecurityManager#checkWrite(java.lang.String)}
	 *                             method denies write access to the file
	 */
	boolean createNewFile() throws java.io.IOException;

	/**
	 * Deletes the file/directory denoted by this abstract pathname.
	 *
	 * <p>If this pathname denotes a directory, then the directory must be empty
	 * in order to be deleted.</p>
	 *
	 * <p>Note that the {@link java.nio.file.Files} class defines the {@link
	 * java.nio.file.Files#delete(Path) delete} method to throw an * {@link
	 * java.io.IOException} when a file cannot be deleted. This is useful for
	 * error reporting and to diagnose why a file cannot be deleted.
	 *
	 * @return {@code true} if and only if the file/directory is successfully
	 * 	deleted; {@code false} otherwise
	 *
	 * @throws SecurityException If a security manager exists and its {@link
	 *                           java.lang.SecurityManager#checkDelete} method
	 *                           denies delete access to the file
	 */
	boolean delete();

	/**
	 * Requests that the file/directory denoted by this abstract pathname be
	 * deleted when the virtual machine terminates.
	 *
	 * <p>Files (or directories) are deleted in the reverse order that
	 * they are registered. Invoking this method to delete a file or directory
	 * that is already registered for deletion has no effect. Deletion will be
	 * attempted only for normal termination of the virtual machine, as defined by
	 * the Java Language Specification.</p>
	 *
	 * <p>Once deletion has been requested, it is not possible to cancel the
	 * request. This method should therefore be used with care.</p>
	 *
	 * <p><b>Note:</b> this method should <i>not</i> be used for file-locking,
	 * as the resulting protocol cannot be made to work reliably. The {@link
	 * java.nio.channels.FileLock FileLock} facility should be used instead.</p>
	 *
	 * @throws SecurityException If a security manager exists and its {@link
	 *                           java.lang.SecurityManager#checkDelete} method
	 *                           denies delete access to the file
	 * @see #delete
	 */
	void deleteOnExit();

	/**
	 * Tests this abstract pathname for equality with the given object. Returns
	 * {@code true} if and only if the argument is not
	 * <code>null</code> and is an abstract pathname that denotes the same file
	 * or directory as this abstract pathname.  Whether or not two abstract
	 * pathnames are equal depends upon the underlying system.  On UNIX systems,
	 * alphabetic case is significant in comparing pathnames; on Microsoft Windows
	 * systems it is not.
	 *
	 * @param obj The object to be compared with this abstract pathname
	 *
	 * @return {@code true} if and only if the objects are the same; {@code false}
	 * 	otherwise
	 */
	@Override boolean equals(Object obj);

	/**
	 * Tests whether this file/directory exists.
	 *
	 * @return {@code true} if this file/directory exists
	 *
	 * @throws SecurityException If a security manager exists and its {@link
	 *                           java.lang.SecurityManager#checkRead(java.lang.String)}
	 *                           method denies read access to this file/directory
	 */
	boolean exists();

	/**
	 * Returns the absolute form of this abstract pathname.  Equivalent to
	 * <code>new File(this.{@link #getAbsolutePath})</code>.
	 *
	 * @return The absolute abstract pathname denoting the same file or directory
	 * 	as this abstract pathname
	 *
	 * @throws SecurityException If a required system property value cannot be
	 *                           accessed.
	 */
	java.io.File getAbsoluteFile();

	/**
	 * Returns the absolute pathname string of this abstract pathname.
	 *
	 * <p>If this abstract pathname is already absolute, then the pathname
	 * string is simply returned as if by the {@link #getPath} method. If this
	 * abstract pathname is the empty abstract pathname then the pathname string
	 * of the current user directory, which is named by the system property
	 * <code>user.dir</code>, is returned. Otherwise this pathname is resolved in
	 * a system-dependent way. On UNIX systems, a relative pathname is made
	 * absolute by resolving it against the current user directory. On Microsoft
	 * Windows systems, a relative pathname is made absolute by resolving it
	 * against the current directory of the drive named by the pathname, if any;
	 * if not, it is resolved against the current user directory.</p>
	 *
	 * @return The absolute pathname string denoting the same file or directory as
	 * 	this abstract pathname
	 *
	 * @throws SecurityException If a required system property value cannot be
	 *                           accessed.
	 * @see #isAbsolute()
	 */
	String getAbsolutePath();

	/**
	 * Returns the canonical form of this abstract pathname.  Equivalent to
	 * <code>new File(this.{@link #getCanonicalPath})</code>.
	 *
	 * @return The canonical pathname string denoting the same file or directory
	 * 	as this abstract pathname
	 *
	 * @throws java.io.IOException If an I/O error occurs, which is possible
	 *                             because the construction of the canonical
	 *                             pathname may require filesystem queries
	 * @throws SecurityException   If a required system property value cannot be
	 *                             accessed, or if a security manager exists and
	 *                             its {@link java.lang.SecurityManager#checkRead}
	 *                             method denies read access to the file
	 * @see   Path#toRealPath
	 */
	java.io.File getCanonicalFile() throws java.io.IOException;

	/**
	 * Returns the canonical pathname string of this abstract pathname.
	 *
	 * <p>A canonical pathname is both absolute and unique.  The precise
	 * definition of canonical form is system-dependent.  This method first
	 * converts this pathname to absolute form if necessary, as if by invoking the
	 * {@link #getAbsolutePath} method, and then maps it to its unique form in a
	 * system-dependent way.  This typically involves removing redundant names
	 * such as {@code "."} and {@code ".."} from the pathname, resolving symbolic
	 * links (on UNIX platforms), and converting drive letters to a standard case
	 * (on Microsoft Windows platforms).
	 *
	 * <p>Every pathname that denotes an existing file/directory has a
	 * unique canonical form.  Every pathname that denotes a nonexistent file or
	 * directory also has a unique canonical form.  The canonical form of the
	 * pathname of a nonexistent file/directory may be different from the
	 * canonical form of the same pathname after the file/directory is created.
	 * Similarly, the canonical form of the pathname of an existing file/directory
	 * may be different from the canonical form of the same pathname after the
	 * file/directory is deleted.
	 *
	 * @return The canonical pathname string denoting the same file or directory
	 * 	as this abstract pathname
	 *
	 * @throws java.io.IOException If an I/O error occurs, which is possible
	 *                             because the construction of the canonical
	 *                             pathname may require filesystem queries
	 * @throws SecurityException   If a required system property value cannot be
	 *                             accessed, or if a security manager exists and
	 *                             its {@link java.lang.SecurityManager#checkRead}
	 *                             method denies read access to the file
	 * @see   Path#toRealPath
	 */
	String getCanonicalPath() throws java.io.IOException;

	/**
	 * Returns the number of unallocated bytes in the partition <a
	 * href="#partName">named</a> by this abstract path name.
	 *
	 * <p>The returned number of unallocated bytes is a hint, but not
	 * a guarantee, that it is possible to use most or any of these bytes.  The
	 * number of unallocated bytes is most likely to be accurate immediately after
	 * this call.  It is likely to be made inaccurate by any external I/O
	 * operations including those made on the system outside of this virtual
	 * machine.  This method makes no guarantee that write operations to this file
	 * system will succeed.
	 *
	 * @return The number of unallocated bytes on the partition or {@code 0L} if
	 * 	the abstract pathname does not name a partition.  This value will be less
	 * 	than or equal to the total file system size returned by {@link
	 *  #getTotalSpace}.
	 *
	 * @throws SecurityException If a security manager has been installed and it
	 *                           denies {@link RuntimePermission}{@code
	 *                           ("getFileSystemAttributes")} or its {@link
	 *                           SecurityManager#checkRead(String)} method denies
	 *                           read access to the file named by this abstract
	 *                           pathname
	 */
	long getFreeSpace();

	/**
	 * Returns the name of the file/directory denoted by this abstract pathname.
	 *
	 * <p>This is just the last name in the pathname's name sequence. If the
	 * pathname's name sequence is empty, then the empty string is returned.</p>
	 *
	 * @return The name of the file/directory denoted by this abstract pathname,
	 * 	or the empty string if this pathname's name sequence is empty
	 */
	String getName();

	/**
	 * Returns the pathname string of this abstract pathname's parent, or
	 * <code>null</code> if this pathname does not name a parent directory.
	 *
	 * <p>The <em>parent</em> of an abstract pathname consists of the
	 * pathname's prefix, if any, and each name in the pathname's name sequence
	 * except for the last.  If the name sequence is empty then the pathname does
	 * not name a parent directory.
	 *
	 * @return The pathname string of the parent directory named by this abstract
	 * 	pathname, or <code>null</code> if this pathname does not name a parent
	 */
	String getParent();

	/**
	 * Returns the abstract pathname of this abstract pathname's parent, or
	 * <code>null</code> if this pathname does not name a parent directory.
	 *
	 * <p>The <em>parent</em> of an abstract pathname consists of the
	 * pathname's prefix, if any, and each name in the pathname's name sequence
	 * except for the last.  If the name sequence is empty then the pathname does
	 * not name a parent directory.
	 *
	 * @return The abstract pathname of the parent directory named by this
	 * 	abstract pathname, or <code>null</code> if this pathname does not name a
	 * 	parent
	 */
	java.io.File getParentFile();

	/**
	 * Converts this abstract pathname into a pathname string.  The resulting
	 * string uses the default name-separator character to separate the names in
	 * the name sequence.
	 *
	 * @return The string form of this abstract pathname
	 */
	String getPath();

	/**
	 * Returns the size of the partition <a href="#partName">named</a> by this
	 * abstract pathname.
	 *
	 * @return The size, in bytes, of the partition or {@code 0L} if this abstract
	 * 	pathname does not name a partition
	 *
	 * @throws SecurityException If a security manager has been installed and it
	 *                           denies {@link RuntimePermission}{@code
	 *                           ("getFileSystemAttributes")} or its {@link
	 *                           SecurityManager#checkRead(String)} method denies
	 *                           read access to the file named by this abstract
	 *                           pathname
	 */
	long getTotalSpace();

	/**
	 * Returns the number of bytes available to this virtual machine on the
	 * partition <a href="#partName">named</a> by this abstract pathname.  When
	 * possible, this method checks for write permissions and other operating
	 * system restrictions and will therefore usually provide a more accurate
	 * estimate of how much new data can actually be written than {@link
	 * #getFreeSpace}.
	 *
	 * <p>The returned number of available bytes is a hint, but not a
	 * guarantee, that it is possible to use most or any of these bytes.  The
	 * number of unallocated bytes is most likely to be accurate immediately after
	 * this call.  It is likely to be made inaccurate by any external I/O
	 * operations including those made on the system outside of this virtual
	 * machine.  This method makes no guarantee that write operations to this file
	 * system will succeed.
	 *
	 * @return The number of available bytes on the partition or {@code 0L} if the
	 * 	abstract pathname does not name a partition.  On systems where this
	 * 	information is not available, this method will be equivalent to a call to
	 *  {@link #getFreeSpace}.
	 *
	 * @throws SecurityException If a security manager has been installed and it
	 *                           denies {@link RuntimePermission}{@code
	 *                           ("getFileSystemAttributes")} or its {@link
	 *                           SecurityManager#checkRead(String)} method denies
	 *                           read access to the file named by this abstract
	 *                           pathname
	 */
	long getUsableSpace();

	/**
	 * Computes a hash code for this abstract pathname.  Because equality of
	 * abstract pathnames is inherently system-dependent, so is the computation of
	 * their hash codes.  On UNIX systems, the hash code of an abstract pathname
	 * is equal to the exclusive <em>or</em> of the hash code of its pathname
	 * string and the decimal value
	 * <code>1234321</code>.  On Microsoft Windows systems, the hash
	 * code is equal to the exclusive <em>or</em> of the hash code of its pathname
	 * string converted to lower case and the decimal value <code>1234321</code>.
	 * Locale is not taken into account on lowercasing the pathname string.
	 *
	 * @return A hash code for this abstract pathname
	 */
	@Override int hashCode();

	/**
	 * Tests whether this abstract pathname is absolute.
	 *
	 * <p>The definition of absolute pathname is system dependent.
	 * On UNIX systems, a pathname is absolute if its prefix is {@code "/"}. On
	 * Microsoft Windows systems, a pathname is absolute if its prefix is a drive
	 * specifier followed by {@code "\\"}, or if its prefix is {@code
	 * "\\\\"}.</p>
	 *
	 * @return {@code true} if this abstract pathname is absolute, {@code false}
	 * 	otherwise
	 */
	boolean isAbsolute();

	/**
	 * Tests whether this file is a directory.
	 *
	 * <p>Where it is required to distinguish an I/O exception from the case
	 * that the file is not a directory, or where several attributes of the same
	 * file are required at the same time, then the {@link
	 * java.nio.file.Files#readAttributes(Path, Class, LinkOption...)}
	 * Files.readAttributes} method may be used.
	 *
	 * @return {@code true} if and only if the file denoted by this abstract
	 * 	pathname exists <em>and</em> is a directory; {@code false} otherwise
	 *
	 * @throws SecurityException If a security manager exists and its {@link
	 *                           java.lang.SecurityManager#checkRead(java.lang.String)}
	 *                           method denies read access to the file
	 */
	boolean isDirectory();

	/**
	 * Tests whether this file is a normal file.  A file is <em>normal</em> if it
	 * is not a directory and, in addition, satisfies other system-dependent
	 * criteria.  Any non-directory file created by a Java application is
	 * guaranteed to be a normal file.
	 *
	 * <p>Where it is required to distinguish an I/O exception from the case
	 * that the file is not a normal file, or where several attributes of the same
	 * file are required at the same time, then the {@link
	 * java.nio.file.Files#readAttributes(Path, Class, LinkOption[])
	 * Files.readAttributes} method may be used.
	 *
	 * @return {@code true} if and only if the file denoted by this abstract
	 * 	pathname exists <em>and</em> is a normal file; {@code false} otherwise
	 *
	 * @throws SecurityException If a security manager exists and its {@link
	 *                           java.lang.SecurityManager#checkRead(java.lang.String)}
	 *                           method denies read access to the file
	 */
	boolean isFile();

	/**
	 * Tests whether the file named by this abstract pathname is a hidden file.
	 *
	 * <p>The exact definition of <em>hidden</em> is system-dependent.</p>
	 *
	 * <p>On UNIX systems, a file is considered to be hidden if its name begins
	 * with a period character.</p>
	 *
	 * <p>On Microsoft Windows systems, a file is considered to be hidden if
	 * it has been marked as such in the filesystem.</p>
	 *
	 * @return {@code true} if and only if the file denoted by this abstract
	 * 	pathname is hidden according to the conventions of the underlying
	 * 	platform
	 *
	 * @throws SecurityException If a security manager exists and its {@link
	 *                           java.lang.SecurityManager#checkRead(java.lang.String)}
	 *                           method denies read access to the file
	 */
	boolean isHidden();

	/**
	 * Returns the time that this file was last modified.
	 *
	 * <p>Where it is required to distinguish an I/O exception from the case
	 * where {@code 0L} is returned, or where several attributes of the same file
	 * are required at the same time, or where the time of last access or the
	 * creation time are required, then the {@link java.nio.file.Files#readAttributes(Path, Class, LinkOption[])
	 * Files.readAttributes} method may be used.  If however only the time of last
	 * modification is required, then the {@link java.nio.file.Files#getLastModifiedTime(Path, LinkOption[])
	 * Files.getLastModifiedTime} method may be used instead.
	 *
	 * @return A <code>long</code> value representing the time the file was last
	 * 	modified, measured in milliseconds since the epoch (00:00:00 GMT, January
	 * 	1, 1970), or <code>0L</code> if the file does not exist or if an I/O error
	 * 	occurs.  The value may be negative indicating the number of milliseconds
	 * 	before the epoch
	 *
	 * @throws SecurityException If a security manager exists and its {@link
	 *                           java.lang.SecurityManager#checkRead(java.lang.String)}
	 *                           method denies read access to the file
	 * @apiNote While the unit of time of the return value is milliseconds, the
	 * 	granularity of the value depends on the underlying file system and may be
	 * 	larger. For example, some file systems use time stamps in units of
	 * 	seconds.
	 */
	long lastModified();

	/**
	 * Returns the length of this file. The return value is unspecified if this
	 * pathname denotes a directory.
	 *
	 * <p>Where it is required to distinguish an I/O exception from the case
	 * that {@code 0L} is returned, or where several attributes of the same file
	 * are required at the same time, then the {@link java.nio.file.Files#readAttributes(Path, Class, LinkOption[])
	 * Files.readAttributes} method may be used.
	 *
	 * @return The length, in bytes, of the file denoted by this abstract
	 * 	pathname, or <code>0L</code> if the file does not exist.  Some operating
	 * 	systems may return <code>0L</code> for pathnames denoting system-dependent
	 * 	entities such as devices or pipes.
	 *
	 * @throws SecurityException If a security manager exists and its {@link
	 *                           java.lang.SecurityManager#checkRead(java.lang.String)}
	 *                           method denies read access to the file
	 */
	long length();

	/**
	 * Returns an array of strings naming the files and directories in the
	 * directory denoted by this abstract pathname.
	 *
	 * <p>If this abstract pathname does not denote a directory, then this
	 * method returns {@code null}. Otherwise, an array of strings is returned,
	 * one for each file/directory in the directory. Names denoting the directory
	 * itself and the directory's parent directory are not included in the result.
	 * Each string is a file name rather than a complete path.
	 * </p>
	 *
	 * <p>There is no guarantee that the name strings in the resulting array
	 * will appear in any specific order; they are not, in particular, guaranteed
	 * to appear in alphabetical order.</p>
	 *
	 * <p>Note that the {@link java.nio.file.Files} class defines the {@link
	 * java.nio.file.Files#newDirectoryStream(Path) newDirectoryStream} method to
	 * open a directory and iterate over the names of the files in the directory.
	 * This may use less resources when working with very large directories, and
	 * may be more responsive when working with remote directories.</p>
	 *
	 * @return An array of strings naming the files and directories in the
	 * 	directory denoted by this abstract pathname.  The array will be empty if
	 * 	the directory is empty.  Returns {@code null} if this abstract pathname
	 * 	does not denote a directory, or if an I/O error occurs.
	 *
	 * @throws SecurityException If a security manager exists and its {@link
	 *                           SecurityManager#checkRead(String)} method denies
	 *                           read access to the directory
	 */
	String[] list();

	/**
	 * Returns an array of strings naming the files and directories in the
	 * directory denoted by this abstract pathname that satisfy the specified
	 * filter.
	 *
	 * <p>The behavior of this method is the same as that of the {@link #list()}
	 * method, except that the strings in the returned array must satisfy the
	 * filter. If the given {@code filter} is {@code null} then all names are
	 * accepted.  Otherwise, a name satisfies the filter if and only if the value
	 * {@code true} results when the {@link java.io.FilenameFilter#accept(java.io.File,
	 * String)} method of the filter is invoked on this abstract pathname and the
	 * name of a file/directory in the directory that it denotes.</p>
	 *
	 * @param filter A filename filter
	 *
	 * @return An array of strings naming the files and directories in the
	 * 	directory denoted by this abstract pathname that were accepted by the
	 * 	given {@code filter}.  The array will be empty if the directory is empty
	 * 	or if no names were accepted by the filter. Returns {@code null} if this
	 * 	abstract pathname does not denote a directory, or if an I/O error occurs.
	 *
	 * @throws SecurityException If a security manager exists and its {@link
	 *                           SecurityManager#checkRead(String)} method denies
	 *                           read access to the directory
	 * @see java.nio.file.Files#newDirectoryStream(Path, String)
	 */
	String[] list(java.io.FilenameFilter filter);

	/**
	 * Returns an array of abstract pathnames denoting the files in the directory
	 * denoted by this abstract pathname.
	 *
	 * <p>If this abstract pathname does not denote a directory, then this
	 * method returns {@code null}.  Otherwise an array of {@code File} objects is
	 * returned, one for each file/directory in the directory.  Pathnames denoting
	 * the directory itself and the directory's parent directory are not included
	 * in the result.  Each resulting abstract pathname is constructed from this
	 * abstract pathname using the {@code File(File, String)} constructor.
	 * Therefore if this pathname is absolute then each resulting pathname is
	 * absolute; if this pathname is relative then each resulting pathname will be
	 * relative to the same directory.
	 *
	 * <p>There is no guarantee that the name strings in the resulting array
	 * will appear in any specific order; they are not, in particular, guaranteed
	 * to appear in alphabetical order.
	 *
	 * <p>Note that the {@link java.nio.file.Files} class defines the {@link
	 * java.nio.file.Files#newDirectoryStream(Path) newDirectoryStream} method to
	 * open a directory and iterate over the names of the files in the directory.
	 * This may use less resources when working with very large directories.
	 *
	 * @return An array of abstract pathnames denoting the files and directories
	 * 	in the directory denoted by this abstract pathname. The array will be
	 * 	empty if the directory is empty.  Returns {@code null} if this abstract
	 * 	pathname does not denote a directory, or if an I/O error occurs.
	 *
	 * @throws SecurityException If a security manager exists and its {@link
	 *                           SecurityManager#checkRead(String)} method denies
	 *                           read access to the directory
	 */
	java.io.File[] listFiles();

	/**
	 * Returns an array of abstract pathnames denoting the files and directories
	 * in the directory denoted by this abstract pathname that satisfy the
	 * specified filter.  The behavior of this method is the same as that of the
	 * {@link #listFiles()} method, except that the pathnames in the returned
	 * array must satisfy the filter.  If the given {@code filter} is {@code null}
	 * then all pathnames are accepted.  Otherwise, a pathname satisfies the
	 * filter if and only if the value {@code true} results when the {@link
	 * java.io.FilenameFilter#accept(File, String)} method of the filter is
	 * invoked on this abstract pathname and the name of a file/directory in the
	 * directory that it denotes.
	 *
	 * @param filter A filename filter
	 *
	 * @return An array of abstract pathnames denoting the files and directories
	 * 	in the directory denoted by this abstract pathname. The array will be
	 * 	empty if the directory is empty.  Returns {@code null} if this abstract
	 * 	pathname does not denote a directory, or if an I/O error occurs.
	 *
	 * @throws SecurityException If a security manager exists and its {@link
	 *                           SecurityManager#checkRead(String)} method denies
	 *                           read access to the directory
	 * @see java.nio.file.Files#newDirectoryStream(Path, String)
	 */
	java.io.File[] listFiles(java.io.FilenameFilter filter);

	/**
	 * Returns an array of abstract pathnames denoting the files and directories
	 * in the directory denoted by this abstract pathname that satisfy the
	 * specified filter.  The behavior of this method is the same as that of the
	 * {@link #listFiles()} method, except that the pathnames in the returned
	 * array must satisfy the filter.  If the given {@code filter} is {@code null}
	 * then all pathnames are accepted.  Otherwise, a pathname satisfies the
	 * filter if and only if the value {@code true} results when the {@link
	 * java.io.FilenameFilter#accept(File, String)} method of the filter is
	 * invoked on the pathname.
	 *
	 * @param filter A file filter
	 *
	 * @return An array of abstract pathnames denoting the files and directories
	 * 	in the directory denoted by this abstract pathname. The array will be
	 * 	empty if the directory is empty.  Returns {@code null} if this abstract
	 * 	pathname does not denote a directory, or if an I/O error occurs.
	 *
	 * @throws SecurityException If a security manager exists and its {@link
	 *                           SecurityManager#checkRead(String)} method denies
	 *                           read access to the directory
	 * @see java.nio.file.Files#newDirectoryStream(Path, java.nio.file.DirectoryStream.Filter)
	 */
	java.io.File[] listFiles(java.io.FileFilter filter);

	/**
	 * Creates the directory named by this abstract pathname.
	 *
	 * @return {@code true} if and only if the directory was created; {@code
	 * 	false} otherwise
	 *
	 * @throws SecurityException If a security manager exists and its {@link
	 *                           java.lang.SecurityManager#checkWrite(java.lang.String)}
	 *                           method does not permit the named directory to be
	 *                           created
	 */
	boolean mkdir();

	/**
	 * Creates the directory named by this abstract pathname, including any
	 * necessary but nonexistent parent directories.  Note that if this operation
	 * fails it may have succeeded in creating some of the necessary parent
	 * directories.
	 *
	 * @return {@code true} if and only if the directory was created, along with
	 * 	all necessary parent directories; {@code false} otherwise
	 *
	 * @throws SecurityException If a security manager exists and its {@link
	 *                           java.lang.SecurityManager#checkRead(java.lang.String)}
	 *                           method does not permit verification of the
	 *                           existence of the named directory and all
	 *                           necessary parent directories; or if the {@link
	 *                           java.lang.SecurityManager#checkWrite(java.lang.String)}
	 *                           method does not permit the named directory and
	 *                           all necessary parent directories to be created
	 */
	boolean mkdirs();

	/**
	 * Renames this file.
	 *
	 * <p>Many aspects of the behavior of this method are inherently
	 * platform-dependent: The rename operation might not be able to move a file
	 * from one filesystem to another, it might not be atomic, and it might not
	 * succeed if a file with the destination abstract pathname already exists.
	 * The return value should always be checked to make sure that the rename
	 * operation was successful.
	 *
	 * <p>Note that the {@link java.nio.file.Files} class defines the {@link
	 * java.nio.file.Files#move move} method to move or rename a file in a
	 * platform independent manner.
	 *
	 * @param dest The new abstract pathname for the named file
	 *
	 * @return {@code true} if and only if the renaming succeeded; {@code false}
	 * 	otherwise
	 *
	 * @throws SecurityException    If a security manager exists and its {@link
	 *                              java.lang.SecurityManager#checkWrite(java.lang.String)}
	 *                              method denies write access to either the old
	 *                              or new pathnames
	 * @throws NullPointerException If parameter <code>dest</code> is
	 *                              <code>null</code>
	 */
	boolean renameTo(java.io.File dest);

	/**
	 * A convenience method to set the owner's execute permission for this
	 * abstract pathname. On some platforms it may be possible to start the Java
	 * virtual machine with special privileges that allow it to execute files that
	 * are not marked executable.
	 *
	 * <p>An invocation of this method of the form {@code
	 * file.setExcutable(arg)} behaves in exactly the same way as the invocation
	 *
	 * <pre>{@code
	 * 	 file.setExecutable(arg, true)
	 * }</pre>
	 *
	 * @param x If {@code true}, sets the access permission to allow execute
	 *          operations; if {@code false} to disallow execute operations
	 *
	 * @return {@code true} if and only if the operation succeeded.  The operation
	 * 	will fail if the user does not have permission to change the access
	 * 	permissions of this abstract pathname.  If
	 * 	<code>executable</code> is {@code false} and the underlying
	 * 	file system does not implement an execute permission, then the operation
	 * 	will fail.
	 *
	 * @throws SecurityException If a security manager exists and its {@link
	 *                           java.lang.SecurityManager#checkWrite(java.lang.String)}
	 *                           method denies write access to the file
	 */
	boolean setExecutable(boolean x);

	/**
	 * Sets the owner's or everybody's execute permission for this abstract
	 * pathname. On some platforms it may be possible to start the Java virtual
	 * machine with special privileges that allow it to execute files that are not
	 * marked executable.
	 *
	 * <p>The {@link java.nio.file.Files} class defines methods that operate on
	 * file attributes including file permissions. This may be used when finer
	 * manipulation of file permissions is required.
	 *
	 * @param x If {@code true}, sets the access permission to allow execute
	 *          operations; if {@code false} to disallow execute operations
	 * @param o If {@code true}, the execute permission applies only to the
	 *          owner's execute permission; otherwise, it applies to everybody. If
	 *          the underlying file system can not distinguish the owner's execute
	 *          permission from that of others, then the permission will apply to
	 *          everybody, regardless of this value.
	 *
	 * @return {@code true} if and only if the operation succeeded.  The operation
	 * 	will fail if the user does not have permission to change the access
	 * 	permissions of this abstract pathname.  If
	 * 	<code>executable</code> is {@code false} and the underlying
	 * 	file system does not implement an execute permission, then the operation
	 * 	will fail.
	 *
	 * @throws SecurityException If a security manager exists and its {@link
	 *                           java.lang.SecurityManager#checkWrite(java.lang.String)}
	 *                           method denies write access to the file
	 */
	boolean setExecutable(boolean x, boolean o);

	/**
	 * A convenience method to set the owner's execute permission for this
	 * abstract pathname. On some platforms it may be possible to start the Java
	 * virtual machine with special privileges that allow it to execute files that
	 * are not marked executable.
	 *
	 * <p>The {@link java.nio.file.Files} class defines methods that operate on
	 * file attributes including file permissions. This may be used when finer
	 * manipulation of file permissions is required.
	 *
	 * <p>An invocation of this method behaves in exactly the same way as the
	 * invocation <pre>{@code file.setExecutable(true, true)}</pre> sets the
	 * access permission to allow execute operations; the execute permission
	 * applies only to the owner.
	 *
	 * @return {@code true} if and only if the operation succeeded.  The operation
	 * 	will fail if the user does not have permission to change the access
	 * 	permissions of this abstract pathname.  If
	 * 	<code>executable</code> is {@code false} and the underlying
	 * 	file system does not implement an execute permission, then the operation
	 * 	will fail.
	 *
	 * @throws SecurityException If a security manager exists and its {@link
	 *                           java.lang.SecurityManager#checkWrite(java.lang.String)}
	 *                           method denies write access to the file
	 */
	default boolean setExecutable() {
		return setExecutable(true, true);
	}

	/**
	 * Sets the last-modified time of the file/directory named by this abstract
	 * pathname.
	 *
	 * <p>All platforms support file-modification times to the nearest second,
	 * but some provide more precision.  The argument will be truncated to fit the
	 * supported precision.  If the operation succeeds and no intervening
	 * operations on the file take place, then the next invocation of the {@link
	 * #lastModified} method will return the (possibly truncated)
	 * <code>time</code> argument that was passed to this method.
	 *
	 * @param time The new last-modified time, measured in milliseconds since the
	 *             epoch (00:00:00 GMT, January 1, 1970)
	 *
	 * @return {@code true} if and only if the operation succeeded; {@code false}
	 * 	otherwise
	 *
	 * @throws IllegalArgumentException If the argument is negative
	 * @throws SecurityException        If a security manager exists and its
	 *                                  {@link java.lang.SecurityManager#checkWrite(java.lang.String)}
	 *                                  method denies write access to the named
	 *                                  file
	 */
	boolean setLastModified(long time);

	/**
	 * Marks the file/directory named by this abstract pathname so that only read
	 * operations are allowed. After invoking this method the file or directory
	 * will not change until it is either deleted or marked to allow write access.
	 * On some platforms it may be possible to start the Java virtual machine with
	 * special privileges that allow it to modify files that are marked read-only.
	 * Whether or not a read-only file or directory may be deleted depends upon
	 * the underlying system.
	 *
	 * @return {@code true} if and only if the operation succeeded; {@code false}
	 * 	otherwise
	 *
	 * @throws SecurityException If a security manager exists and its {@link
	 *                           java.lang.SecurityManager#checkWrite(java.lang.String)}
	 *                           method denies write access to the named file
	 */
	boolean setReadOnly();

	/**
	 * A convenience method to set the owner's read permission for this abstract
	 * pathname. On some platforms it may be possible to start the Java virtual
	 * machine with special privileges that allow it to read files that are marked
	 * as unreadable.
	 *
	 * <p>The {@link java.nio.file.Files} class defines methods that operate on
	 * file attributes including file permissions. This may be used when finer
	 * manipulation of file permissions is required.
	 *
	 * <p>An invocation of this method of the form {@code file.setReadable(arg)}
	 * behaves in exactly the same way as the invocation
	 *
	 * <pre>{@code
	 * 	 file.setReadable(arg, true)
	 * }</pre>
	 *
	 * @param r If {@code true}, sets the access permission to allow read
	 *          operations; if {@code false} to disallow read operations
	 *
	 * @return {@code true} if and only if the operation succeeded.  The operation
	 * 	will fail if the user does not have permission to change the access
	 * 	permissions of this abstract pathname.  If
	 * 	<code>readable</code> is {@code false} and the underlying
	 * 	file system does not implement a read permission, then the operation will
	 * 	fail.
	 *
	 * @throws SecurityException If a security manager exists and its {@link
	 *                           java.lang.SecurityManager#checkWrite(java.lang.String)}
	 *                           method denies write access to the file
	 */
	boolean setReadable(boolean r);

	/**
	 * Sets the owner's or everybody's read permission for this abstract pathname.
	 * On some platforms it may be possible to start the Java virtual machine with
	 * special privileges that allow it to read files that are marked as
	 * unreadable.
	 *
	 * <p>The {@link java.nio.file.Files} class defines methods that operate on
	 * file attributes including file permissions. This may be used when finer
	 * manipulation of file permissions is required.
	 *
	 * @param r If {@code true}, sets the access permission to allow read
	 *          operations; if {@code false} to disallow read operations
	 * @param o If {@code true}, the read permission applies only to the owner's
	 *          read permission; otherwise, it applies to everybody. If the
	 *          underlying file system can not distinguish the owner's read
	 *          permission from that of others, then the permission will apply to
	 *          everybody, regardless of this value.
	 *
	 * @return {@code true} if and only if the operation succeeded. The operation
	 * 	will fail if the user does not have permission to change the access
	 * 	permissions of this abstract pathname. If
	 * 	<code>readable</code> is {@code false} and the underlying
	 * 	file system does not implement a read permission, then the operation will
	 * 	fail.
	 *
	 * @throws SecurityException If a security manager exists and its {@link
	 *                           java.lang.SecurityManager#checkWrite(java.lang.String)}
	 *                           method denies write access to the file
	 */
	boolean setReadable(boolean r, boolean o);

	/**
	 * Convenience method to set the owner's read permission for this abstract
	 * pathname. On some platforms it may be possible to start the Java virtual
	 * machine with special privileges that allow it to read files that are marked
	 * as unreadable.
	 *
	 * <p>An invocation of this method behaves in exactly the same way as the
	 * invocation * <pre>{@code file.setReadable(true, true)}</pre> sets the
	 * access permission to allow read operations; the read permission applies
	 * only to the owner.</p>
	 *
	 * @return {@code true} if and only if the operation succeeded.  The operation
	 * 	will fail if the user does not have permission to change the access
	 * 	permissions of this abstract pathname.  If
	 * 	<code>readable</code> is {@code false} and the underlying
	 * 	file system does not implement a read permission, then the operation will
	 * 	fail.
	 *
	 * @throws SecurityException If a security manager exists and its {@link
	 *                           java.lang.SecurityManager#checkWrite(java.lang.String)}
	 *                           method denies write access to the file
	 */
	default boolean setReadable() {
		return setReadable(true, true);
	}

	/**
	 * Convenience method to set the owner's write permission for this abstract
	 * pathname. On some platforms it may be possible to start the Java virtual
	 * machine with special privileges that allow it to modify files that disallow
	 * write operations.
	 *
	 * <p>The {@link java.nio.file.Files} class defines methods that operate on
	 * file attributes including file permissions. This may be used when finer
	 * manipulation of file permissions is required.
	 *
	 * <p>An invocation of this method of the form {@code file.setWritable(arg)}
	 * behaves in exactly the same way as the invocation
	 *
	 * <pre>{@code
	 * 	 file.setWritable(arg, true)
	 * }</pre>
	 *
	 * @param w If {@code true}, sets the access permission to allow write
	 *          operations; if {@code false} to disallow write operations
	 *
	 * @return {@code true} if and only if the operation succeeded.  The operation
	 * 	will fail if the user does not have permission to change the access
	 * 	permissions of this abstract pathname.
	 *
	 * @throws SecurityException If a security manager exists and its {@link
	 *                           java.lang.SecurityManager#checkWrite(java.lang.String)}
	 *                           method denies write access to the file
	 */
	boolean setWritable(boolean w);

	/**
	 * Sets the owner's or everybody's write permission for this abstract
	 * pathname. On some platforms it may be possible to start the Java virtual
	 * machine with special privileges that allow it to modify files that disallow
	 * write operations.
	 *
	 * <p>The {@link java.nio.file.Files} class defines methods that operate on
	 * file attributes including file permissions. This may be used when finer
	 * manipulation of file permissions is required.
	 *
	 * @param w If {@code true}, sets the access permission to allow write
	 *          operations; if {@code false} to disallow write operations
	 * @param o If {@code true}, the write permission applies only to the owner's
	 *          write permission; otherwise, it applies to everybody. If the
	 *          underlying file system can not distinguish the owner's write
	 *          permission from that of others, then the permission will apply to
	 *          everybody, regardless of this value.
	 *
	 * @return {@code true} if and only if the operation succeeded. The operation
	 * 	will fail if the user does not have permission to change the access
	 * 	permissions of this abstract pathname.
	 *
	 * @throws SecurityException If a security manager exists and its {@link
	 *                           java.lang.SecurityManager#checkWrite(java.lang.String)}
	 *                           method denies write access to the named file
	 */
	boolean setWritable(boolean w, boolean o);

	/**
	 * Convenience method to set the owner's write permission for this abstract
	 * pathname. On some platforms it may be possible to start the Java virtual
	 * machine with special privileges that allow it to modify files that disallow
	 * write operations.
	 *
	 * <p>The {@link java.nio.file.Files} class defines methods that operate on
	 * file attributes including file permissions. This may be used when finer
	 * manipulation of file permissions is required.
	 *
	 * <p>An invocation of this method behaves in exactly the same way as the
	 * invocation <pre>{@code file.setWritable(true, true)}</pre> sets the access
	 * permission to allow write operations; the write permission applies to
	 * everybody.
	 *
	 * @return {@code true} if and only if the operation succeeded. The operation
	 * 	will fail if the user does not have permission to change the access
	 * 	permissions of this abstract pathname.
	 *
	 * @throws SecurityException If a security manager exists and its {@link
	 *                           java.lang.SecurityManager#checkWrite(java.lang.String)}
	 *                           method denies write access to the named file
	 */
	default boolean setWritable() {
		return setWritable(true, true);
	}

	/**
	 * Returns a {@link Path java.nio.file.Path} object constructed from this
	 * abstract path. The resulting {@code Path} is associated with the {@link
	 * java.nio.file.FileSystems#getDefault default-filesystem}.
	 *
	 * <p>The first invocation of this method works as if invoking it were
	 * equivalent to evaluating the expression:
	 * <blockquote><pre>{@link java.nio.file.FileSystems#getDefault
	 * FileSystems.getDefault}().{@link java.nio.file.FileSystem#getPath
	 * getPath}(this.{@link #getPath getPath}()); </pre></blockquote>
	 * Subsequent invocations of this method return the same {@code Path}.
	 *
	 * <p>If this abstract pathname is the empty abstract pathname then this
	 * method returns a {@code Path} that may be used to access the current user
	 * directory.
	 *
	 * @return a {@code Path} constructed from this abstract path
	 *
	 * @throws java.nio.file.InvalidPathException if a {@code Path} object cannot
	 *                                            be constructed from the abstract
	 *                                            path (see {@link java.nio.file.FileSystem#getPath
	 *                                            FileSystem.getPath})
	 * @see Path#toFile
	 */
	java.nio.file.Path toPath();

	/**
	 * Creates a new {@code File} instance by converting the given {@code file:}
	 * URI into an abstract pathname.
	 *
	 * <p>The exact form of a {@code file:} URI is system-dependent, hence
	 * the transformation performed by this constructor is also system-dependent.
	 *
	 * <p>For a given abstract pathname <i>f</i> it is guaranteed that
	 * <pre>{@code new File(f.toURI()).equals(f)}</pre>.
	 * {@link #getAbsoluteFile() getAbsoluteFile}())</code></blockquote>
	 * so long as the original abstract pathname, the URI, and the new abstract
	 * pathname are all created in (possibly different invocations of) the same
	 * Java virtual machine.  This relationship typically does not hold, however,
	 * when a {@code file:} URI that is created in a virtual machine on one
	 * operating system is converted into an abstract pathname in a virtual
	 * machine on a different operating system.
	 *
	 * @return An absolute, hierarchical URI with a scheme equal to {@code
	 * 	"file"}, a non-empty path component, and undefined authority, query, and
	 * 	fragment components
	 *
	 * @throws NullPointerException     If {@code uri} is {@code null}
	 * @throws IllegalArgumentException If the preconditions on the parameter do
	 *                                  not hold
	 * @see #toURI()
	 * @see java.net.URI
	 */
	java.net.URI toURI();

}
