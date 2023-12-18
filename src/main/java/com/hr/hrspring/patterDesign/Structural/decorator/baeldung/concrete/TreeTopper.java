package com.hr.hrspring.patterDesign.Structural.decorator.baeldung.concrete;

import com.hr.hrspring.patterDesign.Structural.decorator.baeldung.base.TreeDecorator;
import com.hr.hrspring.patterDesign.Structural.decorator.baeldung.interf.ChristmasTree;

public class TreeTopper extends TreeDecorator {

    public TreeTopper(ChristmasTree tree) {
        super(tree);
    }
    
    public String decorate() {
        return super.decorate() + decorateWithTreeTopper();
    }
    
    private String decorateWithTreeTopper() {
        return " with Tree Topper";
    }
}