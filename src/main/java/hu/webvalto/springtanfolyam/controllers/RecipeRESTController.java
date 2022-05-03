package hu.webvalto.springtanfolyam.controllers;

import hu.webvalto.springtanfolyam.dto.RecipeDTO;
import hu.webvalto.springtanfolyam.services.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recipe")
@RequiredArgsConstructor
public class RecipeRESTController {

    private final RecipeService recipeService;

    @GetMapping("/{id}")
    public ResponseEntity<RecipeDTO> getById(@PathVariable String id) {
        return new ResponseEntity<>(recipeService.findRecipeById(Long.valueOf(id)), HttpStatus.OK);
    }
}
