package com.Backend_First.Library_Management_System.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuthorRequestDto {

    private String name;
    private int age;
    private String mobNo;
    private String email;

}
