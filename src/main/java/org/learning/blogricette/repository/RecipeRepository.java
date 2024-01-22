package org.learning.blogricette.repository;

import org.learning.blogricette.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

    List<Recipe> findByTitleContaining(String searchTitle);
}
