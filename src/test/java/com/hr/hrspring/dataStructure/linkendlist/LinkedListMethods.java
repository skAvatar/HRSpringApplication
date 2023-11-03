package com.hr.hrspring.dataStructure.linkendlist;

import com.hr.hrspring.Intro.hrclass.DoublyLinkedList;
import com.hr.hrspring.Intro.hrclass.DoublyLinkedListNode;
import com.hr.hrspring.Intro.hrclass.SinglyLinkedList;
import com.hr.hrspring.Intro.hrclass.SinglyLinkedListNode;

import java.util.ArrayList;
import java.util.List;

public abstract class LinkedListMethods {

    public static SinglyLinkedListNode createLinkedList(List<Integer> numbers) {
        SinglyLinkedList lList = new SinglyLinkedList();

        for (Integer actualN : numbers) {
            lList.head = addOnTail(lList.head, actualN);
        }
        return lList.head;
    }

    public static SinglyLinkedListNode addOnTail(SinglyLinkedListNode head, int data) {
        if (head == null) {
            return new SinglyLinkedListNode(data);
        }

        SinglyLinkedListNode localSinglyLinkedListNode = head;
        while (localSinglyLinkedListNode.next != null) {
            localSinglyLinkedListNode = localSinglyLinkedListNode.next;
        }
        localSinglyLinkedListNode.next = new SinglyLinkedListNode(data);

        return head;
    }

    public static DoublyLinkedListNode createDoubleLinkedList(List<Integer> numbers) {
        DoublyLinkedList dLList = new DoublyLinkedList();

        for (Integer actualN : numbers) {
            dLList.head = addOnTailDoubleLinkedL(dLList.head, actualN);
        }
        return dLList.head;
    }

    public static DoublyLinkedListNode addOnTailDoubleLinkedL(DoublyLinkedListNode head, int data) {
        if (head == null) {
            return new DoublyLinkedListNode(data);
        }

        DoublyLinkedListNode localNode = head;
        while (localNode.next != null) {
            localNode = localNode.next;
        }

        localNode.next = new DoublyLinkedListNode(data);
        localNode.next.prev = localNode;

        return head;
    }

    public static SinglyLinkedListNode joinTwoSortedListBest(SinglyLinkedListNode list1, SinglyLinkedListNode list2) {

        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        if (list1.data < list2.data) {
            list1.next = joinTwoSortedListBest(list1.next, list2);
            return list1;
        } else {
            list2.next = joinTwoSortedListBest(list1, list2.next);
            return list2;
        }
    }

    public static void printLinkedList(SinglyLinkedListNode head) {
        while (head != null) {
            System.out.print(head.data + "-> ");
            head = head.next;
        }
    }

    public static int getSize(SinglyLinkedListNode listOne) {
        int size = 0;
        SinglyLinkedListNode oldHead = listOne;
        while (listOne != null) {
            size++;
            listOne = listOne.next;
        }
        listOne = oldHead;
        return size;
    }

    public static int getSizeDLL(DoublyLinkedListNode head) {
        int size = 0;
        DoublyLinkedListNode oldHead = head;
        while (head != null) {
            size++;
            head = head.next;
        }
        head = oldHead;
        return size;
    }

    public static SinglyLinkedListNode addOnHead(SinglyLinkedListNode head, int data) {
        if (head == null) {
            return new SinglyLinkedListNode(data);
        }
        SinglyLinkedListNode newSinglyLinkedListNode = new SinglyLinkedListNode(data);
        newSinglyLinkedListNode.next = head;
        head = newSinglyLinkedListNode;
        return head;
    }

    public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {

        SinglyLinkedListNode localSinglyLinkedListNode = head;
        SinglyLinkedListNode before;
        if (position == 0) {

            localSinglyLinkedListNode = head.next;
            head.next = null;
            return localSinglyLinkedListNode;

        } else {
            for (int i = 0; i <= position - 1; i++) {
                before = localSinglyLinkedListNode;
                localSinglyLinkedListNode = localSinglyLinkedListNode.next;
                if (i == position - 1) {
                    before.next = localSinglyLinkedListNode.next;
                }
            }
        }
        return head;
    }

    public static DoublyLinkedListNode sortedInsertDLL(DoublyLinkedListNode llist, int data) {
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
        DoublyLinkedListNode temp = llist;
        if(temp.data > data){
            newNode.next = temp;
            temp.prev = newNode;
            return newNode;
        }else {
            while (temp.data < data) {
                if (temp.next == null) {
                    newNode.prev = temp;
                    newNode.next = null;
                    temp.next = newNode;
                    return llist;
                } else {
                    temp = temp.next;
                }
            }
            //DoublyLinkedListNode prev = temp.prev;
            newNode.prev = temp.prev;
            newNode.next = temp;
            temp.prev.next = newNode;
        }
        return llist;
    }

    public static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data)    {
        // Write your code here
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);

        if(head == null) return newNode;

        if(data <= head.data) {
            newNode.next = head;
            head.prev = newNode;
            return newNode;
        }

        DoublyLinkedListNode remaining = sortedInsert(head.next, data);
        head.next = remaining;
        remaining.prev = head;

        return head;
    }

    public static void printReverseLinkedList(SinglyLinkedListNode head) {
        List<Integer> listNumber = new ArrayList<>();
        while (head != null) {
            listNumber.add(head.data);
            head = head.next;
        }

        for (int i = listNumber.size() - 1; i >= 0; i--) {
            System.out.println(listNumber.get(i));
        }
    }

    public static SinglyLinkedListNode getTail(SinglyLinkedListNode head) {
        while (true) {
            head = head.next;
            if (head.next == null)
                return head;
        }
    }

    public static DoublyLinkedListNode getTailDLL(DoublyLinkedListNode head) {
        while (true) {
            head = head.next;
            if (head.next == null)
                return head;
        }
    }



}
