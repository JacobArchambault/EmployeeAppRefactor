package com.jacobarchambault.workerdemo;

import java.time.LocalDate;

public class WorkerDemo {

	public static void main(
			String[] args) {
		System.out.println(
				"Now our classes are composable\n");

		// Create a ProductionWorker object and pass the initialization
		// data to the constructor.
		new ProductionWorker(
				new BasicEmployee(
						"John Smith",
						"123-A",
						LocalDate.of(
								1999,
								4,
								21)),
				ProductionWorker.DAY_SHIFT,
				16.50)
						// Display the data.
						.info(
								"Here's a production worker.");
		System.out.println();

		// Create a TeamLeader object.
		new TeamLeader(
				new BasicEmployee(
						"Jack Johnson",
						"321-B",
						LocalDate.of(
								2004,
								12,
								20)),
				5000,
				20,
				10).info(
						"Here's a Team Leader");

		System.out.println();
		new TeamLeader(
				new ProductionWorker(
						new BasicEmployee(
								"Joan Jones",
								"222-L",
								LocalDate.now()),
						ProductionWorker.NIGHT_SHIFT,
						18.50),
				10000,
				30,
				10).info(
						"Here's a team leader who is also a production worker.");
	}
}