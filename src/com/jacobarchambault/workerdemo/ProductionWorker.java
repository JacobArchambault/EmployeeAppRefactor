package com.jacobarchambault.workerdemo;

import java.text.NumberFormat;

/**
 * The ProductionWorker class stores data about an employee who is a production
 * worker for the Employee and ProductionWorker Classes programming challenge.
 */
class ProductionWorker implements Employee {

	// Constants for the day and night shifts.
	static final int DAY_SHIFT = 1;
	static final int NIGHT_SHIFT = 2;
	Employee base;
	double payRate; // The employee's pay rate
	int shift; // The employee's shift

	/**
	 * This constructor initializes an object with a name, employee number, hire
	 * date, shift, and pay rate
	 * 
	 * @param n    The employee's name.
	 * @param num  The employee's number.
	 * @param date The employee's hire date.
	 * @param sh   The employee's shift.
	 * @param rate The employee's pay rate.
	 */
	ProductionWorker(
			Employee basicEmployee,
			int sh,
			double rate) {
		shift = sh;
		payRate = rate;
		base = basicEmployee;
	}

	@Override
	public void info() {
		base.info();
		printShift();
		String str = "Hourly Pay Rate: " + NumberFormat.getCurrencyInstance()
				.format(payRate);

		System.out.println(str);
	}

	@Override
	public void info(String introMessage) {
		System.out.println(introMessage);
		info();
	}

	private void printShift() {
		String str = "Shift: ";
		if (shift == DAY_SHIFT)
			str += "Day";
		else if (shift == NIGHT_SHIFT)
			str += "Night";
		else
			str += "INVALID SHIFT NUMBER";
		System.out.println(str);
	}

}