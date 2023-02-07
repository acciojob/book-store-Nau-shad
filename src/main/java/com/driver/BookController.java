package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    BookService bookService;

    // One example controller, make the rest by yourself
    @PostMapping("/books/create-book ")
    public ResponseEntity createBook(@RequestBody Book book){
        Book newBook = bookService.createBook(book);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    @GetMapping("/books/get-book-by-id/{id}")
    public ResponseEntity findBookById(@PathVariable("id") Integer id){
        Book newBook = bookService.findBookById(String.valueOf(id));
        return new ResponseEntity<>(newBook, HttpStatus.FOUND);
    }

    @GetMapping("/books/get-all-books")

    public ResponseEntity findAllBooks(){
        List<Book> allBooks = bookService.findAllBooks();
        return new ResponseEntity<>(allBooks, HttpStatus.FOUND);
    }

    @GetMapping("/books/get-books-by-author")
    public ResponseEntity findBooksByAuthor(@RequestParam("author") String author){
        List<Book> booksByAuthor= bookService.findBooksByAuthor(author);
        return new ResponseEntity<>(booksByAuthor, HttpStatus.FOUND);
    }

    @GetMapping("/books/get-books-by-genre")
    public ResponseEntity findBooksByGenre(@RequestParam("genre") String genre){
        List<Book> BooksByGenre= bookService.findBooksByGenre(genre);
        return new ResponseEntity<>(BooksByGenre, HttpStatus.FOUND);
    }

    @DeleteMapping("/books/delete-book-by-id/{id}")
    public ResponseEntity  deleteBookById(String id)
    {
        bookService.deleteBookById(id);
        return new ResponseEntity("Success", HttpStatus.OK);
    }

    @DeleteMapping("/books/delete-all-books")
    public ResponseEntity  deleteAllBooks(){

        bookService.deleteAllBooks();
        return new ResponseEntity("Success", HttpStatus.OK);
    }
    /*
    / //delete all books
    @DeleteMapping("/books/delete-all-books")
    public ResponseEntity deleteAllBooks(){
        bookService.deleteAllBooks();
        return new ResponseEntity("Success", HttpStatus.OK);
    }*/

}
