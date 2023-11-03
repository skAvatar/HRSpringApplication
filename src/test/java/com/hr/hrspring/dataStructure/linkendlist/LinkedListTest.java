package com.hr.hrspring.dataStructure.linkendlist;

import ch.qos.logback.core.joran.sanity.Pair;
import com.hr.hrspring.Intro.hrclass.DoublyLinkedList;
import com.hr.hrspring.Intro.hrclass.DoublyLinkedListNode;
import com.hr.hrspring.Intro.hrclass.SinglyLinkedList;
import com.hr.hrspring.Intro.hrclass.SinglyLinkedListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;


@SpringBootTest
public class LinkedListTest extends LinkedListMethods{

    @Test
    void testAddOnTail() {

        List<Integer> elements = Arrays.asList(383, 484, 392, 975, 321);
        SinglyLinkedListNode head = createLinkedList(elements);

        printLinkedList(head);

    }

    @Test
    void insertNodeAtHead() {
        List<Integer> elements = Arrays.asList(383, 484, 392, 975, 321);
        SinglyLinkedList newList = new SinglyLinkedList();

        for (Integer actualN : elements) {
            newList.head = addOnHead(newList.head, actualN);
        }

        printLinkedList(newList.head);
    }


    @Test
    void deleteNode() {
        List<Integer> elements = Arrays.asList(11, 12, 8, 18, 16, 5, 18);

        SinglyLinkedListNode head = createLinkedList(elements);

        int position = 0;
        head = deleteNode(head, position);

        printLinkedList(head);

        Assertions.assertEquals(12, head.data);
    }

    @Test
    void joinTwoSortedListCore() {

        List<Integer> elements = List.of(1, 3, 7);
        List<Integer> elements2 = List.of(1, 2);
        //List<Integer> expectedResult = Arrays.asList(1, 2, 3, 4, 5);

        SinglyLinkedListNode listOne = null;
        SinglyLinkedListNode listTwo = null;
        SinglyLinkedList finalList = new SinglyLinkedList();
        SinglyLinkedListNode resultSinglyLinkedListNode = null;

        for (Integer actualN : elements) {
            listOne = addOnTail(listOne, actualN);
        }

        for (Integer actualN : elements2) {
            listTwo = addOnTail(listTwo, actualN);
        }

        int i = 0;
        int maxSize = getSize(listOne) + getSize(listTwo);
        while (i < maxSize) {
            if (listOne == null) {
                resultSinglyLinkedListNode = listTwo;
                addOnTail(finalList.head, resultSinglyLinkedListNode.data);
                i++;
                listTwo = listTwo.next;
                continue;
            }
            if (listTwo == null) {
                resultSinglyLinkedListNode = listOne;
                addOnTail(finalList.head, resultSinglyLinkedListNode.data);
                i++;
                listOne = listOne.next;
                continue;
            }

            if (listOne.data > listTwo.data) {
                resultSinglyLinkedListNode = listTwo;
                listTwo = listTwo.next;

            } else if (listOne.data < listTwo.data) {
                resultSinglyLinkedListNode = listOne;
                listOne = listOne.next;

            } else {
                resultSinglyLinkedListNode = listTwo;
                if (listTwo.next != null) {
                    listTwo = listTwo.next;
                }
            }

            if (finalList.head == null) {
                resultSinglyLinkedListNode.next = null;
                finalList.head = resultSinglyLinkedListNode;
            } else {
                resultSinglyLinkedListNode.next = null;
                addOnTail(finalList.head, resultSinglyLinkedListNode.data);
            }
            i++;
        }

        printLinkedList(finalList.head);

    }


    @Test
    void joinTwoSortedListBest() {

        List<Integer> elements = List.of(1, 3, 7, 9, 11, 13, 14, 15);
        List<Integer> elements2 = List.of(1, 2, 5, 6, 8, 10);

        SinglyLinkedListNode listOne = createLinkedList(elements);
        SinglyLinkedListNode listTwo = createLinkedList(elements2);;

        SinglyLinkedListNode head = joinTwoSortedListBest(listOne, listTwo);
        System.out.println(head.data);
    }

    @Test
    void getNodeByPositionFromTail() {
        List<Integer> elements = Arrays.asList(11, 12, 8, 10, 16, 5, 18);
        SinglyLinkedListNode llist = createLinkedList(elements);
        int position = 0;
        HashMap<Integer, SinglyLinkedListNode> mapLinked = new HashMap<>();
        Integer indexNode = 0;
        while (llist != null) {
            mapLinked.put(indexNode, llist);
            llist = llist.next;
            indexNode++;
        }
        SinglyLinkedListNode finalNode = mapLinked.get((mapLinked.size() - 1) - position);

        System.out.println("finalNode > " + finalNode.data);

    }

