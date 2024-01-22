package org.learning.blogricette.controller;

import org.learning.blogricette.model.Recipe;
import org.learning.blogricette.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @GetMapping
    public String index(@RequestParam(name = "keyword", required = false) String searchKeyword, Model model) {
        List<Recipe> recipeList;

        if (searchKeyword != null) {
            recipeList = recipeRepository.findByTitleContaining(searchKeyword);
        } else {
            recipeList = recipeRepository.findAll(Sort.by("createdAt").descending());
        }
        model.addAttribute("recipeList", recipeList);

        model.addAttribute("preloadSearch", searchKeyword);
        return "home/index";
    }


    @GetMapping("/show/{id}")
    public String show(@PathVariable Integer id, Model model) {
        Optional<Recipe> result = recipeRepository.findById(id);
        if (result.isPresent()) {
            Recipe recipe = result.get();
            model.addAttribute("recipe", recipe);
            return "home/show";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe with id " + id + " not found");
        }
    }

}
