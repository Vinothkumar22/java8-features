package com.cvk.training.java8.features.functional_interface;

import java.util.ArrayList;
import java.util.List;

public class Employee<T, U, V> {

	private List<T> lastWeekWorkingHours = new ArrayList<>(7);
	private U exp;
	private V minPermissionTime;
	
	public Employee(U exp, V minPermissionTime) {
		this.exp = exp;
		this.minPermissionTime = minPermissionTime;
	}
	
	public void logDayWorkHour(T time) {
		lastWeekWorkingHours.add(time);
	}
	
	public void printEachDayAvg(TriConsumer<T, U, V> triConsumer) {
		lastWeekWorkingHours.stream().forEach(lastweekWorkingHour -> triConsumer.accept(lastweekWorkingHour, this.exp, this.minPermissionTime));
	}
}
