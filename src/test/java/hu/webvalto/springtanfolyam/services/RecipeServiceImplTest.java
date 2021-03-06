package hu.webvalto.springtanfolyam.services;

import hu.webvalto.springtanfolyam.domain.Recipe;
import hu.webvalto.springtanfolyam.exceptions.NotFoundException;
import hu.webvalto.springtanfolyam.mappers.RecipeMapper;
import hu.webvalto.springtanfolyam.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RecipeServiceImplTest {
    RecipeServiceImpl testObj;

    @Mock
    RecipeRepository recipeRepository;

    @Mock
    RecipeMapper recipeMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        testObj = new RecipeServiceImpl(recipeRepository, recipeMapper);
    }

    @Test
    void getRecipes() {
        Recipe recipe = new Recipe();
        Set<Recipe> recipeSet = new HashSet<>();
        recipeSet.add(recipe);

        when(recipeRepository.findAll()).thenReturn(recipeSet);

        assertEquals(1, testObj.getRecipes().size());

        verify(recipeRepository, times(1)).findAll();
    }

    //@Test
    void getRecipeById() {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(recipe.getId())).thenReturn(recipeOptional);

        //Recipe recipeReturned = testObj.findRecipeById(1L);

        //assertNotNull(recipeReturned);
        //assertEquals(recipeReturned, recipe);
        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, never()).findAll();
    }

    @Test
    void testDeleteRecipeById() {
        Long idToDelete= 2L;

        testObj.deleteRecipeById(idToDelete);

        verify(recipeRepository, times(1)).deleteById(anyLong());
    }

    @Test
    public void getRecipeByIdTestNotFound() {
        Optional<Recipe> recipeOptional = Optional.empty();
        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        NotFoundException notFoundException = assertThrows(NotFoundException.class, () -> testObj.findRecipeById(1L));
        assertEquals("Recipe Not Found!", notFoundException.getMessage());
    }
}