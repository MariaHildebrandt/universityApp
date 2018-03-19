package com.hildebrandt.uni.controllers;

import com.hildebrandt.uni.domain.Book;
import com.hildebrandt.uni.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    /*---Site for new book---*/
    @RequestMapping( path = "/book/create")
    public String loadForm(Model model) {
        model.addAttribute("book", new Book());
        return "books/create";
    }

    /*---Add new book---*/
    //@PostMapping("/book")
    @RequestMapping(path = "/book", method = RequestMethod.POST)
    public String save(Book book) {

        long id = bookService.create(book);
        return "redirect:/book/" + id;
    }

    /*---Get a book by id---*/
    @GetMapping("/book/{id}")
    public String get(@PathVariable("id") long id, Model model) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "books/show";    }

    /*---get all books---*/
    @GetMapping("/books")
    public String list(Model model) {
        model.addAttribute("books", bookService.getBooks());
        return "books/index";
    }

    /*---Update a book by id---*/
    @RequestMapping(path = "/book/{id}", method = RequestMethod.POST)
    public String update(@PathVariable("id") long id, Book book) {
        bookService.update(id, book);
        return "redirect:/books";    }

    /*---Delete a book by id---*/
    @RequestMapping(path = "/book/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") long id) {
        bookService.delete(id);
        return "redirect:/books";
    }
}
