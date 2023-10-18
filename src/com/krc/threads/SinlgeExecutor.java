package com.krc.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SinlgeExecutor {

	public static void main(String[] args) {
		// in a single executor pnly 1 thread runs and the next thread will wait for the
		// completion of the thread before starting the next one. Code outside of the
		// thread will run in parallel with the threads.
		ExecutorService exService = Executors.newSingleThreadExecutor();

		for (int d = 0; d < 400; d++) {
			exService.execute(new ATask(d));
		}
		// Task3

		System.out.println("Task 3 Start ");
		for (int i = 401; i < 600; i++) {
			System.out.print(i + " ");
		}
		System.out.println("");
		System.out.println("Task 3 Ended ");

		System.out.println("");
		System.out.println("Main Ended ");
		exService.shutdown();

	}

}
