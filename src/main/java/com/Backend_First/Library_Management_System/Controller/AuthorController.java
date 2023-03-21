package com.Backend_First.Library_Management_System.Controller;

import com.Backend_First.Library_Management_System.Entity.Author;
import com.Backend_First.Library_Management_System.RequestDTO.AuthorRequestDto;
import com.Backend_First.Library_Management_System.ResponseDTO.AuthorResponseDto;
import com.Backend_First.Library_Management_System.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/add")
    public AuthorResponseDto addAuthor(@RequestBody AuthorRequestDto authorRequestDto) {
        return authorService.addAuthor(authorRequestDto);
    }

    @GetMapping("/get_authors")
    public List<Author> getAuthors()
    {
        return authorService.getAuthors();
    }
}
