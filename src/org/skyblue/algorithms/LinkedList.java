package org.skyblue.algorithms;

public class LinkedList<T extends Comparable<T>> {

    private Node<T> head;
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
            head = lastNode;
            return head;
        } else {
            Node<T> newNode = new Node<T>();
            newNode.data = val;
            lastNode.next = newNode;
            return newNode;
        }
    }

    public void reverse() {
        if (head == null) {
            throw new NullPointerException("Can not reverse an empty list");
        }

        Node<T> p = null;
        Node<T> q = head;
        Node<T> r = q.next;

        while (q != null) {
            q.next = p;
            p = q;
            q = r;
            if (q != null) {
                r = q.next;
            }
        }
        head = p;
    }

    public Node<T> root() {
        return head;
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
            Node<T> prev = head;
            while (prev.next != nodeToBeRemoved) {
                prev = prev.next;
            }
            // removes the pointer to nodeToBeRemoved
            prev.next = nodeToBeRemoved.next;
            size--;
        }
    }

    public void sort() {
        // insertion sort routine
        if (head == null) {
            return;
        }

        Node<T> i = head;
        while (i.next != null) {
            // list[0..i] is sorted - loop invariant
            Node<T> j = i.next;
            Node<T> p = head;

            boolean jInserted = false;
            if (p.data.compareTo(j.data) > 0) {
                // insert j as head
                i.next = j.next;
                j.next = p;
                head = j;
                jInserted = true;
            } else {
                // insert j in list[0..i]
                while (p != i) {
                    if (p.next.data.compareTo(j.data) > 0) {
                        i.next = j.next;
                        j.next = p.next;
                        p.next = j;
                        jInserted = true;
                        break;
                    }
                    p = p.next;
                }
            }
            if (!jInserted) {
                i = i.next;
            }
        }
    }

    /**
     * Shuffles the list such that a->b->c->d becomes b->a->d->c
     */
    public void shuffle() {
        Node<T> p = head;
        Node<T> prev = null;

        while (p != null && p.next != null) {
            // invariant need to swap nodes p and p.next
            Node<T> next = p.next;

            p.next = next.next;
            next.next = p;
            if (prev != null) {
                prev.next = next;
            } else {
                // head element
                head = next;
            }

            prev = p;
            p = p.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-- LinkedList --\n");

        Node<T> currentNode = head;
        while (currentNode != null) {
            sb.append(currentNode.data);
            if (currentNode.next != null) {
                sb.append(" --> ");
            }
            currentNode = currentNode.next;
        }

        return sb.toString();
    }

    public T get(int index) {
        int i = 0;
        Node<T> p = head;
        while (p != null) {
            if (i == index) {
                return p.data;
            }
            p = p.next;
        }
        return null;
    }

    /*
     * Private methods
     */
    private Node<T> find(T val) {
        if (head == null) {
            throw new NullPointerException("Finding value in an empty list");
        }

        Node<T> cur = head;
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
        if (head != null) {
            currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
        }
        return currentNode;
    }

}
