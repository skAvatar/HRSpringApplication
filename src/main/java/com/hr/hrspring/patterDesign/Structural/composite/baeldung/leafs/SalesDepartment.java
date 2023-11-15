package com.hr.hrspring.patterDesign.Structural.composite.baeldung.leafs;

import com.hr.hrspring.patterDesign.Structural.composite.baeldung.base.Department;
import lombok.Data;

@Data
public class SalesDepartment implements Department {

    private Integer id;
    private String name;

    public SalesDepartment(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void printDepartmentName() {
        System.out.println(getClass().getSimpleName());
    }
}
