package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsorcedEmployee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Employee> list = new ArrayList<>();
		System.out.println("Enter the number of employees: ");
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			System.out.println("Employee #" + i + " data:");
			System.out.println("Outsourced (y/n)");
			String x = sc.next();
			System.out.println("Name:");
			String name = sc.next();
			System.out.print("Hour:");
			Integer hour = sc.nextInt();
			System.out.print("Value per Hour:");
			Double valueHour = sc.nextDouble();
			if (x == "y") {
				System.out.println("Additional charge:");
				Double addCharge = sc.nextDouble();
				Employee outemp = new OutsorcedEmployee(name, hour, valueHour, addCharge);
				list.add(outemp);
			} else {

				Employee emp = new Employee(name, hour, valueHour);
				list.add(emp);
			}
		}
		for (Employee employee : list) {
			System.out.println(employee.getName()+" - $"+String.format("%.2f", employee.payment()) );
		}
		sc.close();
	}
}
