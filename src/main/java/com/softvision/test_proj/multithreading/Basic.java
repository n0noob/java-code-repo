package com.softvision.test_proj.multithreading;

public class Basic {

	public static void main(String[] args) {
		Runnable runnable = () -> {
			try {
				while (false != true) {
					Thread.sleep(2000);
					System.out.println("Hello from " + Thread.currentThread().getName());
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};

		Thread[] t = new Thread[5];

		for (int i = 0; i < t.length; i++) {
			t[i] = new Thread(runnable);
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			t[i].start();
		}
		
		System.out.println("I am doing my thing dude");

	}
}
