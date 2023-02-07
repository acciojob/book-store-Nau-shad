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
    @PostMapping("/create-book")
    public ResponseEntity createBook(@RequestBody Book book){
        Book newBook = bookService.createBook(book);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    @GetMapping("/get-book-by-id/{id}")
    public ResponseEntity findBookById(@PathVariable("id") Integer id){
        Book newBook = bookService.findBookById(String.valueOf(id));
        return new ResponseEntity<>(newBook, HttpStatus.FOUND);
    }

    @GetMapping("/get-all-books")

    public ResponseEntity findAllBooks(){
        List<Book> allBooks = bookService.findAllBooks();
        return new ResponseEntity<>(allBooks, HttpStatus.FOUND);
    }

    @GetMapping("/get-books-by-author")
    public ResponseEntity findBooksByAuthor(@RequestParam("author") String author){
        List<Book> booksByAuthor= bookService.findBooksByAuthor(author);
        return new ResponseEntity<>(booksByAuthor, HttpStatus.FOUND);
    }

    @GetMapping("/get-books-by-genre")
    public ResponseEntity findBooksByGenre(@RequestParam("genre") String genre){
        List<Book> BooksByGenre= bookService.findBooksByGenre(genre);
        return new ResponseEntity<>(BooksByGenre, HttpStatus.FOUND);
    }

    @DeleteMapping("/delete-book-by-id/{id}")
    public void deleteBookById(String id)
    {
        bookService.deleteBookById(id);
    }

    public void deleteAllBooks(){

        bookService.deleteAllBooks();
    }

}
