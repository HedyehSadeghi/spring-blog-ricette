package org.learning.blogricette.controller;

import jakarta.validation.Valid;
import org.learning.blogricette.model.Recipe;
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
    public String store(@Valid @ModelAttribute("recipe") Recipe recipeForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "recipes/create";
        }
        Recipe savedRecipe = recipeRepository.save(recipeForm);
        return "redirect:/recipes/list";
    }


    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Optional<Recipe> result = recipeRepository.findById(id);
        if (result.isPresent()) {
            model.addAttribute("recipe", result.get());
            return "recipes/edit";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe with id " + id + " not found");
        }

    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable Integer id, @Valid @ModelAttribute("recipe") Recipe recipeForm, BindingResult bindingResult) {
        Optional<Recipe> result = recipeRepository.findById(id);
        if (result.isPresent()) {

            if (bindingResult.hasErrors()) {
                return "recipes/edit";
            }

            Recipe updatedRecipe = recipeRepository.save(recipeForm);
            return "redirect:/recipes/list";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe with id " + id + " not found");

        }
    }


    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        Optional<Recipe> result = recipeRepository.findById(id);
        if (result.isPresent()) {
            recipeRepository.deleteById(id);

            redirectAttributes.addFlashAttribute("redirectMessage", "Recipe" + result.get().getTitle() + " deleted!");
            return "redirect:/recipes/list";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe with id " + id + " not found");

        }
    }


}
