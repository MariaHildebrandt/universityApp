package com.hildebrandt.uni.repositories;

import com.hildebrandt.uni.domain.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    /*
    @Query("SELECT t.category_id " +
            "FROM book_category t " +
            "JOIN books ON t.book_id = books.id WHERE books.id = :id")
    Set<Long> getCategoriesIdByBookId(@Param("id") Long BookId);*/
}

/*
Dies gibt die Categories_id für Bücher aus
dass mus mit findById der entsprechende Name rausgefilter werden

SELECT category_id AS Categories
from book_category
JOIN books on book_id = books.id
Where books.id = 1 ;
 */