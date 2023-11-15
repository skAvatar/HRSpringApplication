package com.hr.hrspring.patterDesign.Structural.composite.baeldung.composite;

import com.hr.hrspring.patterDesign.Structural.composite.baeldung.base.Department;

import java.util.ArrayList;
import java.util.List;

public class HeadDepartment implements Department {

    private Integer id;
    private String name;

    private List<Department> childDepartment;

    public HeadDepartment(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.childDepartment = new ArrayList<>();
    }

    @Override
    public void printDepartmentName() {
        childDepartment.forEach(Department::printDepartmentName);
    }

    public void addDepartment(Department newDepartment){
        childDepartment.add(newDepartment);
    }

    public void removeDepartment(Department newDepartment){
        childDepartment.remove(newDepartment);
    }

}
