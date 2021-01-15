package com.jacobarchambault.workerdemo;
public class WorkerDemo {

	public static void main(String[] args) {
		// Create a ProductionWorker object and pass the initialization
		// data to the constructor.
		TeamLeader tl = new TeamLeader("John Smith", "123-A", "11-15-2005", ProductionWorker.DAY_SHIFT,
				16.50, 500.00, 5.0, 2.5);

		// Display the data.
		System.out.println("Here's the first team leader.");
		info(tl);

		// Create another ProductionWorker object and use the
		// set methods.
		TeamLeader pw2 = new TeamLeader();
		pw2.setName("Joan Jones");
		pw2.setEmployeeNumber("222-L");
		pw2.setHireDate("12-12-2005");
		pw2.setShift(ProductionWorker.NIGHT_SHIFT);
		pw2.setPayRate(18.50);
		pw2.setMonthlyBonus(10000);
		pw2.setRequiredTrainingHours(30);
		pw2.setTrainingHoursAttended(10);

		// Display the data.
		System.out.println("\nHere's the second team leader.");
		info(pw2);
	}

	private static void info(TeamLeader tl) {
		System.out.println(tl);
	}
}