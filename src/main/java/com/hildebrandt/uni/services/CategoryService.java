package com.hildebrandt.uni.services;

import com.hildebrandt.uni.domain.Category;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface CategoryService {

    Set<Category> getCategories();

    Category findById(Long id);

    void delete(Long id);

    Long create(Category category);

    void update(Long id, Category category);

    //Set<Category> getCategoriesIdByBookId(Long BookId);
}
