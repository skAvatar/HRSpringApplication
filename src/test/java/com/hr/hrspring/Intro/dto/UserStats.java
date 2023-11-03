package com.hr.hrspring.Intro.dto;

import java.util.Optional;


public class UserStats {

    public Optional<Long> getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(Optional<Long> visitCount) {
        this.visitCount = visitCount;
    }

    private Optional<Long> visitCount;



}
