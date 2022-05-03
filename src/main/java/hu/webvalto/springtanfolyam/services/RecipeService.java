package hu.webvalto.springtanfolyam.services;

import hu.webvalto.springtanfolyam.domain.Recipe;
import hu.webvalto.springtanfolyam.dto.RecipeDTO;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    RecipeDTO findRecipeById(Long id);

    RecipeDTO save(RecipeDTO recipeDTO);

    void deleteRecipeById(Long id);
}
