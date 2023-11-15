package com.hr.hrspring.patterDesign.Structural.adapter;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Adapter implements DataBaseDataConverter{


    @Override
    public List<DisplayData> convertData(List<DataBaseData> data){
        List<DisplayData> displayDataList = new ArrayList<>();
        for(DataBaseData actualDBD: data){

            DisplayData newDisplayData = new DisplayData(String.valueOf(actualDBD.getPosition())
                    , (long)actualDBD.getAmount());
            displayDataList.add(newDisplayData);
        }


        return displayDataList;
    }



}
