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

	@Override
	public void info() {
		origin.info();
		printMonthlyBonus();
		printRequiredTrainingHours();
		String str = "Training hours attended: " + trainingHoursAttended;
		System.out.println(str);
	}

	@Override
	public void info(String introMessage) {
		System.out.println(introMessage);
		info();
	}

	private void printMonthlyBonus() {
		System.out.println("Monthly bonus: " + NumberFormat.getCurrencyInstance()
		.format(monthlyBonus));
	}

	private void printRequiredTrainingHours() {
		System.out.println("Required training hours: " + requiredTrainingHours);
	}

}