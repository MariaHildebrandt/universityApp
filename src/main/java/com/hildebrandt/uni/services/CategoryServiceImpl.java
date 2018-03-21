package com.hildebrandt.uni.services;

import com.hildebrandt.uni.domain.Category;
import com.hildebrandt.uni.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Set<Category> getCategories(){
        Set<Category> categorySet = new HashSet<>();
        categoryRepository.findAll().iterator().forEachRemaining(categorySet::add);
        return categorySet;
    }

    @Override
    public Category findById(Long id){
        Optional<Category> categoryOptional = categoryRepository.findById(id);

        if (!categoryOptional.isPresent()) {
            throw new RuntimeException("Category Not Found!");
        }
        return categoryOptional.get();
    }

    @Override
    public void delete(Long id){
        categoryRepository.deleteById(id);
    }

    @Override
    public Long create(Category category){
        categoryRepository.save(category);
        return category.getId();
    }

    @Override
    public void update(Long id, Category category){
        Category currentCat = findById(id);
        currentCat.setName(category.getName());

        categoryRepository.save(currentCat);
    }

    /*
    @Override
    public Set<Category> getCategoriesIdByBookId(Long BookId){
        Set<Category> bookCategories = new HashSet<>();
        Set<Long> CategoryIds =  categoryRepository.getCategoriesIdByBookId(BookId);

        for (Long id : CategoryIds) {
            System.out.println("Category_id" + id);
            bookCategories.add(findById(id));
        }

        return bookCategories;
    }*/

}
