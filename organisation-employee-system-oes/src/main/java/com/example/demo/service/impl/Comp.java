package com.example.demo.service.impl;

import java.util.Comparator;

import com.example.demo.model.Employee;

public class Comp implements Comparator<Employee> {
	@Override
	public int compare(Employee o1, Employee o2) {
		String s1 = o1.getName();
		String s2 = o2.getName();
		return s1.compareTo(s2);
	}
}

class Comp2 implements Comparator<Employee> {
	@Override
	public int compare(Employee o1, Employee o2) {

		Integer s1 = o1.getYearOfExperience();
		Integer s2 = o2.getYearOfExperience();
		return -s1.compareTo(s2);
	}
}
