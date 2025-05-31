package com.org.devlogger.api.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@ToString
public class User {
    @Id
    private long id;
    private String username;
    private String password;
    private String createdAt;
}
