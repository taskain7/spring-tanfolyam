package hu.webvalto.springtanfolyam.services;

import hu.webvalto.springtanfolyam.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findRecipeById(Long id);
}
