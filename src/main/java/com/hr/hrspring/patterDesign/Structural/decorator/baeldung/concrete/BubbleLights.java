package com.hr.hrspring.patterDesign.Structural.decorator.baeldung.concrete;

import com.hr.hrspring.patterDesign.Structural.decorator.baeldung.base.TreeDecorator;
import com.hr.hrspring.patterDesign.Structural.decorator.baeldung.interf.ChristmasTree;

public class BubbleLights extends TreeDecorator {

    public BubbleLights(ChristmasTree tree) {
        super(tree);
    }
    
    public String decorate() {
        return super.decorate() + decorateWithBubbleLights();
    }
    
    private String decorateWithBubbleLights() {
        return " with Bubble Lights";
    }
}