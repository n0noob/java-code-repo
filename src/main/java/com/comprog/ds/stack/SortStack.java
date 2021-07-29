package com.comprog.ds.stack;

import java.util.Stack;

public class SortStack {

	public void sortStack2(Stack<Integer> input) {
		Stack<Integer> temp = new Stack<>();

		while (!input.isEmpty()) {

			int t = input.pop();

			while (!temp.isEmpty() && temp.peek() < t) {
				input.push(temp.pop());
			}

			temp.push(t);
		}

		while (!temp.isEmpty())
			input.push(temp.pop());

		// System.out.println(temp);
	}

	public void sortStack(Stack<Integer> input) {
		Stack<Integer> temp = new Stack<>();

		while (input.size() > 0) {
			// Transfer all elements from input stack to temp stack and find minimum element
			int minTemp = Integer.MAX_VALUE;
			int i = 0;
			while (input.size() != 0) {
				int removedElement = input.pop();
				if (removedElement < minTemp)
					minTemp = removedElement;
				temp.push(removedElement);
				i++;
			}
			System.out.println("Temp min : " + minTemp);
			// Transfer all the elements back from temp stack to input stack
			int count = 0;
			while (i > 0) {
				int remEle = temp.pop();
				if (remEle == minTemp) {
					count++;
				} else {
					input.push(remEle);
				}
				i--;
			}
			while (count-- > 0) {
				temp.push(minTemp);
			}
		}

		while (temp.size() != 0) {
			input.push(temp.pop());
		}
	}

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		s.push(3);
		s.push(5);
		s.push(1);
		s.push(4);
		s.push(2);
		s.push(8);
		SortStack driver = new SortStack();
		driver.sortStack2(s);
		System.out.println(s);
	}
}