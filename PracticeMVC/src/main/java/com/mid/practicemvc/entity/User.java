package com.mid.practicemvc.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class User {
    @Id
    private String id;
    private String fullName;
    private String lastName;
    private int age;
    private Double distance;


}
