package com.hr.hrspring.lambdas;

/**
 * @Imperative ->  focuses on describing how a program operates
 * step by step
 *
 * @Declarative -> method to abstract away the control flow for logic
 * required for software to perform an action, and instead involves stating
 * what the task or desired outcome is
 */
public class Lambdas {

    // Stream > is an abstraction of a non-mutable collection,
    // this is applied in some order to the data

    //(int arg1, String arg2) -> (System.out.printf(arg1 + arg2));
    // Arguments              token     body lambda expression
    // operator -> body

    // Zero parameter
    // () -> System.out.printf("Zero")


    // One parameter
    // (x) -> System.out.printf("One >>" + x)

    // Multiples
    // (p1, p2) -> System.out.printf("Multiples >> " + p1 + p2)
    // Fundamentally a lambda is just a shorter way of writing as implementation of a
    // method for later execution.
                            // Abstract way of telling what we cant not how
    // [concrete].stream -> stream.stream.stream -> Sn

    // Structure
    // source -> [intermediate operation].terminal operation

}
