package com.jacobarchambault.workerdemo;

import java.text.NumberFormat;

/**
 * @author jacobarchambault
 *
 */
class TeamLeader implements Employee {
	private double monthlyBonus;
	private double requiredTrainingHours;
	private double trainingHoursAttended;
	private Employee origin;

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
	public String toString() {
		String str = origin.toString();
		str += "\nMonthly bonus: " + NumberFormat.getCurrencyInstance()
				.format(monthlyBonus) + "\nRequired training hours: " + requiredTrainingHours
				+ "\nTraining hours attended: " + trainingHoursAttended;
		return str;
	}

	public void info() {
		System.out.println(this);
	}

	public void info(String introMessage) {
		System.out.println(introMessage);
		info();
	}

}