package com.car.demo.controller;

import com.car.demo.model.Book;
import com.car.demo.model.Employee;
import com.car.demo.service.BookService;
import com.car.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    private BookService bookService;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Optional<Book> getBookById(@PathVariable Long id) {
        Optional<Book> book = bookService.getBookById(id);
//        return (book != null) ? (ResponseEntity<Book>) ResponseEntity.ok() : ResponseEntity.notFound().build();
    return book;
    }

    @PostMapping("/books")
    public String createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }
    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return employeeService.getEmployee(id);
    }


    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }


    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        Employee updated = employeeService.updateEmployee(id, employeeDetails);
        return (updated != null) ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        Book updated = bookService.updateBook(id, bookDetails);
//        return (updated != null) ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
        return updated;
    }
//
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        Object empService;
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
   }
    @DeleteMapping("/books/{id}")
    public String deleteBook(@PathVariable Long id) {
        Object empService;
       String s= bookService.deleteBook(id);
        return s;
    }
}

