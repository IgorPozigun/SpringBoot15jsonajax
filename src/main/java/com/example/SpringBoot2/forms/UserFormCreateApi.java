package com.example.SpringBoot2.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserFormCreateApi {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
    private String password;
    private String roles;
}
