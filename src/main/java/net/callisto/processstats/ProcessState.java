package net.callisto.processstats;

public enum ProcessState {
	RUNNING,
	SLEEPING_INTERRUPTABLE_WAIT,
	WAITING_UNINTERRUPTIBLE_DISK_SLEEP,
	ZOMBIE,
	STOPPED_ON_SIGNAL,
	TRACING_STOP,
	DEAD,
	IDLE;
	
	public static ProcessState of(final char c) {
		return switch (c) {
			case 'R' -> RUNNING;
			case 'S' -> SLEEPING_INTERRUPTABLE_WAIT;
			case 'D' -> WAITING_UNINTERRUPTIBLE_DISK_SLEEP;
			case 'Z' -> ZOMBIE;
			case 'T' -> STOPPED_ON_SIGNAL;
			case 't' -> TRACING_STOP;
			case 'X' -> DEAD;
			case 'I' -> IDLE;
			default -> throw new IllegalStateException(String.format("'%c' is not a recognized state", c));
		};
	}
}
