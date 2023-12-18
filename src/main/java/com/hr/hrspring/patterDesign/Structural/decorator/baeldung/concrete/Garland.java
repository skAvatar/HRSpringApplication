package com.hr.hrspring.patterDesign.Structural.decorator.baeldung.concrete;

import com.hr.hrspring.patterDesign.Structural.decorator.baeldung.base.TreeDecorator;
import com.hr.hrspring.patterDesign.Structural.decorator.baeldung.interf.ChristmasTree;

public class Garland extends TreeDecorator {

    public Garland(ChristmasTree tree) {
        super(tree);
    }
    
    public String decorate() {
        return super.decorate() + decorateWithGarland();
    }
    
    private String decorateWithGarland() {
        return " with Garland";
    }
}