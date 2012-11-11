package org.skyblue.algorithms;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LinkedListTest {
	
	@Test
	public void createAndPrint() {
		LinkedList<String> names = buildLinkedList();
		System.out.println(names);
		assertTrue(names.root() != null);
		assertTrue(names.root().data != null);
		assertTrue(names.root().data.equals("gambhir"));
		assertTrue(names.size() == 8);
	}
	
	@Test
	public void tryReverse() {
		LinkedList<String> names = buildLinkedList();
		names.reverse();
		System.out.println(names);
		assertTrue(names.root() != null);
		assertTrue(names.root().data != null);
		assertTrue(names.root().data.equals("zaheer"));
		assertTrue(names.size() == 8);
	}
	
	
	@Test
	public void tryFind() {
		LinkedList<String> names = buildLinkedList();
		assertTrue(names.exists("dhoni"));
		assertTrue(!names.exists("amit"));
    }
	
	@Test
	public void tryRemove() {
		LinkedList<String> names = buildLinkedList();
		assertTrue(names.size() == 8);
		names.remove("dhoni");
		assertTrue(names.size() == 7);
		System.out.println(names);
    }

	private LinkedList<String> buildLinkedList() {
		LinkedList<String> names = new LinkedList<String>();
		names.insert("gambhir");
		names.insert("sehwag");
		names.insert("tendulkar");
		names.insert("kohli");
		names.insert("dhoni");
		names.insert("raina");
		names.insert("ashwin");
		names.insert("zaheer");
		return names;
	}

}
