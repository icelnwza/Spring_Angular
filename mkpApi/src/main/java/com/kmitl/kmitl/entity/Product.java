package com.kmitl.kmitl.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Product {
    @Id
    private String id;

    //@JsonProperty("fullname")
    private String name;
    private String description;
    private Double price;
    private String status;
}


