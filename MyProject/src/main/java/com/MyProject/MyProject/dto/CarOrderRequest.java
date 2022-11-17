package com.MyProject.MyProject.dto;

import lombok.Data;

import java.util.List;

@Data
public class CarOrderRequest {

    private List<Integer>carIdList;
    private String userName;
}
