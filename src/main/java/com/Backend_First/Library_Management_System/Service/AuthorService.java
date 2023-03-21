package com.Backend_First.Library_Management_System.Service;

import com.Backend_First.Library_Management_System.Entity.Author;
import com.Backend_First.Library_Management_System.Repository.AuthorRepository;
import com.Backend_First.Library_Management_System.RequestDTO.AuthorRequestDto;
import com.Backend_First.Library_Management_System.ResponseDTO.AuthorResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

//    public void addAuthor(Author author) { authorRepository.save(author); }

    public AuthorResponseDto addAuthor(AuthorRequestDto authorRequestDto)
    {
        Author author = new Author();
        author.setName(authorRequestDto.getName());
        author.setAge(authorRequestDto.getAge());
        author.setMobNo(authorRequestDto.getMobNo());
        author.setEmail(authorRequestDto.getEmail());

        Author updatedAuthor = authorRepository.save(author);

        AuthorResponseDto authorResponseDto = new AuthorResponseDto();
        authorResponseDto.setId(updatedAuthor.getId());
        authorResponseDto.setAge(updatedAuthor.getAge());
        authorResponseDto.setName(updatedAuthor.getName());
        authorResponseDto.setEmail(updatedAuthor.getEmail());
        authorResponseDto.setMobNo(updatedAuthor.getMobNo());

        return authorResponseDto;
    }

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }
}
