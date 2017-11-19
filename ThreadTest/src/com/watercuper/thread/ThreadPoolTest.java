package com.watercuper.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
	public static void main(String[] args) {
		//ExecutorService threadPool=Executors.newFixedThreadPool(3);
		//ExecutorService threadPool=Executors.newCachedThreadPool();
		ExecutorService threadPool=Executors.newSingleThreadExecutor();
		for(int i=0;i<10;i++) {
			final int task=i;
			threadPool.execute(new Runnable() {
				
				@Override
				public void run() {
					for(int j=1;j<=10;j++) {
						try {
							Thread.sleep(20);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName()+" is loop of"+j +" for task of" +task);
					}
				}
			});
		}
		System.out.println("all of 10 tasks have committed!");
		//threadPool.shutdown();
		
		/**
		 * 定时器线程
		 */
		Executors.newScheduledThreadPool(3).scheduleWithFixedDelay(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("bombing!");
			}
		}, 10, 5, TimeUnit.SECONDS);
	}
}
