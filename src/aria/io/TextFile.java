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

/**
 * Text File.
 *
 * @author  Alejandro Elí
 * @version 24/05/20
 * @since   1.0
 */
public abstract class TextFile extends File implements TextFileInterface {

	private static final long serialVersionUID = 3288881805920088878L;

	/** UTF-8 encoding literal. */
	private static final String UTF_8 = "UTF-8";

	/** ASCII encoding literal. */
	private static final String ASCII = "ASCII";

	/** Default encoding. */
	private String encoding = UTF_8;

	/**
	 * Initialize an abstract text file from the specified path.
	 *
	 * <p>Initialize a File with the specified path</p>
	 *
	 * @param path the path to the file
	 */
	public TextFile(final String path) {
		super(path);
	}

	/**
	 * Initialize an abstract text file from the specified path.
	 *
	 * <p>Initialize an abstract text file from the specified path</p>
	 *
	 * @param path the path to the file
	 */
	public TextFile(final java.nio.file.Path path) {
		super(path);
	}

	/**
	 * Initialize an abstract text file from a {@code java.io.File}.
	 *
	 * <p>This text file will contain the same path as the specified file</p>
	 *
	 * @param origin origin file
	 */
	public TextFile(final java.io.File origin) {
		super(origin);
	}

	/**
	 * Initialize a File from a composed path.
	 *
	 * <p>Initialize a File with the specified path. The path will be
	 * created by joining {@code parent} and {@code child} strings by a {@code
	 * /}.</p>
	 *
	 * @param parent the path to the parent file
	 * @param child  the name of the child file
	 */
	public TextFile(final String parent, final String child) {
		super(parent, child);
	}

	/**
	 * Initialize an abstract text file from a composed path.
	 *
	 * <p>Initialize an abstract text file from the specified path.
	 * The path will be created by joining {@code parent.toAbsolutePath().toString()}
	 * and {@code child} strings by a {@code /}.</p>
	 *
	 * @param parent parent file path
	 * @param child  name of the file
	 */
	public TextFile(final java.nio.file.Path parent, final String child) {
		super(parent, child);
	}

	/**
	 * Initialize an abstract text file from a composed path.
	 *
	 * <p>Initialize an abstract text file from the specified path.
	 * The path will be created by joining {@code parent.toAbsolutePath()} and
	 * {@code child} strings by a {@code /}.</p>
	 *
	 * @param parent parent file
	 * @param child  name of the file
	 */
	public TextFile(final java.io.File parent, final String child) {
		super(parent, child);
	}

	@Override
	public String getCurrentEncoding() {
		return encoding;
	}

	@Override
	public String getDefaultEncoding() {
		return UTF_8;
	}

	@Override
	public void setEncoding(final String encoding) {
		this.encoding = ASCII.equals(encoding) ? ASCII : UTF_8;
	}

	@Override
	public int[] read(final int ofs, final int length, final String enc) {
		final var list = new java.util.ArrayList<Integer>();
		try (var fis = new java.io.FileInputStream(getAbsoluteFile()); var isr = new java.io.InputStreamReader(fis, enc); var bfr = new java.io.BufferedReader(isr)) {
			var hasLimit = length > 0;
			int index = 0;
			int step = 0;
			int got;
			while ((got = bfr.read()) > -1) {
				if (++index <= ofs) continue;
				if (hasLimit && ++step > length) break;
				list.add(got);
			}
		} catch (java.io.IOException ex) {
			System.err.println(ex.getMessage());
		}
		return aria.util.Prima.ofInt(list);
	}

	@Override
	public boolean write(final String enc, final String... parts) {
		try (var fos = new java.io.FileOutputStream(getAbsoluteFile()); var osw = new java.io.OutputStreamWriter(fos, enc); var out = new java.io.BufferedWriter(osw)) {
			out.write(String.join("", parts));
			return true;
		} catch (java.io.IOException ex) {
			System.err.println(ex.getMessage());
			return false;
		}
	}
}


/**
 * Text File Interface.
 *
 * @author  Alejandro Elí
 * @version 24/05/20
 * @since   1.0
 */
interface TextFileInterface {

