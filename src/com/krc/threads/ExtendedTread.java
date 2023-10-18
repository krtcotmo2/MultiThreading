package com.krc.threads;

class ATask extends Thread {
	// all base function of the thread is run()

	private int number;

	ATask(int n) {
		this.number = n;
	}

	@Override
	public void run() {
		System.out.println("Task " + number + " Start ");
		for (int i = number * 100; i < number * 100 + 99; i++) {
			System.out.print(i + " ");
		}
		System.out.println("");
		System.out.println("Task " + number + " Ended ");
	}
}

class Task1 extends Thread {
	// all base function of the thread is run()
	@Override
	public void run() {
		System.out.println("Task 1 Start ");
		for (int i = 0; i < 200; i++) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}
}

class Task2 extends Thread {
	// all base function of the thread is run()
	@Override
	public void run() {
		System.out.println("Task 2 Start ");
		for (int i = 201; i < 400; i++) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}
}

class Task3 extends Thread {
	// all base function of the thread is run()
	@Override
	public void run() {
		System.out.println("Task 3 Start ");
		for (int i = 401; i < 600; i++) {
			System.out.print(i + " ");
		}
		System.out.println("");
		System.out.println("Task 3 Ended ");
	}
}

public class ExtendedTread {

	public static void main(String[] args) throws InterruptedException {
		Task1 task1 = new Task1();
		task1.start(); // IT IS NOT THE RUN METHOD
		Task2 task2 = new Task2();
		task2.start(); // IT IS NOT THE RUN METHOD

		// to have task 3 start only after Task 1 is completed
		task1.join();
		// to have task 3 start only after Task 1 and task 2 is completed uncomment both
		// lines
		// task1.join();
		// task2.join();

		// Task3
		System.out.println("Task 3 Start ");
		for (int i = 401; i < 600; i++) {
			System.out.print(i + " ");
		}
		System.out.println("");
		System.out.println("Task 3 Ended ");

		System.out.println("");
		System.out.println("Main Ended ");
	}

}
