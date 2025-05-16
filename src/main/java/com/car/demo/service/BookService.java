package com.car.demo.service;

import com.car.demo.model.Book;
import com.car.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    private static final Map<Long, Book> books = new HashMap<>();

    static {
        Book b1=new Book();
        b1.setId(1l);
        b1.setName("Hello");
        b1.setAuthor("Sudhakar");

        Book b2=new Book();
        b2.setId(2l);
        b2.setName("HI");
        b2.setAuthor("ABC");

        Book b3=new Book();
        b3.setId(3l);
        b3.setName("Hello");
        b3.setAuthor("XYZ");

        Book b4=new Book();
        b4.setId(4l);
        b4.setName("Hey");
        b4.setAuthor("XYZ");

        books.put(b1.getId(),b1);
        books.put(b2.getId(), b2);
        books.put(b3.getId(), b3);
        books.put(b4.getId(), b4);


    }
    public List<Book> getAllBooks() {
return bookRepository.findAll();
//        Collection<Book> bookCollection=books.values();
//        return bookCollection.stream().toList();


        }

    public Optional<Book> getBookById(Long id) {
//        Map<Long,Book> bookMap=books;
//        Set keys=bookMap.keySet();
//        if(keys.contains(id)){
//           Book book=bookMap.get(id);
//           return book;
//        }
//        return null;
        Optional<Book> b=bookRepository.findById(id);
        if (b.isPresent())
        {

            return b;
        }

        return b;
    }


    public String createBook(Book book) {
        Book b=bookRepository.save(book);
//        books.put(book.getId(),book);
//        return book;
      return "Book Saved Successfully and book id is: "+b.getId();
    }

    public String deleteBook(Long id) {
        bookRepository.deleteById(id);
        return "successfully deleted" +id+"";
    }

    public Book updateBook(Long id, Book bookDetails) {
//        Object Book = null;
//        Optional<Book> b= bookRepository.findById(id);
//        if(b.isPresent()){
//            Book b1=new Book();
//            b1.setName();
//            b1.setAuthor();
//        }
        return bookRepository.findById(id)
                .map(book -> {
                    book.setName(bookDetails.getName());
                    book.setAuthor(bookDetails.getAuthor());
                    Book savedBook = bookRepository.save(book);
                    return savedBook;
                })
                .orElseGet(() ->null);
    }
}
