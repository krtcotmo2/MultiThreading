package com.krc.threads;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class CallableTask implements Callable<Long> {
	@Override
	public Long call() throws Exception {
		// TODO Auto-generated method stub
		Thread.sleep(5000);
		long a = System.currentTimeMillis();
		System.out.println("Internal " + a);
		return a;
	}
}

public class ReturnDataThread {

	public static void main(String[] args)
			throws InterruptedException, Exception {
		System.out.println(System.currentTimeMillis());
		ExecutorService exService = Executors.newFixedThreadPool(3);

		// Future is like a promise in JS
		// Future<Long> outTime = exService.submit(new CallableTask());
		// Long outTimeMsg = outTime.get();
		// System.out.println(outTimeMsg);

		List<CallableTask> abc = List.of(new CallableTask(),
				new CallableTask(), new CallableTask(),
				new CallableTask(), new CallableTask(), new CallableTask());
		// Future is like a promise in JS
		List<Future<Long>> outTime = exService.invokeAll(abc);
		for (Future<Long> l : outTime) {
			System.out.println(l.get());
		}

		exService.shutdown();

		// To get just the first result of multiple threads
		// It does not continue with the remaining threads
		exService = Executors.newFixedThreadPool(3);

		// Future<Long> outTime = exService.submit(new CallableTask());
		// Long outTimeMsg = outTime.get();
		// System.out.println(outTimeMsg);

		List<CallableTask> newList = List.of(new CallableTask(),
				new CallableTask(), new CallableTask(), new CallableTask(),
				new CallableTask(), new CallableTask());
		Long singleTime = exService.invokeAny(newList);

		System.out.println(singleTime);

		System.out.println("\n Main completed");
		exService.shutdown();
	}

}
