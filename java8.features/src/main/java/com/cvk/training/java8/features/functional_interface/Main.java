package com.cvk.training.java8.features.functional_interface;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		List<Employee<Float, Float, Float>> employees = new ArrayList<>();
		Employee<Float, Float, Float> emp1 = new Employee<>(1f, 1f);
		emp1.logDayWorkHour(8f);
		emp1.logDayWorkHour(6f);
		employees.add(emp1);

		Employee<Float, Float, Float> emp2 = new Employee<>(2f, 1f);
		employees.add(emp2);
		
		Employee<Float, Float, Float> emp3 = new Employee<>(3f, 0.5f);
		employees.add(emp3);
		
		Employee<Float, Float, Float> emp4 = new Employee<>(4f, 0.5f);
		employees.add(emp4);

		employees.forEach(employee -> {
			// with lambda
			employee.printEachDayAvg((lastWeekHour, exp, minPermHrs) -> {
				if (8 - lastWeekHour > minPermHrs) System.out.println("Exp " + exp + " not satisfied");
			});
		});
		
		employees.forEach(employee -> {
			// without lambda
			employee.printEachDayAvg(new TriConsumer<Float, Float, Float>() {
				@Override
				public void accept(Float lastWeekHour, Float exp, Float minPermHrs) {
					if (8 - lastWeekHour > minPermHrs) System.out.println("Exp " + exp + " not satisfied");					
				}
			});
		});
	}
}
