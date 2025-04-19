package net.callisto.processstats;

import java.io.*;

public class StatmReader implements AutoCloseable {
	private final RandomAccessFile statmFile;
	
	private StatmReader(final RandomAccessFile statmFile) {
		this.statmFile = statmFile;
	}
	
	public static StatmReader of(final int pid) throws FileNotFoundException {
		return new StatmReader(new RandomAccessFile(String.format("/proc/%d/statm", pid), "r"));
	}
	
	public Statm read() throws IOException {
		final Statm statm = Statm.parseString(this.statmFile.readLine());
		this.statmFile.seek(0);
		return statm;
	}
	
	@Override
	public void close() throws IOException {
		this.statmFile.close();
	}
}
