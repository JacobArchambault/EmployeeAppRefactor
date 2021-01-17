package com.jacobarchambault.workerdemo;

import java.text.NumberFormat;

/**
 * @author jacobarchambault
 *
 */
class TeamLeader implements Employee {
	private double monthlyBonus;
	private Employee origin;

	TeamLeader(
			Employee employee,
			double bonus) {
		origin = employee;
		monthlyBonus = bonus;
	}

	@Override
	public void info() {
		origin.info();
		printMonthlyBonus();
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

}