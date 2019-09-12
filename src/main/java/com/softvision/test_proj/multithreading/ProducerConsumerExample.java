package com.softvision.test_proj.multithreading;

import java.util.Queue;
import java.util.Random;

class Producer {
	public void produce(Queue q) {
		//Wait if queue is full
		while(q.size() >= 10)
			;
		
		Random rand = new Random();
		Integer temp = rand.nextInt();
		System.out.println("Pushing : " + temp);
		q.add(temp);
		System.out.println("Queue : " + q);
	}
}

class Consumer {
	public void consume(Queue q) {
		while(q.size() == 0)
			;
		
		Integer temp = (Integer) q.poll();
		System.out.println("Consuming : " + temp);
		System.out.println("Queue : " + q);
	}
}

public class ProducerConsumerExample {
	
}
