package ku.util;
/**
 * A class for read and write a file
 * @author Pannapat Panpakdee
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class FileUtil {
	/**
	 * To read a text and copy
	 * @param in is to send file in to the method
	 * @param out is the output of copy process
	 */
	static void copy(InputStream in, OutputStream out) {
		try {
			while(in.read() > 0) {
				out.write( in.read() );
			}
		} catch (Exception e) {
			throw new RuntimeException();
		}
		finally {
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				throw new RuntimeException("can not close");
			}
		}
	}

	/**
	 * To read a text and copy
	 * @param in is to send file in to the method
	 * @param out is the output of copy process
	 * @param blocksize is the size of array that use to read file
	 */
	static void copy (InputStream in, OutputStream out, int blocksize) {
		byte[] buffer = new byte[blocksize];
		int count = 0;
		try {
			while ((count = in.read(buffer)) > 0) {
				out.write(buffer);
			}
		} catch (Exception e) {
			throw new RuntimeException("can not close");
		}
		finally {
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				throw new RuntimeException("can not close");
			}
		}
	}

	/**
	 * To read a text and copy
	 * @param in is to send file in to the method
	 * @param out is the output of copy process
	 */
	static void bcopy (InputStream in, OutputStream out) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		PrintWriter print = new PrintWriter(out);

		try {
			while (reader.ready()) {
				print.write(reader.read());
			}
		} catch (Exception e) {
			throw new RuntimeException("can not close");
		}
		finally {
			try {
				reader.close();
				print.close();
				in.close();
				out.close();	
			} catch (IOException e) {
				throw new RuntimeException("can not close");
			}
		}
	}

	/**
	 * To read a text and copy
	 * @param in is to send file in to the method
	 * @param out is the output of copy process
	 * @param blocksize is the size of array that use to read file
	 */
	static void bwriter (InputStream in, OutputStream out, int blocksize) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
		char [] output = new char [blocksize];

		try {
			while (reader.ready()) {
				writer.write(reader.read());
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		} 
		finally {
			try {
				reader.close();
				writer.close();
				in.close();
				out.close();
			} catch (IOException e) {
				throw new RuntimeException("can not close");
			}
		}
	}
}