	private static char[] toChars(int[] data) {
		char[] ret = new char[data.length];
		for (int i = 0; i < data.length; i++) {
			ret[i] = (char) data[i];
		}
		return ret;
	}

	/**
	 * Get the current file encoding.
	 *
	 * @return the current file encoding
	 */
	String getCurrentEncoding();

	/**
	 * Get the default file encoding.
	 *
	 * @return the default file encoding
	 */
	String getDefaultEncoding();

	/**
	 * Redefine the current file encoding.
	 *
	 * @param encoding the new file encoding
	 */
	void setEncoding(String encoding);

	/**
	 * Read data from this file.
	 *
	 * @param ofs offset to start reading
	 * @param len length of returning array
	 * @param enc encoding name
	 *
	 * @return array of {@code int} with char code points
	 */
	int[] read(int ofs, int len, String enc);


	// * Reading

	/**
	 * Read data from this file.
	 *
	 * @param ofs offset to start reading
	 * @param len length of returning array
	 *
	 * @return array of {@code int} with char code points
	 */
	default int[] read(int ofs, int len) {
		return read(ofs, len, getDefaultEncoding());
	}

	/**
	 * Read data from this file.
	 *
	 * @param len length of returning array
	 * @param enc encoding name
	 *
	 * @return array of {@code int} with char code points
	 */
	default int[] read(int len, String enc) {
		return read(0, len, enc);
	}

	/**
	 * Read data from this file.
	 *
	 * @param enc encoding name
	 * @param ofs offset to start reading
	 *
	 * @return array of {@code int} with char code points
	 */
	default int[] read(String enc, int ofs) {
		return read(ofs, 0, enc);
	}

	/**
	 * Read data from this file.
	 *
	 * @param enc encoding name
	 *
	 * @return array of {@code int} with char code points
	 */
	default int[] read(String enc) {
		return read(0, 0, enc);
	}

	/**
	 * Read data from this file.
	 *
	 * @param len length of returning array
	 *
	 * @return array of {@code int} with char code points
	 */
	default int[] read(int len) {
		return read(0, len, getDefaultEncoding());
	}

	/**
	 * Read data from this file.
	 *
	 * @return array of {@code int} with char code points
	 */
	default int[] read() {
		return read(0, 0, getDefaultEncoding());
	}

	/**
	 * Read data from this file.
	 *
	 * @param ofs offset to start reading
	 * @param len length of the returning array
	 * @param enc encoding name
	 *
	 * @return String representation of the data in this file.
	 */
	default String reads(int ofs, int len, String enc) {
		return new String(toChars(read(ofs, len, enc)));
	}


	// * Reading as String

	/**
	 * Read data from this file.
	 *
	 * @param ofs offset to start reading
	 * @param len length of the returning array
	 *
	 * @return String representation of the data in this file.
	 */
	default String reads(int ofs, int len) {
		return new String(toChars(read(ofs, len)));
	}

	/**
	 * Read data from this file.
	 *
	 * @param len length of the returning array
	 * @param enc encoding name
	 *
	 * @return String representation of the data in this file.
	 */
	default String reads(int len, String enc) {
		return new String(toChars(read(len, enc)));
	}

	/**
	 * Read data from this file.
	 *
	 * @param enc encoding name
	 *
	 * @return String representation of the data in this file.
	 */
	default String reads(String enc) {
		return new String(toChars(read(enc)));
	}

	/**
	 * Read data from this file.
	 *
	 * @param len length of the returning array
	 *
	 * @return String representation of the data in this file.
	 */
	default String reads(int len) {
		return new String(toChars(read(len)));
	}

	/**
	 * Read data from this file.
	 *
	 * @return String representation of the data in this file.
	 */
	default String reads() {
		return new String(toChars(read()));
	}


	// * Writing

	/**
	 * Write a message on this file.
	 *
	 * @param encoding encoding name.
	 * @param parts    parts of the message
	 *
	 * @return {@code true} if the operation succeed
	 */
	boolean write(String encoding, String... parts);

	/**
	 * Write a String on this file using current encoding.
	 *
	 * @param message the string to write
	 *
	 * @return {@code true} if the operation succeed
	 */
	default boolean write(String message) {
		return write(getCurrentEncoding(), message);
	}
}
