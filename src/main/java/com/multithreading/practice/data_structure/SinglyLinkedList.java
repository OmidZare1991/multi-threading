package com.multithreading.practice.data_structure;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedList {
    Node head;

    public void insertItem(int data) {
        Node newNode = new Node(data);

        // If the Linked List is empty,
        // then make the new node as head
        if (this.head == null) {
            this.head = newNode;
        } else {
            // Else traverse till the last node
            // and insert the new_node there
            Node last = this.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
    }

    public void printList() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }

    public boolean deleteByKey(int data) {
        //Search the key for its first occurrence in the list
        //Case 1: The key is found at the head
        //Case 2: The key is found in the middle or last, except at the head
        //Case 3: The key is not found in the list
        if (head == null) {
            return false;
        }
        // if it is the first node
        if (head.data == data) {
            head = head.next;
            return true;
        }
        Node prevNode = head;
        Node current = head.next;

        while (current.next != null) {

            if (current.data == data) {
                prevNode.next = current.next;
                return true;
            } else {
                prevNode = current;
                current = current.next;
            }
        }
        // if it is the last node
        if (current.data == data) {
            prevNode.next = null;
            return true;
        }
        return false;
    }
}
