/**
 * 
 */
package com.jacobarchambault.workerdemo;

/**
 * @author jacobarchambault
 *
 */
public class Trainee implements Employee {
	private final Employee base;
	private final double requiredTrainingHours;
	private final double trainingHoursAttended;

	/**
	 * 
	 */
	public Trainee(
			Employee employee,
			double requiredHours,
			double hoursAttended) {
		base = employee;
		requiredTrainingHours = requiredHours;
		trainingHoursAttended = hoursAttended;
	}

	@Override
	public void info() {
		base.info();
		printTrainingHoursAttended();
		printRequiredTrainingHours();

	}

	@Override
	public void info(String introMessage) {
		System.out.println(introMessage);
		info();
	}

	private void printRequiredTrainingHours() {
		System.out.println("Required training hours: " + requiredTrainingHours);
	}

	private void printTrainingHoursAttended() {
		System.out.println("Training hours attended: " + trainingHoursAttended);
	}
}
