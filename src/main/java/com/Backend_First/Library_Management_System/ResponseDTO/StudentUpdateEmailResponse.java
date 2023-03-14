package com.Backend_First.Library_Management_System.ResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentUpdateEmailResponse {
    private int id;
    private String name;
    private String email;
}
