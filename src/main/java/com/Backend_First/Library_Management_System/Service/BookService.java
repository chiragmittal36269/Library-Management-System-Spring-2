package com.Backend_First.Library_Management_System.Service;

import com.Backend_First.Library_Management_System.Entity.Author;
import com.Backend_First.Library_Management_System.Entity.Book;
import com.Backend_First.Library_Management_System.Repository.AuthorRepository;
import com.Backend_First.Library_Management_System.Repository.BookRepository;
import com.Backend_First.Library_Management_System.RequestDTO.BookRequestDto;
import com.Backend_First.Library_Management_System.ResponseDTO.BookResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

//    public String addBook(Book book) throws Exception {
//
//        Author author;
//
//        try {
//            author = authorRepository.findById(book.getAuthor().getId()).get();
//            // except author id everything is null because we pass only author id.
//            // line 24 is Fetch the data of author from author repository by the help of authorId which was given in book class.
//            // book is  the class, book.getAuthor() gives the details of Author of who publish the book, but we only want author_id so, we use .getId()
//            // now the main task is find the details of author using its id . because at the time of giving the data we are not providing the information of author we only provide the author_id.
//            // so we also need to find the author who is having that id.
//            // So for this, firstly I got the primary key which is author_Id from book class so, we use book.getAuthor().getId()
//            // after this we find the full details of author using it particular id so for this we use author repository because all author data is available over there.
//            // To access that data we use authorRepository.findByID(book.getAuthor().getId());
//            // findById() is return type function which is optional because it is possible that element or the value is not present so, it may be return null also
//            // so, we use .get(). It do something like if value is present then it return the value else return the exception
//            // so for this we write the line 24 in try and catch block
//
//        } catch (Exception e) {
//            throw new Exception(e);
////            return "Author not added";
//        }
//
//        // author is having all the information so, it is easy to access the list which was present in Author class
//        // because we have author_id which was present in book class
//        // Author "author" is having all the details of author who written that book
//        List<Book> booksWritten = author.getBooks();
//        booksWritten.add(book);
//
//        authorRepository.save(author);
//
//        return "Book Added Successfully";
//    }


    public BookResponseDto addBook(BookRequestDto bookRequestDto)
    {
        //get the author object
        Author author = authorRepository.findById(bookRequestDto.getAuthorId()).get();


        Book book = new Book();
        book.setTitle(bookRequestDto.getTitle());
        book.setPrice(bookRequestDto.getPrice());
        book.setGenre(bookRequestDto.getGenre());
        book.setIssued(false);
        book.setAuthor(author);

        author.getBooks().add(book);

        authorRepository.save(author);  // it will save both book and author

        //create a response also
        BookResponseDto bookResponseDto = new BookResponseDto();
        bookResponseDto.setTitle(book.getTitle());
        bookResponseDto.setPrice(book.getPrice());

        return bookResponseDto;
    }

    public List<Book> getBooks()
    {
        return bookRepository.findAll();
    }
}
