package com.Backend_First.Library_Management_System.RequestDTO;

import com.Backend_First.Library_Management_System.Enum.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookRequestDto {

    private String title;
    private int price;
    private Genre genre;
    private int authorId;
}
