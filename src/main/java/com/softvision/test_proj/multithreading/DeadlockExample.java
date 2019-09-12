package com.softvision.test_proj.multithreading;

public class DeadlockExample {
	public static void main(String[] args) {
		
		TestClass tc = new TestClass();
		Runnable r1 = () -> {
			tc.foo1();
		};
		
		Runnable r2 = () -> {
			tc.foo2();
		};
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		t1.start();
		t2.start();
		
	}
}
