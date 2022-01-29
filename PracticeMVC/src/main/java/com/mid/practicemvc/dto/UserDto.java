package com.mid.practicemvc.dto;

import lombok.Data;

@Data
public class UserDto {

    private String id = "";
    private String fullName = "";
    private String lastName = "";
    private int age = 0;
    private Double distance = 0.0;

}
