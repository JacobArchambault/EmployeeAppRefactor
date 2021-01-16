package com.jacobarchambault.workerdemo;

import java.time.LocalDate;

public class WorkerDemo {

	public static void main(String[] args) {
		// Create a ProductionWorker object and pass the initialization
		// data to the constructor.
		Employee foo = new BasicEmployee("John Smith", "123-A", LocalDate.of(1999, 4, 21));
		Employee bar = new ProductionWorker(foo, ProductionWorker.DAY_SHIFT, 16.50);
		new TeamLeader(bar, 500.00,
				5.0, 2.5)
		// Display the data.
		.info("Here's the first team leader.");

		Employee foobar = new BasicEmployee("Joan Jones", "222-L", LocalDate.now());
		Employee prodWorker = new ProductionWorker(foobar, ProductionWorker.NIGHT_SHIFT, 18.50);
		// Create another TeamLeader object.
		new TeamLeader(prodWorker, 10000,
				30, 10)
		.info("\nHere's the second team leader.");
	}
}