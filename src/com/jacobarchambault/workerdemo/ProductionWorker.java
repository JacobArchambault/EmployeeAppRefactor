package com.jacobarchambault.workerdemo;
import java.text.DecimalFormat;
import java.time.LocalDate;

/**
 * The ProductionWorker class stores data about an employee who is a production
 * worker for the Employee and ProductionWorker Classes programming challenge.
 */
class ProductionWorker extends Employee {

	// Constants for the day and night shifts.
	static final int DAY_SHIFT = 1;
	static final int NIGHT_SHIFT = 2;
	 int shift; // The employee's shift
	double payRate; // The employee's pay rate

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
	ProductionWorker(String n, String num, LocalDate date, int sh, double rate) {
		super(n, num, date);
		shift = sh;
		payRate = rate;
	}


	/**
	 * toString method
	 * 
	 * @return A reference to a String representation of the object.
	 */
	@Override
	public String toString() {
		DecimalFormat currency = new DecimalFormat("$##,##0.00");
		String str = super.toString();
		str += "\nShift: ";
		if (shift == DAY_SHIFT)
			str += "Day";
		else if (shift == NIGHT_SHIFT)
			str += "Night";
		else
			str += "INVALID SHIFT NUMBER";
		str += "\nHourly Pay Rate: " + currency.format(payRate);

		return str;
	}
}