package net.callisto.processstats;

/**
 * Variables are from {@code man proc_pid_stat}
 * {@code PT}, unmaintained, or otherwise static variables are not listed
 */
public record Stat(
	int pid,
	String name,
	ProcessState state,
	int parent,
	int processGroup,
	int session,
	int terminal,
	int controllingTerminalProcessGroup,
	int flags,
	long minorFaults,
	long minorFaultsChildren,
	long majorFaults,
	long majorFaultsChildren,
	long userTimeTicks,
	long kernelTimeTicks,
	long userTimeTicksChildren,
	long kernelTimeTicksChildren,
	long priority,
	long nice,
	long threadCount,
	long startTimeTicks,
	long virtualMemorySize,
	long residentSetSize,
	long residentSetSizeLimit,
	int exitSignal,
	int processor,
	int realtimePriority
) {
	public static Stat parseData(final String... data) {
		return new Stat(
			Integer.parseInt(data[0]),
			data[1].substring(1, data[1].length() - 1),
			ProcessState.of(data[2].charAt(0)),
			Integer.parseInt(data[3]),
			Integer.parseInt(data[4]),
			Integer.parseInt(data[5]),
			Integer.parseInt(data[6]),
			Integer.parseInt(data[7]),
			Integer.parseUnsignedInt(data[8]),
			Long.parseUnsignedLong(data[9]),
			Long.parseUnsignedLong(data[10]),
			Long.parseUnsignedLong(data[11]),
			Long.parseUnsignedLong(data[12]),
			Long.parseUnsignedLong(data[13]),
			Long.parseUnsignedLong(data[14]),
			Long.parseLong(data[15]),
			Long.parseLong(data[16]),
			Long.parseLong(data[17]),
			Long.parseLong(data[18]),
			Long.parseLong(data[19]),
			Long.parseUnsignedLong(data[21]),
			Long.parseUnsignedLong(data[22]),
			Long.parseLong(data[23]),
			Long.parseUnsignedLong(data[24]),
			Integer.parseInt(data[37]),
			Integer.parseInt(data[38]),
			Integer.parseUnsignedInt(data[39])
		);
	}
	
	public static Stat parseString(final String data) {
		return parseData(data.split(" "));
	}
}
