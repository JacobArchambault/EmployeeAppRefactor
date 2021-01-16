package com.jacobarchambault.workerdemo;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		setEmployeeNumber(num);
		hireDate = date;
	}

	/**
	 * The setEmployeeNumber method sets the employee's number.
	 * 
	 * @param e The employee's number.
	 */
	public void setEmployeeNumber(String e) {
		if (isValidEmpNum(e))
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
	boolean isValidEmpNum(String e) {
		Pattern p = Pattern.compile("[0-9]{3}-[A-z]");
		Matcher m = p.matcher(e);
		return m.matches();
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