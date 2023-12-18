package com.hr.hrspring.patterDesign.Structural.decorator.baeldung.base;

import com.hr.hrspring.patterDesign.Structural.decorator.baeldung.interf.ChristmasTree;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public abstract class TreeDecorator implements ChristmasTree {
    private ChristmasTree tree;
    
    // standard constructors
    @Override
    public String decorate() {
        return tree.decorate();
    }
}