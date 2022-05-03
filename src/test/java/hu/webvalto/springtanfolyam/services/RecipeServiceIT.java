package hu.webvalto.springtanfolyam.services;

import hu.webvalto.springtanfolyam.domain.Recipe;
import hu.webvalto.springtanfolyam.dto.RecipeDTO;
import hu.webvalto.springtanfolyam.mappers.RecipeMapper;
import hu.webvalto.springtanfolyam.repositories.RecipeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RecipeServiceIT {

    private static final String NEW_DESCRIPTION = "New description";

    @Autowired
    RecipeService recipeService;

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    RecipeMapper recipeMapper;

    @Transactional
    @Test
    void testSaveOfDescription() {
        Iterable<Recipe> recipes = recipeRepository.findAll();
        Recipe recipe = recipes.iterator().next();
        RecipeDTO recipeDTO = recipeMapper.recipeToRecipeDTO(recipe);

        recipeDTO.setDescription(NEW_DESCRIPTION);
        RecipeDTO savedRecipeDTO = recipeService.save(recipeDTO);

        assertEquals(NEW_DESCRIPTION, savedRecipeDTO.getDescription());
        assertEquals(recipe.getId(), savedRecipeDTO.getId());
        assertEquals(recipe.getCategories().size(), savedRecipeDTO.getCategories().size());
        assertEquals(recipe.getIngredients().size(), savedRecipeDTO.getIngredients().size());
    }
}
