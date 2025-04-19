package net.callisto.processstats;

public record Statm(
	int totalSize,
	int residentSetSize,
	int residentSharedPages,
	int text,
	int data // (and stack)
) {
	public static Statm parseData(final String... data) {
		return new Statm(
			Integer.parseInt(data[0]),
			Integer.parseInt(data[1]),
			Integer.parseInt(data[2]),
			Integer.parseInt(data[3]),
			Integer.parseInt(data[4])
		);
	}
	
	public static Statm parseString(final String data) {
		return parseData(data.split(" "));
	}
}
