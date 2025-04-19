package net.callisto.processstats;

import java.io.*;

public class StatReader implements AutoCloseable {
	private final RandomAccessFile statFile;
	
	private StatReader(final RandomAccessFile statFile) {
		this.statFile = statFile;
	}
	
	public static StatReader of(final int pid) throws FileNotFoundException {
		return new StatReader(new RandomAccessFile(String.format("/proc/%d/stat", pid), "r"));
	}
	
	public Stat read() throws IOException {
		final Stat stat = Stat.parseString(this.statFile.readLine());
		this.statFile.seek(0);
		return stat;
	}
	
	@Override
	public void close() throws IOException {
		this.statFile.close();
	}
}
