package com.Backend_First.Library_Management_System.ResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuthorResponseDto {

    private String name;
    private int age;
    private String mobNo;
    private String email;
    private int id;


}
