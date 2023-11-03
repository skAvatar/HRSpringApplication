package com.hr.hrspring.dataStructure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


/**
 Queue -> represents an ordered list of elements FIFO
 Stack -> An abstract data type that holds an ordered, linear sequence of items LIFO
 */
public class QueueOrStackTest {

    // Extends from Collections
    @Test
    void queueTest(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        Assertions.assertEquals(1, queue.poll());
    }

    // Synchronized
    // Extends from vector
    @Test
    void stackTest(){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        Assertions.assertEquals(3, stack.pop());
    }

}
