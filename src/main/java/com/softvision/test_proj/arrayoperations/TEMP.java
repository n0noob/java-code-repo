package com.softvision.test_proj.arrayoperations;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TEMP {

	public static void main(String[] args) throws InterruptedException {

		// define capacity of ArrayBlockingQueue
		int capacity = 5;

		// create object of ArrayBlockingQueue
		BlockingQueue<String> queue = new LinkedBlockingQueue<String>(capacity);

		// Add elements to ArrayBlockingQueue using put method
		queue.put("StarWars");
		queue.put("SuperMan");
		queue.put("Flash");
		queue.put("BatMan");
		queue.put("Avengers");

		// print Queue
		System.out.println("queue contains " + queue);

		// Add elements to ArrayBlockingQueue
		// using put method
		queue.put("CaptainAmerica");
		queue.put("Thor");

		System.out.println("queue contains " + queue);
	}
}