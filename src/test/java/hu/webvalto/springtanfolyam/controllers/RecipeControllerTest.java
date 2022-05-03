package hu.webvalto.springtanfolyam.controllers;

import hu.webvalto.springtanfolyam.domain.Recipe;
import hu.webvalto.springtanfolyam.dto.RecipeDTO;
import hu.webvalto.springtanfolyam.exceptions.NotFoundException;
import hu.webvalto.springtanfolyam.services.RecipeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class RecipeControllerTest {

    @Mock
    RecipeServiceImpl recipeService;

    MockMvc mockMvc;

    RecipeController testObj;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        testObj = new RecipeController(recipeService);
        mockMvc = MockMvcBuilders.standaloneSetup(testObj).build();
    }

    //@Test
    void showById() throws Exception {
        Recipe recipe = new Recipe();
        recipe.setId(1L);

        //when(recipeService.findRecipeById(recipe.getId())).thenReturn(recipe);

        mockMvc.perform(get("/recipe/show/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/show"));
    }

    @Test
    void testGetNewRecipeForm() throws Exception {
        mockMvc.perform(get("/recipe/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/recipeform"))
                .andExpect(model().attributeExists("recipe"));
    }

    @Test
    void testPostNewRecipeForm() throws Exception {
        RecipeDTO recipeDTO = new RecipeDTO();
        recipeDTO.setId(2L);

        when(recipeService.save(any())).thenReturn(recipeDTO);

        mockMvc.perform(post("/recipe")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("id", "")
                .param("description", "some text")
        )
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/recipe/show/2"));
    }

    @Test
    void testDeleteAction() throws Exception {
        mockMvc.perform(get("/recipe/1/delete"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/"));

        verify(recipeService, times(1)).deleteRecipeById(anyLong());
    }

    @Test
    void testGetRecipeNotFound() throws Exception {
        when(recipeService.findRecipeById(anyLong())).thenThrow(NotFoundException.class);

        mockMvc.perform(get("/recipe/show/1"))
                .andExpect(status().isNotFound())
                .andExpect(view().name("404error"));
    }
}