package com.jacobarchambault.workerdemo;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * @author jacobarchambault
 *
 */
public class TeamLeader extends ProductionWorker {
	double monthlyBonus;
	double requiredTrainingHours;
	double trainingHoursAttended;

	public TeamLeader(String n, String num, String date, int sh, double rate, double bonus, double requiredHours, double hoursAttended) {
		super(n, num, date, sh, rate);
		monthlyBonus = bonus;
		requiredTrainingHours = requiredHours;
		trainingHoursAttended = hoursAttended;
	}
	public TeamLeader(double bonus, double hoursRequired, double hoursAttended) {
		super();
		monthlyBonus = bonus;
		requiredTrainingHours = hoursRequired;
		trainingHoursAttended = hoursAttended;
	}

	public TeamLeader() {
		this(0, 0, 0);
	}
	public double getMonthlyBonus() {
		return monthlyBonus;
	}

	/**
	 * @param monthlyBonus
	 */
	public void setMonthlyBonus(double monthlyBonus) {
		this.monthlyBonus = monthlyBonus;
	}

	public double getRequiredTrainingHours() {
		return requiredTrainingHours;
	}

	/**
	 * @param requiredTrainingHours
	 */
	public void setRequiredTrainingHours(double requiredTrainingHours) {
		this.requiredTrainingHours = requiredTrainingHours;
	}

	public double getTrainingHoursAttended() {
		return trainingHoursAttended;
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
		str += "\nMonthly bonus: " + NumberFormat.getCurrencyInstance().format(monthlyBonus) + "\nRequired training hours: " + requiredTrainingHours
				+ "\nTraining hours attended: " + trainingHoursAttended;
		return str;
	}
	
	

}