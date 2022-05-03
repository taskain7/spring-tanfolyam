package hu.webvalto.springtanfolyam.controllers;

import hu.webvalto.springtanfolyam.dto.RecipeDTO;
import hu.webvalto.springtanfolyam.services.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    @RequestMapping("/recipe/show/{id}")
    public String showById(@PathVariable String id, Model model) {
        model.addAttribute("recipe", recipeService.findRecipeById(Long.valueOf(id)));
        return "recipe/show";
    }

    @RequestMapping("/recipe/new")
    public String newRecipe(Model model) {
        model.addAttribute("recipe", new RecipeDTO());
        return "recipe/recipeform";
    }

    @PostMapping
    @RequestMapping("recipe")
    public String saveOrUpdateRecipe(@ModelAttribute RecipeDTO recipeDTO) {
        RecipeDTO savedRecipeDTO = recipeService.save(recipeDTO);
        return "redirect:/recipe/show/" + savedRecipeDTO.getId();
    }

    @RequestMapping("recipe/{id}/delete")
    public String deleteRecipeById(@PathVariable String id) {
        recipeService.deleteRecipeById(Long.valueOf(id));
        return "redirect:/";
    }
}
