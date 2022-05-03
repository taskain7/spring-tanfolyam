package hu.webvalto.springtanfolyam.controllers;

import hu.webvalto.springtanfolyam.dto.RecipeDTO;
import hu.webvalto.springtanfolyam.services.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class RecipeRESTControllerTest {

    @Mock
    RecipeService recipeService;

    MockMvc mockMvc;

    RecipeRESTController testObj;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        testObj = new RecipeRESTController(recipeService);
        mockMvc = MockMvcBuilders.standaloneSetup(testObj).build();
    }

    @Test
    void getById() throws Exception {
        RecipeDTO recipeDTO = new RecipeDTO();
        recipeDTO.setId(1L);

        when(recipeService.findRecipeById(anyLong())).thenReturn(recipeDTO);

        mockMvc.perform(get("/api/recipe/1")
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("id", is(recipeDTO.getId().intValue())));
    }
}