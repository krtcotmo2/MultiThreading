package com.krc.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiExecutor {

	public static void main(String[] args) {
		ExecutorService exService = Executors.newFixedThreadPool(100);

		for (int d = 0; d < 400; d++) {
			exService.execute(new ATask(d));
		}

		exService.shutdown();


	}

}
