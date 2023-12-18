package com.hr.hrspring.patterDesign.Structural.decorator.baeldung;

import com.hr.hrspring.patterDesign.Structural.decorator.baeldung.interf.ChristmasTree;

public class ChristmasTreeImpl implements ChristmasTree {

    @Override
    public String decorate() {
        return "Christmas tree";
    }
}