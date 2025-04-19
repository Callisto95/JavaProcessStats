package net.callisto.processstats;

import java.io.*;

public class Main {
	public static void main(String[] args) {
		try (StatReader statReader = StatReader.of(1); StatmReader statmReader = StatmReader.of(1)) {
			System.out.println(statReader.read());
			System.out.println(statmReader.read());
			
			System.out.println(SysConf.getCLK());
			System.out.println(SysConf.getPageSize());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
