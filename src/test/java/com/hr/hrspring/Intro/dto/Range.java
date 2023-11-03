package com.hr.hrspring.Intro.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Range {

    int min;
    int max;

    public Range(int min, int max){
        this.min = min;
        this.max = max;
    }

}
