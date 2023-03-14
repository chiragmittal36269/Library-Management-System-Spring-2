package com.Backend_First.Library_Management_System.Controller;

import com.Backend_First.Library_Management_System.Entity.Book;
import com.Backend_First.Library_Management_System.RequestDTO.BookRequestDto;
import com.Backend_First.Library_Management_System.ResponseDTO.BookResponseDto;
import com.Backend_First.Library_Management_System.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

//    @PostMapping("/add")
//    public String addBook(@RequestBody Book book)
//    {
//        try {
//            bookService.addBook(book);
//        }
//        catch(Exception e) {
////            throw new RuntimeException(e.getMessage() + " So " + "Book not added");       // this line is showing error in intellj
//            return "author not found so book not added";                                    // this line is showing error in postman
//        }
//        return "Book Added Successfully";
//    }

    @PostMapping("/add")
    public BookResponseDto addBook(BookRequestDto bookRequestDto)
    {
        return bookService.addBook(bookRequestDto);
    }


    @GetMapping("/get_books")
    public List<Book> getBooks()
    {
        return bookService.getBooks();
    }
}
