package com.org.java.collections.list.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import com.org.java.collections.list.entitie.Employee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employee> employees = new ArrayList<Employee>();
		Employee employee = null;
		
		System.out.print("How many employees will be registered? ");
		int quantity = sc.nextInt();
		
		for (int i = 0; i < quantity; i++) {
			
			System.out.println();
			System.out.println("Employee #" + (i + 1) + ":");
			System.out.print("Id: ");
			int id = sc.nextInt();
			
			while (hasId(employees, id)) {
				System.out.println("Id already taken! Try again:");
				id = sc.nextInt();
			}
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			
			employee = new Employee(id, name, salary);
			employees.add(employee);
		}// for(-)
		
		System.out.println();
		System.out.print("Enter the employee 'id' that will have salary increase: ");
		int idSalary = sc.nextInt();
		
//		Integer index = idSearch(employees, idSalary); 
		
		Employee emp = employees.stream().filter(x -> x.getId() == idSalary).findFirst().orElse(null);
		
//		if (index == null) {
		if (emp == null) {
			
			System.out.println("This id does not exist!");
		} else {
			System.out.print("Enter the percentage: ");
			double percentage = sc.nextDouble();
			
//			employees.get(index).increaseSalary(percentage);
			emp.increaseSalary(percentage);
		}
		
		System.out.println();
		System.out.println("List of employees:");
		for(Employee e : employees) {
			System.out.println(e);
		}
		
		sc.close();
		
	}// main(-)
	
	
//	public static Integer idSearch(List<Employee> list, int id) {
//		for (int i = 0; i < list.size(); i++) {
//			if (list.get(i).getId() == id) {
//				return i;
//			}
//		}
//		return null;
//	}
	
	public static boolean hasId(List<Employee> list, int id) {
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		
		return emp != null;
		
//		for (int i = 0; i < list.size(); i++) {
//			if (list.get(i).getId() == id) {
//				return true;
//			}
//		}
//		return false;
		
	}// method(-)
	
	
}// class(-)
