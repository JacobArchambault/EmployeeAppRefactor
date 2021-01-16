package com.jacobarchambault.workerdemo;

import java.time.LocalDate;

public class WorkerDemo {

	public static void main(String[] args) {
		// Create a ProductionWorker object and pass the initialization
		// data to the constructor.
		new TeamLeader(new BasicEmployee("John Smith", "123-A", LocalDate.of(1999, 4, 21)), ProductionWorker.DAY_SHIFT, 16.50, 500.00,
				5.0, 2.5)
		// Display the data.
		.info("Here's the first team leader.");

		// Create another TeamLeader object.
		new TeamLeader(new BasicEmployee("Joan Jones", "222-L", LocalDate.now()), ProductionWorker.NIGHT_SHIFT, 18.50, 10000,
				30, 10)
		.info("\nHere's the second team leader.");
	}
}