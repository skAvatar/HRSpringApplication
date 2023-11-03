package com.hr.hrspring.Intro.dto;

import lombok.Getter;

@Getter
public class Pin  {

    Long id;
    Long height;

    public Pin(Long id, Long height){
        this.id = id;
        this.height = height;
    }

}
