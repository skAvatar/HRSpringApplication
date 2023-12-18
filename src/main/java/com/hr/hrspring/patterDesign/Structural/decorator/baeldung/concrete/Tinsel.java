package com.hr.hrspring.patterDesign.Structural.decorator.baeldung.concrete;

import com.hr.hrspring.patterDesign.Structural.decorator.baeldung.base.TreeDecorator;
import com.hr.hrspring.patterDesign.Structural.decorator.baeldung.interf.ChristmasTree;

public class Tinsel extends TreeDecorator {

    public Tinsel(ChristmasTree tree) {
        super(tree);
    }
    
    public String decorate() {
        return super.decorate() + decorateWithTinsel();
    }
    
    private String decorateWithTinsel() {
        return " with Tinsel";
    }
}