package com.jacobarchambault.workerdemo;

import java.text.NumberFormat;

/**
 * @author jacobarchambault
 *
 */
class TeamLeader extends ProductionWorker {
	double monthlyBonus;
	double requiredTrainingHours;
	double trainingHoursAttended;

	TeamLeader(String n, String num, String date, int sh, double rate, double bonus, double requiredHours,
			double hoursAttended) {
		super(n, num, date, sh, rate);
		monthlyBonus = bonus;
		requiredTrainingHours = requiredHours;
		trainingHoursAttended = hoursAttended;
	}

	/**
	 * @param monthlyBonus
	 */
	public void setMonthlyBonus(double monthlyBonus) {
		this.monthlyBonus = monthlyBonus;
	}

	/**
	 * @param requiredTrainingHours
	 */
	public void setRequiredTrainingHours(double requiredTrainingHours) {
		this.requiredTrainingHours = requiredTrainingHours;
	}

	/**
	 * @param trainingHoursAttended
	 */
	public void setTrainingHoursAttended(double trainingHoursAttended) {
		this.trainingHoursAttended = trainingHoursAttended;
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

}