package com.multithreading.practice.data_structure;

public class LinkedListMain {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertItem(10);
        list.insertItem(12);
        list.insertItem(4);
        list.printList();

//        System.out.println("***************");
//        list.deleteByKey(10);
//        list.printList();
//
//        System.out.println("***************");
//
//        list.deleteByKey(12);
//        list.printList();


        System.out.println("***************");

        list.deleteByKey(4);
        list.printList();
    }
}
