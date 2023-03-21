package com.Backend_First.Library_Management_System.ResponseDTO;

import com.Backend_First.Library_Management_System.Enum.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentResponseDto {

    private int id;
    private String name;
    private int age;
    private String email;
    private Department department;

}
