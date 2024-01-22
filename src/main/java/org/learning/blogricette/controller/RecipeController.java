package org.learning.blogricette.controller;

import jakarta.validation.Valid;
import org.learning.blogricette.model.Recipe;
import org.learning.blogricette.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/recipes")
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;


    @GetMapping("/list")
    public String list(Model model) {
        List<Recipe> recipeList = recipeRepository.findAll();
        model.addAttribute("recipeList", recipeList);
        return "recipes/list";
    }


    @GetMapping("/create")
    public String create(Model model) {
        Recipe recipe = new Recipe();
        model.addAttribute("recipe", recipe);
        return "recipes/create";
    }


    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("recipe") Recipe recipeForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "recipes/create";
        }
        Recipe savedRecipe = recipeRepository.save(recipeForm);
        return "redirect:/recipes/list";
    }


}
