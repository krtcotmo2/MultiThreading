package com.krc.threads;

class Task1R implements Runnable {
	// all base function of the thread is run()
	@Override
	public void run() {
		System.out.println("Task 1 Start ");
		for (int i = 0; i < 20000; i++) {
			System.out.print(i + " ");
		}
		System.out.println("");
		System.out.println("TIME" + System.nanoTime());
		System.out.println("Task 1 Ended ");

	}
}

class Task2R implements Runnable {
	// all base function of the thread is run()
	@Override
	public void run() {
		System.out.println("Task 2 Start ");
		for (int i = 20001; i < 40000; i++) {
			System.out.print(i + " ");
		}
		System.out.println("");
		System.out.println("TIME" + System.nanoTime());
		System.out.println("Task 2 Ended ");
	}
}



public class ImplementRunnable {

	public static void main(String[] args) throws InterruptedException {
		Task1R task1 = new Task1R();
		Thread thread1 = new Thread(task1);
		thread1.start(); // IT IS NOT THE RUN METHOD
		Task2R task2 = new Task2R();
		Thread thread2 = new Thread(task2);
		thread2.start(); // IT IS NOT THE RUN METHOD

		// to have task 3 start only after Task 1 is completed (requires Interrupted
		// Exception)
		// thread1.join();
		// to have task 3 start only after Task 1 and task 2 is completed uncomment both
		// lines (requires Interrupted
		thread1.join();
		thread2.join();

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
