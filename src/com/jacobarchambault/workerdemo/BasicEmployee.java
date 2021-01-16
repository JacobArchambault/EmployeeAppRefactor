package com.jacobarchambault.workerdemo;

import java.time.LocalDate;

class BasicEmployee implements Employee {
	String name; // Employee name
	String employeeNumber; // Employee number
	LocalDate hireDate; // Employee hire date

	/**
	 * This constructor initializes an object with a name, employee number, and hire
	 * date.
	 * 
	 * @param n    The employee's name.
	 * @param num  The employee's number.
	 * @param date The employee's hire date.
	 */
	BasicEmployee(
			String n,
			String num,
			LocalDate date) {
		name = n;
		setEmployeeNumber(
				num);
		hireDate = date;
	}

	/**
	 * The setEmployeeNumber method sets the employee's number.
	 * 
	 * @param e The employee's number.
	 */
	public void setEmployeeNumber(
			String e) {
		if (isValidEmpNum(
				e))
			employeeNumber = e;
		else
			employeeNumber = "";
	}

	/**
	 * isValidEmpNum is a method that determines whether a string is a valid
	 * employee number.
	 * 
	 * @param e The string containing an employee number.
	 * @return true if e references a valid ID number, false otherwise.
	 */
	boolean isValidEmpNum(
			String e) {
		boolean status = true;
		if (e
				.length() != 5) {
			status = false;
		} else {
			if ((!Character
					.isDigit(
							e
									.charAt(
											0)))
					|| (!Character
							.isDigit(
									e
											.charAt(
													1)))
					|| (!Character
							.isDigit(
									e
											.charAt(
													2)))
					|| (e
							.charAt(
									3) != '-')
					|| (!Character
							.isLetter(
									e
											.charAt(
													4))))
				status = false;
		}
		return status;
	}

	/**
	 * toString method
	 * 
	 * @return A reference to a String representation of the object.
	 */
	public String toString() {
		String str = "Name: " + name + "\nEmployee Number: ";
		if (employeeNumber == "")
			str += "INVALID EMPLOYEE NUMBER";
		else
			str += employeeNumber;
		str += ("\nHire Date: " + hireDate);
		return str;
	}

}