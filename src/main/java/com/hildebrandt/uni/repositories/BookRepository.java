package com.hildebrandt.uni.repositories;

import com.hildebrandt.uni.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
