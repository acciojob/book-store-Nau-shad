package com.driver;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    public BookRepository(){
        super();
    }
   private Map<Integer,Book> bookById = new HashMap<>(); // for store Id and Book details by class
   private Map<String ,Book> bookByAuthor = new HashMap<>();
   private Map<String,Book> bookByGenre = new HashMap<>();

   //**************************constructor ***********************************//
    public Book save(Book book){

        bookById.put(book.getId(), book);
        bookByAuthor.put(book.getAuthor(),book);
        bookByGenre.put(book.getGenre(),book);
         return book;
    }
//###########################################constructor ################################//

    public Book findBookById(int id){
      if(!bookById.containsKey(id)){
          return null;
      }
       Book book = bookById.get(id);
      return book;
    }

    public List<Book> findAll(){
        ArrayList<Book> allBook = new ArrayList<>();
        for(Book b : bookById.values()){
              allBook.add(b);
        }
        return allBook;
    }

    public void deleteBookById(int id){
        if(bookById.containsKey(id)){
            Book book = bookById.get(id);
            bookById.remove(book);
        }
      // return "Book deleted By Id";
    }

    public void deleteAll(){
        bookById.clear();
       // return "All books deleted";
    }

    public List<Book> findBooksByAuthor(String author){
        ArrayList<Book> BookByAuthor = new ArrayList<>();
        for(Book b : bookById.values()){
            BookByAuthor.add(b);
        }
        return BookByAuthor;
    }

    public List<Book> findBooksByGenre(String genre){
        ArrayList<Book> BookByGenre = new ArrayList<>();
        for(Book b : bookById.values()){
            BookByGenre.add(b);
        }
        return BookByGenre;

    }
}
