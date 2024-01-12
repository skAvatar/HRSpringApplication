package com.hr.hrspring.patterDesign.Structural.flyweight.basic;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookType { // flyweightClass
    // Store invariant context-independent
    // Shareable and never altered at runtime
    private final String type;
    private final String distributor;
    private final String otherData;
}
