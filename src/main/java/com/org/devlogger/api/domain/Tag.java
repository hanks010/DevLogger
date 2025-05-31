package com.org.devlogger.api.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Tag {
    @Id
    private long id;
    private String name;
}
