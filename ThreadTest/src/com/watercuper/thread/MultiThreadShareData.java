package com.watercuper.thread;

public class MultiThreadShareData {
	public static void main(String[] args) {
		shareData1 data1=new shareData1();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				data1.decrement();
			}
		}).start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				data1.increment();
			}
		}).start();
	}
}

class shareData1 /*implements Runnable*/{
	
//	private int count=100;
//	@Override
//	public void run() {
//		while(true) {
//			count--;
//		}
//	}
	
	private int j=0;
	public synchronized void increment() {
		j++;
	}
	public synchronized void decrement() {
		j--;
	}
}
