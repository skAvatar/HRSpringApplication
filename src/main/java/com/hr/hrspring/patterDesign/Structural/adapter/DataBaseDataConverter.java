package com.hr.hrspring.patterDesign.Structural.adapter;

import java.util.List;

public interface DataBaseDataConverter {
    List<DisplayData> convertData(List<DataBaseData> data);

}
