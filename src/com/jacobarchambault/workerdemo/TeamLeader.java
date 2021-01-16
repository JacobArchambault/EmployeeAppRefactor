package com.jacobarchambault.workerdemo;

import java.text.NumberFormat;

/**
 * @author jacobarchambault
 *
 */
class TeamLeader implements Employee {
	private double monthlyBonus;
	private Employee origin;
	private double requiredTrainingHours;
	private double trainingHoursAttended;

	TeamLeader(
			Employee employee,
			double bonus,
			double requiredHours,
			double hoursAttended) {
		origin = employee;
		monthlyBonus = bonus;
		requiredTrainingHours = requiredHours;
		trainingHoursAttended = hoursAttended;
	}

	public void info() {
		origin.info();
		String str = "Monthly bonus: " + NumberFormat.getCurrencyInstance()
				.format(monthlyBonus) + "\nRequired training hours: " + requiredTrainingHours
				+ "\nTraining hours attended: " + trainingHoursAttended;
		System.out.println(str);
	}

	public void info(String introMessage) {
		System.out.println(introMessage);
		info();
	}

}