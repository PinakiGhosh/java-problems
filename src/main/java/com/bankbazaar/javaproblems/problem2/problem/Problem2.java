package com.bankbazaar.javaproblems.problem2.problem;

import com.bankbazaar.javaproblems.problem2.model.SinglyLinkedList;

public class Problem2 {
    public static void main(String[] args) {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();

        list.addEnd("hello");
        list.addEnd("world");

        list.addStart("new");

        list.addAfter(1,"my");

        list.show();

        System.out.println("----------------");

        list.deleteStart();

        list.deleteEnd();

        list.deleteAfter(0);

        list.show();
    }
}
