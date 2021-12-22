package com.dolbom.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SampleDTOList {

    private List<SampleDTO> list;

    public void sampleDTOList() {
        list = new ArrayList<>();
    }
}
