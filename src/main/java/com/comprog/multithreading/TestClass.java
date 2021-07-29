package com.comprog.multithreading;

public class TestClass {
	//Here are my locks
	private Object lock1 = new Object();
	private Object lock2 = new Object();
	
	public void foo1() {
		System.out.println(Thread.currentThread().getName() + " : You are inside foo1()");
		/*
		 * try { Thread.sleep(1000); } catch (InterruptedException e) {
		 * e.printStackTrace(); }
		 */
		synchronized (lock1) {
			System.out.println(Thread.currentThread().getName() + " : Trying to call foo2");
			this.foo2();
		}
	}

	public void foo2() {
		System.out.println(Thread.currentThread().getName() + " : You are inside foo2()");

		synchronized(lock2) {
			System.out.println(Thread.currentThread().getName() + " : Trying to call foo3");
			this.foo3();
		}
	}
	
	public void foo3() {
		System.out.println(Thread.currentThread().getName() + " : You are inside foo3()");

		synchronized(lock1) {
			System.out.println(Thread.currentThread().getName() + " : BANG");
		}
	}
	
}
