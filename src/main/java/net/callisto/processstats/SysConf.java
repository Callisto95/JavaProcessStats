package net.callisto.processstats;

public class SysConf {
	static {
		System.loadLibrary("pstats");
	}
	
	static native int getCLK();
	static native int getPageSize();
	
	public int calculateMemorySize(final int pages) {
		return pages * getPageSize();
	}
	
	public double calculateSeconds(final int ticks) {
		return (double) ticks / getCLK();
	}
}
