package com.jacobarchambault.workerdemo;

import java.text.NumberFormat;

/**
 * @author jacobarchambault
 *
 */
class TeamLeader extends ProductionWorker {
	private double monthlyBonus;
	private double requiredTrainingHours;
	private double trainingHoursAttended;

	TeamLeader(Employee basicEmployee, int sh, double rate, double bonus, double requiredHours,
			double hoursAttended) {
		super(basicEmployee, sh, rate);
		monthlyBonus = bonus;
		requiredTrainingHours = requiredHours;
		trainingHoursAttended = hoursAttended;
	}

	@Override
	public String toString() {
		String str = super.toString();
		str += "\nMonthly bonus: " + NumberFormat.getCurrencyInstance().format(monthlyBonus)
				+ "\nRequired training hours: " + requiredTrainingHours + "\nTraining hours attended: "
				+ trainingHoursAttended;
		return str;
	}

	void info() {
		System.out.println(this);
	}
	void info(String introMessage) {
		System.out.println(introMessage);
		info();
	}

}