package com.hildebrandt.uni.controllers;

import com.hildebrandt.uni.domain.Category;
import com.hildebrandt.uni.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /*---Site for new Category---*/
    @RequestMapping( path = "/category/create")
    public String loadForm(Model model) {
        model.addAttribute("category", new Category());
        return "categories/create";
    }

    /*---Add new Category---*/
    @RequestMapping(path = "/category", method = RequestMethod.POST)
    public String save(Category category) {
        long id = categoryService.create(category);
        return "redirect:/categories";
    }

    /*---Get a Category by id---*/
    @GetMapping("/category/{id}")
    public String get(@PathVariable("id") long id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "categories/edit";
    }

    /*---get all Categories---*/
    @GetMapping("/categories")
    public String list(Model model) {
        model.addAttribute("categories", categoryService.getCategories());
        return "categories/index";
    }

    /*---Update a category by id---*/
    @RequestMapping(path = "/category/{id}", method = RequestMethod.POST)
    public String update(@PathVariable("id") long id, Category category) {
        categoryService.update(id, category);
        return "redirect:/categories";    }

    /*---Delete a book by id---*/
    @RequestMapping(path = "/category/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") long id) {
        categoryService.delete(id);
        return "redirect:/categories";
    }
}
