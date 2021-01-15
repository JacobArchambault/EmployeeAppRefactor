package com.jacobarchambault.workerdemo;
public class WorkerDemo {

	public static void main(String[] args) {
		// Create a ProductionWorker object and pass the initialization
		// data to the constructor.
		TeamLeader tl = new TeamLeader("John Smith", "123-A", "11-15-2005", ProductionWorker.DAY_SHIFT,
				16.50, 500.00, 5.0, 2.5);

		// Display the data.
		System.out.println("Here's the first team leader.");
		tl.info();

		// Create another ProductionWorker object.
		TeamLeader pw2 = new TeamLeader("Joan Jones", "222-L", "12-12-2005", ProductionWorker.NIGHT_SHIFT, 18.50, 10000, 30, 10);

		// Display the data.
		System.out.println("\nHere's the second team leader.");
		tl.info();
	}
}