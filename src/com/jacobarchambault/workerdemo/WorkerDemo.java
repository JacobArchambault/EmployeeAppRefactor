package com.jacobarchambault.workerdemo;

import java.time.LocalDate;

public class WorkerDemo {

	public static void main(String[] args) {
		System.out.println("Illustrating composable decorators: \n");

		// Create a ProductionWorker object and pass the initialization
		// data to the constructor.
		new ProductionWorker(
				new BasicEmployee(
						"John Smith",
						"123-A",
						LocalDate.of(1999,
								4,
								21)),
				ProductionWorker.DAY_SHIFT,
				16.50)
						// Display the data.
						.info("Here's a production worker.");
		System.out.println();

		// Create a TeamLeader object.
		new TeamLeader(
				new BasicEmployee(
						"Jack Johnson",
						"321-B",
						LocalDate.of(2004,
								12,
								20)),
				5000).info("Here's a Team Leader");

		System.out.println();
		new Trainee(
				new ProductionWorker(
						new BasicEmployee(
								"Joan Jones",
								"222-L",
								LocalDate.now()),
						ProductionWorker.NIGHT_SHIFT,
						18.50),
				30,
				10).info("Here's a production worker who's also a trainee: ");

		System.out.println();
		new Trainee(
				new TeamLeader(
						new BasicEmployee(
								"Coriolanus Snow",
								"354-J",
								LocalDate.now()),
						5000),
				30,
				20).info("Hear's a trainee who's also a team leader: ");
	}
}