package org.learning.blogricette.controller;


import org.learning.blogricette.model.Category;
import org.learning.blogricette.repository.CategoryRepository;
import org.learning.blogricette.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private RecipeRepository recipeRepository;

    @GetMapping("/list")
    public String list(Model model) {
        List<Category> categoryList = categoryRepository.findAll();
        model.addAttribute("categoryList", categoryList);
        return "categories/list";
    }


}
