package com.jacobarchambault.workerdemo;

import java.time.LocalDate;
import java.util.regex.Pattern;

class BasicEmployee implements Employee {
	String employeeNumber; // Employee number
	LocalDate hireDate; // Employee hire date
	String name; // Employee name

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
		employeeNumber = num;
		hireDate = date;
	}

	@Override
	public void info() {
		printName();
		printNumber();
		printHireDate();
	}

	@Override
	public void info(String introMessage) {
		System.out.println(introMessage);
		info();
	}

	private void printHireDate() {
		System.out.println("Hire Date: " + hireDate);
	}

	private void printName() {
		System.out.println("Name: " + name);
	}

	private void printNumber() {
		String num = isValidEmpNum(employeeNumber) ? employeeNumber : "INVALID EMPLOYEE NUMBER";
		System.out.println("Employee Number: " + num);
	}

	/**
	 * isValidEmpNum is a method that determines whether a string is a valid
	 * employee number.
	 * 
	 * @param e The string containing an employee number.
	 * @return true if e references a valid ID number, false otherwise.
	 */
	boolean isValidEmpNum(String e) {
		return Pattern.compile("[0-9]{3}-[A-z]")
				.matcher(e)
				.matches();
	}
}