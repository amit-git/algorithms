package org.skyblue.algorithms;

public class LinkedList<T> {

	private Node<T> root;
	private int size;

	public static class Node<T> {
		T data;
		Node<T> next;
	}
	
	public LinkedList() {
		
	}
	
	public Node<T> insert(T val) {
		size++;
		Node<T> lastNode = findLastNode();
		if (lastNode == null) {
			lastNode = new Node<T>();
			lastNode.data = val;
			root = lastNode;
			return root;
		} else {
			Node<T> newNode = new Node<T>();
			newNode.data = val;
			lastNode.next = newNode;
			return newNode;
		}
	}
	
	public void reverse() {
		if (root == null) {
			throw new NullPointerException("Can not reverse an empty list");
		}
		
		Node<T> p = null;
		Node<T> q = root;
		Node<T> r = q.next;
		
		while (q != null) {
			q.next = p;
			p = q;
			q = r;
			if (q != null) {
				r = q.next;
			}
		}
		root = p;
	}

	public Node<T> root() {
		return root;
	}
	
	public int size() {
		return size;
	}
	
	
	
	public boolean exists(T val) {
		return find(val) != null;
	}
	
	public void remove(T val) {
		Node<T> nodeToBeRemoved = find(val);
		
		// Remove logic
		if (nodeToBeRemoved != null) {
			Node<T> prev = root;
			while (prev.next != nodeToBeRemoved) {
				prev = prev.next;
			}
			// removes the pointer to nodeToBeRemoved
			prev.next = nodeToBeRemoved.next;
			size--;
		}
	}

	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("-- LinkedList --\n");
		
		Node<T> currentNode = root;
		while (currentNode != null) {
			sb.append(currentNode.data);
			if (currentNode.next != null) {
				sb.append(" --> ");
			}
			currentNode = currentNode.next;
		}
		
		return sb.toString();
	}
	
	
	/*
	 * Private methods
	 */
	private Node<T> find(T val) {
		if (root == null) {
			throw new NullPointerException("Finding value in an empty list");
		}
		
		Node<T> cur = root;
		while (cur != null) {
			if (cur.data.equals(val)) {
				return cur;
			}
			cur = cur.next;
		}
		return null;
	}
	
	private Node<T> findLastNode() {
		Node<T> currentNode = null;
		if (root != null) {
			currentNode = root;
			while(currentNode.next != null) {
				currentNode = currentNode.next;
			}
		}
		return currentNode;
	}
	
}
