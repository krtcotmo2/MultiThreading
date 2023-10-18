package com.krc.threads;

public class ThreadBasicRunner {

	public static void main(String[] args) {
		// SINGLE THREAD OPERATIONS
		// TASK
		System.out.println("Task 1 Start ");
		for (int i = 0; i < 200; i++) {
			System.out.print(i + " ");
		}
		// TASK
		System.out.println("");
		System.out.println("Task 1 Ended ");
		System.out.println("Task 2 Start ");
		for (int i = 201; i < 400; i++) {
			System.out.print(i + " ");
		}
		// TASK
		System.out.println("");
		System.out.println("Task 2 Ended ");
		System.out.println("Task 3 Start ");
		for (int i = 401; i < 600; i++) {
			System.out.print(i + " ");
		}
		System.out.println("");
		System.out.println("Task 3 Ended ");
	}

}
