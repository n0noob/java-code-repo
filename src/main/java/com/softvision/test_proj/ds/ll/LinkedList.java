package com.softvision.test_proj.ds.ll;

class LinkedList {
	private LinkedNode root;

	public LinkedList(int data) {
		root = new LinkedNode(data);
	}

	public void insertStart(int data) {
		LinkedNode newNode = new LinkedNode(data);
		if (root == null)
			root = newNode;
		else {
			newNode.next = root;
			root = newNode;
		}
	}

	public void insertEnd(int data) {
		LinkedNode newNode = new LinkedNode(data);
		if (root == null)
			root = newNode;
		else {
			LinkedNode temp = root;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
	}

	public int deleteStart() {
		if (root == null) {
			return 0;
		}

		LinkedNode temp = root;
		root = root.next;
		System.out.println("Deleting node from start : " + temp.data);
		return temp.data;
	}

	public int deleteEnd() {
		if (root == null) {
			return 0;
		}

		int data;
		if (root.next == null) {
			data = root.data;
			root = null;
			return data;
		} else {
			LinkedNode temp = root;
			while (temp.next.next != null) {
				temp = temp.next;
			}
			data = temp.next.data;
			temp.next = null;
		}

		System.out.println("Deleting node from end : " + data);
		return data;
	}

	public void print() {
		StringBuilder sb = new StringBuilder();
		System.out.print("<");
		LinkedNode temp = root;

		while (temp != null) {
			sb.append(temp.data + ", ");
			temp = temp.next;
		}
		sb.deleteCharAt(sb.lastIndexOf(","));
		sb.deleteCharAt(sb.lastIndexOf(" "));
		System.out.print(sb.toString());

		System.out.print(">");
	}

	public void insertAfter(int toFind, int data) {

		LinkedNode temp = root;
		if (temp == null) {
			System.out.println("insertAfter : Empty list!");
			return;
		}
		LinkedNode newNode = new LinkedNode(data);

		while (temp.next != null) {
			if (temp.data == toFind) {
				LinkedNode x = temp.next;
				temp.next = newNode;
				newNode.next = x;
				return;
			}
			temp = temp.next;
		}

		System.out.println("insertAfter : Requested node not found!");
		return;
	}

	public void reverse() {
		if (root == null || root.next == null)
			return;

		LinkedNode prev = root;
		LinkedNode curr = root.next;
		LinkedNode next = root.next.next;

		prev.next = null;
		while (curr != null) {
			curr.next = prev;
			prev = curr;
			curr = next;
			if (next != null)
				next = next.next;
		}
		root = prev;
	}

}