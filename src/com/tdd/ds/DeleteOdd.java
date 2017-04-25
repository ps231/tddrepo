package com.tdd.ds;

//delete odd valued nodes from a singly linked list
public class DeleteOdd {

    public static void main(String... args) {
        LinkedListNode list = new LinkedListNode();
        list.val = 1;

        LinkedListNode head = list;

        LinkedListNode another = new LinkedListNode();
        another.val = 3;
        list.next = another;
        list = list.next;

        another = new LinkedListNode();
        another.val = 2;
        list.next = another;
        list = list.next;

        another = new LinkedListNode();
        another.val = 5;
        list.next = another;
        list = list.next;

        another = new LinkedListNode();
        another.val = 6;
        list.next = another;
        list = list.next;


        LinkedListNode d = deleteOdd(head);

        System.out.println(d.val);
    }

    static LinkedListNode deleteOdd(LinkedListNode list) {
        if(list == null)
            return null;

        LinkedListNode p1 = list;

        while(p1 != null) {
            if(p1.val < 1 || p1.val > 100000)
                throw new IllegalArgumentException("Input node violates value constraints");
            if(p1.val % 2 != 0){
                p1 = p1.next;
            } else
                break;
        }

        if(p1 == null)
            return null;

        list = p1;
        LinkedListNode p2 = p1.next;

        while(p2 != null) {
            if(p2.val < 1 || p2.val > 100000)
                throw new IllegalArgumentException("Input node violates value constraints");
            if(p2.val % 2 != 0){
                if(p2.next != null){
                    p2 = p2.next;
                } else {
                    p1.next = null;
                    p2 = p2.next;
                }
            } else {
                p1.next = p2;
                p1 = p1.next;
                p2 = p1.next;
            }
        }
        return list;
    }
}

class LinkedListNode {
    LinkedListNode next;
    int val;
}
