package com.hildebrandt.uni.services;

import com.hildebrandt.uni.domain.Book;
import com.hildebrandt.uni.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Set<Book> getBooks(){
        Set<Book> bookSet = new HashSet<>();
        bookRepository.findAll().iterator().forEachRemaining(bookSet::add);
        return bookSet;
    }

    @Override
    public Book findById(Long id){
        Optional<Book> bookOptional = bookRepository.findById(id);

        if (!bookOptional.isPresent()) {
            throw new RuntimeException("Book Not Found!");
        }

        return bookOptional.get();

    }

    @Override
    public void update(Long id, Book book){
        Book currentBook = findById(id);
        currentBook.setTitle(book.getTitle());
        currentBook.setAuthor(book.getAuthor());
        //currentBook.setCategories(book.getCategories());
        currentBook.setDescription(book.getDescription());
        currentBook.setDateField(book.getDateField());

        bookRepository.save(currentBook);
    }

    @Override
    public void delete(Long id){
        bookRepository.deleteById(id);
    }

    @Override
    public Long create(Book book){
        bookRepository.save(book);
        return book.getId();
    }
}