    // https://www.hackerrank.com/challenges/delete-duplicate-value-nodes-from-a-sorted-linked-list/problem
    @Test
    void removeDuplicates() {

        List<Integer> elements = Arrays.asList(1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4);
        SinglyLinkedList llist = new SinglyLinkedList();

        // Build List
        for (Integer actualN : elements) {
            llist.head = addOnTail(llist.head, actualN);
        }

        SinglyLinkedListNode actual = llist.head;
        SinglyLinkedListNode nextNode = actual.next;

        while (nextNode != null) {
            if (actual.data != nextNode.data) {
                actual.next = nextNode;
                actual = actual.next;
            }
            nextNode = nextNode.next;
        }

        actual.next = null;
        System.out.println(llist.head);

    }

    @Test
    void reversePrint() {
        List<Integer> elements = List.of(16, 12, 4, 2, 5);
        SinglyLinkedList newList = new SinglyLinkedList();
        for (Integer actualN : elements) {
            newList.head = addOnTail(newList.head, actualN);
        }
        printReverseLinkedList(newList.head);
    }

    @Test
    void reverseOrder() {

        List<Integer> elements = List.of(1, 2, 3, 4, 5);

        SinglyLinkedListNode node = createLinkedList(elements);
        SinglyLinkedList reverseList = new SinglyLinkedList();

        while (node != null) {
            reverseList.head = addOnHead(reverseList.head, node.data);
            node = node.next;
        }

        printLinkedList(reverseList.head);

    }

    @Test
    void directReverseOrder() {

        List<Integer> elements = List.of(1, 2, 3, 4, 5);
        SinglyLinkedListNode node = createLinkedList(elements);

        SinglyLinkedListNode prev = null;
        SinglyLinkedListNode current = node;
        SinglyLinkedListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = null;
            prev = current;
            current = next;
        }

        printLinkedList(prev);

    }

    @Test
    void compare2LinkedList() {

        List<Integer> elementsOne = List.of(1, 2, 3, 4);
        SinglyLinkedListNode headOne = createLinkedList(elementsOne);

        List<Integer> elementsTwo = List.of(1, 2, 3, 4);
        SinglyLinkedListNode listTwo = createLinkedList(elementsTwo);
        int sizeA = 0, sizeB = 0;

        if (sizeA != sizeB) {
            System.out.println(false);
        }
        boolean isEquals = false;

        while (headOne != null) {
            if (headOne.data == listTwo.data) {
                isEquals = true;
                headOne = headOne.next;
                listTwo = listTwo.next;
            } else {
                isEquals = false;
                break;
            }
        }
        Assertions.assertTrue(isEquals);
    }

    //https://www.hackerrank.com/challenges/find-the-merge-point-of-two-joined-linked-lists/problem?isFullScreen=true
    @Test
    void findMergeNode() {

        List<Integer> elementsOne = List.of(1, 2, 3);
        SinglyLinkedListNode headOne = createLinkedList(elementsOne);

        List<Integer> elementsTwo = List.of(1, 2, 3, 1, 1);
        SinglyLinkedListNode headTwo = createLinkedList(elementsTwo);

        SinglyLinkedListNode head1 = headOne;
        SinglyLinkedListNode head2;

        while (head1.next != null) {
            head2 = headTwo;
            while (head2.next != null) {
                if (head1 == head2) {
                    System.out.println("merge Node > " + head1.data);
                } else {
                    head2 = head2.next;
                }
            }
            head1 = head1.next;
            if (head1.next == null) {
                if (head1.data == head2.data) {
                    System.out.println("merge Node > " + head1.data);
                }
            }
        }
        Assertions.assertEquals(3, head1.data);
    }

    @Test
    void findMergeNodeBest() {

        List<Integer> elementsOne = List.of(1, 2, 3);
        SinglyLinkedListNode headOne = createLinkedList(elementsOne);

        List<Integer> elementsTwo = List.of(1, 3);
        SinglyLinkedListNode headTwo = createLinkedList(elementsTwo);

        SinglyLinkedListNode currentA = headOne;
        SinglyLinkedListNode currentB = headTwo;

        while (currentA != currentB) {
            if (currentB == null) {
                currentA = currentA.next;
                currentB = headTwo;
            } else {
                currentB = currentB.next;
            }
            if (currentA != null && currentB != null) {
                if (currentA.data == currentB.data &&
                        currentA.next == currentB.next) {
                    break;
                }
            }
        }
        Assertions.assertEquals(3, currentA.data);
    }

    @Test
    void insertNodeDoubleLinkedList() {
        int data = 1;
        List<Integer> elementsOne = List.of(2, 3, 4);
        DoublyLinkedListNode head = createDoubleLinkedList(elementsOne);

        head= sortedInsert(head, data);

        Assertions.assertEquals(4, getSizeDLL(head));
        Assertions.assertEquals(1, head.data);
        Assertions.assertEquals(4, getTailDLL(head).data);

    }

    @Test
    void reverseDLL() {

        List<Integer> elementsOne = List.of(1, 2, 3, 4);
        DoublyLinkedListNode lList = createDoubleLinkedList(elementsOne);

        DoublyLinkedListNode prev = null;
        DoublyLinkedListNode current = lList;
        DoublyLinkedListNode next = lList;
        while(current != null){
            next = next.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        System.out.println(prev.data);

    }


}
