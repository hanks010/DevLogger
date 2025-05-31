package com.org.devlogger.api.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class LogEntryTag {
    @Id
    private Long id;
}
