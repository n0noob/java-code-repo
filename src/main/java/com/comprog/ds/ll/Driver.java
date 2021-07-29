package com.comprog.ds.ll;

public class Driver {
	public static void main(String[] args) {
		LinkedList ll = new LinkedList(5);
		ll.insertStart(3);
		ll.insertStart(2);
		ll.insertStart(1);
		ll.insertAfter(3, 4);
		ll.reverse();

		ll.print();
	}
}
