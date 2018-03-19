package com.hildebrandt.uni.services;

import com.hildebrandt.uni.domain.Book;

import java.util.Set;

public interface BookService {

    Set<Book> getBooks();

    Book findById(Long id);

    void update(Long id, Book book);

    void delete(Long id);

    Long create(Book book);
}
