package hu.webvalto.springtanfolyam.config;

import hu.webvalto.springtanfolyam.domain.*;
import hu.webvalto.springtanfolyam.repositories.CategoryRepository;
import hu.webvalto.springtanfolyam.repositories.RecipeRepository;
import hu.webvalto.springtanfolyam.repositories.UnitOfMeasureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@RequiredArgsConstructor
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    
    private final RecipeRepository recipeRepository;
    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        recipeRepository.saveAll(getRecipes());
    }

    private List<Recipe> getRecipes() {
        UnitOfMeasure each = unitOfMeasureRepository.findByDescription("Each").orElse(null);

        List<Recipe> recipes = new ArrayList<>();
        Recipe scrambledEgg = new Recipe();
        scrambledEgg.setDescription("Very simple scrambled egg!");
        scrambledEgg.setCookTime(6);
        scrambledEgg.setPrepTime(3);
        scrambledEgg.setDifficulty(Difficulty.EASY);
        scrambledEgg.setServings(1);
        scrambledEgg.setDirections("Cook it!");
        Notes scrambledEggNotes = new Notes();
        scrambledEggNotes.setRecipeNotes("Egg note");
        scrambledEgg.setNotes(scrambledEggNotes);
        Ingredient egg = new Ingredient();
        egg.setDescription("Large egg");
        egg.setUnitOfMeasure(each);
        egg.setRecipe(scrambledEgg);
        scrambledEgg.getIngredients().add(egg);
        recipes.add(scrambledEgg);

        Recipe guamacole = new Recipe();
        guamacole.setDescription("Very simple guacamole!");
        guamacole.setCookTime(1);
        guamacole.setPrepTime(4);
        guamacole.setDifficulty(Difficulty.EASY);
        guamacole.setServings(1);
        guamacole.setDirections("Cook it!");
        Notes guacamoleEggNotes = new Notes();
        guacamoleEggNotes.setRecipeNotes("Guacamole note");
        guamacole.setNotes(guacamoleEggNotes);
        Ingredient avocado = new Ingredient();
        avocado.setDescription("Large avocado");
        avocado.setUnitOfMeasure(each);
        avocado.setRecipe(guamacole);
        guamacole.getIngredients().add(avocado);
        recipes.add(guamacole);
        return recipes;
    }
}
