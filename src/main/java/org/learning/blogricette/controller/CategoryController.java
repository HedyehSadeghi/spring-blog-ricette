package org.learning.blogricette.controller;


import jakarta.validation.Valid;
import org.learning.blogricette.model.Category;
import org.learning.blogricette.repository.CategoryRepository;
import org.learning.blogricette.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/create")
    public String create(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "categories/create";
    }


    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("category") Category categoryForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "categories/create";
        }
        Category savedCategory = categoryRepository.save(categoryForm);
        return "redirect:/categories/list";
    }


    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Optional<Category> result = categoryRepository.findById(id);
        if (result.isPresent()) {
            model.addAttribute("category", result.get());
            return "categories/edit";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "category with id " + id + " not found");
        }

    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable Integer id, @Valid @ModelAttribute("category") Category categoryForm, BindingResult bindingResult, Model model) {
        Optional<Category> result = categoryRepository.findById(id);
        if (result.isPresent()) {

            if (bindingResult.hasErrors()) {
                return "categories/edit";
            }

            Category updatedCategory = categoryRepository.save(categoryForm);
            return "redirect:/categories/list";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "category with id " + id + " not found");

        }
    }


    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        Optional<Category> result = categoryRepository.findById(id);
        if (result.isPresent()) {
            categoryRepository.deleteById(id);

            redirectAttributes.addFlashAttribute("redirectMessage", "Category " + result.get().getName() + " deleted!");
            return "redirect:/categories/list";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe with id " + id + " not found");

        }
    }


}
